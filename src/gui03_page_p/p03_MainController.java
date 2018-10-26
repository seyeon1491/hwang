package gui03_page_p;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

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

public class p03_MainController {

	
	
	@FXML Button mainBtn;
	
	@FXML TextField msg;


	public void subGo() {
		
		try {
			
			
			Stage newStage = new Stage(StageStyle.DECORATED); 	
			                          //老馆利 货肺款 芒 积己
			
			Parent root = FXMLLoader.load(
					getClass().getResource("sub.fxml"),
					new ResourceBundle() {
						
						@Override
						protected Object handleGetObject(String key) {
							// TODO Auto-generated method stub
							return msg.getText();
						}
						
						@Override
						public Enumeration<String> getKeys() {
							// TODO Auto-generated method stub
							return null;
						}
			});
			
			Scene scene = new Scene(root);
			
			newStage.setScene(scene);
			
			newStage.show();
			
			Stage oldStage =  (Stage)mainBtn.getScene().getWindow();
			oldStage.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
