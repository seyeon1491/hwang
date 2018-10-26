package g05_thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class TimelineController implements Initializable {

	@FXML Arc arc;
	@FXML Button btn1, btn2;
	Timer3 t3;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		btn1.setOnAction( ee -> {
			
		
		Timeline t1 = new Timeline();
		
		
		KeyFrame key1 = new KeyFrame(new Duration(0),              //Duration 시간이 매우
						new KeyValue(arc.layoutXProperty(), 50));
		KeyFrame y1 = new KeyFrame(new Duration(0), new KeyValue(arc.layoutYProperty(), 50));
		KeyFrame key2 = new KeyFrame(new Duration(1000), new KeyValue(arc.layoutXProperty(), 100));
		KeyFrame y2 = new KeyFrame(new Duration(1000), new KeyValue(arc.layoutYProperty(), 50));
		KeyFrame key3 = new KeyFrame(new Duration(2000), new KeyValue(arc.layoutXProperty(), 100));
		KeyFrame y3 = new KeyFrame(new Duration(2000), new KeyValue(arc.layoutYProperty(), 200));

		//add순사와 KeyFrame순서는 상관없다.
		t1.getKeyFrames().add(key1);
		t1.getKeyFrames().add(y1);
		t1.getKeyFrames().add(key2);
		t1.getKeyFrames().add(y2);
		t1.getKeyFrames().add(key3);
		t1.getKeyFrames().add(y3);
		
		t1.setCycleCount(5);  // -1 무한반복
		t1.setAutoReverse(true);
		t1.play();
		});
		
		
		
		btn2.setOnAction( ee -> {

			t3 = new Timer3();
			t3.start();
			Timeline t1 = new Timeline();
			
			KeyFrame y1 = new KeyFrame(new Duration(3000), new KeyValue(arc.layoutYProperty(), 470));
			KeyFrame x1 = new KeyFrame(new Duration(3000), new KeyValue(arc.layoutXProperty(), 100));

			KeyFrame y2 = new KeyFrame(new Duration(4500), new KeyValue(arc.layoutYProperty(), 300));
			KeyFrame x2 = new KeyFrame(new Duration(4500), new KeyValue(arc.layoutXProperty(), 150));

			KeyFrame y3 = new KeyFrame(new Duration(6000), new KeyValue(arc.layoutYProperty(), 470));
			KeyFrame x3 = new KeyFrame(new Duration(6000), new KeyValue(arc.layoutXProperty(), 200));
			
			KeyFrame y4 = new KeyFrame(new Duration(6750), new KeyValue(arc.layoutYProperty(), 400));
			KeyFrame x4 = new KeyFrame(new Duration(6750), new KeyValue(arc.layoutXProperty(), 225));
			
			KeyFrame y5 = new KeyFrame(new Duration(7500), new KeyValue(arc.layoutYProperty(), 470));
			KeyFrame x6 = new KeyFrame(new Duration(7500), new KeyValue(arc.layoutXProperty(), 250));
			
			t1.getKeyFrames().add(y1);
			t1.getKeyFrames().add(x1);
			t1.getKeyFrames().add(y2);
			t1.getKeyFrames().add(x2);
			t1.getKeyFrames().add(y3);
			t1.getKeyFrames().add(x3);
			t1.getKeyFrames().add(y4);
			t1.getKeyFrames().add(x4);
			t1.getKeyFrames().add(y5);
			t1.getKeyFrames().add(x6);
		
			
			t1.play();
			
			
		});
		
		
		
	
	
	}
	
	class Timer3 extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
			cla();
			
			try {
				sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			}
		}
		
		void cla() {
			ScaleTransition transition = new ScaleTransition();
			transition.setFromX(1);
			transition.setToX(2);
			transition.setFromY(2);
			transition.setToY(1);
			transition.setNode(arc);
			transition.setDuration(new Duration(1500));
			transition.setAutoReverse(true);
			transition.setCycleCount(2);
			if(arc.getLayoutY()>460) {
				
				transition.play();

			}
			if(arc.layoutXProperty().getValue()>460) {
				
				transition.play();
				
			}
		}
		
		
	}

}
