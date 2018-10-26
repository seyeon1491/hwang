package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class n11_Exam_UDP_FileSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
            DatagramChannel channel = 
                    DatagramChannel.open(StandardProtocolFamily.INET);
            
            Path path = Paths.get("ppp/aa.jpg");
            FileChannel fc = FileChannel.open(path, StandardOpenOption.READ);
            ByteBuffer buf = ByteBuffer.allocate(1024);
            
            String unicast = "192.168.0.2"; //내 아이피	 unicast
            String Broadcast = "192.168.0.255";
            int cn = 0;
            while(true) {    
            	cn = fc.read(buf);
//            	if(cn==-1)
//            		break;
            	System.out.println(cn);
            	buf.flip();
            	channel.send(buf,new InetSocketAddress("192.168.0.2",7777));
            	buf.clear();        
            	if (cn<buf.capacity())
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