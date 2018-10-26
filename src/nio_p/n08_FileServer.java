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
			
			System.out.println("서버대기");
			//파일 크기를 알기위해서는  client 실행 전에 
			Path path = Paths.get("ppp/aaaaa.jpg");
//			System.out.println(Files.size(path));
			
			
			SocketChannel client = server.accept();
			
			//공간 생성
			ByteBuffer buf = ByteBuffer.allocate(1024);
			//파일 읽어오기  파일채널의 위로 두어야한다. 밑에잇으면 4바이트가 추가됨
//			Path path = Paths.get("ppp/ccc.txt"); //파일 크기가 buf크기 보다 작으면 한번에 전송이 된다.
//			Path path = Paths.get("ppp/aaaaa.jpg"); //파일 크기가 buf크기 보다 작으면 한번에 전송이 된다.
			
			FileChannel fc = FileChannel.open(path, StandardOpenOption.READ);
			
			//for문 돌리는 횟수 전체용량(long)/설정byte (   buf.limit()  ||  buf.capacity()  ) 둘다 int
			//size = (int) (Files.size(path) / buf.limit()); 
			size = (int) Math.ceil((double)(Files.size(path)) / buf.limit()); 
///txt파일//			
//			fc.read(buf);
//			//read를 하면 꼭 flip을 해줘야 한다.
//			//사용을 안하면 커서가 뒤집어져 있어서 내용을 읽을수가 없다.
//			buf.flip();
//			
//			//파일 전송
//			client.write(buf);
			
			//클라이언트에도 size를 알려준다
			buf.putInt(size);
			buf.flip();
			client.write(buf);
			buf.clear();
			
			
///이미지파일//		
			for (int i = 0; i < size; i++) {  //파일 크기가 버퍼크기의 배수만큼  돌려본다.
				//fc.read(buf);//지금까지 읽은 파일의 커서를 남겨서 다음 작업을할때 여기서부터 1024바이트만큼 가져온다. close전까지 이어서 파일 읽기.
				int cnt = fc.read(buf);
				buf.flip();
				
				client.write(buf);
				buf.clear();//한번쓴 버프는 지우고 다음포문에서 새로 담는다.
				System.out.println("server : " + cnt);
			}
		
			
			//파일을 보내면 항상 닫아줘야 한다.
			fc.close();
			client.close();
			server.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
