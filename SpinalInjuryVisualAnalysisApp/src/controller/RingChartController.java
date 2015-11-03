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
import javafx.scene.control.Label;
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

	private Stage stage;
	
	@FXML
	private TitledPane bmiGroupPane;
	@FXML
	private TitledPane patientPane;
	
	@FXML
	private GridPane ringChartGridPane;
	@FXML
	private GridPane detailsGridPane;
	@FXML
	private GridPane bmiGroupGridPane;
	@FXML
	private GridPane injuryLevelGridPane;
	
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
	
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label sexLabel;
	@FXML
	private Label weightLabel;
	@FXML
	private Label heightLabel;
	@FXML
	private Label strengthLabel;
	@FXML
	private Label wnmLabel;
	@FXML
	private Label patientDetailsLabel;
	@FXML
	private Label numberOfBMIPatientsLabel;
	@FXML
	private Label bmiRangeLabel;
	@FXML
	private Label bmiGroupDetailsLabel;
	@FXML
	private Label injuryLevelNumberOfPatientsLabel;
	@FXML
	private Label injuryLevelDetailsLabel;
	
	
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
		     
		     int sumOfPatients = 0;
		     for(BMIGroup bmiGroup: bmiGroups)
		     {
		    	 sumOfPatients+= bmiGroup.getPatientsOnChartMen().size();
		    	 sumOfPatients+= bmiGroup.getPatientsOnChartWomen().size();
		     }
		     
		     injuryLevelNumberOfPatientsLabel.setText(Integer.toString(sumOfPatients));
		     
		     injuryLevelDetailsLabel.setVisible(true);
			 injuryLevelGridPane.setVisible(true);
		     bmiGroupPane.setDisable(false);
			 }
			else
			{
				injuryLevelDetailsLabel.setVisible(false);
				injuryLevelGridPane.setVisible(false);
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
			
			
			numberOfBMIPatientsLabel.setText(Integer.toString(patientsOnChart.size()));
			bmiRangeLabel.setText(currentSelectedBMIGroup.getBmiRange().toString());
			
			bmiGroupGridPane.setVisible(true);
			bmiGroupDetailsLabel.setVisible(true);
			
				
			patientPane.setDisable(false);
			}
			else
			{
				bmiGroupGridPane.setVisible(false);
				bmiGroupDetailsLabel.setVisible(false);
				patientPane.setDisable(true);
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
	
			Patient selectedPatient = currentSelectedPatient.getPatient();
			
			firstNameLabel.setText(selectedPatient.getFirstName());
			lastNameLabel.setText(selectedPatient.getLastName());
			sexLabel.setText(selectedPatient.getSex().toString());
			weightLabel.setText(Double.toString(selectedPatient.getWeight()));
			heightLabel.setText(Double.toString(selectedPatient.getHeight()));
			strengthLabel.setText(Double.toString(selectedPatient.getStrength()));
			wnmLabel.setText(Double.toString(selectedPatient.getWnm()));
			
			
			detailsGridPane.setVisible(true);
			patientDetailsLabel.setVisible(true);			
			
		}
		else 
		{
			detailsGridPane.setVisible(false);
			patientDetailsLabel.setVisible(false);
		}
		
		ringChart.setChosenPatient(currentSelectedPatient);
		selectedPatientOnChart = currentSelectedPatient;
		
	}
	
	public void changeAnimated()
	{
		ringChart.setAnimated(animationsCheckBox.isSelected());
	}
	
	public void fullScreenModeSelectionChanged()
	{
		stage.setFullScreen(fullScreenModeCheckBox.isSelected());
	}

	public void setStage(Stage primaryStage)
	{
		this.stage = primaryStage;
	}
	

}
