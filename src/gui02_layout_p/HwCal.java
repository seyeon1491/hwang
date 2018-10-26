package gui02_layout_p;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HwCal extends Application implements Initializable {
	
	@FXML Button zero,one,two,three,four,five,six,seven,eight,nine,add,sub,mul,div,equal,init,jum,del;
	@FXML TextField res;
	
	String total="", lastCode="";
	double result=0;
	double re=0;
	String aaa = "";
	String [] a;
	ArrayList<Button>nums = new ArrayList<>(); 
	
	ArrayList<Button> code = new ArrayList<>();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		nums.add(zero);
		nums.add(one);
		nums.add(two);
		nums.add(three);
		nums.add(four);
		nums.add(five);
		nums.add(six);
		nums.add(seven);
		nums.add(eight);
		nums.add(nine);
		nums.add(jum);

		nums.add(add);
		nums.add(sub);
		nums.add(mul);
		nums.add(div);
		
		code.add(add);
		code.add(sub);
		code.add(mul);
		code.add(div);
	
		
		for (Button button : nums) {
			button.setOnAction(ee->{
				
				if(!total.equals("")) {
					if(total.substring(total.length()-1).equals("+") ||
					   total.substring(total.length()-1).equals("-") ||
					   total.substring(total.length()-1).equals("*") ||
					   total.substring(total.length()-1).equals("/")) {
						if(button.getText().equals("+") ||
						   button.getText().equals("-") ||
						   button.getText().equals("*") ||
						   button.getText().equals("/")) {
							total = total.substring(0,total.length()-1)+button.getText();
							res.setText(total);
						}
						else {
							total+=button.getText();
							res.setText(total);
						}
					}
					
					else {	
					total+=button.getText();
					res.setText(total);
					}
				}
				else {
					if(button.getText().equals("+") ||
							   button.getText().equals("-") ||
							   button.getText().equals("*") ||
							   button.getText().equals("/")) {
						total = "";
						res.setText(total);
					}
					else {
					total+=button.getText();
					res.setText(total);
					}
				}
			});
		}
		
		equal.setOnAction(ee->{
			String buf = total;
			String [] arr = {"+","-","*","/"};
			while(true) {
				int pos=buf.length();
				int now=-1;
				for (String string : arr) {
					now=buf.indexOf(string);
					if(pos>now && now>0) {	
						pos=now;
					}
				}
				if(pos==buf.length()) {
					cal(buf);
					break;
				}
				cal(buf.substring(0, pos));
				lastCode=buf.substring(pos,pos+1);
				buf = buf.substring(pos+1);
			}
			re = (double)((int)(result*100))/100;
			
			aaa = re + "";
			a = aaa.split("[.]");
			
		    if(Integer.parseInt(a[1])==0) {
				aaa = (int)re + "";
		    }
			else{
				aaa = re + "";
			}
		    //total+="="+re;
		   
			total=aaa;
			res.setText(total);
			lastCode = "";
		});	
		
		
		del.setOnAction(ee -> {
			if(!res.getText().equals("")) {
				total = res.getText().substring(0, res.getText().length()-1);
				lastCode="";
				result = (int)(result/10);
				res.setText(total);
			}
			else {
				total = "";
				lastCode="";
				res.setText(total);
			}
		});
		
		
		init.setOnAction(ee->{
			total="";
			lastCode="";
			res.setText(total);
		});
		
		
	}
	
	void cal(String str) {
		double su =Double.parseDouble(str);
		switch(lastCode) {
			case "+":
				result += su;
				break;
			case "-":
				result -= su;
				break;
			case "*":
				result *= su;
				break;
			case "/":
				result /= su;
				break;
			case "":
				result = su;
				break;
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Parent parent = FXMLLoader.load(getClass().getResource("cal.fxml"));
		Scene scene = new Scene(parent);
		primaryStage.setTitle("°è»ê±â");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
