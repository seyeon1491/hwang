package g05_thread_p
;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;

public class t02_ThreadAniController implements Initializable{

	@FXML Pane pane,pane1;
	@FXML Arc arc;
	@FXML AnchorPane totalp;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.setDaemon(true);
		timer.start();
		
		
		totalp.addEventHandler(KeyEvent.KEY_PRESSED , new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent key) {
				// TODO Auto-generated method stub
				System.out.println(key.getCode());
				
				
//				switch(key.getCode()) {
//				case UP:
//					double yy = pane1.getLayoutY()-5;
//					
//					if(yy<0) yy=0;
//
//					pane1.setLayoutY(yy);
//					break;
//				case DOWN:
//					double yyy = pane1.getLayoutY()+5;
//					
//					if(totalp.getPrefHeight()<yyy+pane1.getPrefHeight()) 
//						yyy=totalp.getPrefHeight()-pane1.getPrefHeight();
//					
//					
//					pane1.setLayoutY(yyy);
//					break;
//				case RIGHT:
//					double xx = pane1.getLayoutX()+5;
//					
//					if(totalp.getPrefWidth()<xx+pane1.getPrefWidth()) 
//						xx=totalp.getPrefWidth()-pane1.getPrefWidth();
//					
//					
//					pane1.setLayoutX(xx);
//					break;
//				case LEFT:
//					double xxx = pane1.getLayoutX()-5;
//					
//					if(xxx<0) xxx=0;
//
//					pane1.setLayoutX(xxx);
//					break;
//				
//				
//				}
				if(key.getCode()==KeyCode.UP) {
					double yy = pane1.getLayoutY()-10;
					
					if(yy<0) yy=0;

					pane1.setLayoutY(yy);
				}
				
				if(key.getCode()==KeyCode.DOWN) {
					double yy = pane1.getLayoutY()+10;
					
					if(totalp.getPrefHeight()<yy+pane1.getPrefHeight()) 
						yy=totalp.getPrefHeight()-pane1.getPrefHeight();
					
					
					pane1.setLayoutY(yy);
				}
				
				if(key.getCode()==KeyCode.LEFT) {
					double xx = pane1.getLayoutX()-10;
					
					if(xx<0) xx=0;

					pane1.setLayoutX(xx);
				}
				
				if(key.getCode()==KeyCode.RIGHT) {
					double xx = pane1.getLayoutX()+10;
					
					if(totalp.getPrefWidth()<xx+pane1.getPrefWidth()) 
						xx=totalp.getPrefWidth()-pane1.getPrefWidth();
					
					
					pane1.setLayoutX(xx);
				}
			}
			
			
		});
		
	}

	
	
	class Timer extends Thread {


		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					
//					Platform.runLater( new Runnable() {	
//						@Override
//						public void run() {
//							// TODO Auto-generated method stub
//							init();
//						}
//					});
					
					Platform.runLater(() -> init());
					
					
					sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	boolean aa = true;
	boolean cc = true;	
	int a = 5;
	int b = 5;
	int c = 5;
	void init() {
		// TODO Auto-generated method stub
		
		double xx = pane.getLayoutX()+a;
		if(totalp.getPrefWidth() < xx+pane.getPrefWidth()) {
			a *= -1;
			aa = false;
			if(cc)
				arc.setRotate(-45);
			else if(cc==false)
				arc.setRotate(-135);
		} 
		else if(xx<0) {
			a *= -1;
			aa = true;
			if(cc)
				arc.setRotate(45);
			else if(aa==false)
				arc.setRotate(0);
		}
		
		
		double yy = pane.getLayoutY()+b;
		if(totalp.getPrefHeight() < yy+pane.getPrefHeight()) {
			b *= -1;
			cc = false;
			if(aa)
				arc.setRotate(-45);
			else if(aa==false)
				arc.setRotate(-135);
		
		}
		else if( yy<0 ) {
			b *= -1;
			cc = true;
			if(aa)
				arc.setRotate(45);
			else if(aa==false)
				arc.setRotate(135);
		}
		
		pane.setLayoutX(xx);
		pane.setLayoutY(yy);
		
		if(arc.getStartAngle()==0 || arc.getStartAngle()==45)
			c *= -1;
		
		arc.setStartAngle(arc.getStartAngle()+c);
		arc.setLength(arc.getLength()-(c*2));
	}
	
	
}
