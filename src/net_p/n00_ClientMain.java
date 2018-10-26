package net_p;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class n00_ClientMain {
 // 서버를 먼저키고 클라이언트를 킨다
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// cmd ipconfig ip주소 확인
			Socket socket = new Socket("192.168.0.39",7777);
			
			InputStream is = socket.getInputStream();
			
			DataInputStream dis = new DataInputStream(is);
			System.out.println("서버 : " + dis.readUTF());
			dis.close();
			is.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
