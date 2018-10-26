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
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class p03_PageMain extends Application {
	
	@FXML Button subbtn;
	@FXML TextField mainid;

	public void subGo() {  //public 해줘야함 클래스 달라서
		
		try {
			//Popup ppp = new Popup(); 	//새로운 창 생성
			Stage ppp = new Stage(StageStyle.DECORATED); 	
			                          //일반적 새로운 창 생성
			
			Parent root = FXMLLoader.load(
					getClass().getResource("p03_PageMain.fxml"));
			
			Scene scene = new Scene(root);
			
			ppp.setScene(scene);
			
			ppp.show();
		
			Stage oldstage =  (Stage)subbtn.getScene().getWindow();
			oldstage.close();
			
			/*Stage stage =  (Stage)btn.getScene().getWindow();
			ppp.show(stage);*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("p03_PageMain.fxml"));
		
		Parent root = loader.load();
		
		p03_PageController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}