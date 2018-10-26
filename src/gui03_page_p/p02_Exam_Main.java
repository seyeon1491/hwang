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

public class p02_Exam_Main extends Application {
	
	@FXML Button btn1;

	public void subGo() { 
		
		try {
			Popup ppp =  new Popup();	
			Parent root;
			root = FXMLLoader.load(getClass().getResource("p02_Exam_Main.fxml"));
			ppp.getContent().add(root);
			ppp.show(btn1.getScene().getWindow());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("p02_Exam_Main.fxml"));
		
		Parent root = loader.load();
		
		p02_Exam_Controller controller = loader.getController();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}