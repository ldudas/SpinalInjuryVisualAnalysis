package ringChart;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sun.javafx.charts.Legend;

import auxiliary.BMIRange;
import auxiliary.BMIRangeFactory;
import auxiliary.BMIRangeName;
import auxiliary.InjuryLevel;
import auxiliary.Patient;
import auxiliary.Sex;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;

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
		 private ObservableList<Patient> old;
		 
		  @Override 
		  protected void invalidated()
		  {
				System.out.println("RingChart: patients invalidated()"); 
				
				final ObservableList<Patient> current = getValue();
				if(current!=old) //if new set list is not the old list
				{
					if(old != null) old.removeListener(patientsChangeListener); // remove data change listener from old list
			        if(current != null) current.addListener(patientsChangeListener); // add data change listener to new list
			            
					clearGroupsFromPatients(); //clear groups from patients
					
					if(current!= null) //if new list exists
					{
						assignPatientsToGroups(current); //assign patients from new list to chart groups, subgroups
					}
					
					
					old = current; // save current list as the old one for further changes
					requestChartLayout(); //redraw the chart
				}
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
	 
	/*------------------- CONSTRUCTORS ------------------------------------------------------------*/
	
	 public RingChart(ObservableList<Patient> patients)
	{
		System.out.println("RingChart: constructor(patients). List size: "+patients.size());
		injuryLevelGroups = new LinkedHashMap<InjuryLevel, InjuryLevelGroup>();
		patientsOnChartConnections = new LinkedList<PatientsOnChartConnection>();
		shownPatientsOnChartConnections = new LinkedList<PatientsOnChartConnection>();
		createGroups();
		setPatients(patients);
		setLegend(legend);
		useChartContentMirroring = false;
	}
	 
	/*------------------- METHODS -----------------------------------------------------------------*/ 
	 Arc arc = new Arc();
	 Arc inner = new Arc();
	 Region  ring = new Region();
	@Override
	protected void layoutChartChildren(double top, double left, double width, double height)
	{
		System.out.println("RingChart: layoutChartChildren()");
		
		centerX = width/2 + left; //X center of chart pane
        centerY = height/2 + top; //Y center of char pane
       
        if(!getChartChildren().contains(ring))
        {
        	arc.setType(ArcType.ROUND); //ustaw typ kwaa³ka ciasta
         	inner.setType(ArcType.ROUND); //ustaw typ kwaa³ka ciasta
        	ring.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        	ring.setOpacity(0.4);
        	ring.setStyle("-fx-border-color: green");
        	ring.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT); //orientacja wêz³a
            ring.setPickOnBounds(false);
            ring.setScaleShape(false); 
            ring.setCenterShape(false);
            ring.setCacheShape(false);
        	getChartChildren().add(ring);
        }
        
       
        arc.setStartAngle(0); //ustaw k¹t pocz¹tkowy
        arc.setLength(100); //ustaw k¹t
        arc.setRadiusX(0.5*width); //ustawX promienia (bo arc to kawa³ek elipsy)
        arc.setRadiusY(0.5*width); //ustawY promienia (bo arc to kawa³ek elipsy)
        
        inner.setStartAngle(0); //ustaw k¹t pocz¹tkowy
        inner.setLength(100); //ustaw k¹t
        inner.setRadiusX(0.2*width); //ustawX promienia (bo arc to kawa³ek elipsy)
        inner.setRadiusY(0.2*width); //ustawY promienia (bo arc to kawa³ek elipsy)
  
        ring.setLayoutX(centerX);
        ring.setLayoutY(centerY);
       
        ring.setShape(Shape.subtract(arc, inner));
      
        
       
        
	}
	
	
	/*------------------- private methods ---------------------------------------------------------*/
	private void createGroups()
	{
		BMIRangeFactory bmiRangeFactory = BMIRangeFactory.getInstance();
		
		for(InjuryLevel injuryLevel: InjuryLevel.values())
		{
			InjuryLevelGroup injuryLevelGroup = new InjuryLevelGroup(injuryLevel,this);
			injuryLevelGroups.put(injuryLevel, injuryLevelGroup);
			
			for(BMIRangeName bmiRangeName: BMIRangeName.values())
			{
		 		BMIGroup bmiGroup = new BMIGroup(injuryLevelGroup,bmiRangeFactory.getBMIRange(bmiRangeName),this);
		 		injuryLevelGroup.getBmiGroups().put(bmiRangeName, bmiGroup);
			}
		}
		
		/*for(InjuryLevelGroup injGr: injuryLevelGroups.values())
		{
			System.out.println("InjGroup: "+injGr.getInjuryLevel());
			for(BMIGroup bmiGr: injGr.getBmiGroups().values())
			{
				System.out.println("  BMIGr: "+bmiGr.getBmiRange());
			}
		}*/
		
	}
	
	private void clearGroupsFromPatients()
	{
		System.out.println("RingChart: clearGroupsFromPatients()");
		for(InjuryLevelGroup injGr: injuryLevelGroups.values())
		{
			for(BMIGroup bmiGr: injGr.getBmiGroups().values())
			{
				bmiGr.getPatientsOnChartMen().clear();
				bmiGr.getPatientsOnChartWomen().clear();
				bmiGr.setEmpty(true);
			}
			injGr.setEmpty(true);
		}
	}
	
	private void assignPatientsToGroups(ObservableList<Patient> currentList)
	{
		//int assignmentCounter = 0;
		
		
		BMIRangeFactory bmiRangeFactory = BMIRangeFactory.getInstance(); //get bmi ranges factory
		
		for(Patient patient: currentList) //for each patient in current data list
		{
			double patientsBMI = patient.getHeight() / Math.pow(patient.getWeight(), 2); //calculate patient's BMI
			InjuryLevelGroup patientsInjuryLevelGroup = injuryLevelGroups.get(patient.getInjuryLevel()); //get injury level group for patient
			
			for(BMIRangeName bmiRangeName: BMIRangeName.values()) //for each bmi range
			{
				BMIRange bmiRange = bmiRangeFactory.getBMIRange(bmiRangeName); //get bmi range for bmi range name
				
				if(patientsBMI>bmiRange.getFromBMI() && patientsBMI<=bmiRange.getToBMI()) // if bmi range fits patient
				{
					BMIGroup bmiGroup = patientsInjuryLevelGroup.getBmiGroups().get(bmiRangeName); // get bmi subgroup for injury level group of patient
					
					//assignmentCounter++;
					
					if(patient.getSex()==Sex.MAN) //if patient is a man
					{
						bmiGroup.getPatientsOnChartMen().add(new PatientOnChart(patient,bmiGroup,this));
					}
					else if (patient.getSex()==Sex.WOMAN) //if patient is a woman
					{
						bmiGroup.getPatientsOnChartWomen().add(new PatientOnChart(patient,bmiGroup,this));
					}
					
					// patient was added to bmi subgroup and injury level group, so they are not empty
					bmiGroup.setEmpty(false); 
					bmiGroup.getInjuryLevelGroup().setEmpty(false);
				}
			}
			
			
		}
			
		
		//System.out.println("Patients assigned: "+assignmentCounter);
	}
	
}
