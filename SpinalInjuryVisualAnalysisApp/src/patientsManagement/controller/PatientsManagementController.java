package patientsManagement.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import addEditPatient.controller.AddEditPatientController;
import addEditPatient.controller.AddEditPatientController.Type;
import auxiliary.Patient;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import startWindow.controller.StartWindowController;

public class PatientsManagementController implements Initializable
{

	private Stage stage;
	
	@FXML
	private ListView<Patient> patientsListView;
	@FXML
	private StackPane stackPane;
	@FXML
	private Button editButton;
	@FXML
	private Button deleteButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		patientsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Patient>() {

		    @Override
		    public void changed(ObservableValue<? extends Patient> observable, Patient oldValue, Patient newValue) {
		        editButton.setDisable(false);
		        deleteButton.setDisable(false);
		    }
		});
	}
	
	public void goToStartWindow()
	{
		try {
			stage.hide();
			
			
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
	
	public void goToAddPatient()
	{
		try {
			
			Stage newStage = new Stage();
			 FXMLLoader loader = new FXMLLoader();
	         loader.setLocation(getClass().getResource("/addEditPatient/view/addEditPatientView.fxml"));
	         VBox root = (VBox) loader.load();
	         
	         
	         Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

	        double minX = primaryScreenBounds.getMinX();
	        double minY = primaryScreenBounds.getMinY();
	        double width = primaryScreenBounds.getWidth();
	        double height = primaryScreenBounds.getHeight();
	        
	        double stageWidth = root.getPrefWidth();
	        double stageHeight = root.getPrefHeight();
	        double leftCornerX = minX + width/2 - stageWidth/2;
	        double leftCornerY = minY + height/2 - stageHeight/2;
	         
	         newStage.setX(leftCornerX);
	         newStage.setY(leftCornerY);
	         newStage.setWidth(stageWidth);
	         newStage.setHeight(stageHeight);
	            	
	         Scene scene = new Scene(root);
	         newStage.setScene(scene);
	         newStage.initModality(Modality.WINDOW_MODAL);
	         newStage.initOwner(stage);
	         newStage.setResizable(false);
			 
			 AddEditPatientController controller = loader.getController();
				if(controller.getStage()==null)
				{
					controller.setStage(newStage);
				}
			controller.setType(Type.ADD);
			controller.setPatientsListView(patientsListView);
			
			newStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void deletePatientPressed()
	{
		Patient selectedPatient = patientsListView.getSelectionModel().getSelectedItem();
		
		Alert conf = new Alert(AlertType.CONFIRMATION);
		conf.setTitle("Deletion confirmation");
		conf.setHeaderText(null);
		conf.setContentText("Are you sure you want to delete "+selectedPatient+"?");

		Optional<ButtonType> result = conf.showAndWait();
		
		if (result.get() == ButtonType.OK)
		{
			File file = new File("D:/patients/"+selectedPatient.toString());
	    	
			if(file.delete()){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setHeaderText(null);
				alert.setContentText(selectedPatient.toString()+" deleted.");
	
				patientsListView.getItems().remove(selectedPatient);
				
				alert.showAndWait();
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText(selectedPatient.toString()+" couldn't be deleted.");
	
				alert.showAndWait();
			}
		}
			
	}
	
	public void editButtonPressed()
	{
		Patient selectedPatient = patientsListView.getSelectionModel().getSelectedItem();
		
		try {
			
			Stage newStage = new Stage();
			 FXMLLoader loader = new FXMLLoader();
	         loader.setLocation(getClass().getResource("/addEditPatient/view/addEditPatientView.fxml"));
	         VBox root = (VBox) loader.load();
	         
	         
	         Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

	        double minX = primaryScreenBounds.getMinX();
	        double minY = primaryScreenBounds.getMinY();
	        double width = primaryScreenBounds.getWidth();
	        double height = primaryScreenBounds.getHeight();
	        
	        double stageWidth = root.getPrefWidth();
	        double stageHeight = root.getPrefHeight();
	        double leftCornerX = minX + width/2 - stageWidth/2;
	        double leftCornerY = minY + height/2 - stageHeight/2;
	         
	         newStage.setX(leftCornerX);
	         newStage.setY(leftCornerY);
	         newStage.setWidth(stageWidth);
	         newStage.setHeight(stageHeight);
	            	
	         Scene scene = new Scene(root);
	         newStage.setScene(scene);
	         newStage.initModality(Modality.WINDOW_MODAL);
	         newStage.initOwner(stage);
	         newStage.setResizable(false);
			 
			 AddEditPatientController controller = loader.getController();
				if(controller.getStage()==null)
				{
					controller.setStage(newStage);
				}
			controller.setType(Type.EDIT);
			controller.setPatientsListView(patientsListView);
			controller.setPatient(selectedPatient);
			
			newStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void loadPatients()
	{
		GetPatientsService service = new GetPatientsService();
		Region veil = new Region();
        veil.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
        ProgressIndicator p = new ProgressIndicator();
        p.setMaxSize(150, 150);
        
        p.progressProperty().bind(service.progressProperty());
        veil.visibleProperty().bind(service.runningProperty());
        p.visibleProperty().bind(service.runningProperty());
        patientsListView.itemsProperty().bind(service.valueProperty());
        
        stackPane.getChildren().addAll(veil,p);
		
		service.start();
		
	}

	public void setStage(Stage stage)
	{
		this.stage = stage;
	}
	
	public Stage getStage()
	{
		return stage;
	}
	
	private class GetPatientsService extends Service<ObservableList<Patient>> 
	{
        @Override
        protected Task<ObservableList<Patient>> createTask() 
        {
            return new GetPatientsTask();
        }
    }
	
	 private class GetPatientsTask extends Task<ObservableList<Patient>> 
	 {       
	        @Override protected ObservableList<Patient> call() throws Exception 
	        {

	            ObservableList<Patient> patients = FXCollections.observableArrayList();
	            
	            File[] files = new File("D:/patients").listFiles();
	            int index = 0;
	            for(File file:files)
	            {
	            	try
	                {
	                   ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
	                   Patient patient = (Patient) in.readObject();
	                   patients.add(patient);
	                   in.close();
	                }
	            	catch(IOException i)
	                {
	                   i.printStackTrace();
	                   return patients;
	                }
	            	catch(ClassNotFoundException c)
	                {
	                   c.printStackTrace();
	                   return patients;
	                }
	            	
	            	index++;
		            updateProgress(index, files.length);
	            }
	           
	            
	            return patients;

	        }

	    }




}
