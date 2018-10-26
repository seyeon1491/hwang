package gui02_layout_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class l04_ListViewController implements Initializable{

	@FXML Label label;

	@FXML ListView<String> list;

	@FXML Label label1;
	@FXML Button btn0;
	@FXML Button btn1;
	@FXML Button btn2;
	@FXML Button btn3;
	@FXML Button btn4;
	@FXML Button btn5;
	@FXML ListView<String> list1;
	
	ObservableList<String> items;
	ObservableList<String> items1;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		// ���� ������ set�ϰ� ���� �Ҷ�
		//list.setItems(FXCollections.observableArrayList());
		
		list.getItems().add("�ø�");
		list.getItems().add("Ī����");
		list.getItems().add("���ĵκ�");

		list1.getItems().add("�Ȱ�");
		list1.getItems().add("����");
		list1.getItems().add("�ڵ���");
		list1.getItems().add("��Ʈ��");
		
		//SINGLE ó��
//		list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);   //MULTIPLE �������� �����Ҽ��ִ�
//																		   //SINGLE   �Ѱ� ����
//		
//		list.setOnMouseClicked(mm -> {
//			Object obj = list.getSelectionModel().getSelectedItem();
//			label.setText(obj.toString());
//		});
//		
//		
//		list.getSelectionModel().selectedItemProperty().addListener(   //selectedItemProperty() String ,   selectedIndexProperty() integer     
//				(observable, oldValue, newValue) -> {		
//					label.setText(oldValue + "->" + newValue);
//				});

		
		
		//MULTIPLE ó��
//		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);   
//		   
//
//		list.setOnMouseClicked(mm -> {
//			items = list.getSelectionModel().getSelectedItems();
//			for (String str : items) {
//				System.out.println(str);
//				
//			}	
//		});
//		
//		
//		//�������
//		btn.setOnAction(ee -> {
//			if(items!=null) {
//				for (String str : items) {
//					list.getItems().remove(str); 
//				}
//			}
//		});
		
		
//		@FXML Label label;
//		@FXML Button btn;
//		@FXML Button btn1;
//		@FXML ListView<String> list;
//
//		@FXML Label label1;
//		@FXML Button btn2;
//		@FXML Button btn3;
//		@FXML ListView<String> list2;
		
		
		//MULTIPLE ó��
				list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);   
				list1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);   
				   

				list.setOnMouseClicked(mm -> {
					items = list.getSelectionModel().getSelectedItems();
					for (String str : items) {
						System.out.println(str);
						
					}	
				});
				
				list1.setOnMouseClicked(mm -> {
					items1 = list1.getSelectionModel().getSelectedItems();
					for (String str : items1) {
						System.out.println(str);
						
					}	
				});
				
				
				
				//�������
				btn2.setOnAction(ee -> {
					if(items!=null) {
						list.getItems().removeAll(items); 
					}
				});
				//�������
				btn3.setOnAction(ee -> {
					if(items1!=null) {
						list1.getItems().removeAll(items1); 
					}
				});
			
				btn4.setOnAction(ee -> {
					if(items!=null) {
						for (String str : items) {
							list1.getItems().add(str);
						}
						list.getItems().removeAll(items); 
					}
				});
				
				btn5.setOnAction(ee -> {
					if(items1!=null) {
						for (String str : items1) {
							list.getItems().add(str);
						}
						list1.getItems().removeAll(items1);
					}
				});
				
				
		
		
		
	
	}
}
