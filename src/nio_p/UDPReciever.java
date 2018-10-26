package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class UDPReciever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DatagramChannel channel = 
					DatagramChannel.open(StandardProtocolFamily.INET);
			
			channel.bind(new InetSocketAddress(7777));
			
			System.out.println("���Ŵ��");
			
			while(true) {
				ByteBuffer buf = ByteBuffer.allocate(100);
				SocketAddress addr = channel.receive(buf);
				
				buf.flip();
				Charset charset = Charset.defaultCharset();
				String data = charset.decode(buf).toString();
				
				System.out.println(addr.toString()+":"+data);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
