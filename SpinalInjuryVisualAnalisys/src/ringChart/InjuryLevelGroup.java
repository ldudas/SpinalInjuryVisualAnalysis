package ringChart;

import java.util.LinkedHashMap;
import java.util.Map;

import auxiliary.BMIRangeName;
import auxiliary.InjuryLevel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.scene.shape.Shape;

public class InjuryLevelGroup extends ChartGroup
{

	private Map<BMIRangeName,BMIGroup> bmiGroups;
	private InjuryLevel injuryLevel;
	
	private double value;
	
	
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
    
    
    
    public InjuryLevelGroup(InjuryLevel injuryLevel,RingChart ringChart)
	{
    	super(ringChart);
		this.injuryLevel = injuryLevel;
		bmiGroups = new LinkedHashMap<BMIRangeName,BMIGroup>();
		isEmpty = true;
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

	public void setBmiGroups(Map<BMIRangeName, BMIGroup> bmiGroups)
	{
		this.bmiGroups = bmiGroups;
	}
	public Map<BMIRangeName, BMIGroup> getBmiGroups()
	{
		return bmiGroups;
	}
    
}
