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

public class g01_CanvasMain extends Application implements Initializable{

	@FXML Canvas canvas;
	GraphicsContext gc;  //그림판 객체
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.RED);
		gc.fillRect(100, 10, 200, 50);  // 시작점 (100,10)   size(200,50) 
		
		gc.setStroke(Color.GREEN);
		gc.strokeRect(100, 20, 130, 70);
		
		gc.setStroke(Color.BLUE);
		gc.strokeOval(50, 70, 100, 100);
		
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
		
		gc.fillArc(400,100,100,100,45,90,ArcType.ROUND);
		
		
		gc.fillPolygon(new double [] {450,570,650,520},new double [] {470,400,560,540},4);
		gc.strokePolygon(new double [] {450,570,650,520},new double [] {470,400,560,540},4);
		
		Image img; 
		//img = new Image("file:ppp/aaa.jpg");
		img = new Image("file:ppp/aaa.jpg",300,300,true,true);
		gc.drawImage(img, 50, 400);

		img = new Image("file:ppp/aa.jpg",500,500,true,true);
		gc.drawImage(img, 50, 400);
		
		
		
		
		
		
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Parent parent =  FXMLLoader.load(getClass().getResource("g01_CanvasMain.fxml"));
		
		Scene scene = new Scene(parent);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


}
