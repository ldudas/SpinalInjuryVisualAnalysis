package ringChart;

import java.util.Map;

import auxiliary.BMIRangeName;
import auxiliary.InjuryLevel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.scene.shape.Shape;

public class InjuryLevelGroup
{

	private Map<BMIRangeName,BMIGroup> bmiGroups;
	private RingChart ringChart;
	private InjuryLevel injuryLevel;
	
	private double value;
	
	private Shape shape;
	private BooleanProperty shown = new BooleanPropertyBase(true) 
	{

		@Override public void invalidated() 
		{
          System.out.println("InjuryLevelGroup: invalidated() - ");
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
    
    
   
	public RingChart getRingChart()
	{
		return ringChart;
	}
	public void setRingChart(RingChart ringChart)
	{
		this.ringChart = ringChart;
	}
	public InjuryLevel getInjuryLevel()
	{
		return injuryLevel;
	}
	public void setInjuryLevel(InjuryLevel injuryLevel)
	{
		this.injuryLevel = injuryLevel;
	}
	public double getValue()
	{
		return value;
	}
	public void setValue(double value)
	{
		this.value = value;
	}
	public Shape getShape()
	{
		return shape;
	}
	public void setShape(Shape shape)
	{
		this.shape = shape;
	}

	public void setBmiGroups(Map<BMIRangeName, BMIGroup> bmiGroups)
	{
		this.bmiGroups = bmiGroups;
	}
	public Map<BMIRangeName, BMIGroup> getBmiGroups()
	{
		return bmiGroups;
	}
    
}
