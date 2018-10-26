package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class ControlMain extends Application implements Initializable{

	@FXML CheckBox checkBox;
	@FXML RadioButton genM; //�׷��� �ƴ� ��ü�� �����ð�
	@FXML RadioButton genF;
	@FXML ComboBox<String> email;
	@FXML Slider zoom;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		//CheckBox---------------------------------------------------------
		checkBox.setSelected(false);    //true üũ false üũx     ������ �������� �����Ѵ�� ���
		checkBox.setOnAction( ee -> {
				System.out.println("üũ�ڽ� : " + checkBox.isSelected());		
				CheckBox box = (CheckBox)ee.getSource();
				System.out.println(box.getText());	
		});
		
		
		//RadioButton---------------------------------------------------------
		EventHandler handler = ee -> {
			RadioButton rd = (RadioButton)ee.getSource();
			System.out.println("���� : " + rd.getText()+ rd.getId());
			
		};
		genM.setOnAction(handler);
		genF.setOnAction(handler);
		
		
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
		
		
		//Slider---------------------------------------------------------
		zoom.valueProperty().addListener((
				observable, oldValue, newValue) -> {
			
					System.out.println("zoom : " + oldValue + " -> " + newValue);
		});
		
	
		
	}

	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("control.fxml"));
		Scene scene = new Scene(parent);

		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	
}
