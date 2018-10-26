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
		transition.setToX(400);	//����x��ġ
		transition.setToY(0);	//����Y��ġ
		transition.setDuration(new Duration(5000));//����ð�
		transition.setCycleCount(5);	//�ݺ�Ƚ��
		transition.setAutoReverse(true);
		
		transition.setNode(arc);		//������ node
		transition.play();
		
		pb.setOnAction(ee -> {
			if(pb.getText().equals("�Ͻ�����")) {
				transition.pause();
				pb.setText("����");
			}
			else if(pb.getText().equals("����")) {
				transition.play();
				pb.setText("�Ͻ�����");
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
