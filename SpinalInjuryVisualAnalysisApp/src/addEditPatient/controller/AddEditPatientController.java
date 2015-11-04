package addEditPatient.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import auxiliary.InjuryLevel;
import auxiliary.Patient;
import auxiliary.Sex;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEditPatientController implements Initializable
{
	
	private Stage stage;
	private Type type;
	public enum Type{ADD,EDIT};
	
	@FXML
	private Button addEditPatientButton;
	@FXML
	private ComboBox<Sex> sexComboBox;
	@FXML
	private ComboBox<InjuryLevel> injuryLevelComboBox;
	
	@FXML
	private TextField firstNameTextField;
	@FXML
	private TextField lastNameTextField;
	@FXML
	private TextField weightTextField;
	@FXML
	private TextField heightTextField;
	@FXML
	private TextField strenghtTextField;
	@FXML
	private TextField wnmTextField;
	
	private ListView<Patient> patientsListView;
	private Patient editedPatient;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		sexComboBox.setItems(FXCollections.observableArrayList(Sex.values()));
		injuryLevelComboBox.setItems(FXCollections.observableArrayList(InjuryLevel.values()));
	}
	
	public void goToPatientsManagement()
	{
		stage.close();
	}
	
	public void addEditPatientButtonPressed()
	{
		if(allFieldsFilled())
		{
			if(allFiledsCorrect())
			{
				int oldPatientIndex = -1;
				if(type==Type.EDIT)
				{
					oldPatientIndex = patientsListView.getItems().indexOf(editedPatient);
					File file = new File("D:/patients/"+editedPatient.toString());
			    	
					if(!file.delete())
					{
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText("Patient not edited.");
						alert.setContentText("There were some problems with editing patient.");

						alert.showAndWait();
						return;
					}
				}
				
					Patient newPatient = new Patient(firstNameTextField.getText(),
						 lastNameTextField.getText(),
						 sexComboBox.getValue(), 
						 Double.parseDouble(weightTextField.getText()),
						 Double.parseDouble(heightTextField.getText()), 
						 injuryLevelComboBox.getValue(), 
						 Double.parseDouble(strenghtTextField.getText()),
						 Double.parseDouble(wnmTextField.getText())
						 );
					newPatient.serializeToFile("D://patients", newPatient.toString());
					if(oldPatientIndex!=-1)
					{
						patientsListView.getItems().set(oldPatientIndex, newPatient);
					}
					else
					{
						patientsListView.getItems().add(newPatient);
					}
					stage.close();
			
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success");
					alert.setHeaderText(null);
					alert.setContentText("Patient saved.");

					alert.showAndWait();
			}
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Empty fields");
			alert.setContentText("You must fill all fields");

			alert.showAndWait();
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

	public Type getType()
	{
		return type;
	}

	public void setType(Type type)
	{
		if(type==Type.ADD) addEditPatientButton.setText("Add");
		else addEditPatientButton.setText("Edit");
		this.type = type;
	}
	
	public void setPatientsListView(ListView<Patient> patientsListView)
	{
		this.patientsListView = patientsListView;		
	}
	
	
	private boolean allFieldsFilled()
	{
		if(firstNameTextField.getText().equals("")) return false;
		if(lastNameTextField.getText().equals("")) return false;
		if(weightTextField.getText().equals("")) return false;
		if(heightTextField.getText().equals("")) return false;
		if(strenghtTextField.getText().equals("")) return false;
		if(wnmTextField.getText().equals("")) return false;
		if(sexComboBox.getValue()==null) return false;
		if(injuryLevelComboBox.getValue()==null) return false;
		return true;
	}
	
	private boolean allFiledsCorrect()
	{
		return true;
	}

	public void setPatient(Patient selectedPatient)
	{
		editedPatient = selectedPatient;
		firstNameTextField.setText(editedPatient.getFirstName());
		lastNameTextField.setText(editedPatient.getLastName());
		weightTextField.setText(Double.toString(editedPatient.getWeight()));
		heightTextField.setText(Double.toString(editedPatient.getHeight()));
		strenghtTextField.setText(Double.toString(editedPatient.getStrength()));
		wnmTextField.setText(Double.toString(editedPatient.getWnm()));
		sexComboBox.setValue(editedPatient.getSex());
		injuryLevelComboBox.setValue(editedPatient.getInjuryLevel());
	}

}