package application;
	
import controller.RingChartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			 FXMLLoader loader = new FXMLLoader();
	         loader.setLocation(getClass().getResource("/view/ringChartView.fxml"));
	         SplitPane root = (SplitPane) loader.load();
	         
	         Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

	         double minX = primaryScreenBounds.getMinX();
	        double minY = primaryScreenBounds.getMinY();
	        double width = primaryScreenBounds.getWidth();
	        double height = primaryScreenBounds.getHeight();
	        
	        double stageWidth = 0.85 * width;
	        double stageHeight = 0.85 * height;
	        double leftCornerX = minX + width/2 - stageWidth/2;
	        double leftCornerY = minY + height/2 - stageHeight/2;
	         
	         primaryStage.setX(leftCornerX);
	         primaryStage.setY(leftCornerY);
	         primaryStage.setWidth(stageWidth);
	         primaryStage.setHeight(stageHeight);
	            
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			RingChartController controller = loader.getController();
			controller.setStage(primaryStage);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
