package Exam;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SubController3 implements Initializable{

	@FXML Button subBtn,b1;
	@FXML Label label,label1;
	@FXML TextField msg;
	@FXML AnchorPane subLayout;
	
	Eng eng;
	List<String> engexam,enganswer,engomr;
	int ejum = 0,jum = 20,i = 0,j = 0;
	boolean timeChk = false;
	
	public void subClose() {
		AnchorPane root=  (AnchorPane)subBtn.getScene().getRoot();	        
		root.getChildren().remove(subLayout);		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		engexam = Arrays.asList("����� �����??","�ٳ����� �����???","�丶�並 �����??","�Ҹ� �����??","���� �����??","");
		enganswer = Arrays.asList("","apple","banana","tomato","cow","dog");
		engomr = new ArrayList<>();
		
		b1.setOnAction(ee -> {
			
			eng = new Eng();
			if(b1.getText().equals("�������")) 
				eng.start();
			msg.setLayoutY(300);
			b1.setText("��������");
			label.setText(engexam.get(i));
			engomr.add(msg.getText());
			msg.setText("");
			
			String answer = enganswer.get(i);
			String omr = engomr.get(i);
			
			if(!omr.equals(""))
				if(answer.equals(omr))
					ejum += jum;
			if(i==4)
				b1.setText("��������");
			if(i==engexam.size()-1 || timeChk)
				subClose();
			i++;
		});
	
	}
	
	class Eng extends Thread{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (j = 0; j <= 60 ; j++) {
				Platform.runLater(new Runnable() {		
					@Override
					public void run() {
						// TODO Auto-generated method stub
						label1.setText("�����ð� : "+(60-j)+"��");
					}
				});
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			timeChk=true;
		}	
	}
}