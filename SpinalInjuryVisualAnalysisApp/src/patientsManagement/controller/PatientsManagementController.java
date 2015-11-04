package patientsManagement.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import startWindow.controller.StartWindowController;

public class PatientsManagementController implements Initializable
{

	private Stage stage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		
	}
	
	public void goToStartWindow()
	{
		try {
			stage.hide();
			
			
			 FXMLLoader loader = new FXMLLoader();
	         loader.setLocation(getClass().getResource("/startWindow/view/startWindowView.fxml"));
	         AnchorPane root = (AnchorPane) loader.load();
	         
	         
	         Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

	        double minX = primaryScreenBounds.getMinX();
	        double minY = primaryScreenBounds.getMinY();
	        double width = primaryScreenBounds.getWidth();
	        double height = primaryScreenBounds.getHeight();
	        
	        double stageWidth = root.getPrefWidth();
	        double stageHeight = root.getPrefHeight();
	        double leftCornerX = minX + width/2 - stageWidth/2;
	        double leftCornerY = minY + height/2 - stageHeight/2;
	         
	         stage.setX(leftCornerX);
	         stage.setY(leftCornerY);
	         stage.setWidth(stageWidth);
	         stage.setHeight(stageHeight);
	            	
	         Scene scene = new Scene(root);
			 stage.setScene(scene);
			 
			 StartWindowController controller = loader.getController();
				if(controller.getStage()==null)
				{
					controller.setStage(stage);
				}
			
			stage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void setStage(Stage stage)
	{
		this.stage = stage;
	}
	
	public Stage getStage()
	{
		return stage;
	}

}
