package page;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SubController implements Initializable{

	
	
	@FXML Button subBtn;
	
	//String data;
	
	@FXML Label label;
	
	@FXML TextField msg;

	////subLayout ��������
	@FXML AnchorPane subLayout;
	
	MainController main;

	
	public void subClose() {
		
			
		///���� layout
		AnchorPane root=  (AnchorPane)subBtn.getScene().getRoot();	
		          //���� Parent �� AnchorPane(layout)�� ������
		
		main.label.setText("From sub:"+msg.getText());
		///���� layout ���� subLayout ����
		root.getChildren().remove(subLayout);
		
	
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		System.out.println(resources.getObject("hi"));
		
		main = (MainController)resources.getObject("main");
		
		//main�� �޾ƿ��� �����ν�
		//data = resources.getObject("data").toString();
		//System.out.println(data);
		//label.setText("From Main :"+data);
		
		label.setText("From Main :"+main.msg.getText());
		
	}

}
