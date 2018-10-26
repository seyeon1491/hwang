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
		
		// 기존 정보를 set하고 새로 할때
		//list.setItems(FXCollections.observableArrayList());
		
		list.getItems().add("냉면");
		list.getItems().add("칭따오");
		list.getItems().add("마파두부");

		list1.getItems().add("안경");
		list1.getItems().add("지갑");
		list1.getItems().add("핸드폰");
		list1.getItems().add("노트북");
		
		//SINGLE 처리
//		list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);   //MULTIPLE 여러개를 선택할수있다
//																		   //SINGLE   한개 선택
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

		
		
		//MULTIPLE 처리
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
//		//삭제기능
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
		
		
		//MULTIPLE 처리
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
				
				
				
				//삭제기능
				btn2.setOnAction(ee -> {
					if(items!=null) {
						list.getItems().removeAll(items); 
					}
				});
				//삭제기능
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
