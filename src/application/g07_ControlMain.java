package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class g07_ControlMain extends Application implements Initializable{

	@FXML CheckBox checkBox;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		checkBox.setSelected(false);    //true 체크 false 체크x     없으면 빌더에서 설정한대로 출력
		checkBox.setOnAction( ee -> {
				System.out.println("체크박스 : " + checkBox.isSelected());
		});
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("g07_control.fxml"));
		Scene scene = new Scene(parent);

		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	
}
