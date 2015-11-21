package main;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import startWindow.controller.StartWindowController;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			 FXMLLoader loader = new FXMLLoader();
	         loader.setLocation(getClass().getResource("/startWindow/view/startWindowView.fxml"));
	         AnchorPane root = (AnchorPane) loader.load();
	         Scene scene = new Scene(root);
			 primaryStage.setScene(scene);
			 primaryStage.getIcons().add(new Image("/resources/ring-icon.png"));
			 primaryStage.setTitle("Main menu");
	         
	         Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

	         double minX = primaryScreenBounds.getMinX();
	        double minY = primaryScreenBounds.getMinY();
	        double width = primaryScreenBounds.getWidth();
	        double height = primaryScreenBounds.getHeight();
	        
	        double stageWidth = root.getPrefWidth();
	        double stageHeight = root.getPrefHeight();
	        double leftCornerX = minX + width/2 - stageWidth/2;
	        double leftCornerY = minY + height/2 - stageHeight/2;
	         
	         primaryStage.setX(leftCornerX);
	         primaryStage.setY(leftCornerY);
	         primaryStage.setWidth(stageWidth);
	         primaryStage.setHeight(stageHeight);
	            
			
			
			StartWindowController controller = loader.getController();
			controller.setStage(primaryStage);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
