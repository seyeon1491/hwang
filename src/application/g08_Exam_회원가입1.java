package application;

import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class g08_Exam_회원가입1 extends Application implements Initializable{

	@FXML Label sub_id;
	@FXML Label sub_pw;
	@FXML Label sub_name;
	@FXML Label sub_nick;
	@FXML Label sub_address;
	@FXML Label sub_birth;
	@FXML Label sub_gen;
	@FXML Label sub_num;
	@FXML Label sub_email;
	
	Member mem;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Member mem = (Member)resources.getObject("");
		
		sub_id.setText(mem.id);
		sub_pw.setText(mem.pw);
		sub_name.setText(mem.name);
		sub_nick.setText(mem.nick);
		sub_address.setText(mem.address);
		sub_birth.setText(mem.birth);
		sub_gen.setText(mem.gen);
		sub_num.setText(mem.num);
		sub_email.setText(mem.email);
	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("g08_Exam_회원가입1.fxml"),
				new ResourceBundle() {

					@Override
					protected Object handleGetObject(String key) {
						// TODO Auto-generated method stub
						return mem;
					}

					@Override
					public Enumeration<String> getKeys() {
						// TODO Auto-generated method stub
						return null;
					}
			
		}); 
		Scene scene = new Scene(parent);
	
		primaryStage.setScene(scene);
		primaryStage.setTitle("회원가입 확인");
		primaryStage.show();
	}
	

	
}

