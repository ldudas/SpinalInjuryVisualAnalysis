package controller;

import java.net.URL;
import java.util.ResourceBundle;

import auxiliary.Patient;
import data.PatientsCreator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import ringChart.RingChart;

public class RingChartController implements Initializable
{

	@FXML
	private GridPane ringChartGridPane;
	@FXML
	private Slider startAngleSlider;
	
	private RingChart ringChart;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		
		startAngleSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) {
                       changeStartAngle();
                }
            });
		
		ObservableList<Patient> ringChartData = PatientsCreator.getPatients();
	     ringChart = new RingChart(ringChartData);
	     ringChart.setTitle("Spinal Injury Patients");
	     ringChart.setTitleSide(Side.TOP);
	     ringChart.setLegendVisible(true);
	     ringChart.setLegendSide(Side.LEFT);
	     
	     ringChartGridPane.getChildren().add(ringChart);
	}
	
	public void showSyso()
	{
		System.out.println("eventHandled");
	}
	
	public void changeStartAngle()
	{
		ringChart.setStartAngle(startAngleSlider.getValue());
	}
	
	public void resetPatientSelection()
	{
		ringChart.showHiddenConnections();
	}
	

}
