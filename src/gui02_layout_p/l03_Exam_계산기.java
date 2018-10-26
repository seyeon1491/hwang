package gui02_layout_p;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class l03_Exam_계산기 extends Application implements Initializable{
	
	@FXML Button num0;
	@FXML Button num1;
	@FXML Button num2;
	@FXML Button num3;
	@FXML Button num4;
	@FXML Button num5;
	@FXML Button num6;
	@FXML Button num7;
	@FXML Button num8;
	@FXML Button num9;
	@FXML Button add;
	@FXML Button sub;
	@FXML Button mul;
	@FXML Button div;
	@FXML Button set;
	@FXML Button del;
	@FXML Button eq;
	@FXML Label mon;
	@FXML Label mon1;
	
	boolean addchk = false;
	boolean subchk = false;
	boolean mulchk = false;
	boolean divchk = false;

	ArrayList<Button> num = new ArrayList<>();
	ArrayList<Button> cal = new ArrayList<>();
	ArrayList chk = new ArrayList<>();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		
		num.add(num0);
		num.add(num1);
		num.add(num2);
		num.add(num3);
		num.add(num4);
		num.add(num5);
		num.add(num6);
		num.add(num7);
		num.add(num8);
		num.add(num9);
		
		cal.add(add);
		cal.add(sub);
		cal.add(mul);
		cal.add(div);
		
		chk.add(addchk);
		chk.add(subchk);
		chk.add(mulchk);
		chk.add(divchk);
		
		
		for (Button bu : num) {
			bu.setOnAction(ee -> {
				String a = bu.getText();
				mon.setText(mon.getText()+a);
			});
		}
		/*
		for (int i = 0; i < cal.size(); i++) {
			Chk = (boolean) chk.get(i);
			Button bu = cal.get(i);
			bu.setOnAction(ee -> {
				String a = bu.getText();
				Chk = true;
				mon.setText(mon.getText()+a);
			});
			(boolean)chk.get(i) = Chk;
		}
		*/
		
		String [] ccal = {"+","-","*","/"};
		add.setOnAction(ee -> {
			addchk = true;
			String a = add.getText();
			mon.setText(mon.getText()+a);
		});
		
		sub.setOnAction(ee -> {
			subchk = true;
			String a = sub.getText();
			mon.setText(mon.getText()+a);
		});
		
		mul.setOnAction(ee -> {
			mulchk = true;
			String a = mul.getText();
			mon.setText(mon.getText()+a);
		});
		
		
		div.setOnAction(ee -> {
			divchk = true;
			String a = div.getText();
			mon.setText(mon.getText()+a);			
		});
		
		eq.setOnAction(ee -> {	
			cal();
			});
		
		set.setOnAction(ee -> {
			mon.setText("");
		});

		
		del.setOnAction(ee -> {
			if(!mon.getText().equals("")) 
				mon.setText(mon.getText().substring(0,mon.getText().length()-1));
			
			else if (mon.getText().equals(""))
				mon.setText("");
		});
		
	}
	
	void cal() {
		
		if(addchk == true) {
			 
			String [] aaaa = mon.getText().split("[+]");
			int a = (Integer.parseInt(aaaa[0])+Integer.parseInt(aaaa[1]));
			mon.setText(a+"");
			addchk = false;
		}
		
		if(subchk == true) {
			
			String [] aaaa = mon.getText().split("[-]");
			int a = (Integer.parseInt(aaaa[0])-Integer.parseInt(aaaa[1]));
			mon.setText(a+"");
			subchk = false;	
		}
		
		if(mulchk == true) {
			
			String [] aaaa = mon.getText().split("[*]");
			int a = (Integer.parseInt(aaaa[0])*Integer.parseInt(aaaa[1]));
			mon.setText(a+"");
			mulchk = false;
		}
		
		if(divchk == true) {
			
			String [] aaaa = mon.getText().split("[/]");
			int a = (Integer.parseInt(aaaa[0])/Integer.parseInt(aaaa[1]));
			mon.setText(a+"");
			divchk = false;
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Parent parent = FXMLLoader.load(getClass().getResource("l03_Exam_계산기.fxml"));
		
		Scene scene = new Scene(parent);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("계산기");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}



}
