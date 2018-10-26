package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class g06_EventMain2 extends Application {

	@FXML Label label1;
	@FXML TextField tf1;
	@FXML Button btn1;
	
	
	@FXML
	void btnClk(ActionEvent ee) {
		System.out.println("qqqqqqq들어오냐?");
		String str = tf1.getText();
		label1.setText("입력내용 : " + str);
		System.out.println(label1);
		tf1.setText("");
		tf1.requestFocus();
		
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("event2.fxml"));
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
