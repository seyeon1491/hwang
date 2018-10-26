package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class n05_TCPSingleClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SocketChannel socket = null;
		
		try {
			socket = SocketChannel.open();
			socket.configureBlocking(true);
			
			socket.connect(new InetSocketAddress("192.168.0.56", 7777));
			System.out.println("���� ���� ����");
			
			new TCPSingleSender1(socket).start();
			new TCPSingleReciever1(socket).start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}

