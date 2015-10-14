package ringChart;

import auxiliary.Patient;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.scene.layout.Region;

public class PatientOnChart extends ChartElement
{

	private Patient patient;
	private BMIGroup bmiGroup;
	private BooleanProperty shown = new BooleanPropertyBase(true) 
	{

		@Override public void invalidated() 
		{
          System.out.println("PatientOnChat: invalidated() - "+patient.getFirstName()+" "+patient.getLastName());
        }
		
		@Override
		public Object getBean()
		{
			return ringChart;
		}

		@Override
		public String getName()
		{
			return "shown";
		}
	
	};
	public final void setShown(boolean value) 
	{ 
		shown.setValue(value);
	}
    public final boolean isShown() 
    { 
    	return shown.getValue();
    }
    
    public final BooleanProperty shownProperty() 
    { 
    	return shown;
    }
	
    
    
    public PatientOnChart(Patient patient, BMIGroup bmiGroup, RingChart ringChart)
	{
    	super(ringChart);
		this.patient = patient;
		this.bmiGroup= bmiGroup;
	}
    
    public Patient getPatient()
	{
		return patient;
	}
	public void setPatient(Patient patient)
	{
		this.patient = patient;
	}
	public BMIGroup getBmiGroup()
	{
		return bmiGroup;
	}
	public void setBmiGroup(BMIGroup bmiGroup)
	{
		this.bmiGroup = bmiGroup;
	}
	
}
