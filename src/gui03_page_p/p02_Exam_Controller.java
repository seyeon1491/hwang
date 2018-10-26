package gui03_page_p;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class p02_Exam_Controller {
	
	@FXML Button btn;

	public void subGo() { 
		
		try {
			Popup ppp =  new Popup();	
			Parent root;
			root = FXMLLoader.load(getClass().getResource("p02_Exam_Controller.fxml"));
			ppp.getContent().add(root);
			ppp.show(btn.getScene().getWindow());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
