package main;

import auxiliary.Patient;
import data.PatientsCreator;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ringChart.RingChart;

public class Main extends Application
{

	public static void main(String[] args)
	{
		 launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		
		 BorderPane borderPane = new BorderPane();
		 Scene scene = new Scene(borderPane);
	     stage.setTitle("Ring chart");
	     stage.setWidth(500);
	     stage.setHeight(500);
	     
	     ObservableList<Patient> ringChartData = PatientsCreator.getPatients();
	     RingChart ringChart = new RingChart(ringChartData);
	     ringChart.setTitle("Spinal Injury Patients");
	     
	     borderPane.setCenter(ringChart);
	     stage.setScene(scene);
	     stage.show();
		
	}

}
