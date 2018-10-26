package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class g05_Exam_ȸ������ extends Application implements Initializable {

	@FXML ComboBox<String> email;
	@FXML RadioButton male;
	@FXML RadioButton female;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		//ComboBox---------------------------------------------------------
		ObservableList<String> emailData = 
				FXCollections.observableArrayList("����","���̹�","����","��");
		//email.setValue("���̹�");
		email.setValue(emailData.get(1));
		email.setItems(emailData);
//		email.setOnAction( ee -> {
//			System.out.println("email �̺�Ʈ" + email.getValue());
//		});
		
		
		
//		email.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				// TODO Auto-generated method stub
//				System.out.println(oldValue + " -> " + newValue);
//			}
//		});
		
		
		email.getSelectionModel().selectedItemProperty().addListener((
				observable, oldValue, newValue) -> {
			
					System.out.println("email : " + oldValue + " -> " + newValue);
		});
		
		
		
		
		//RadioButton---------------------------------------------------------
				EventHandler handler = ee -> {
					RadioButton rd = (RadioButton)ee.getSource();
					System.out.println("���� : " + rd.getText()+ rd.getId());
					
				};
				male.setOnAction(handler);
				female.setOnAction(handler);
		
		
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	
		
		
		
		Parent parent = FXMLLoader.load(getClass().getResource("g05_Exam_ȸ������.fxml"));
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);		
		primaryStage.setTitle("ȸ������");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}



}

//��Ʋ�� ȸ������ �����
