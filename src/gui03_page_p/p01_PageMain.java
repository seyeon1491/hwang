package gui03_page_p;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Popup;
import javafx.stage.Stage;



public class p01_PageMain extends Application {
	
	@FXML Button btn1;

	public void subGo() {  //public 해줘야함 클래스 달라서
		
		try {
			Popup ppp =  new Popup();	//새로운창 생성
			Parent root;
			root = FXMLLoader.load(getClass().getResource("p01_Page.fxml"));
			ppp.getContent().add(root);
			//ppp.show(primaryStage);  //show는 Stage가 있어야한다.
			
			//Stage stage = (Stage)btn1.getScene().getWindow();   //show 다른방법 
			ppp.show(btn1.getScene().getWindow());
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("p01_PageMain.fxml"));
		
		Parent root = loader.load();
		
		p01_PageController controller = loader.getController();
		//controller.setPrimaryStage(primaryStage);  //controller에 다른방법잇으
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}