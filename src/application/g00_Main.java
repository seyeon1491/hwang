package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//class Sub extends Application {
//
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		// TODO Auto-generated method stub
//		
//			System.out.println("start다");
//			//primaryStage  >  scene  >  root
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);  //scene는 창 size
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.setTitle("와 서브당");
//			primaryStage.show();
//		
//	}
//	
//	
//}

public class g00_Main extends Application {
	
	public g00_Main() {
		System.out.println("생성자");
	}
	
	
	
	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init이다");
	}



	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("죽는닷");
		//new Sub().launch(new String [] {}); //메인이 끝나면 다음서브가 실행된다.
		//Sub.launch(new String [] {}); //메인이 끝나면 다음서브가 실행된다.
		g01_Sub.main(new String [] {}); //메인이 끝나면 다음서브가 실행된다.
		
	}



	@Override
	public void start(Stage primaryStage) {
		try {
			System.out.println("start다");
			//primaryStage  >  scene  >  root
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);  //scene는 창 size
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("와 제목이당");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("main이다");
		launch(args);  //start를 실행
		
		//작동 순서
		//메인   
		//init   생성자와 같이  동작실행
		//start
		//stop    ->    프로그램 종료시 동작
	}
}
