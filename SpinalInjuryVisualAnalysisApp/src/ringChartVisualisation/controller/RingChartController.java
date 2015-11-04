package ringChartVisualisation.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import auxiliary.Patient;
import auxiliary.Sex;
import data.PatientsCreator;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import ringChart.BMIGroup;
import ringChart.InjuryLevelGroup;
import ringChart.PatientOnChart;
import ringChart.RingChart;
import ringChartVisualisation.model.RingChartModel;
import startWindow.controller.StartWindowController;

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
	private CheckBox injuryLevelGroupShownCheckBox;
	@FXML
	private CheckBox bmiGroupShownCheckBox;
	@FXML
	private CheckBox patientShownCheckBox;
	
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
		
		 ObservableList<Patient> ringChartData = RingChartModel.getPatients();
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
		     injuryLevelGroupShownCheckBox.setSelected(currentSelectedInjuryLevelGroup.isShown());
		     injuryLevelDetailsLabel.setVisible(true);
			 injuryLevelGridPane.setVisible(true);
		     
				if(injuryLevelGroupShownCheckBox.isSelected())
				 {
					 bmiGroupPane.setDisable(false);
				 }
				 else
				 {
					 bmiGroupPane.setDisable(true);
				 }
			 
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
			patientsOnChart.addAll(currentSelectedBMIGroup.getPatientsOnChartMen());
			
			patientSelect.setItems(FXCollections.observableArrayList(patientsOnChart));
			
			
			numberOfBMIPatientsLabel.setText(Integer.toString(patientsOnChart.size()));
			bmiRangeLabel.setText(currentSelectedBMIGroup.getBmiRange().toString());
			
			bmiGroupShownCheckBox.setSelected(currentSelectedBMIGroup.isShown());
			bmiGroupGridPane.setVisible(true);
			bmiGroupDetailsLabel.setVisible(true);
			
			if(bmiGroupShownCheckBox.isSelected())
			{
				patientPane.setDisable(false);
			}
			else
			{
				patientPane.setDisable(true);
			}
			
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
			
			
			patientShownCheckBox.setSelected(currentSelectedPatient.isShown());
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
	
	public void injuryLevelGroupShownChanged()
	{
		if(selectedInjuryLevelGroup.isShown()!=injuryLevelGroupShownCheckBox.isSelected())
		{
			selectedInjuryLevelGroup.setShown(injuryLevelGroupShownCheckBox.isSelected());
			if(injuryLevelGroupShownCheckBox.isSelected())
			{
				ringChart.selectRelatedPatientsIfPatientSelected();
				if(ringChart.getChosenPatient()==selectedPatientOnChart)
				{
					patientShownCheckBox.setSelected(true);
				}
			}
			else
			{
				ringChart.unselectRelatedPatientsIfPatientSelected();
			}
			
			
		}
		
		
		if(injuryLevelGroupShownCheckBox.isSelected())
		{
			bmiGroupPane.setDisable(false);
			if(selectedPatientOnChart!=null)
			{
			patientPane.setDisable(false);
			}
		}
		else
		{
			bmiGroupPane.setDisable(true);
			patientPane.setDisable(true);
		}
	}
	
	public void bmiGroupShownChanged()
	{
		System.out.println("bmiGroupShownChanged");
		if(selectedBMIGroup.isShown()!=bmiGroupShownCheckBox.isSelected())
		{
			
			if(bmiGroupShownCheckBox.isSelected())
			{
				selectedBMIGroup.setShown(bmiGroupShownCheckBox.isSelected());
				ringChart.selectRelatedPatientsIfPatientSelected();
				if(ringChart.getChosenPatient()==selectedPatientOnChart)
				{
					patientShownCheckBox.setSelected(true);
				}
			}
			else
			{
				Collection<BMIGroup> shownBMIGroups = selectedBMIGroup.getInjuryLevelGroup().getShownBMIGroups().values();
				
				if(shownBMIGroups.size() == 1 )
		       	{
					injuryLevelGroupShownCheckBox.setSelected(false);
					injuryLevelGroupShownChanged();
					selectedBMIGroup.setShown(bmiGroupShownCheckBox.isSelected());
		       	  	bmiGroupSelect.setValue(null);
		       	  	if(ringChart.getChosenPatient()!=null)
		       	  	{
		       	  		ringChart.setChosenPatient(null);
		       	  	}
		       	}
				else
				{
					selectedBMIGroup.setShown(bmiGroupShownCheckBox.isSelected());
					ringChart.unselectRelatedPatientsIfPatientSelected();
				}
				
				
			}
		}
		
		if(bmiGroupShownCheckBox.isSelected())
		{
			patientPane.setDisable(false);
		}
		else
		{
			patientPane.setDisable(true);
		}
	}
	
	public void patientShownChanged()
	{
		if(selectedPatientOnChart.isShown()!=patientShownCheckBox.isSelected())
		{
			
			if(patientShownCheckBox.isSelected())
			{
				selectedPatientOnChart.setShown(patientShownCheckBox.isSelected());
				ringChart.selectRelatedPatientsIfPatientSelected();
			}
			else
			{
				List<PatientOnChart> shownPatientsList = selectedPatientOnChart.getPatient().getSex() == Sex.MAN ? selectedPatientOnChart.getBmiGroup().getShownPatientsOnChartMen() : selectedPatientOnChart.getBmiGroup().getShownPatientsOnChartWomen();
		      	List<PatientOnChart> shownPatientsList2 = selectedPatientOnChart.getPatient().getSex() == Sex.MAN ? selectedPatientOnChart.getBmiGroup().getShownPatientsOnChartWomen() : selectedPatientOnChart.getBmiGroup().getShownPatientsOnChartMen();
		      	 
		      	if(shownPatientsList.size()==1 && shownPatientsList2.isEmpty())
		      	{
		      		bmiGroupShownCheckBox.setSelected(false);
		      		bmiGroupShownChanged();
		      		selectedPatientOnChart.setShown(patientShownCheckBox.isSelected());
		      		patientSelect.setValue(null);
		      		ringChart.setChosenPatient(null);
		      	}
		      	else
		      	{
		      		ringChart.unselectRelatedPatientsIfPatientSelected();
		      		selectedPatientOnChart.setShown(patientShownCheckBox.isSelected());
		      	}
		      	
		      	
			}
		}

	}
	
	public void goToStartWindow()
	{
		try {
			stage.hide();
			
			if (stage.isFullScreen()) stage.setFullScreen(false);
			
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
				stage.setResizable(false);
			stage.show();
		} 
		catch(Exception e) 
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
