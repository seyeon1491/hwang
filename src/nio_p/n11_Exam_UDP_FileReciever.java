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
//�޴°� ��ٸ��� �ʰ� �� �����⶧���� �����带 �Ŵ°� ���� ��ü�� �����⿡ ����. 
// �׳� ���������� tcp�� �ض�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            DatagramChannel channel = 
                    DatagramChannel.open(StandardProtocolFamily.INET);
            channel.bind(new InetSocketAddress(7777));
            System.out.println("���Ŵ��");
            
            ByteBuffer buf = ByteBuffer.allocate(1024); 
            Path path = Paths.get("nnn/bbbbbbbbbbb.jpg");
            FileChannel fc = FileChannel.open(path, 
            		StandardOpenOption.CREATE, 
            		StandardOpenOption.WRITE);
            
            while(true) {
                SocketAddress addr = channel.receive(buf);
                System.out.println(buf.limit());
                System.out.println(buf.capacity());
                System.out.println(buf.position());//flip������ 
                buf.flip();
                System.out.println();
                fc.write(buf);
                buf.clear();
                if(buf.limit()<buf.capacity())    //buf.limit()    buf.capacity()    buf.position()�� ����Ͽ� break;
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