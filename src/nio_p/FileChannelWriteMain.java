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
	
		//파일 채널 열기
		FileChannel channel = FileChannel.open(
				Paths.get("ppp/ccc.txt"),  //ccc라는 txt파일 생성
				StandardOpenOption.CREATE,
				StandardOpenOption.WRITE);
		
		//버퍼 생성
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode("아 기 상ㅇ ㅓ 뚜 루루루ㅜㄹ 긔엄운 뚤르루룰 바다 속 뚜우우둥ㄷ 아기상어!!!!");
		
		
		//파일에 쓰기
		int cnt = channel.write(buf);
		System.out.println(cnt); //한글은 한자에 2byte 나머지 1byte

		buf = charset.encode("ㅇㅇㅇ");   //기존의 write는 사라짐 ()  //지워도 계속해서 txt파일에 저장됨
		
		//파일에 쓰기
		cnt = channel.write(buf);
		System.out.println(cnt); //한글은 한자에 2byte 나머지 1byte

		//파일에 쓰기
		cnt = channel.write(buf);  //한번 작성한 buffer내용은 다시 사용 못함
		System.out.println(cnt); 
		
		//파일채널 달기
		channel.close();

	}

}
