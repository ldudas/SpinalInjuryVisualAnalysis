package startWindow.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import patientsManagement.controller.PatientsManagementController;
import ringChartVisualisation.controller.RingChartController;

public class StartWindowController implements Initializable
{

	private Stage stage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		
	}
	
	public void goToVisualisation()
	{
		try 
		{
			stage.hide();
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/ringChartVisualisation/view/ringChartView.fxml"));
	        GridPane root = (GridPane) loader.load();
	        
	        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	
	       double minX = primaryScreenBounds.getMinX();
	       double minY = primaryScreenBounds.getMinY();
	       double width = primaryScreenBounds.getWidth();
	       double height = primaryScreenBounds.getHeight();
	       
	       double stageWidth = 0.85 * width;
	       double stageHeight = 0.85 * height;
	       double leftCornerX = minX + width/2 - stageWidth/2;
	       double leftCornerY = minY + height/2 - stageHeight/2;
	        
	        stage.setX(leftCornerX);
	        stage.setY(leftCornerY);
	        stage.setWidth(stageWidth);
	        stage.setHeight(stageHeight);
	           
			Scene scene = new Scene(root);
			stage.setScene(scene);
			
			RingChartController controller = loader.getController();
			if(controller.getStage()==null)
			{
				controller.setStage(stage);
			}
			stage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void goToPatients()
	{
		try 
		{
			stage.hide();
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/patientsManagement/view/patientsManagementView.fxml"));
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
			
			PatientsManagementController controller = loader.getController();
			if(controller.getStage()==null)
			{
				controller.setStage(stage);
			}
			stage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void setStage(Stage primaryStage)
	{
		this.stage = primaryStage;
	}
	
	public Stage getStage()
	{
		return stage;
	}

}
