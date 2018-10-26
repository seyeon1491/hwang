package Exam;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import Exam.SubController;
import Exam.SubController2;
import Exam.SubController3;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import page.MainController;

public class SubController4 implements Initializable{

	@FXML Button subBtn;
	@FXML Label kor,mat,eng;
	@FXML AnchorPane subLayout;
	
	MainController main;
	SubController ko;
	SubController2 ma;
	SubController3 en;
	
	public void subClose() {
		AnchorPane root=  (AnchorPane)subBtn.getScene().getRoot();	        
		root.getChildren().remove(subLayout);		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		

	}

}