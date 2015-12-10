package ringChartVisualisation.model;

import auxiliary.Patient;
import businessLayer.Patients;
import javafx.collections.ObservableList;

public class RingChartModel
{

	public static ObservableList<Patient> getPatients()
	{
		 return Patients.getPatients();
	}
	
}
