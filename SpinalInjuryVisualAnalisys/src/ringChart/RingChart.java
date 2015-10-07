package ringChart;

import java.util.List;
import java.util.Map;

import com.sun.javafx.charts.Legend;

import auxiliary.InjuryLevel;
import auxiliary.Patient;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.chart.Chart;

public class RingChart extends Chart
{
	
	private static double radiusMultiplierInnerInjuryLevel = 0.9;
	private static double injuryLevelBmiGap = 10.0;
	private static double radiusMultiplierInnerBmi = 0.7;
	
	
	private Map<InjuryLevel,InjuryLevelGroup> injuryLevelGroups;
	private List<PatientsOnChartConnection> patientsOnChartConnections;
	private List<PatientsOnChartConnection> shownPatientsOnChartConnections;
	
	private Legend legend = new Legend();
	
	private double centerX;
	private double centerY;
	private double radiusOuterInjuryLevel;
	
	/* ------------------- PATIENTS LIST CHANGE LISTENER --------------------------------- */
	
	private final ListChangeListener<Patient> patientsChangeListener = c -> {System.out.println("RingChart: patientsChangeListeer.onChange()");};
	
	/*-------------------- PROPERTIES --------------------------------------------------- */
	
	private ObjectProperty<ObservableList<Patient>> patients = new ObjectPropertyBase<ObservableList<Patient>>() 
	 {
	 
		  @Override 
		  protected void invalidated()
		  {
				System.out.println("RingChart: patients invalidated()"); 
		  }
		
		  public Object getBean() 
		  {
	            return RingChart.this;
	      }
	
	      public String getName() 
	      {
	            return "patients";
	      }
	        
	 };
	 	public final ObservableList<Patient> getPatients() { return patients.getValue(); }
	 	public final void setPatients(ObservableList<Patient> value) { patients.setValue(value); }
	 	public final ObjectProperty<ObservableList<Patient>> patientsProperty() { return patients; }
	
	
			
  private DoubleProperty startAngle = new DoublePropertyBase(0) 
  {
   
  	@Override 
  	public void invalidated() 
  	{
  		System.out.println("RingChart: startAngle invalidated()");	
    }

  	@Override
    public Object getBean() 
	{
       return RingChart.this; 
    }

    @Override
    public String getName() 
    {
        return "startAngle"; 
    }

  };
  	public final double getStartAngle() { return startAngle.getValue(); }
  	public final void setStartAngle(double value) { startAngle.setValue(value); }
  	public final DoubleProperty startAngleProperty() { return startAngle; }
  	
  private DoubleProperty currentStartAngle = new SimpleDoubleProperty(this, "currentStartAngle");
	 private double getCurrentStartAngle() {return currentStartAngle.getValue();}
	 private void setCurrentStartAngle(double value) {currentStartAngle.setValue(value);}
	 private DoubleProperty currentStartAngleProperty() {return currentStartAngle;}
	 
	 
	/*------------------- METHODS -----------------------------------------------------------------*/ 
	@Override
	protected void layoutChartChildren(double top, double left, double width, double height)
	{
		System.out.println("RingChart: layoutChartChildren()");
	}
	
}
