package gui02_layout_p;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class l04_ListViewMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		FXMLLoader loader = new FXMLLoader(getClass().getResource("l04_ListViewMain.fxml"));
		Parent root = loader.load();
		l04_ListViewController controller = loader.getController();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	
}
