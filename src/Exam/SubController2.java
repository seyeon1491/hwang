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

public class SubController2 implements Initializable{

	@FXML Button subBtn,b1;
	@FXML Label label;
	@FXML Label label1;
	@FXML TextField msg;
	@FXML AnchorPane subLayout;
	
	Mat mat;
	List<String> matexam,matanswer,matomr;
	int mjum = 0,jum = 20,i = 0,j = 0;
	boolean timeChk = false;
	
	public void subClose() {
		AnchorPane root=  (AnchorPane)subBtn.getScene().getRoot();	        
		root.getChildren().remove(subLayout);		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		matexam = Arrays.asList("1 + 1 = ?","2 + 2 = ?","3 + 3 = ?","4 + 4 = ?","5 + 5 = ?","");
		matanswer = Arrays.asList("","2","4","6","8","10");
		matomr = new ArrayList<>();
		
		b1.setOnAction(ee -> {
			
			mat = new Mat();
			if(b1.getText().equals("시험시작")) 
				mat.start();
			msg.setLayoutY(300);
			b1.setText("다음문제");
			label.setText(matexam.get(i));
			matomr.add(msg.getText());
			msg.setText("");
			
			String answer = matanswer.get(i);
			String omr = matomr.get(i);
			
			if(!omr.equals(""))
				if(answer.equals(omr))
					mjum += jum;
			if(i==4)
				b1.setText("시험종료");
			if(i==matexam.size()-1 || timeChk)
				subClose();
			i++;
		});
	
	}
	
	class Mat extends Thread{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (j = 0; j <= 5 ; j++) {
				Platform.runLater(new Runnable() {		
					@Override
					public void run() {
						// TODO Auto-generated method stub
						label1.setText("남은시간 : "+(5-j)+"초");
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