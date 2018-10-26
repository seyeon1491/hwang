package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelWriteMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		//���� ä�� ����
		FileChannel channel = FileChannel.open(
				Paths.get("ppp/ccc.txt"),  //ccc��� txt���� ����
				StandardOpenOption.CREATE,
				StandardOpenOption.WRITE);
		
		//���� ����
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode("�� �� �� �� �� ����̤� ����� �Ը���� �ٴ� �� �ѿ��դ� �Ʊ���!!!!");
		
		
		//���Ͽ� ����
		int cnt = channel.write(buf);
		System.out.println(cnt); //�ѱ��� ���ڿ� 2byte ������ 1byte

		buf = charset.encode("������");   //������ write�� ����� ()  //������ ����ؼ� txt���Ͽ� �����
		
		//���Ͽ� ����
		cnt = channel.write(buf);
		System.out.println(cnt); //�ѱ��� ���ڿ� 2byte ������ 1byte

		//���Ͽ� ����
		cnt = channel.write(buf);  //�ѹ� �ۼ��� buffer������ �ٽ� ��� ����
		System.out.println(cnt); 
		
		//����ä�� �ޱ�
		channel.close();

	}

}
