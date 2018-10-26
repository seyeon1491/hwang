package gui03_page_p;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class p01_PageController {
	
	Stage primaryStage;
	
	@FXML Button btn;
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void subGo() {  //public ������� Ŭ���� �޶�
		
		try {
			Popup ppp =  new Popup();	//���ο�â ����
			Parent root;
			root = FXMLLoader.load(getClass().getResource("p01_PageSub.fxml"));
			ppp.getContent().add(root);
			//ppp.show(primaryStage);  //show�� Stage�� �־���Ѵ�.
			
			//Stage stage = (Stage)btn.getScene().getWindow();   //show �ٸ���� 
			ppp.show(btn.getScene().getWindow());
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
