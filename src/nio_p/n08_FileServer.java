package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class n08_FileServer {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 0;
		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
			
			System.out.println("�������");
			//���� ũ�⸦ �˱����ؼ���  client ���� ���� 
			Path path = Paths.get("ppp/aaaaa.jpg");
//			System.out.println(Files.size(path));
			
			
			SocketChannel client = server.accept();
			
			//���� ����
			ByteBuffer buf = ByteBuffer.allocate(1024);
			//���� �о����  ����ä���� ���� �ξ���Ѵ�. �ؿ������� 4����Ʈ�� �߰���
//			Path path = Paths.get("ppp/ccc.txt"); //���� ũ�Ⱑ bufũ�� ���� ������ �ѹ��� ������ �ȴ�.
//			Path path = Paths.get("ppp/aaaaa.jpg"); //���� ũ�Ⱑ bufũ�� ���� ������ �ѹ��� ������ �ȴ�.
			
			FileChannel fc = FileChannel.open(path, StandardOpenOption.READ);
			
			//for�� ������ Ƚ�� ��ü�뷮(long)/����byte (   buf.limit()  ||  buf.capacity()  ) �Ѵ� int
			//size = (int) (Files.size(path) / buf.limit()); 
			size = (int) Math.ceil((double)(Files.size(path)) / buf.limit()); 
///txt����//			
//			fc.read(buf);
//			//read�� �ϸ� �� flip�� ����� �Ѵ�.
//			//����� ���ϸ� Ŀ���� �������� �־ ������ �������� ����.
//			buf.flip();
//			
//			//���� ����
//			client.write(buf);
			
			//Ŭ���̾�Ʈ���� size�� �˷��ش�
			buf.putInt(size);
			buf.flip();
			client.write(buf);
			buf.clear();
			
			
///�̹�������//		
			for (int i = 0; i < size; i++) {  //���� ũ�Ⱑ ����ũ���� �����ŭ  ��������.
				//fc.read(buf);//���ݱ��� ���� ������ Ŀ���� ���ܼ� ���� �۾����Ҷ� ���⼭���� 1024����Ʈ��ŭ �����´�. close������ �̾ ���� �б�.
				int cnt = fc.read(buf);
				buf.flip();
				
				client.write(buf);
				buf.clear();//�ѹ��� ������ ����� ������������ ���� ��´�.
				System.out.println("server : " + cnt);
			}
		
			
			//������ ������ �׻� �ݾ���� �Ѵ�.
			fc.close();
			client.close();
			server.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
