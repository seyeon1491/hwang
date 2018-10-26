package g05_thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class TranslateController implements Initializable {

	@FXML Arc arc;
	@FXML Button pb;
	@FXML Button sb;
	@FXML Button stop;
	
	
	TranslateTransition transition;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		transition = new TranslateTransition();
		
		transition.setFromX(500);
		transition.setFromY(200);
		transition.setToX(400);	//도착x위치
		transition.setToY(0);	//도착Y위치
		transition.setDuration(new Duration(5000));//진행시간
		transition.setCycleCount(5);	//반복횟수
		transition.setAutoReverse(true);
		
		transition.setNode(arc);		//적용할 node
		transition.play();
		
		pb.setOnAction(ee -> {
			if(pb.getText().equals("일시정지")) {
				transition.pause();
				pb.setText("시작");
			}
			else if(pb.getText().equals("시작")) {
				transition.play();
				pb.setText("일시정지");
			}
			System.out.println(transition.getStatus());
		});
		
		sb.setOnAction(ee -> {
			
			transition.play();
			System.out.println(transition.getStatus());
			});

		stop.setOnAction(ee -> {
			transition.stop();
			System.out.println(transition.getStatus());
		});
	
	}

}
