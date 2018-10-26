package gui03_page_p;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class p03_SubController implements Initializable{

	
	
	@FXML Button subBtn;
	
	String data;

	
	public void mainGo() {
		
		try {
			
			
			Stage ppp = new Stage(StageStyle.DECORATED); 	
			                          //老馆利 货肺款 芒 积己
			
			Stage newStage = new Stage(StageStyle.DECORATED); 	
            //老馆利 货肺款 芒 积己

			Parent root = FXMLLoader.load(
			getClass().getResource("main.fxml"));
			
			Scene scene = new Scene(root);
			
			newStage.setScene(scene);
			
			newStage.show();
			
			Stage oldStage =  (Stage)subBtn.getScene().getWindow();
			oldStage.close();
						
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		data = resources.getObject("").toString();
		System.out.println(data);
	}

}
