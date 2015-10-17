package main;

import auxiliary.Patient;
import data.PatientsCreator;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
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
	     
	     ringChart.getPatients().get(0).getPatientOnChart().getRegion().addEventHandler(MouseEvent.MOUSE_PRESSED,
	                new EventHandler<MouseEvent>() {
             @Override public void handle(MouseEvent e) {
                Region reg =(Region) e.getSource();
               ringChart.setStartAngle(ringChart.getStartAngle()+90);
   
              }
         });
		
	}

}
