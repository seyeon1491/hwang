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
	@FXML RadioButton genM; //그룹이 아닌 객체로 가져올것
	@FXML RadioButton genF;
	@FXML ComboBox<String> email;
	@FXML Slider zoom;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		//CheckBox---------------------------------------------------------
		checkBox.setSelected(false);    //true 체크 false 체크x     없으면 빌더에서 설정한대로 출력
		checkBox.setOnAction( ee -> {
				System.out.println("체크박스 : " + checkBox.isSelected());		
				CheckBox box = (CheckBox)ee.getSource();
				System.out.println(box.getText());	
		});
		
		
		//RadioButton---------------------------------------------------------
		EventHandler handler = ee -> {
			RadioButton rd = (RadioButton)ee.getSource();
			System.out.println("성별 : " + rd.getText()+ rd.getId());
			
		};
		genM.setOnAction(handler);
		genF.setOnAction(handler);
		
		
		//ComboBox---------------------------------------------------------
		ObservableList<String> emailData = 
				FXCollections.observableArrayList("구글","네이버","다음","줌");
		//email.setValue("네이버");
		email.setValue(emailData.get(1));
		email.setItems(emailData);
//		email.setOnAction( ee -> {
//			System.out.println("email 이벤트" + email.getValue());
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
