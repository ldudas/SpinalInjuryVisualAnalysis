package dataAccessLayer;

import auxiliary.Patient;
import data.PatientsCreator;
import javafx.collections.ObservableList;

public class PatientsDAO
{

	public static ObservableList<Patient> getPatients()
	{
		  ObservableList<Patient> patients = //FXCollections.observableArrayList();
		 PatientsCreator.getPatients();
          
         /* File[] files = new File(PatientsDirectory.getPatientsPath()).listFiles();
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
          }*/
         
          
          return patients;
	}
	
}
