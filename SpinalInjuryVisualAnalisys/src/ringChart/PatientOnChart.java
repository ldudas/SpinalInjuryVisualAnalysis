package ringChart;

import auxiliary.Patient;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
		
		Circle circle = new Circle();
		region.setShape(circle);
		region.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
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
