package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import auxiliary.Patient;
import data.PatientsCreator;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import ringChart.BMIGroup;
import ringChart.InjuryLevelGroup;
import ringChart.PatientOnChart;
import ringChart.RingChart;

public class RingChartController implements Initializable
{

	@FXML
	private TitledPane bmiGroupPane;
	@FXML
	private TitledPane patientPane;
	
	@FXML
	private GridPane ringChartGridPane;
	@FXML
	private Slider startAngleSlider;
	@FXML
	private ComboBox<InjuryLevelGroup> injuryLevelGroupSelect;
	@FXML
	private ComboBox<BMIGroup> bmiGroupSelect;
	@FXML
	private ComboBox<PatientOnChart> patientSelect;
	@FXML
	private CheckBox animationsCheckBox;
	
	
	private RingChart ringChart;
	
	private InjuryLevelGroup selectedInjuryLevelGroup;
	private BMIGroup selectedBMIGroup;
	private PatientOnChart selectedPatientOnChart;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		
		 ObservableList<Patient> ringChartData = PatientsCreator.getPatients();
	     ringChart = new RingChart(ringChartData);
	     ringChart.setTitle("Spinal Injury Patients");
	     ringChart.setTitleSide(Side.TOP);
	     ringChart.setLegendVisible(true);
	     ringChart.setLegendSide(Side.LEFT);
	     
	     ringChartGridPane.getChildren().add(ringChart);
	     
	     startAngleSlider.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                    Number old_val, Number new_val) {
	                       changeStartAngle();
	                }
	            });
	     
	     injuryLevelGroupSelect.setItems(FXCollections.<InjuryLevelGroup>observableArrayList(ringChart.getShownInjuryLevelGroups().values()));
	     
	     ringChart.chosenPatientProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable arg0)
			{
				System.out.println("addition Listener: "+ringChart.getChosenPatient());
				//TODO zaznacz z prawej ze pacjent zaznaczony
			}
		});
	}
	
	public void changeStartAngle()
	{
		ringChart.setStartAngle(startAngleSlider.getValue());
	}
	
	public void resetPatientSelection()
	{
		ringChart.showHiddenConnections();
	}
	
	public void injuryLevelGroupSelected()
	{
		
		 InjuryLevelGroup currentSelectedInjuryLevelGroup = injuryLevelGroupSelect.getValue();
		  
		 if(selectedInjuryLevelGroup==null || selectedInjuryLevelGroup!=currentSelectedInjuryLevelGroup)
		 {
		 
	     Collection<BMIGroup> bmiGroups = currentSelectedInjuryLevelGroup.getBmiGroups().values();
	     
	     bmiGroupSelect.setItems(FXCollections.observableArrayList(bmiGroups));
			 
		 
	     if(selectedPatientOnChart!=null)
	     {
	    	 ringChart.showHiddenConnections();
	    	 selectedPatientOnChart=null;
	     }
	     
	     bmiGroupPane.setDisable(false);
		 
		 selectedInjuryLevelGroup = currentSelectedInjuryLevelGroup;
		 }
	}
	
	public void bmiGroupSelected()
	{
		BMIGroup currentSelectedBMIGroup = bmiGroupSelect.getValue();
		
		
		
		if(currentSelectedBMIGroup != null && (selectedBMIGroup== null || currentSelectedBMIGroup!= selectedBMIGroup))
		{

		List<PatientOnChart> patientsOnChart = new ArrayList<PatientOnChart>();
		patientsOnChart.addAll(currentSelectedBMIGroup.getPatientsOnChartWomen());
		patientsOnChart.addAll(currentSelectedBMIGroup.getShownPatientsOnChartMen());
		
		patientSelect.setItems(FXCollections.observableArrayList(patientsOnChart));
		
		if(selectedPatientOnChart!=null)
	    {	
			ringChart.showHiddenConnections();
			selectedPatientOnChart=null;
	    }
		
		patientPane.setDisable(false);
		
		selectedBMIGroup = currentSelectedBMIGroup;
		}
	}
	
	public void patientSelected()
	{
		PatientOnChart currentSelectedPatient = patientSelect.getValue();
		
		if(currentSelectedPatient!= null)
		{
			ringChart.setChosenPatient(currentSelectedPatient);
			
			selectedPatientOnChart = currentSelectedPatient;
		}
		
	}
	
	public void changeAnimated()
	{
		ringChart.setAnimated(animationsCheckBox.isSelected());
	}
	

}
