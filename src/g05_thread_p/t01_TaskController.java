package g05_thread_p;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

//fx:controller="g05_thread_p.t01_TaskController"
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class t01_TaskController implements Initializable {

	NumberGo numbergo;
	@FXML Button sb;
	@FXML Button pb;
	@FXML Label label;
	@FXML Polyline ss;
	@FXML HBox pp;
	
	////////////////////////////////////////
	boolean chk = true;
	
//	boolean reChk = false;
	boolean reChk = true;

	HashMap<Boolean, String>chkMap, restartMap;
	///////////////////////////////////////////
	
	@Override
//	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//		numbergo = new NumberGo();
//		numbergo.start();
//		
//		
//		pb.setOnAction(ee -> {
//			numbergo.cancel();
//		});
//		
//		sb.setOnAction(ee -> {
//			
//			if(sb.getGraphic().equals(pp)) {
//				aa = false;
//				sb.setGraphic(ss);
//				sb.setText("");
//			}
//		
//			else if(sb.getGraphic().equals(ss)) {
//				aa = true;
//				sb.setGraphic(pp);
//			}
//		});
		
		
		///////////////////////////////////////
			
		
//		chkMap = new HashMap<>();
//		chkMap.put(true, "||");
//		chkMap.put(false, "▶");
//		
//		restartMap = new HashMap<>();
//		restartMap.put(true, "■");
//		restartMap.put(false, "restart");
//		
//		numbergo = new NumberGo();
//		numbergo.start();
//		
//		pb.setOnAction(ee->{
//			//reChk ::: true  진행중
//			if(reChk) {
//				numbergo.cancel();
//			}
//			else {
//				numbergo.restart();
//			}
//			
//			reChk = !reChk;
//			pb.setText(restartMap.get(reChk));
//			
//		});
//		
//		sb.setOnAction(ee->{
//			chk = !chk;
//			sb.setText(chkMap.get(chk));
//		});
//
//	}
//
//	
//	class NumberGo extends Service<Void> {
//		
//		@Override
//		protected Task<Void> createTask() {
//			// TODO Auto-generated method stub
//			
//			Task<Void> task = new Task<Void>() {
//				
//				@Override
//				protected Void call() throws Exception {
//					// TODO Auto-generated method stub
//					
//					int i = -1;
//					while(true) {
//						if(chk)
//							i++;
//						System.out.println("들어온다");
//						Thread.sleep(1000);
//						//label.setText(i + ""); 쓰레드 내부에서 직접 gui 객체 변경 불가!!!   메소드를 통해서만 가능하다.
//						updateMessage(i + ""); // task내부 메소드로 가지고 나감
//						
////						if(!reChk)
////							break;
//					}
//					//return null;
//				}
//			};
//			
//			label.textProperty().bind(task.messageProperty()); // label과 task를 묶어준다
//			return task;
//		}	
//	}
//}
		
		
		
		
		
		
		
		
		
		
		////////////////////////////////////////
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
//			numbergo = new NumberGo();
//			numbergo.start();
//			
//			
//			pb.setOnAction(ee -> {
//				numbergo.cancel();
//			});
//			
//			sb.setOnAction(ee -> {
//				
//				if(sb.getGraphic().equals(pp)) {
//					aa = false;
//					sb.setGraphic(ss);
//					sb.setText("");
//				}
//			
//				else if(sb.getGraphic().equals(ss)) {
//					aa = true;
//					sb.setGraphic(pp);
//				}
//			});
			
			
			///////////////////////////////////////
				
			
			chkMap = new HashMap<>();
			chkMap.put(true, "||");
			chkMap.put(false, "▶");
			
			restartMap = new HashMap<>();
			restartMap.put(true, "■");
			restartMap.put(false, "restart");
			
			numbergo = new NumberGo();
			numbergo.start();
			
			pb.setOnAction(ee->{
				//reChk ::: true  진행중
				if(reChk) {
					numbergo.stop();
				}
				else {
					numbergo = new NumberGo();
					numbergo.start();
				}
				
				reChk = !reChk;
				pb.setText(restartMap.get(reChk));
				
			});
			
			sb.setOnAction(ee->{
				if(chk)
					numbergo.suspend();
				else {
					numbergo.resume();
				}
				chk = !chk;
				sb.setText(chkMap.get(chk));
			});

		}
		
		class NumberGo extends Thread  {
			
			int i = 0;
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				
				while(true) {
					
//					if(chk)
						i++;
						
						
//					Platform.runLater( () -> {
//						label.setText(i+"");
//					});
					
					Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							label.setText(i+"");
						}
					});
						
//				}
					
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				
			}
		}
	}
}
