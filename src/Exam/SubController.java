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

public class SubController implements Initializable{

	@FXML Button subBtn,b1;
	@FXML Label label;
	@FXML Label label1;
	@FXML TextField msg;
	@FXML AnchorPane subLayout;
	
	Kor kor;
	List<String> korexam,koranswer,koromr;
	int kjum = 0,jum = 20,i = 0,j = 0;
	boolean timeChk = false;
	
	public void subClose() {
		AnchorPane root=  (AnchorPane)subBtn.getScene().getRoot();	        
		root.getChildren().remove(subLayout);		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		korexam = Arrays.asList("�κη����� / �κ귯����","��ġ �ұ��ϰ� / ��ġ �Ұ��ϰ�","-���� / -����","���� / ����","�ظ��ϸ� / �����ϸ�","");
		koranswer = Arrays.asList("","�κ귯����","��ġ �Ұ��ϰ�","����","����","�����ϸ�");
		koromr = new ArrayList<>();
		
		b1.setOnAction(ee -> {
			
			kor = new Kor();
			if(b1.getText().equals("�������")) 
				kor.start();
			msg.setLayoutY(300);
			b1.setText("��������");
			label.setText(korexam.get(i));
			koromr.add(msg.getText());
			msg.setText("");
			
			String answer = koranswer.get(i);
			String omr = koromr.get(i);
			
			if(!omr.equals(""))
				if(answer.equals(omr))
					kjum += jum;
			if(i==4)
				b1.setText("��������");
			if(i==korexam.size()-1 || timeChk)
				subClose();
			i++;
		});
	
	}
	
	class Kor extends Thread{
		
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