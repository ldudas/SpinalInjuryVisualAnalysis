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
	    		//C1 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C1, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C1, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C1, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C1, 10, 0.1), //34,6
	    		//C1 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C1, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C1, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C1, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C1, 10, 0.1), //34,6
	    		 
	    		//C2 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C2, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C2, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C2, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C2, 10, 0.1), //34,6
	    		//C2 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C2, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C2, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C2, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 10, 0.1), //34,6
	    		 
	    		//C3 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C3, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C3, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C3, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C3, 10, 0.1), //34,6
	    		//C3 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C3, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C3, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C3, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C3, 10, 0.1), //34,6
	    		 
	    		//C4 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C4, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C4, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C4, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C4, 10, 0.1), //34,6
	    		//C4 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C4, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C4, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C4, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C4, 10, 0.1), //34,6
	    		 
	    		//C5 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C5, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C5, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C5, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C5, 10, 0.1), //34,6
	    		//C5 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C5, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C5, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C5, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C5, 10, 0.1), //34,6
	    		 
	    		//C6 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C6, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C6, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C6, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C6, 10, 0.1), //34,6
	    		//C6 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C6, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C6, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C6, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C6, 10, 0.1), //34,6
	    		 
	    		//C7 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C7, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C7, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C7, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C7, 10, 0.1), //34,6
	    		//C7 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C7, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C7, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C7, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C7, 10, 0.1), //34,6
	    		 
	    		//C8 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C8, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C8, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C8, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C8, 10, 0.1), //34,6
	    		//C8 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C8, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C8, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C8, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C8, 10, 0.1) //34,6
	    		 
	    		/*//T1 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T1, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T1, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T1, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T1, 10, 0.1), //34,6
	    		//T1 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T1, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T1, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T1, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T1, 10, 0.1), //34,6
	    		 
	    		//T2 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T2, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T2, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T2, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T2, 10, 0.1), //34,6
	    		//T2 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T2, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T2, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T2, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T2, 10, 0.1), //34,6
	    		 
	    		//T3 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T3, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T3, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T3, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T3, 10, 0.1), //34,6
	    		//T3 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T3, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T3, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T3, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T3, 10, 0.1), //34,6
	    		 
	    		//T4 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T4, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T4, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T4, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T4, 10, 0.1), //34,6
	    		//T4 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T4, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T4, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T4, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T4, 10, 0.1), //34,6
	    		 
	    		//T5 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T5, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T5, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T5, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T5, 10, 0.1), //34,6
	    		//T5 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T5, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T5, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T5, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T5, 10, 0.1), //34,6
	    		 
	    		//T6 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T6, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T6, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T6, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T6, 10, 0.1), //34,6
	    		//T6 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T6, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T6, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T6, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T6, 10, 0.1), //34,6
	    		 
	    		//T7 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T7, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T7, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T7, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T7, 10, 0.1), //34,6
	    		//T7 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T7, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T7, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T7, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T7, 10, 0.1), //34,6
	    		 
	    		//T8 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T8, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T8, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T8, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T8, 10, 0.1), //34,6
	    		//T8 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T8, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T8, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T8, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T8, 10, 0.1), //34,6
	    		 
	    		//T9 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T9, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T9, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T9, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T9, 10, 0.1), //34,6
	    		//T9 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T9, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T9, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T9, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T9, 10, 0.1), //34,6
	    		 
	    		//T10 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T10, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T10, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T10, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T10, 10, 0.1), //34,6
	    		//T10 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T10, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T10, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T10, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T10, 10, 0.1), //34,6
	    		 
	    		//T11 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T11, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T11, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T11, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T11, 10, 0.1), //34,6
	    		//T11 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T11, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T11, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T11, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T11, 10, 0.1), //34,6
	    		 
	    		//T12 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T12, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T12, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T12, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T12, 10, 0.1), //34,6
	    		//T12 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T12, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T12, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T12, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T12, 10, 0.1), //34,6
	    		 
	    		//L1 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.L1, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L1, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L1, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L1, 10, 0.1), //34,6
	    		//L1 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L1, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L1, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L1, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.L1, 10, 0.1), //34,6
	    		 
	    		//L2 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.L2, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L2, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L2, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L2, 10, 0.1), //34,6
	    		//L2 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L2, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L2, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L2, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.L2, 10, 0.1), //34,6
	    		 
	    		//L3 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.L3, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L3, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L3, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L3, 10, 0.1), //34,6
	    		//L3 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L3, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L3, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L3, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.L3, 10, 0.1), //34,6
	    		 
	    		//L4 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.L4, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L4, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L4, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L4, 10, 0.1), //34,6
	    		//L4 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L4, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L4, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L4, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.L4, 10, 0.1), //34,6
	    		 
	    		//L5 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.L5, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L5, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L5, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L5, 10, 0.1), //34,6
	    		//L5 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L5, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L5, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L5, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.L5, 10, 0.1), //34,6
	    		 
	    		//S1 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.S1, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.S1, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.S1, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.S1, 10, 0.1), //34,6
	    		//S1 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.S1, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.S1, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.S1, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.S1, 10, 0.1), //34,6
	    		 
	    		//S2 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.S2, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.S2, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.S2, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.S2, 10, 0.1), //34,6
	    		//S2 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.S2, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.S2, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.S2, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.S2, 10, 0.1), //34,6
	    		 
	    		//S3 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.S3, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.S3, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.S3, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.S3, 10, 0.1), //34,6
	    		//S3 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.S3, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.S3, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.S3, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.S3, 10, 0.1), //34,6
	    		 
	    		//S4 m�czy�ni
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.S4, 10, 0.1), //18
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.S4, 10, 0.1), //20,7
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.S4, 10, 0.1), //26,3
	    		 new Patient("Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.S4, 10, 0.1), //34,6
	    		//S4 kobiety
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.S4, 10, 0.1), //18
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.S4, 10, 0.1), //20,7
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.S4, 10, 0.1), //26,3
	    		 new Patient("Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.S4, 10, 0.1), //34,6
	    		 
	    		//S5 m�czy�ni
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
