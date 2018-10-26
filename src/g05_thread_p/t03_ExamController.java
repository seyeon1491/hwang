package g05_thread_p
;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;

public class t03_ExamController implements Initializable{

	@FXML Pane ball,bar, box;
	@FXML Arc arc;
	@FXML AnchorPane totalp;
	@FXML Label label;
	//@FXML HBox box;
	@FXML Rectangle b1,b2,b3,b4,b5,pb1,pb2,pb3,pb4,pb5;
	List<Rectangle> l = new ArrayList();
	
	Timer1 timer;
	int a = 5;
	int b = 5;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 //TODO Auto-generated method stub
		timer = new Timer1();
		timer.setDaemon(true);
		
	
		l.add(pb1);
		l.add(pb2);
		l.add(pb3);
		l.add(pb4);
		l.add(pb5);
		
		
		totalp.addEventHandler(KeyEvent.KEY_PRESSED , new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent key) {
				 //TODO Auto-generated method stub
				System.out.println(key.getCode());
				
				double xx = 0;
				switch(key.getCode()) {
				case SPACE:
					timer.start();
					break;
				case Z:
					timer.suspend();;
					label.setText("일시정지");
					break;
				case X:
					timer.resume();
					label.setText("");
					break;
				
				case RIGHT:
					xx = bar.getLayoutX()+15;
					if(totalp.getPrefWidth()<xx+bar.getPrefWidth()) 
						xx=totalp.getPrefWidth()-bar.getPrefWidth();
					
					bar.setLayoutX(xx);
					break;
				
				case LEFT:
					xx = bar.getLayoutX()-15;
					if(xx<0) 
						xx=0;

					bar.setLayoutX(xx);
					break;
				}
			}
	
		});
	}
	
	
	class Timer1 extends Thread {
		
		@Override
		public void run() {
			 //TODO Auto-generated method stub
			while(true) {
				try {
					
					Platform.runLater( new Runnable() {	
						@Override
						public void run() {
							 //TODO Auto-generated method stub
							init();
						}
					});
					
					Platform.runLater(() -> init());
					
					
					sleep(30);
				} catch (InterruptedException e) {
					 //TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	void init() {
		//TODO Auto-generated method stub
		double xx = ball.getLayoutX()+a;
		double yy = ball.getLayoutY()+b;
		
		if(totalp.getPrefWidth() < xx+ball.getPrefWidth() || xx<0) {
			a *= -1;	
		} 
		
		if(yy < box.getLayoutY()+box.getPrefHeight() || yy<0) {
			b *= -1;
		}
		
		else if(bar.getLayoutY() < yy+ball.getPrefHeight()) {
			if(bar.getLayoutX()+bar.getPrefWidth() > ball.getLayoutX() && 
			   ball.getLayoutX()+ball.getPrefWidth()>bar.getLayoutX()) 
				b *= -1;
			else {
				timer.stop();
				bar.setLayoutX(150);
				bar.setLayoutY(580);
				xx = 185;
				yy = 555;
				timer = new Timer1();
			}
		}
		ball.setLayoutX(xx);
		ball.setLayoutY(yy);
		
		for (Rectangle ob : l) {
			
		
		if(ball.getLayoutY() < box.getLayoutY()+box.getHeight()) {
			if(ob.getLayoutX()+ob.getWidth() > ball.getLayoutX() && 
			   ball.getLayoutX()+ball.getPrefWidth()>ob.getLayoutX()) {
				ob.setHeight(0);
				ob.setWidth(0);
				ob.setLayoutX(-1);
				ob.setLayoutY(-1);
			}
						
		}
						
		}
		
		
		
	}
}
