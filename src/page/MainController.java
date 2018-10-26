package page;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {

	
	
	@FXML Button mainBtn;
	
	@FXML TextField msg;
	
	@FXML Label label;


	MainController me;
	
	public void subGo() {
		
		try {
			
			///���� layout
			AnchorPane root=  (AnchorPane)mainBtn.getScene().getRoot();	
			          //���� Parent �� AnchorPane(layout)�� ������
			
			me = this;  //�ڱ��ڽ��� ��������� ����
			
			///sub layout
			Parent sub = FXMLLoader.load(
					getClass().getResource("sub.fxml"),
					new ResourceBundle() {
						
						@Override
						protected Object handleGetObject(String key) {
							// TODO Auto-generated method stub
							
							HashMap<String, Object>map = new HashMap<>();
							map.put("data", msg.getText());
							map.put("hi", "������ Ȯ �׳�");
							map.put("main", me);
							
							return map.get(key);  ///key�� �ش��ϴ� value return
						}
						
						@Override
						public Enumeration<String> getKeys() {
							// TODO Auto-generated method stub
							return null;
						}
			});
			
			root.getChildren().add(sub);
			
			//���� layout �� ������ sub_layout �� ��ҷ� �߰�
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		if(resources!=null)
			label.setText("From Sub :"+resources.getObject("").toString());
	}

}
