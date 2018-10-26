package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

class Member {
	String id,pw,name,nick,gen,num,email,address,birth;

	public Member(String id, String pw, String name, String nick, String gen, String num, String email, String address,
			String birth) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nick = nick;
		this.gen = gen;
		this.num = num;
		this.email = email;
		this.address = address;
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", nick=" + nick + ", gen=" + gen + ", num=" + num
				+ ", email=" + email + ", address=" + address + ", birth=" + birth + "]";
	}
	
	
	
	
}

class Main extends Application implements Initializable {

	@FXML TextField main_id;
	@FXML PasswordField main_pw;
	@FXML PasswordField main_pw1;
	@FXML TextField main_name;
	@FXML TextField main_nick;
	@FXML RadioButton male;	
	@FXML RadioButton female;	
	@FXML ComboBox main_num;	
	@FXML TextField main_num1;
	@FXML TextField main_num2;
	@FXML TextField main_email;
	@FXML ComboBox main_email1;	
	@FXML TextField main_address;
	@FXML DatePicker main_birth;
	@FXML Button bu;
	@FXML Button idChk;
	@FXML Button cancel;
	
	

	RadioButton rd;
	boolean idchk = false;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//RadioButton---------------------------------------------------------
		Alert alert = new Alert(AlertType.CONFIRMATION);
	      alert.setTitle("알림창");

		EventHandler handler = ee -> {
				rd = (RadioButton)ee.getSource();
			};
		male.setOnAction(handler);
		female.setOnAction(handler);
				
				
		//ComboBox---------------------------------------------------------
		ObservableList<String> emailData = 
				FXCollections.observableArrayList("google.com","naver.com","daum.net","zum.com");
		ObservableList<String> numData = 
				FXCollections.observableArrayList("010","011","016","017","019");
		//email.setValue("네이버");
		main_email1.setValue(emailData.get(1));
		main_email1.setItems(emailData);
		main_num.setValue(numData.get(0));
		main_num.setItems(numData);
				
		
		idChk.setOnAction(ee -> {
			if(main_id.getText().equals("")) {
				alert.setHeaderText("ID를 입력하세요.");
				alert.show();
				main_id.requestFocus();
				return;
			}
			else {
				alert.setHeaderText("사용 가능한 ID입니다.");
				alert.show();
				main_pw.requestFocus();
				idchk = true;
			}
		});
		
		
		bu.setOnAction(ee->{
			String id = main_id.getText();
			if(!idchk == true) {
				alert.setHeaderText("ID중복 확인하세요.");
				alert.show();
				main_id.requestFocus();
				return;
			}
			String pw = main_pw.getText();
			if(!main_pw.getText().equals("") && !main_pw1.getText().equals("")) {
				if(main_pw1.getText().equals(main_pw.getText()))
						pw = main_pw.getText();
				else {
					main_pw1.requestFocus();
					alert.setHeaderText("비밀번호가 일치하지 않습니다.");
					alert.show();
					return;
				}				
			}
			else {
				if(main_pw.getText().equals("")) {
					alert.setHeaderText("비밀번호를 입력하세요.");
					alert.show();
					main_pw.requestFocus();
				}else {
					alert.setHeaderText("비밀번호확인 입력하세요.");
					alert.show();
					main_pw1.requestFocus();
				}
				return;								
			}
			String name = main_name.getText();
			if(main_name.getText().equals("")) {
				alert.setHeaderText("이름을 입력하세요.");
				alert.show();
				main_name.requestFocus();
				return;
			}
			String nick = main_nick.getText();
			if(main_nick.getText().equals("")) {
				alert.setHeaderText("닉네임을 입력하세요.");
				alert.show();
				main_nick.requestFocus();
				return;
			}
			String address = main_address.getText();
			if(main_address.getText().equals("")) {
				alert.setHeaderText("주소를 입력하세요.");
				alert.show();
				main_address.requestFocus();
				return;
			}
			String gen = rd.getText();
			String birth = main_birth.getValue() + "";
			String num = "";		
			if(!Pattern.matches("[0-9][0-9][0-9][0-9]", main_num1.getText())) {
				alert.setHeaderText("전화번호를  다시입력하세요.");
				alert.show();
				main_num1.requestFocus();
				return;
			}
			else {
				if(!Pattern.matches("[0-9][0-9][0-9][0-9]", main_num2.getText())) {
					alert.setHeaderText("전화번호를  다시입력하세요.");
					alert.show();
					main_num2.requestFocus();
					return;
				}
				else {
					num = main_num.getValue() + "-" + main_num1.getText() +  "-" + main_num2.getText();	
				}
			}
			String email = main_email.getText() + "@" + main_email1.getValue();
			if(main_email.getText().equals("")) {
				alert.setHeaderText("email을 입력하세요.");
				alert.show();
				main_email.requestFocus();
				return;
			}
			alert.setHeaderText("가입완료");
			alert.show();
			System.out.println("아이디 : " + id);
			System.out.println("비밀번호 : " + pw);
			System.out.println("이름 : " + name);
			System.out.println("닉네임 : " + nick);
			System.out.println("주소 : " + address);
			System.out.println("생년월일 : " + birth);
			System.out.println("성별 : " + gen);
			System.out.println("전화번호 : " + num);
			System.out.println("email : " + email);

			g08_Exam_회원가입1 a = new g08_Exam_회원가입1();
			a.mem = new Member(id, pw, name, nick, gen, num, email, address, birth);
			
			try {
	                a.start(new Stage());
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }			
			
		});
				
			cancel.setOnAction(ee->{
				System.exit(0);
//				((Stage)((Node)ee.getSource()).getScene().getWindow()).close();
			});
		
			
		
		
	}
	
	

	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("g08_Exam_회원가입.fxml"));
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
public class g08_Exam_회원가입 extends Main {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}



}



