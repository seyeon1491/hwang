package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class UDPSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DatagramChannel channel = 
					DatagramChannel.open(StandardProtocolFamily.INET);
										//IPV4 사용-StandardProtocolFamily.INET
			
			System.out.println("data 전송시작");
			
			Charset charset = Charset.defaultCharset();
			ByteBuffer buf = charset.encode("난 선생이에요");
			// 포트(ex.7777)는 TCP용 UDP용 서로 다르다.
			String ip = "192.168.0.02";
			ip = "192.168.0.255"; //브로드 캐스트 /	전체전파
			int cnt = channel.send(buf,new InetSocketAddress("192.168.0.02",7777));
			
			System.out.println("data 전송완료:"+cnt);
			
			channel.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
