package net_p;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class n00_ClientMain {
 // ������ ����Ű�� Ŭ���̾�Ʈ�� Ų��
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// cmd ipconfig ip�ּ� Ȯ��
			Socket socket = new Socket("192.168.0.39",7777);
			
			InputStream is = socket.getInputStream();
			
			DataInputStream dis = new DataInputStream(is);
			System.out.println("���� : " + dis.readUTF());
			dis.close();
			is.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
