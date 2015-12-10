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
		/*ObservableList<Patient> patients = FXCollections.observableArrayList
		 (
		//C1 mê¿czyŸni
	    				 new Patient("12345678911","Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C1, 33, 0.1), //18
	    				 new Patient("57492045611","Mieczys³aw", "Dêbowski", Sex.MAN, 75, 1.9, InjuryLevel.C1, 87, 0.3), //20,7
	    				 new Patient("12356432311","Ignacy", "Ude³", Sex.MAN, 95, 1.9, InjuryLevel.C1, 50, 0.5), //26,3
	    				 new Patient("12376546711","Micha³", "Nowak", Sex.MAN, 125, 1.9, InjuryLevel.C1, 12, 0.55), //34,6
	    				//C1 kobiety
	    				 new Patient("07958439911","Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C1, 77, 0.34), //18
	    				 new Patient("54777654311","Agnieszka", "Opala", Sex.WOMAN, 75, 1.9, InjuryLevel.C1, 28, 0.12), //20,7
	    				 new Patient("44567865411","Kinga", "Wroñska", Sex.WOMAN, 95, 1.9, InjuryLevel.C1, 88, 0.90), //26,3
	    				 new Patient("44567895611","Ewa", "Trojniak", Sex.WOMAN, 125, 1.9, InjuryLevel.C1, 89, 0.99), //34,6
	    				 
	    				//C2 mê¿czyŸni
	    				 new Patient("11234567811","Robert", "Torek", Sex.MAN, 65, 1.9, InjuryLevel.C2, 99, 0.34), //18
	    				 new Patient("54444332211","Piotr", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C2, 80, 0.22), //20,7
	    				 new Patient("98877756511","Pawe³", "Idny", Sex.MAN, 95, 1.9, InjuryLevel.C2, 12, 0.7), //26,3
	    				 new Patient("44444334511","Wiktor", "Mêtny", Sex.MAN, 125, 1.9, InjuryLevel.C2, 48, 0.8), //34,6
	    				//C2 kobiety
	    				 new Patient("77777866511","Paulina", "Rêdna", Sex.WOMAN, 65, 1.9, InjuryLevel.C2, 33, 0.77), //18
	    				 new Patient("32342343211","Justyna", "Lowicka", Sex.WOMAN, 75, 1.9, InjuryLevel.C2, 65, 0.01), //20,7
	    				 new Patient("78687667711","Sylwia", "Kokoñska", Sex.WOMAN, 95, 1.9, InjuryLevel.C2, 50, 0.2), //26,3
	    				 new Patient("33333423311","Daria", "Redka", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 75, 0.16), //34,6
	    				
	    				 
	    				 new Patient("22334323411","Maria", "Torda", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 100, 0.2),
	    				 new Patient("87877666611","Stanis³awa", "Owal", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 50, 0.67),
	    				 new Patient("78767666611","Cecylia", "Radna", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 4, 0.87),
	    				//C3 mê¿czyŸni
	    				 new Patient("34242656711","Tomasz", "Kowal", Sex.MAN, 65, 1.9, InjuryLevel.C3, 43, 0.55), //18
	    				 new Patient("55556645511","Pawe³", "Nowak", Sex.MAN, 75, 1.9, InjuryLevel.C3, 30, 0.34), //20,7
	    				 new Patient("65456545611","Wiktor", "Wernald", Sex.MAN, 95, 1.9, InjuryLevel.C3, 22, 0.88), //26,3
	    				 new Patient("34434344411","Stanis³aw", "Polak", Sex.MAN, 125, 1.9, InjuryLevel.C3, 88, 0.08), //34,6
	    				 
	    				 new Patient("33344445511","Rados³aw", "Terendy", Sex.MAN, 95, 1.9, InjuryLevel.C3, 100, 0.11), //26,3
	    				 new Patient("76765543311","Robert", "Góral", Sex.MAN, 125, 1.9, InjuryLevel.C3, 2, 0.19), //34,6
	    				 
	    				 
	    				//C3 kobiety
	    				 new Patient("44443333311","Anna", "Tarnowska", Sex.WOMAN, 65, 1.9, InjuryLevel.C3, 50, 0.23), //18
	    				 new Patient("32345654411","Magdalena", "Wiernicka", Sex.WOMAN, 75, 1.9, InjuryLevel.C3, 93, 0.88), //20,7
	    				 new Patient("12312312311","Barbara", "Radkowska", Sex.WOMAN, 95, 1.9, InjuryLevel.C3, 23, 0.4), //26,3
	    				 new Patient("55556655611","Ewa", "Nowak", Sex.WOMAN, 125, 1.9, InjuryLevel.C3, 65, 0.9));
		
		
		for(Patient patient: patients)
		{
			patient.serializeToFile("D:/patients/");
		}
		*/
		
		//pierwszy zestaw
		/*
		return FXCollections.observableArrayList
	    		 (
	    				//C1 mê¿czyŸni
	    				 new Patient("123456789","Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C1, 33, 0.1), //18
	    				 new Patient("574920456","Mieczys³aw", "Dêbowski", Sex.MAN, 75, 1.9, InjuryLevel.C1, 87, 0.3), //20,7
	    				 new Patient("123564323","Ignacy", "Ude³", Sex.MAN, 95, 1.9, InjuryLevel.C1, 50, 0.5), //26,3
	    				 new Patient("123765467","Micha³", "Nowak", Sex.MAN, 125, 1.9, InjuryLevel.C1, 12, 0.55), //34,6
	    				//C1 kobiety
	    				 new Patient("079584399","Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C1, 77, 0.34), //18
	    				 new Patient("547776543","Agnieszka", "Opala", Sex.WOMAN, 75, 1.9, InjuryLevel.C1, 28, 0.12), //20,7
	    				 new Patient("445678654","Kinga", "Wroñska", Sex.WOMAN, 95, 1.9, InjuryLevel.C1, 88, 0.90), //26,3
	    				 new Patient("445678956","Ewa", "Trojniak", Sex.WOMAN, 125, 1.9, InjuryLevel.C1, 89, 0.99), //34,6
	    				 
	    				//C2 mê¿czyŸni
	    				 new Patient("112345678","Robert", "Torek", Sex.MAN, 65, 1.9, InjuryLevel.C2, 99, 0.34), //18
	    				 new Patient("544443322","Piotr", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C2, 80, 0.22), //20,7
	    				 new Patient("988777565","Pawe³", "Idny", Sex.MAN, 95, 1.9, InjuryLevel.C2, 12, 0.7), //26,3
	    				 new Patient("444443345","Wiktor", "Mêtny", Sex.MAN, 125, 1.9, InjuryLevel.C2, 48, 0.8), //34,6
	    				//C2 kobiety
	    				 new Patient("777778665","Paulina", "Rêdna", Sex.WOMAN, 65, 1.9, InjuryLevel.C2, 33, 0.77), //18
	    				 new Patient("323423432","Justyna", "Lowicka", Sex.WOMAN, 75, 1.9, InjuryLevel.C2, 65, 0.01), //20,7
	    				 new Patient("786876677","Sylwia", "Kokoñska", Sex.WOMAN, 95, 1.9, InjuryLevel.C2, 50, 0.2), //26,3
	    				 new Patient("333334233","Daria", "Redka", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 75, 0.16), //34,6
	    				
	    				 
	    				 new Patient("223343234","Maria", "Torda", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 100, 0.2),
	    				 new Patient("878776666","Stanis³awa", "Owal", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 50, 0.67),
	    				 new Patient("787676666","Cecylia", "Radna", Sex.WOMAN, 125, 1.9, InjuryLevel.C2, 4, 0.87),
	    				//C3 mê¿czyŸni
	    				 new Patient("342426567","Tomasz", "Kowal", Sex.MAN, 65, 1.9, InjuryLevel.C3, 43, 0.55), //18
	    				 new Patient("555566455","Pawe³", "Nowak", Sex.MAN, 75, 1.9, InjuryLevel.C3, 30, 0.34), //20,7
	    				 new Patient("654565456","Wiktor", "Wernald", Sex.MAN, 95, 1.9, InjuryLevel.C3, 22, 0.88), //26,3
	    				 new Patient("344343444","Stanis³aw", "Polak", Sex.MAN, 125, 1.9, InjuryLevel.C3, 88, 0.08), //34,6
	    				 
	    				 new Patient("333444455","Rados³aw", "Terendy", Sex.MAN, 95, 1.9, InjuryLevel.C3, 100, 0.11), //26,3
	    				 new Patient("767655433","Robert", "Góral", Sex.MAN, 125, 1.9, InjuryLevel.C3, 2, 0.19), //34,6
	    				 
	    				 
	    				//C3 kobiety
	    				 new Patient("444433333","Anna", "Tarnowska", Sex.WOMAN, 65, 1.9, InjuryLevel.C3, 50, 0.23), //18
	    				 new Patient("323456544","Magdalena", "Wiernicka", Sex.WOMAN, 75, 1.9, InjuryLevel.C3, 93, 0.88), //20,7
	    				 new Patient("123123123","Barbara", "Radkowska", Sex.WOMAN, 95, 1.9, InjuryLevel.C3, 23, 0.4), //26,3
	    				 new Patient("555566556","Ewa", "Nowak", Sex.WOMAN, 125, 1.9, InjuryLevel.C3, 65, 0.9) //34,6
	    		 
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
	    				 );*/
		
		return FXCollections.observableArrayList
	    		 ( 
	    				 //c5
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C5, 8, 0.02), //18
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.C5, 8, 0.02), //18
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C5, 10, 0.03), //20,7
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.C5, 10, 0.03), //20,7
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.C5, 60, 0.04), //26,3
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C5, 17, 0.55), //34,6
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C5, 17, 0.05), //34,6
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C5, 17, 0.05), //34,6
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.C5, 17, 0.05), //34,6
	    				 
	    				 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.C5, 3, 0.12), //18
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C5, 4, 0.13), //20,7
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.C5, 4, 0.13), //20,7
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.C5, 70, 0.14), //26,3
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C5, 10, 0.15), //34,6
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.C5, 10, 0.15), //34,6
	    	    		 
	    	    		 //t5
	    	    		 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T7, 28, 0.22), //18
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T7, 30, 0.23), //20,7
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T7, 33, 0.24), //26,3
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T7, 90, 0.25), //34,6
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T7, 90, 0.25), //34,6
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T7, 90, 0.25), //34,6
	    				 
	    				 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T7, 23, 0.32), //18
	    				 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T7, 23, 0.32), //18
	    				 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T7, 23, 0.32), //18
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T7, 70, 0.33), //20,7
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T7, 27, 0.34), //26,3
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T7, 27, 0.34), //26,3
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T7, 30, 0.35), //34,6
	    	    		 
	    	    		 
	    	    		//t10
	    	    		 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.T10, 48, 0.42), //18
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.T10, 50, 0.43), //20,7
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T10, 53, 0.44), //26,3
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.T10, 53, 0.44), //26,3
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T10, 57, 0.45), //34,6
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.T10, 57, 0.45), //34,6
	    				 
	    				 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.T10, 43, 0.52), //18
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.T10, 44, 0.53), //20,7
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T10, 47, 0.54), //26,3
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.T10, 47, 0.60), //26,3
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.T10, 97, 0.55), //34,6
	    	    		
	    	    		 //l2
	    	    		 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.L2, 68, 0.62), //18
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L2, 70, 0.63), //20,7
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L2, 70, 0.63), //20,7
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L2, 70, 0.63), //20,7
	    				// new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L2, 73, 0.64), //26,3
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L2, 77, 0.65), //34,6
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L2, 77, 0.65), //34,6
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L2, 77, 0.65), //34,6
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L2, 77, 0.65), //34,6
	    				 
	    				 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L2, 63, 0.72), //18
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L2, 20, 0.73), //20,7
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L2, 67, 0.74), //26,3
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L2, 67, 0.74), //26,3
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.L2, 70, 0.75), //34,6
	    	    		 
	    	    		 //l5
	    	    		 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 65, 1.9, InjuryLevel.L5, 88, 0.82), //18
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 75, 1.9, InjuryLevel.L5, 90, 0.83), //20,7
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L5, 93, 0.84), //26,3
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L5, 93, 0.84), //26,3
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 95, 1.9, InjuryLevel.L5, 93, 0.84), //26,3
	    				 new Patient("11111111111","Adam", "Kowalski", Sex.MAN, 125, 1.9, InjuryLevel.L5, 97, 0.85), //34,6
	    				 
	    				 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L5, 50, 0.92), //18
	    				 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 65, 1.9, InjuryLevel.L5, 50, 0.92), //18
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L5, 84, 0.93), //20,7
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L5, 84, 0.93), //20,7
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L5, 84, 0.93), //20,7
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L5, 84, 0.93), //20,7
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 75, 1.9, InjuryLevel.L5, 84, 0.93), //20,7
	    	    		 new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 95, 1.9, InjuryLevel.L5, 70, 0.94) //26,3
	    	    		// new Patient("11111111111","Anna", "Kowalska", Sex.WOMAN, 125, 1.9, InjuryLevel.L5, 90, 0.95) //34,6
	    				 
	    				 );
		
	}
}
