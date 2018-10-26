package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class n11_Exam_UDP_FileReciever {
//받는걸 기다리지 않고 막 보내기때문에 쓰레드를 거는게 파일 전체를 보내기에 좋다. 
// 그냥 파일전송은 tcp로 해라
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            DatagramChannel channel = 
                    DatagramChannel.open(StandardProtocolFamily.INET);
            channel.bind(new InetSocketAddress(7777));
            System.out.println("수신대기");
            
            ByteBuffer buf = ByteBuffer.allocate(1024); 
            Path path = Paths.get("nnn/bbbbbbbbbbb.jpg");
            FileChannel fc = FileChannel.open(path, 
            		StandardOpenOption.CREATE, 
            		StandardOpenOption.WRITE);
            
            while(true) {
                SocketAddress addr = channel.receive(buf);
                System.out.println(buf.limit());
                System.out.println(buf.capacity());
                System.out.println(buf.position());//flip위에서 
                buf.flip();
                System.out.println();
                fc.write(buf);
                buf.clear();
                if(buf.limit()<buf.capacity())    //buf.limit()    buf.capacity()    buf.position()를 사용하여 break;
                	break;
            }      
            fc.close();
            channel.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}