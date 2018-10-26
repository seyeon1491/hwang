package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class g02_BtnMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		VBox vBox = new VBox();
		vBox.setPrefWidth(700);  //가로 size
		vBox.setPrefHeight(400); //세로 size
		vBox.setAlignment(Pos.CENTER);  //버튼위치 정중앙
		
		Button button = new Button("눌러봐"); //레이아웃에 넣어야함   //버튼에 문구넣기
		vBox.getChildren().add(button);
		
		Alert alert = new Alert(AlertType.ERROR); //CONFIRMATION  확인  /  취소 
											  	  //INFORMATION 확인
												  //ERROR 에러창 생성
		alert.setTitle("알림창");
		alert.setContentText("java Fx이지롱");//내용
		alert.setHeaderText("메시지");
		//alert.show();
		
		//람다식
		button.setOnAction(ee -> {
			System.out.println("눌렀습니다.");
			alert.show();  //버튼 클릭시 알림창 생성
		});
		
		//람다식
		//button.setOnAction(ee -> System.out.println("눌렀습니다."));
		
//		button.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				// TODO Auto-generated method stub
//				System.out.println("눌렀습니다.");
//				
//			}
//		});
		//버튼 이벤트 소스
		//대기(어떠한 작업을 할지) 이벤트 리스너  / 핸들러
		Label lb = new Label("라벨이당");
		Font font = new Font("궁서체",50);
		lb.setFont(font);
		Slider slider = new Slider();
		//vBox.getChildren().add(new Label("라벨이당"));
		vBox.getChildren().add(lb);
		vBox.getChildren().add(slider);
		
		//람다식
		slider.valueProperty().addListener(
			(ObservableValue<? extends Number> observable, 
			Number oldValue, 
			Number newValue)->{
				
				
				lb.setText(newValue + "");
				lb.setFont(new Font(newValue.doubleValue()));
				//System.out.println(newValue);
			});
		
		
//		slider.valueProperty().addListener(new ChangeListener<Number>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//				// TODO Auto-generated method stub
//				System.out.println(newValue);
//			}
//			
//		});
		
		
		
		
		
		Scene scene = new Scene(vBox);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
