package gui04_graphic_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class g02_GraphicFxmlMain extends Application implements Initializable{

	@FXML Rectangle nm;
	@FXML Polyline sm;
	@FXML Circle o;
	@FXML Arc qq;
	@FXML Ellipse to;
	@FXML Ellipse to1;
	@FXML Button bb;
	
	
	int a = 20;
	int b = 10;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Parent parent =  FXMLLoader.load(getClass().getResource("g02_GraphicFxmlMain.fxml"));
		
		Scene scene = new Scene(parent);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	int maxAngle=45;
	
	int oneAngle = 3;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		nm.setRotate(160);
		
		bb.setOnAction(ee -> {
			System.out.println("4444");
			nm.setRotate(nm.getRotate()*-1);
			
			
			
			double startAngle = qq.getStartAngle();
			
			startAngle+=oneAngle;
			
			if(startAngle>=maxAngle || startAngle<0) {
				oneAngle*=-1;
				
				if(startAngle>=maxAngle)
					startAngle=maxAngle;
				else if(startAngle<0)
					startAngle=0;
			}
			
			qq.setStartAngle(startAngle);
			
			qq.setLength(359-(startAngle*2));
		
	
		});
		
		
		
	}


}
