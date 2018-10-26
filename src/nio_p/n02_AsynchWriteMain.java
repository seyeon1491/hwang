package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AttachGoGo {
	
	Path path;
	AsynchronousFileChannel channel;

	
	public AttachGoGo(Path path, AsynchronousFileChannel channel) {
		super();
		this.path = path;
		this.channel = channel;
	}
	
	
	
}
///쓰기///
public class n02_AsynchWriteMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//현재의 쓰레드를 알려줌
		ExecutorService executorservice = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
		System.out.println(executorservice);
		
		for (int i = 0; i < 10; i++) {
			
			Path pp  = Paths.get("nnn/aaa_"+i+".txt");
			
			Charset chSet = Charset.defaultCharset();
			
			ByteBuffer buf = chSet.encode("시간탐험대 지니");
			
//			AsynchronousFileChannel channel = AsynchronousFileChannel.open(
//					pp,
//					EnumSet.of(   
//							StandardOpenOption.CREATE,
//							StandardOpenOption.WRITE),
//					executorservice
//					);
			AsynchronousFileChannel channel = AsynchronousFileChannel.open(
					pp, 
					StandardOpenOption.CREATE,
					StandardOpenOption.WRITE
					);
		
			// CompletionHandler로 작동시키기 위해 Path롸 channel을 멤버로 묶어 처리할 클래스 생성
			AttachGoGo gogo = new AttachGoGo(pp, channel);
			//쓰레드로 작동  ---> 특정작업을 마치고 나면 자동으로 completed가 실행됨
			CompletionHandler<Integer, AttachGoGo> completionhandler = 
					new CompletionHandler<Integer, AttachGoGo>() {

						@Override //channel.write() 정상종료시 진입
						public void completed(Integer result, AttachGoGo attachment) {
							// TODO Auto-generated method stub
							//파일 작동시 log를 남김
							//Thread.currentThread().getName() 여러개의 쓰레드가 나누어서 비동기 식으로 처리함
							System.out.println(Thread.currentThread().getName() + "->" + attachment.path.getFileName() + ":" + result + " byte");
							try {
								attachment.channel.close(); //다 사용했으면 닫기
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						@Override  //channel.write() 처리 실패시 진입
						public void failed(Throwable exc, AttachGoGo attachment) {
							// TODO Auto-generated method stub
							
						}
					};
			
			//channel.write(buf, 0);
			//channel에 작성시 묶고 : gogo, write()진행후   결과처리 : completionhandler
			channel.write(buf, 0, gogo, completionhandler);
			
			//정상작동되엇을때 completionhandler의 completed()에서 닫기함
			//channel.close();
		}
		
	}

}
