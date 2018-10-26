package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class n04_ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
			
			while(true) {
				System.out.println("���� ���");
				
				SocketChannel client = server.accept();
				
				InetSocketAddress addr = (InetSocketAddress)client.getRemoteAddress();
				
				String clientAddr = "["+addr.getAddress().getHostAddress()+"]";
				
				System.out.println(clientAddr+ " ����");
				
				//Charset charset = Charset.forName("UTF-8");
				Charset charset = Charset.defaultCharset();
				
				ByteBuffer buf = charset.encode("������ ������ �޽���");
				client.write(buf);
				System.out.println(clientAddr+ " ������ ����");
				
				
				buf = ByteBuffer.allocate(100);
				
				int cnt = client.read(buf);
				
				buf.flip();
				
				String data = charset.decode(buf).toString();
				
				System.out.println(clientAddr+data);
				
				System.out.println(clientAddr+ " ��������");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
