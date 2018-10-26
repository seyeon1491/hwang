package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class n08_FileClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			SocketChannel channel = SocketChannel.open();
			
			channel.configureBlocking(true);
			
			//127.0.0.1 �� �ڱ� �ڽ��� ip�� ���Ѵ�.   ==   
			channel.connect(new InetSocketAddress("127.0.0.1", 7777));
			//������ �޴� ���  nnn������ ccvb��� ���Ϸ� �����ϰڴ�.
//			Path path = Paths.get("nnn/ccvb.txt");
			Path path = Paths.get("nnn/aaa.jpg");
			FileChannel fc = FileChannel.open(path, 
					StandardOpenOption.CREATE,  //ccvb��� ������ ������ ������ �����Ѵ�.
					StandardOpenOption.WRITE    //�Ϸ��� �۾��� ���ڴ�.
					);
			//�޾ƿ����� ũ�⿡ ���缭 ����ش�.
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			//�����κ��� ���� ���۸� channel�� ��´�.
///txt����//
			/*
			channel.read(buf);
			buf.flip();
			//fc�� ���۸� ����.
			fc.write(buf);
			*/
			channel.read(buf);
			buf.flip();
			int size = buf.getInt();
			buf.clear();
			
///�̹�������//
			for (int i = 0; i <size; i++) {  //������ ������ ��ŭ ������ �޴´�.
				//channel.read(buf);
				int cnt = channel.read(buf);
				buf.flip();
				fc.write(buf);
				buf.clear();//�ѹ����� ������ �����ְ� ���ο� ������ �޴´�.
				System.out.println("client : " + cnt);
			}
			
			
			channel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
