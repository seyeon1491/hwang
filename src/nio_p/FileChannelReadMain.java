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
		
		//가지고 올 데이터 크기를 모르므로 충분한 buffer 크기 확보
		ByteBuffer buf = ByteBuffer.allocate(20); //버퍼공간이 모자라면 깨짐
		
		
		Charset charset = Charset.defaultCharset();
		//사용 이유 : 회면에서 한글을 보기 위해서 이외에는 사용 안해도 됨 
		
		int cnt=0;
		
		
		String data="";
		while(true) {
			cnt = channel.read(buf);
			
			if(cnt==-1)		// -1 이 리턴 되면 channel 에서 가져올 data가 마지막이라는 것
				break;
			
			buf.flip(); //
			
			data+=charset.decode(buf);
			
			buf.clear();	//다쓴 buffer 공간은 지운다
		}
		
		channel.close();
		
		System.out.println(data);
	}
}
