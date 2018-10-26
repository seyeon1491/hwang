package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class g07_ControlMain2 extends Application implements Initializable{

	@FXML CheckBox checkBox;
	@FXML RadioButton genM; //�׷��� �ƴ� ��ü�� �����ð�
	@FXML RadioButton genF;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		checkBox.setSelected(false);    //true üũ false üũx     ������ �������� �����Ѵ�� ���
		checkBox.setOnAction( ee -> {
				System.out.println("üũ�ڽ� : " + checkBox.isSelected());		
				CheckBox box = (CheckBox)ee.getSource();
				System.out.println(box.getText());
		}
		);
	
	/*	genM.setOnAction(ee -> {
			System.out.println("����");
			
		});
		genF.setOnAction(ee -> {
			System.out.println("����");
		});
	*/	
		EventHandler handler = ee -> {
			RadioButton rd = (RadioButton)ee.getSource();
			System.out.println("���� : " + rd.getText()+ rd.getId());
			
		};
		genM.setOnAction(handler);
		genF.setOnAction(handler);
		
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
