package gui04_graphic_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class g01_CanvasMain2 extends Application implements Initializable{

	@FXML Canvas canvas;
	GraphicsContext gc;  //그림판 객체
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		gc = canvas.getGraphicsContext2D();
		
		
		
		gc.setStroke(Color.BLUE);
		gc.setStroke(new Color(0, 0, 0, 0.5));
		//빨 초 파  opacity :: 0~1  투명도

		
		gc.setFill(Color.PINK);
		gc.fillRoundRect(50,180,200,200,50,100);
		
		gc.setFill(Color.AQUA);
		gc.fillArc(400,20,100,100,0,90,ArcType.CHORD);
		gc.fillArc(500,20,100,100,0,90,ArcType.OPEN);
		gc.fillArc(600,20,100,100,0,90,ArcType.ROUND);
		gc.setStroke(Color.RED);
		gc.strokeArc(400,20,100,100,0,90,ArcType.CHORD);
		gc.strokeArc(500,20,100,100,0,90,ArcType.OPEN);
		gc.strokeArc(600,20,100,100,0,90,ArcType.ROUND);
		
		gc.fillArc(400,100,100,100,30,180,ArcType.ROUND);
		
		gc.setFill(Color.RED);
		
		
		Image img; 
		//img = new Image("file:ppp/aaa.jpg");
		img = new Image("file:ppp/a.jpg",500,500,true,true);
		gc.drawImage(img, 50, 200);
		
		gc.strokeOval(50, 50, 100, 100);
		gc.strokeOval(30, 30, 140, 140);
		//gc.strokeOval(20, 20, 50, 50);
		gc.fillArc(20,20,50,50,20,230,ArcType.OPEN);
		gc.fillArc(130,20,50,50,290,230,ArcType.OPEN);
		gc.strokeOval(95, 95, 10, 10);
		gc.strokeLine(105,100,140,100);
		gc.strokeLine(100,95,100,75);
		gc.strokePolygon(new double [] {55,75,60,40}, new double [] {150,160,190,180},4);
		gc.fillArc(38.5,170,25,25,150,180,ArcType.ROUND);

		img = new Image("file:ppp/aa.jpg",500,500,true,true);
		gc.drawImage(img, 50, 400);
		
		gc.strokeArc(400,20,100,100,0,180,ArcType.OPEN);
		gc.strokeLine(400, 70, 400, 120);
		gc.strokeLine(500, 70, 500, 120);
		gc.strokeRoundRect(380,70,20,60,20,20);
		gc.strokeRoundRect(500,70,20,60,20,20);
		gc.fillArc(360,80,40,40,90,180,ArcType.ROUND);
		gc.fillArc(500,80,40,40,270,180,ArcType.ROUND);
		
		
		
		
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Parent parent =  FXMLLoader.load(getClass().getResource("g01_CanvasMain2.fxml"));
		
		Scene scene = new Scene(parent);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


}
