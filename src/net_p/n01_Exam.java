package net_p;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class n01_Exam extends Application implements Initializable {

	@FXML Button btn;
	@FXML TextField ip,port;
	@FXML TextArea ta;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		btn.setOnAction(ee -> {
			try {
				if(port.getText().equals(""))
					port.setText("7777");
				int Port = Integer.parseInt(port.getText());
				
				Socket socket = new Socket(ip.getText(),Port);
				
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
			
				if(ip.getText().equals(""))
					ta.setText("");
				else 
					ta.setText("¼­¹ö : " + dis.readUTF());
			
				dis.close();
				is.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Parent pp = FXMLLoader.load(getClass().getResource("n01_Exam.fxml"));
		Scene scene = new Scene(pp);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


}
