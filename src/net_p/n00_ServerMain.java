package net_p;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class n00_ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocket server = new ServerSocket(7777);
			//cmd netstat-an
			while(true) {
				System.out.println("���� ���");
				Socket client = server.accept();
				
				OutputStream os = client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				
				dos.writeUTF("���� ���������...");
			
				
				//��������ſ� �������� �ݴ´�.
				dos.close();
				os.close();
				client.close();
				
				System.out.println("���� �Ϸ�");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
