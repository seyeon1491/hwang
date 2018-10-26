package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class TCPSelectorServer {
	
	Selector selector;
	ArrayList<Client> list;
	
	public TCPSelectorServer() {
		// TODO Auto-generated constructor stub
		
		try {
			
			selector = Selector.open();
			list = new ArrayList<>();
			
			ServerSocketChannel server = ServerSocketChannel.open();
			server.configureBlocking(false);
			server.bind(new InetSocketAddress(7777));
			
			server.register(selector, SelectionKey.OP_ACCEPT);
			
			while(true) {
				int cnt = selector.select();

				System.out.println(cnt);
				if(cnt==0)
					continue;
				
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey>it = keys.iterator();
				
				while(it.hasNext()) {
					SelectionKey key=it.next();
					//System.out.println(key);
					if(key.isAcceptable()) {
						accept(key);
					}else if(key.isReadable()) {///Ŭ���̾�Ʈ�κ��� data�� ������
						//System.out.println("isReadable");
						Client client = (Client)key.attachment();
						client.recieve(key);
					}else if(key.isWritable()) {
						//System.out.println("isWritable");
						Client client = (Client)key.attachment();
						client.send(key);
					}
					it.remove();   //coll_p�� setMain Ȯ��
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
	}
	
	void accept(SelectionKey key) {  ///���ӽ� ����
		
		try {
			ServerSocketChannel server = (ServerSocketChannel)key.channel();
			SocketChannel socket = server.accept();  //���� ������ ������ Ŭ���̾�Ʈ ������
			Client client = new Client(socket);
			
			list.add(client);
			String msg = socket.getRemoteAddress()+"����:"+list.size();
			System.out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	class Client{
		SocketChannel socket;
		Charset charset = Charset.defaultCharset();

		String msg; ///send �� ����� ����
		public Client(SocketChannel socket) {
			super();
			this.socket = socket;
			try {
				socket.configureBlocking(false);
				SelectionKey key = socket.register(selector, SelectionKey.OP_READ);
				key.attach(this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		void recieve(SelectionKey key) {
			
			
			
			try {
				ByteBuffer buf = ByteBuffer.allocate(1024);
				int cnt = socket.read(buf);
				
				buf.flip();
				
				String data = charset.decode(buf).toString();
				System.out.println("isReadable:"+data);
				sendToAll(data);
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		void send(SelectionKey key) {
			System.out.println("send:"+msg);
			ByteBuffer buf = charset.encode(msg);
			try {
				socket.write(buf);
				
				key.interestOps(SelectionKey.OP_READ);
				//interestOps()
				//SelectionKey�� �۾� ������ OP_READ�� ����
				selector.wakeup();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	void sendToAll(String msg) {//��ü���� ������ ���� �޼ҵ�
		for (Client client : list) {
			client.msg = msg;
			SelectionKey key = client.socket.keyFor(selector);
			//keyFor(selector);
			///selector�� ���� socket�� �ش��ϴ� SelectionKey�� ���Ϲ޴´�.
			
			key.interestOps(SelectionKey.OP_WRITE);
			//interestOps()
			//SelectionKey�� �۾� ������ OP_WRITE�� ����
		}
		selector.wakeup();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new TCPSelectorServer();
	}

}
