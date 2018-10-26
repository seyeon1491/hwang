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
///����///
public class n02_AsynchWriteMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//������ �����带 �˷���
		ExecutorService executorservice = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
		System.out.println(executorservice);
		
		for (int i = 0; i < 10; i++) {
			
			Path pp  = Paths.get("nnn/aaa_"+i+".txt");
			
			Charset chSet = Charset.defaultCharset();
			
			ByteBuffer buf = chSet.encode("�ð�Ž��� ����");
			
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
		
			// CompletionHandler�� �۵���Ű�� ���� Path�� channel�� ����� ���� ó���� Ŭ���� ����
			AttachGoGo gogo = new AttachGoGo(pp, channel);
			//������� �۵�  ---> Ư���۾��� ��ġ�� ���� �ڵ����� completed�� �����
			CompletionHandler<Integer, AttachGoGo> completionhandler = 
					new CompletionHandler<Integer, AttachGoGo>() {

						@Override //channel.write() ��������� ����
						public void completed(Integer result, AttachGoGo attachment) {
							// TODO Auto-generated method stub
							//���� �۵��� log�� ����
							//Thread.currentThread().getName() �������� �����尡 ����� �񵿱� ������ ó����
							System.out.println(Thread.currentThread().getName() + "->" + attachment.path.getFileName() + ":" + result + " byte");
							try {
								attachment.channel.close(); //�� ��������� �ݱ�
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						@Override  //channel.write() ó�� ���н� ����
						public void failed(Throwable exc, AttachGoGo attachment) {
							// TODO Auto-generated method stub
							
						}
					};
			
			//channel.write(buf, 0);
			//channel�� �ۼ��� ���� : gogo, write()������   ���ó�� : completionhandler
			channel.write(buf, 0, gogo, completionhandler);
			
			//�����۵��Ǿ����� completionhandler�� completed()���� �ݱ���
			//channel.close();
		}
		
	}

}
