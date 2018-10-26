package Exam;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController{

	@FXML Button b1,b2,b3;
	@FXML TextField msg;
	@FXML Label label;
	
	MainController me;
	
	SubController ko;
	SubController2 ma;
	SubController3 en;

	public void korGo() {
		try {
			AnchorPane root=  (AnchorPane)b1.getScene().getRoot();	
			me = this; 
			Parent sub = FXMLLoader.load(
					getClass().getResource("sub.fxml"));
			root.getChildren().add(sub);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void matGo() {
		
		try {
			AnchorPane root=  (AnchorPane)b2.getScene().getRoot();	
			Parent sub = FXMLLoader.load(
					getClass().getResource("sub2.fxml")
					);
			root.getChildren().add(sub);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void engGo(){
	
		try {
			AnchorPane root=  (AnchorPane)b3.getScene().getRoot();
			Parent sub = FXMLLoader.load(
					getClass().getResource("sub3.fxml"));
			root.getChildren().add(sub);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void chkGo() {
		
		try {
			AnchorPane root=  (AnchorPane)b3.getScene().getRoot();
			Parent sub = FXMLLoader.load(
					getClass().getResource("sub4.fxml"));
			root.getChildren().add(sub);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}