package nio_p;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelReadMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileChannel channel = FileChannel.open(
				Paths.get("ppp/ccc.txt"), 
				StandardOpenOption.READ
				);
		
		//������ �� ������ ũ�⸦ �𸣹Ƿ� ����� buffer ũ�� Ȯ��
		ByteBuffer buf = ByteBuffer.allocate(20); //���۰����� ���ڶ�� ����
		
		
		Charset charset = Charset.defaultCharset();
		//��� ���� : ȸ�鿡�� �ѱ��� ���� ���ؼ� �̿ܿ��� ��� ���ص� �� 
		
		int cnt=0;
		
		
		String data="";
		while(true) {
			cnt = channel.read(buf);
			
			if(cnt==-1)		// -1 �� ���� �Ǹ� channel ���� ������ data�� �������̶�� ��
				break;
			
			buf.flip(); //
			
			data+=charset.decode(buf);
			
			buf.clear();	//�پ� buffer ������ �����
		}
		
		channel.close();
		
		System.out.println(data);
	}
}
