package ringChart;

import java.util.LinkedList;
import java.util.List;

import auxiliary.BMIRange;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.scene.shape.Shape;

public class BMIGroup extends ChartGroup
{

	private List<PatientOnChart> patientsOnChartMen; 
	private List<PatientOnChart> patientsOnChartWomen;
	private InjuryLevelGroup injuryLevelGroup;
	private BMIRange bmiRange;
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
    
    
    public BMIGroup(InjuryLevelGroup injuryLevelGroup, BMIRange bmiRange, RingChart ringChart)
	{
    	super(ringChart);
    	this.injuryLevelGroup = injuryLevelGroup;
    	this.bmiRange = bmiRange;
    	patientsOnChartMen = new LinkedList<PatientOnChart>();
    	patientsOnChartWomen = new LinkedList<PatientOnChart>();
    	isEmpty = true;
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

	public BMIRange getBmiRange()
	{
		return bmiRange;
	}
	public void setBmiRange(BMIRange bmiRange)
	{
		this.bmiRange = bmiRange;
	}
	public boolean isEmpty()
	{
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty)
	{
		this.isEmpty = isEmpty;
	}
	public List<PatientOnChart> getPatientsOnChartMen()
	{
		return patientsOnChartMen;
	}
	public void setPatientsOnChartMen(List<PatientOnChart> patientsOnChartMen)
	{
		this.patientsOnChartMen = patientsOnChartMen;
	}
	public List<PatientOnChart> getPatientsOnChartWomen()
	{
		return patientsOnChartWomen;
	}
	public void setPatientsOnChartWomen(List<PatientOnChart> patientsOnChartWomen)
	{
		this.patientsOnChartWomen = patientsOnChartWomen;
	}
}
