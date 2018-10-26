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
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class p03_PageController {
	
	Stage primaryStage;
	
	@FXML Button mainbtn;
	@FXML TextField subid;
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void subGo() {  //public 해줘야함 클래스 달라서
		
		try {
			Stage newStage = new Stage(StageStyle.DECORATED); 	
			                          //일반적 새로운 창 생성
			
			Parent root = FXMLLoader.load(
					getClass().getResource("p03_PageController.fxml"));
			
			Scene scene = new Scene(root);
			
			newStage.setScene(scene);
			
			newStage.show();
			
			Stage oldstage =  (Stage)mainbtn.getScene().getWindow();   // mainbtn이 있는 scene의 window를 가져온다.
			oldstage.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
