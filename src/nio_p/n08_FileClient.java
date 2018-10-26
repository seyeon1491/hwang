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
			
			//127.0.0.1 은 자기 자신의 ip를 뜻한다.   ==   
			channel.connect(new InetSocketAddress("127.0.0.1", 7777));
			//파일을 받는 경로  nnn폴더에 ccvb라는 파일로 접근하겠다.
//			Path path = Paths.get("nnn/ccvb.txt");
			Path path = Paths.get("nnn/aaa.jpg");
			FileChannel fc = FileChannel.open(path, 
					StandardOpenOption.CREATE,  //ccvb라는 파일이 없으면 파일을 생성한다.
					StandardOpenOption.WRITE    //하려는 작업을 쓰겠다.
					);
			//받아오는쪽 크기에 맞춰서 잡아준다.
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			//서버로부터 받은 버퍼를 channel에 담는다.
///txt파일//
			/*
			channel.read(buf);
			buf.flip();
			//fc에 버퍼를 쓴다.
			fc.write(buf);
			*/
			channel.read(buf);
			buf.flip();
			int size = buf.getInt();
			buf.clear();
			
///이미지파일//
			for (int i = 0; i <size; i++) {  //서버가 보내는 만큼 돌려서 받는다.
				//channel.read(buf);
				int cnt = channel.read(buf);
				buf.flip();
				fc.write(buf);
				buf.clear();//한번받은 버프는 지워주고 새로운 버프를 받는다.
				System.out.println("client : " + cnt);
			}
			
			
			channel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
