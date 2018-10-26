package gui02_layout_p;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class l01_PaddingMargin extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		HBox hbox = new HBox();
		////
		hbox.setPadding(new Insets(50,10,100,200));  //좌 우 상 하 간격    padding 전체공간 확보      gui에서 HBox의 layout에서도 할수 있
		
		Button btn = new Button();
		Button btn1 = new Button();
		btn.setPrefSize(100, 100);
		btn1.setPrefSize(100, 100);
		hbox.setMargin(btn, new Insets(20,20,20,20)); //margin btn(각 개체)에 대한 공간 확보
		
		
		hbox.getChildren().add(btn);
		hbox.getChildren().add(btn1);
		
		Scene scene = new Scene(hbox);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
