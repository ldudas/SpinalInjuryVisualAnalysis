package data;
import auxiliary.InjuryLevel;
import auxiliary.Patient;
import auxiliary.Sex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PatientsCreator
{

	public static ObservableList<Patient> getPatients()
	{
		return FXCollections.observableArrayList
	    		 (
	    		//C1 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C1, 33, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C1, 87, 0.3), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C1, 50, 0.5), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C1, 12, 0.55), //34,6
	    		//C1 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C1, 77, 0.34), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C1, 28, 0.12), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C1, 88, 0.90), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C1, 89, 0.99), //34,6
	    		 
	    		//C2 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C2, 99, 0.34), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C2, 80, 0.22), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C2, 12, 0.7), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C2, 48, 0.8), //34,6
	    		//C2 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C2, 33, 0.77), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C2, 65, 0.01), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C2, 50, 0.2), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 75, 0.16), //34,6
	    		
	    		 
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 100, 0.2),
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 50, 0.67),
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 4, 0.87),
	    		//C3 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C3, 43, 0.55), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C3, 30, 0.34), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C3, 22, 0.88), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C3, 88, 0.08), //34,6
	    		 
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C3, 100, 0.11), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C3, 2, 0.19), //34,6
	    		 
	    		 
	    		//C3 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C3, 50, 0.23), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C3, 93, 0.88), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C3, 23, 0.4), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C3, 65, 0.9) //34,6
	    		 /*
	    		//C4 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C4, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C4, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C4, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C4, 10, 0.1), //34,6
	    		//C4 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C4, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C4, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C4, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C4, 10, 0.1), //34,6
	    		 
	    		//C5 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C5, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C5, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C5, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C5, 10, 0.1), //34,6
	    		//C5 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C5, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C5, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C5, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C5, 10, 0.1), //34,6
	    		 
	    		//C6 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C6, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C6, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C6, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C6, 10, 0.1), //34,6
	    		//C6 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C6, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C6, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C6, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C6, 10, 0.1), //34,6
	    		 
	    		//C7 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C7, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C7, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C7, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C7, 10, 0.1), //34,6
	    		//C7 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C7, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C7, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C7, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C7, 10, 0.1), //34,6
	    		 
	    		//C8 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C8, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C8, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C8, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C8, 10, 0.1), //34,6
	    		//C8 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C8, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C8, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C8, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C8, 10, 0.1), //34,6
	    		 
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C8, 10, 0.1),
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C8, 10, 0.1),
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C8, 10, 0.1)
	    		 
	    		//T1 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T1, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T1, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T1, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T1, 10, 0.1), //34,6
	    		//T1 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T1, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T1, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T1, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T1, 10, 0.1), //34,6
	    		 
	    		//T2 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T2, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T2, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T2, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T2, 10, 0.1), //34,6
	    		//T2 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T2, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T2, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T2, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T2, 10, 0.1), //34,6
	    		 
	    		//T3 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T3, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T3, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T3, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T3, 10, 0.1), //34,6
	    		//T3 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T3, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T3, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T3, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T3, 10, 0.1), //34,6
	    		 
	    		//T4 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T4, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T4, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T4, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T4, 10, 0.1), //34,6
	    		//T4 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T4, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T4, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T4, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T4, 10, 0.1), //34,6
	    		 
	    		//T5 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T5, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T5, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T5, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T5, 10, 0.1), //34,6
	    		//T5 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T5, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T5, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T5, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T5, 10, 0.1), //34,6
	    		 
	    		//T6 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T6, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T6, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T6, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T6, 10, 0.1), //34,6
	    		//T6 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T6, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T6, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T6, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T6, 10, 0.1), //34,6
	    		 
	    		//T7 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T7, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T7, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T7, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T7, 10, 0.1), //34,6
	    		//T7 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T7, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T7, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T7, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T7, 10, 0.1), //34,6
	    		 
	    		//T8 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T8, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T8, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T8, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T8, 10, 0.1), //34,6
	    		//T8 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T8, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T8, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T8, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T8, 10, 0.1), //34,6
	    		 
	    		//T9 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T9, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T9, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T9, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T9, 10, 0.1), //34,6
	    		//T9 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T9, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T9, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T9, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T9, 10, 0.1), //34,6
	    		 
	    		//T10 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T10, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T10, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T10, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T10, 10, 0.1), //34,6
	    		//T10 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T10, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T10, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T10, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T10, 10, 0.1), //34,6
	    		 
	    		//T11 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T11, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T11, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T11, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T11, 10, 0.1), //34,6
	    		//T11 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T11, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T11, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T11, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T11, 10, 0.1), //34,6
	    		 
	    		//T12 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T12, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T12, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T12, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T12, 10, 0.1), //34,6
	    		//T12 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T12, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T12, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T12, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T12, 10, 0.1), //34,6
	    		 
	    		//L1 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.L1, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L1, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L1, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L1, 10, 0.1), //34,6
	    		//L1 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L1, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L1, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L1, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.L1, 10, 0.1), //34,6
	    		 
	    		//L2 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.L2, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L2, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L2, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L2, 10, 0.1), //34,6
	    		//L2 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L2, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L2, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L2, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.L2, 10, 0.1), //34,6
	    		 
	    		//L3 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.L3, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L3, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L3, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L3, 10, 0.1), //34,6
	    		//L3 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L3, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L3, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L3, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.L3, 10, 0.1), //34,6
	    		 
	    		//L4 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.L4, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L4, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L4, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L4, 10, 0.1), //34,6
	    		//L4 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L4, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L4, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L4, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.L4, 10, 0.1), //34,6
	    		 
	    		//L5 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.L5, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L5, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L5, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L5, 10, 0.1), //34,6
	    		//L5 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L5, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L5, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L5, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.L5, 10, 0.1), //34,6
	    		 
	    		//S1 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.S1, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.S1, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.S1, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.S1, 10, 0.1), //34,6
	    		//S1 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.S1, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.S1, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.S1, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.S1, 10, 0.1), //34,6
	    		 
	    		//S2 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.S2, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.S2, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.S2, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.S2, 10, 0.1), //34,6
	    		//S2 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.S2, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.S2, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.S2, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.S2, 10, 0.1), //34,6
	    		 
	    		//S3 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.S3, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.S3, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.S3, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.S3, 10, 0.1), //34,6
	    		//S3 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.S3, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.S3, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.S3, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.S3, 10, 0.1), //34,6
	    		 
	    		//S4 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.S4, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.S4, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.S4, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.S4, 10, 0.1), //34,6
	    		//S4 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.S4, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.S4, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.S4, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.S4, 10, 0.1), //34,6
	    		 
	    		//S5 mê¿czyŸni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.S5, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.S5, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.S5, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.S5, 10, 0.1), //34,6
	    		//S5 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.S5, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.S5, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.S5, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.S5, 10, 0.1) //34,6
	    			*/	 );
		
	}
}
