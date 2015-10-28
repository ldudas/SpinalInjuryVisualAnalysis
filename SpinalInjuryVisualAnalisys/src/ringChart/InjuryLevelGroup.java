package ringChart;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import auxiliary.BMIRangeName;
import auxiliary.InjuryLevel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class InjuryLevelGroup extends ChartGroup
{

	private Map<BMIRangeName,BMIGroup> bmiGroups;
	private Map<Integer,BMIGroup> shownBMIGroups;
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
		shownBMIGroups = new TreeMap<Integer,BMIGroup>();
		isEmpty = true;
		
		region.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		region.setStyle("-fx-border-color: -fx-background; -fx-border-width: 1;");
		
		text.setText(injuryLevel.toString());
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
	public Map<Integer, BMIGroup> getShownBMIGroups()
	{
		return shownBMIGroups;
	}
	public void setShownBMIGroups(Map<Integer, BMIGroup> shownBMIGroups)
	{
		this.shownBMIGroups = shownBMIGroups;
	}
    
}
