package ringChart;

import auxiliary.Patient;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.scene.shape.Shape;

public class PatientOnChart
{

	private Patient patient;
	private RingChart ringChart;
	private BMIGroup bmiGroup;
	private Shape shape;
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
	
    
    
    public Patient getPatient()
	{
		return patient;
	}
    
	public void setPatient(Patient patient)
	{
		this.patient = patient;
	}
	public RingChart getRingChart()
	{
		return ringChart;
	}
	public void setRingChart(RingChart ringChart)
	{
		this.ringChart = ringChart;
	}
	public BMIGroup getBmiGroup()
	{
		return bmiGroup;
	}
	public void setBmiGroup(BMIGroup bmiGroup)
	{
		this.bmiGroup = bmiGroup;
	}
	public Shape getShape()
	{
		return shape;
	}
	public void setShape(Shape shape)
	{
		this.shape = shape;
	}
	
}
