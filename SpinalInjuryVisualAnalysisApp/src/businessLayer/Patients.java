package businessLayer;

import auxiliary.Patient;
import dataAccessLayer.PatientsDAO;
import javafx.collections.ObservableList;

public class Patients
{
	public static ObservableList<Patient> getPatients()
	{
		return PatientsDAO.getPatients();
	}
}
