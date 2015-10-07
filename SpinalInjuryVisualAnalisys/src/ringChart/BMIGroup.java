package ringChart;

import java.util.List;

import auxiliary.BMIRange;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.scene.shape.Shape;

public class BMIGroup
{

	private List<PatientOnChart> patientsOnChart; //TODO men women
	private RingChart ringChart;
	private InjuryLevelGroup injuryLevelGroup;
	private BMIRange bmiRange;
	private Shape shape;
	private BooleanProperty shown = new BooleanPropertyBase(true) 
	{

		@Override public void invalidated() 
		{
          System.out.println("BMIGroup: invalidated() - ");
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
    
    
	public List<PatientOnChart> getPatientsOnChart()
	{
		return patientsOnChart;
	}
	public void setPatientsOnChart(List<PatientOnChart> patientsOnChart)
	{
		this.patientsOnChart = patientsOnChart;
	}
	public RingChart getRingChart()
	{
		return ringChart;
	}
	public void setRingChart(RingChart ringChart)
	{
		this.ringChart = ringChart;
	}
	public InjuryLevelGroup getInjuryLevelGroup()
	{
		return injuryLevelGroup;
	}
	public void setInjuryLevelGroup(InjuryLevelGroup injuryLevelGroup)
	{
		this.injuryLevelGroup = injuryLevelGroup;
	}
	public Shape getShape()
	{
		return shape;
	}
	public void setShape(Shape shape)
	{
		this.shape = shape;
	}
	public BMIRange getBmiRange()
	{
		return bmiRange;
	}
	public void setBmiRange(BMIRange bmiRange)
	{
		this.bmiRange = bmiRange;
	}
}
