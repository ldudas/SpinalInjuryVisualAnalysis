package ringChartVisualisation.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import auxiliary.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RingChartModel
{

	public static ObservableList<Patient> getPatients()
	{
		  ObservableList<Patient> patients = FXCollections.observableArrayList();
		 // PatientsCreator.getPatients();
          
          File[] files = new File("D:/patients").listFiles();
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
          }
         
          
          return patients;
	}
	
	
	


	          

	


}
