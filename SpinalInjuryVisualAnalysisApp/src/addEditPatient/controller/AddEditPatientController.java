package addEditPatient.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import auxiliary.ConnectionEndColorPicker;
import auxiliary.InjuryLevel;
import auxiliary.Patient;
import auxiliary.Sex;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vars.PatientsDirectory;

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
	private TextField peselTextField;
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
					File file = new File(PatientsDirectory.getPatientsPath()+editedPatient.getPesel());
			    	
					if(!file.delete())
					{
						Alert alert = new Alert(AlertType.ERROR);
						((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resources/ring-icon.png"));
						alert.setTitle("Error");
						alert.setHeaderText("Patient not edited.");
						alert.setContentText("There were some problems with editing patient.");

						alert.showAndWait();
						return;
					}
				}
				
					Patient newPatient = new Patient(peselTextField.getText(),
						 firstNameTextField.getText(),
						 lastNameTextField.getText(),
						 sexComboBox.getValue(), 
						 Double.parseDouble(weightTextField.getText()),
						 Double.parseDouble(heightTextField.getText()), 
						 injuryLevelComboBox.getValue(), 
						 Double.parseDouble(strenghtTextField.getText()),
						 Double.parseDouble(wnmTextField.getText())
						 );
					newPatient.serializeToFile(PatientsDirectory.getPatientsPath());
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
					((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resources/ring-icon.png"));
					alert.setTitle("Success");
					alert.setHeaderText(null);
					alert.setContentText("Patient saved.");

					alert.showAndWait();
			}
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
		String message="";
		boolean allFieldsFilled=true;
		if(peselTextField.getText().equals("")) {message+="PESEL field is empty.\n"; allFieldsFilled=false;setErrorBorder(peselTextField);}else{setNormalBorder(peselTextField);}
		if(firstNameTextField.getText().equals("")) { message+="First name field is empty.\n"; allFieldsFilled=false;setErrorBorder(firstNameTextField);}else{setNormalBorder(firstNameTextField);}
		if(lastNameTextField.getText().equals("")){  message+="Last name field is empty.\n"; allFieldsFilled=false;setErrorBorder(lastNameTextField);}else{setNormalBorder(lastNameTextField);}
		if(weightTextField.getText().equals("")){  message+="Weight field is empty.\n"; allFieldsFilled=false;setErrorBorder(weightTextField);}else{setNormalBorder(weightTextField);}
		if(heightTextField.getText().equals("")) { message+="Height field is empty.\n"; allFieldsFilled=false;setErrorBorder(heightTextField);}else{setNormalBorder(heightTextField);}
		if(strenghtTextField.getText().equals("")) { message+="Strength field is empty.\n"; allFieldsFilled=false;setErrorBorder(strenghtTextField);}else{setNormalBorder(strenghtTextField);}
		if(wnmTextField.getText().equals("")){  message+="WNM field is empty.\n"; allFieldsFilled=false;setErrorBorder(wnmTextField);}else{setNormalBorder(wnmTextField);}
		if(sexComboBox.getValue()==null) {  message+="Sex is not choosen.\n"; allFieldsFilled=false;setErrorBorder(sexComboBox);}else{setNormalBorder(sexComboBox);}
		if(injuryLevelComboBox.getValue()==null){ message+="Injury level is not choosen.\n"; allFieldsFilled=false;setErrorBorder(injuryLevelComboBox);}else{setNormalBorder(injuryLevelComboBox);}
		
		if(!allFieldsFilled)
		{
			Alert alert = new Alert(AlertType.ERROR);
			((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resources/ring-icon.png"));
			alert.setTitle("Error");
			alert.setHeaderText("Empty fields");
			alert.setContentText(message);
	
			alert.showAndWait();
		}
		
		return allFieldsFilled;
	}
	
	private void setErrorBorder(Control control)
	{
		control.setStyle("-fx-text-box-border: red;-fx-focus-color: red ;");
	}
	
	private void setNormalBorder(Control control)
	{
		control.setStyle("");
	}
	
	private boolean allFiledsCorrect()
	{
		StringBuilder messageBuilder = new StringBuilder();
		
		boolean allFieldsCorrect = true;
		if(!checkPesel(messageBuilder)){setErrorBorder(peselTextField); allFieldsCorrect=false;}else{setNormalBorder(peselTextField);}
		if(!checkFirstName(messageBuilder)){setErrorBorder(firstNameTextField); allFieldsCorrect=false;}else{setNormalBorder(firstNameTextField);}
		if(!checkLastName(messageBuilder)){setErrorBorder(lastNameTextField); allFieldsCorrect=false;}else{setNormalBorder(lastNameTextField);}
		if(!checkWeight(messageBuilder)){setErrorBorder(weightTextField); allFieldsCorrect=false;}else{setNormalBorder(weightTextField);}
		if(!checkHeight(messageBuilder)){setErrorBorder(heightTextField); allFieldsCorrect=false;}else{setNormalBorder(heightTextField);}
		if(!checkStrenght(messageBuilder)){setErrorBorder(strenghtTextField); allFieldsCorrect=false;}else{setNormalBorder(strenghtTextField);}
		if(!checkWNM(messageBuilder)){setErrorBorder(wnmTextField); allFieldsCorrect=false;}else{setNormalBorder(wnmTextField);}
		

		
		if(!allFieldsCorrect)
		{
			Alert alert = new Alert(AlertType.ERROR);
			((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/resources/ring-icon.png"));
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText(messageBuilder.toString());
	
			alert.showAndWait();
		}
		return allFieldsCorrect;
	}

	private boolean checkWNM(StringBuilder messageBuilder)
	{
		boolean wnmCorrect = true;
		String wnm = wnmTextField.getText();
		
		try
		{
			double wnmValue = Double.parseDouble(wnm);
			
			if(wnmValue>1d || wnmValue<0d )
			{
				messageBuilder.append("Strenght must be between 0.0 and 1.0.\n");
				wnmCorrect = false;
			}
			
		} 
		catch (NumberFormatException e)
		{
			messageBuilder.append("WNM is not a number.\n");
			wnmCorrect = false;
		}
		
		return wnmCorrect;
	}

	private boolean checkStrenght(StringBuilder messageBuilder)
	{
		boolean strenghtCorrect = true;
		String strenght = strenghtTextField.getText();
		
		try
		{
			double strengthValue = Double.parseDouble(strenght);
			
			if(strengthValue>ConnectionEndColorPicker.getMaxStrength() || strengthValue<0 )
			{
				messageBuilder.append("Strenght must be between 0.0 and "+ConnectionEndColorPicker.getMaxStrength()+".\n");
				strenghtCorrect = false;
			}
			
		} 
		catch (NumberFormatException e)
		{
			messageBuilder.append("Strenght is not a number.\n");
			strenghtCorrect = false;
		}
		
		return strenghtCorrect;
	}

	private boolean checkHeight(StringBuilder messageBuilder)
	{
		boolean heightCorrect = true;
		String height = heightTextField.getText();
		
		try
		{
			double heightValue = Double.parseDouble(height);
			
			if(heightValue<0 )
			{
				messageBuilder.append("Height must be greater than 0.\n");
				heightCorrect = false;
			}
		} 
		catch (NumberFormatException e)
		{
			messageBuilder.append("Height is not a number.\n");
			heightCorrect = false;
		}
		
		return heightCorrect;
	}

	private boolean checkWeight(StringBuilder messageBuilder)
	{
		boolean weightCorrect = true;
		String weight = weightTextField.getText();
		
		try
		{
			double weightValue = Double.parseDouble(weight);
			
			if(weightValue<0 )
			{
				messageBuilder.append("Weight must be greater than 0.\n");
				weightCorrect = false;
			}
		} 
		catch (NumberFormatException e)
		{
			messageBuilder.append("Weight is not a number.\n");
			weightCorrect = false;
		}
		
		return weightCorrect;
	}

	private boolean checkLastName(StringBuilder messageBuilder)
	{
		boolean lastNameCorrect = true;
		String lastName = lastNameTextField.getText();
		
		if(lastName.length()<2)
		{
			messageBuilder.append("Last name length must be greater than 1.\n");
			lastNameCorrect=false;
		}
		
		return lastNameCorrect;
	}

	private boolean checkFirstName(StringBuilder messageBuilder)
	{
		boolean firstNameCorrect = true;
		String firstName = firstNameTextField.getText();
		
		if(firstName.length()<2)
		{
			messageBuilder.append("First name length must be greater than 1.\n");
			firstNameCorrect=false;
		}
		
		return firstNameCorrect;
	}

	private boolean checkPesel(StringBuilder messageBuilder)
	{
		boolean peselCorrect = true;
		String pesel = peselTextField.getText();
		if(pesel.length()!=11)
		{
			messageBuilder.append("PESEL lenght must be 11.\n");
			peselCorrect = false;
		}
		else
		{
			for(char c:pesel.toCharArray())
			{
				try
				{
					Integer.parseInt(String.valueOf(c));
				}
				catch(NumberFormatException e)
				{
					messageBuilder.append("PESEL must contain only digits.\n");
					peselCorrect = false;
					break;
				}
				
			}
				
		  }
		
		
		return peselCorrect;
	}

	public void setPatient(Patient selectedPatient)
	{
		editedPatient = selectedPatient;
		peselTextField.setText(editedPatient.getPesel());
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