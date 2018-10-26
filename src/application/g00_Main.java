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
//			System.out.println("start��");
//			//primaryStage  >  scene  >  root
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);  //scene�� â size
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.setTitle("�� �����");
//			primaryStage.show();
//		
//	}
//	
//	
//}

public class g00_Main extends Application {
	
	public g00_Main() {
		System.out.println("������");
	}
	
	
	
	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init�̴�");
	}



	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("�״´�");
		//new Sub().launch(new String [] {}); //������ ������ �������갡 ����ȴ�.
		//Sub.launch(new String [] {}); //������ ������ �������갡 ����ȴ�.
		g01_Sub.main(new String [] {}); //������ ������ �������갡 ����ȴ�.
		
	}



	@Override
	public void start(Stage primaryStage) {
		try {
			System.out.println("start��");
			//primaryStage  >  scene  >  root
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);  //scene�� â size
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("�� �����̴�");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("main�̴�");
		launch(args);  //start�� ����
		
		//�۵� ����
		//����   
		//init   �����ڿ� ����  ���۽���
		//start
		//stop    ->    ���α׷� ����� ����
	}
}
