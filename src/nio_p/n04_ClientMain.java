package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class n04_ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			SocketChannel channel = SocketChannel.open();
			channel.configureBlocking(true);
			
			channel.connect(new InetSocketAddress("192.168.0.47", 7777));
			System.out.println("���� ���� ����");
			
			ByteBuffer buf = ByteBuffer.allocate(100);
			
			int cnt = channel.read(buf);
			
			buf.flip();
			
			Charset charset = Charset.defaultCharset();
			
			String data = charset.decode(buf).toString();
			
			System.out.println("[����]"+data);
			
			buf = charset.encode("����?");
			channel.write(buf);
			System.out.println("������ ������ �۽� �Ϸ�");
			
			channel.close();
			System.out.println("���� ���� ����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
