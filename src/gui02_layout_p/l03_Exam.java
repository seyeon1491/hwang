package gui02_layout_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class l03_Exam extends Application implements Initializable{
	
	@FXML Button num0;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Parent parent = FXMLLoader.load(getClass().getResource("l03_Exam_계산기.fxml"));
		
		Scene scene = new Scene(parent);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("계산기");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}



}
