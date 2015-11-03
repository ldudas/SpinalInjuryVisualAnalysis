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
import javafx.stage.Stage;
import ringChart.BMIGroup;
import ringChart.InjuryLevelGroup;
import ringChart.PatientOnChart;
import ringChart.RingChart;

public class RingChartController implements Initializable
{

	public static Stage stage;
	
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
	@FXML
	private CheckBox fullScreenModeCheckBox;
	
	
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
				PatientOnChart patientOnChart = ringChart.getChosenPatient();
				
				if(patientOnChart!= null && patientOnChart!=patientSelect.getValue())
				{
					injuryLevelGroupSelect.setValue(patientOnChart.getBmiGroup().getInjuryLevelGroup());
					bmiGroupSelect.setValue(patientOnChart.getBmiGroup());
					patientSelect.setValue(patientOnChart);
				}
			}
		});
	     
	     ringChart.chosenBMIGroupProperty().addListener(new InvalidationListener() {
				
				@Override
				public void invalidated(Observable arg0)
				{
					//System.out.println("addition Listener: "+ringChart.getChosenPatient());
					//TODO zaznacz z prawej ze pacjent zaznaczony
					BMIGroup chosenBMIGroup = ringChart.getChosenBMIGroup();
					
					if(chosenBMIGroup!= null && chosenBMIGroup!=bmiGroupSelect.getValue())
					{
						injuryLevelGroupSelect.setValue(chosenBMIGroup.getInjuryLevelGroup());
						bmiGroupSelect.setValue(chosenBMIGroup);
						patientSelect.setValue(null);
					}
				}
			});
	     
	     ringChart.chosenInjuryLevelGroupProperty().addListener(new InvalidationListener() {
				
				@Override
				public void invalidated(Observable arg0)
				{
					//System.out.println("addition Listener: "+ringChart.getChosenPatient());
					//TODO zaznacz z prawej ze pacjent zaznaczony
					InjuryLevelGroup chosenInjuryLevelGroup = ringChart.getChosenInjuryLevelGroup();
					
					if(chosenInjuryLevelGroup!= null && chosenInjuryLevelGroup!=injuryLevelGroupSelect.getValue())
					{
						injuryLevelGroupSelect.setValue(chosenInjuryLevelGroup);
						bmiGroupSelect.setValue(null);
						patientSelect.setValue(null);
					}
				}
			});
	}
	
	public void changeStartAngle()
	{
		ringChart.setStartAngle(startAngleSlider.getValue());
	}
	
	public void resetPatientSelection()
	{
		injuryLevelGroupSelect.setValue(null);
		bmiGroupPane.setDisable(true);
		patientPane.setDisable(true);
	}
	
	public void injuryLevelGroupSelected()
	{
		
		 InjuryLevelGroup currentSelectedInjuryLevelGroup = injuryLevelGroupSelect.getValue();
		  
		 if(selectedInjuryLevelGroup!=currentSelectedInjuryLevelGroup)
		 {
		 
			if(currentSelectedInjuryLevelGroup!=null)
			 {
		     Collection<BMIGroup> bmiGroups = currentSelectedInjuryLevelGroup.getBmiGroups().values();
		     
		     bmiGroupSelect.setItems(FXCollections.observableArrayList(bmiGroups));
		     
		     bmiGroupPane.setDisable(false);
			 }
			
		     bmiGroupSelect.setValue(null);
			 
		     ringChart.setChosenInjuryLevelGroup(currentSelectedInjuryLevelGroup);
		     
		     
			 
			 selectedInjuryLevelGroup = currentSelectedInjuryLevelGroup;
		 }
	}
	
	public void bmiGroupSelected()
	{
		BMIGroup currentSelectedBMIGroup = bmiGroupSelect.getValue();
		
		
		
		if(currentSelectedBMIGroup!= selectedBMIGroup)
		{

			if(currentSelectedBMIGroup!=null)
			{
			List<PatientOnChart> patientsOnChart = new ArrayList<PatientOnChart>();
			patientsOnChart.addAll(currentSelectedBMIGroup.getPatientsOnChartWomen());
			patientsOnChart.addAll(currentSelectedBMIGroup.getShownPatientsOnChartMen());
			
			patientSelect.setItems(FXCollections.observableArrayList(patientsOnChart));
			
			patientPane.setDisable(false);
			}
			
			if(selectedPatientOnChart!=null)
		    {	
				ringChart.setChosenPatient(null);
				selectedPatientOnChart=null;
		    }
			
		ringChart.setChosenBMIGroup(currentSelectedBMIGroup);
		
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
	
	public void fullScreenModeSelectionChanged()
	{
		stage.setFullScreen(fullScreenModeCheckBox.isSelected());
	}
	

}
