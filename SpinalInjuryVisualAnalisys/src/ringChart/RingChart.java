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
	private static double injuryLevelBmiGap = 1;
	private static double radiusMultiplierInnerBmi = 0.9;
	
	
	
	private Map<InjuryLevel,InjuryLevelGroup> injuryLevelGroups;
	private List<InjuryLevelGroup> shownInjuryLevelGroups;
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
					clearShownInjuryGroupsListAndSubgroups(); //clear shown injury groups and bmi subgroups
					
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
  		setCurrentStartAngle(get());
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
		shownInjuryLevelGroups = new LinkedList<InjuryLevelGroup>();
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
	/** @inheritDoc */
	protected void layoutChartChildren(double top, double left, double width, double height)
	{
		System.out.println("RingChart: layoutChartChildren()");
		
		centerX = width/2 + left; //X center of chart pane
        centerY = height/2 + top; //Y center of char pane
        radiusOuterInjuryLevel = Math.min(width,height) / 2;
       
        //count number of shown InjuryLevelGroups
        int numbOfShownInjuryLevelGroups = shownInjuryLevelGroups.size();
        
        //System.out.println(shownLevelGroups);
        
        double sizeOfRingPart = (numbOfShownInjuryLevelGroups != 0) ? 360.0 / numbOfShownInjuryLevelGroups : 0;   
        double startAngle = getCurrentStartAngle();
        double innerInjuryArcRadius = radiusMultiplierInnerInjuryLevel*radiusOuterInjuryLevel;
        double outerBMIArcRadius = innerInjuryArcRadius - injuryLevelBmiGap;
        double innerBMIArcRadius = outerBMIArcRadius * radiusMultiplierInnerBmi;
        
        
        for(InjuryLevelGroup injuryGroup: shownInjuryLevelGroups)
        {
        	
        		//drawing injury level ring part
        		Region ringPartRegion = injuryGroup.getRegion();
        		Arc outerArc = injuryGroup.getOuterArc();
                Arc innerArc = injuryGroup.getInnerArc();
               
                outerArc.setStartAngle(startAngle); //ustaw k¹t pocz¹tkowy
                outerArc.setLength(sizeOfRingPart); //ustaw k¹t
                outerArc.setRadiusX(radiusOuterInjuryLevel); //ustawX promienia (bo arc to kawa³ek elipsy)
                outerArc.setRadiusY(radiusOuterInjuryLevel); //ustawY promienia (bo arc to kawa³ek elipsy)
                
                innerArc.setStartAngle(startAngle); //ustaw k¹t pocz¹tkowy
                innerArc.setLength(sizeOfRingPart); //ustaw k¹t
                innerArc.setRadiusX(innerInjuryArcRadius); //ustawX promienia (bo arc to kawa³ek elipsy)
                innerArc.setRadiusY(innerInjuryArcRadius); //ustawY promienia (bo arc to kawa³ek elipsy)
                
                
                ringPartRegion.setShape(Shape.subtract(outerArc, innerArc));
                ringPartRegion.setLayoutX(centerX);
                ringPartRegion.setLayoutY(centerY);
                
              /*  if(!getChartChildren().contains(ringPartRegion))
                {
                	getChartChildren().add(ringPartRegion);
                }*/
                
                
                
                // drawing bmi subgroup ring parts
                
                //count number of shown bmi groups inside InjuryLevelGroups
                int shownBMIGroups = injuryGroup.getShownBMIGroups().size();
                
                double sizeOfBMIRingPart = (shownBMIGroups != 0) ? sizeOfRingPart / shownBMIGroups : 0;
                double startAngleBMIGroup = startAngle;
                double sizeOfSexGroup = sizeOfBMIRingPart/2;
                for(BMIGroup bmiGroup: injuryGroup.getShownBMIGroups())
                {
                	
                		//drawing bmi group ring part
                		Region ringPartBMIRegion = bmiGroup.getRegion();
                		Arc outerArcBMI = bmiGroup.getOuterArc();
                        Arc innerArcBMI = bmiGroup.getInnerArc();
                        
                        outerArcBMI.setStartAngle(startAngleBMIGroup); //ustaw k¹t pocz¹tkowy
                        outerArcBMI.setLength(sizeOfBMIRingPart); //ustaw k¹t
                        outerArcBMI.setRadiusX(outerBMIArcRadius); //ustawX promienia (bo arc to kawa³ek elipsy)
                        outerArcBMI.setRadiusY(outerBMIArcRadius); //ustawY promienia (bo arc to kawa³ek elipsy)
                        
                        innerArcBMI.setStartAngle(startAngleBMIGroup); //ustaw k¹t pocz¹tkowy
                        innerArcBMI.setLength(sizeOfBMIRingPart); //ustaw k¹t
                        innerArcBMI.setRadiusX(innerBMIArcRadius); //ustawX promienia (bo arc to kawa³ek elipsy)
                        innerArcBMI.setRadiusY(innerBMIArcRadius); //ustawY promienia (bo arc to kawa³ek elipsy)
                        
                        
                        ringPartBMIRegion.setShape(Shape.subtract(outerArcBMI, innerArcBMI));
                        ringPartBMIRegion.setLayoutX(centerX);
                        ringPartBMIRegion.setLayoutY(centerY);
                        
                       /* if(!getChartChildren().contains(ringPartBMIRegion))
                        {
                        	getChartChildren().add(ringPartBMIRegion);
                        }*/
                        
                        //drawing men region
                		Region ringPartMenRegion = bmiGroup.getMenRegion();
                		Arc outerArcMen = bmiGroup.getOuterArcMen();
                        Arc innerArcMen = bmiGroup.getInnerArcMen();
                        
                        outerArcMen.setStartAngle(startAngleBMIGroup); //ustaw k¹t pocz¹tkowy
                        outerArcMen.setLength(sizeOfSexGroup); //ustaw k¹t
                        outerArcMen.setRadiusX(radiusOuterInjuryLevel+20); //ustawX promienia (bo arc to kawa³ek elipsy)
                        outerArcMen.setRadiusY(radiusOuterInjuryLevel+20); //ustawY promienia (bo arc to kawa³ek elipsy)
                        
                        innerArcMen.setStartAngle(startAngleBMIGroup); //ustaw k¹t pocz¹tkowy
                        innerArcMen.setLength(sizeOfSexGroup); //ustaw k¹t
                        innerArcMen.setRadiusX(radiusOuterInjuryLevel); //ustawX promienia (bo arc to kawa³ek elipsy)
                        innerArcMen.setRadiusY(radiusOuterInjuryLevel); //ustawY promienia (bo arc to kawa³ek elipsy)
                        
                        
                        ringPartMenRegion.setShape(Shape.subtract(outerArcMen, innerArcMen));
                        ringPartMenRegion.setLayoutX(centerX);
                        ringPartMenRegion.setLayoutY(centerY);
                        
                       /* if(!getChartChildren().contains(ringPartMenRegion))
                        {
                        	getChartChildren().add(ringPartMenRegion);
                        }*/
                        
                        //drawing women region
                        Region ringPartWomenRegion = bmiGroup.getWomenRegion();
                		Arc outerArcWomen = bmiGroup.getOuterArcWomen();
                        Arc innerArcWomen = bmiGroup.getInnerArcWomen();
                        
                        outerArcWomen.setStartAngle(startAngleBMIGroup+sizeOfSexGroup); //ustaw k¹t pocz¹tkowy
                        outerArcWomen.setLength(sizeOfSexGroup); //ustaw k¹t
                        outerArcWomen.setRadiusX(radiusOuterInjuryLevel+20); //ustawX promienia (bo arc to kawa³ek elipsy)
                        outerArcWomen.setRadiusY(radiusOuterInjuryLevel+20); //ustawY promienia (bo arc to kawa³ek elipsy)
                        
                        innerArcWomen.setStartAngle(startAngleBMIGroup+sizeOfSexGroup); //ustaw k¹t pocz¹tkowy
                        innerArcWomen.setLength(sizeOfSexGroup); //ustaw k¹t
                        innerArcWomen.setRadiusX(radiusOuterInjuryLevel); //ustawX promienia (bo arc to kawa³ek elipsy)
                        innerArcWomen.setRadiusY(radiusOuterInjuryLevel); //ustawY promienia (bo arc to kawa³ek elipsy)
                        
                        
                        ringPartWomenRegion.setShape(Shape.subtract(outerArcWomen, innerArcWomen));
                        ringPartWomenRegion.setLayoutX(centerX);
                        ringPartWomenRegion.setLayoutY(centerY);
                        
                        /*if(!getChartChildren().contains(ringPartWomenRegion))
                        {
                        	getChartChildren().add(ringPartWomenRegion);
                        }*/
                        
                        startAngleBMIGroup += sizeOfBMIRingPart;
                	
                
                }
                
                startAngle+=sizeOfRingPart;
        }
    
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
	
	private void clearShownInjuryGroupsListAndSubgroups()
	{
		for(InjuryLevelGroup injuryLevelGr: shownInjuryLevelGroups)
		{
			injuryLevelGr.getShownBMIGroups().clear();
		}
		shownInjuryLevelGroups.clear();	
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
			double patientsBMI = patient.getWeight() / Math.pow(patient.getHeight(), 2); //calculate patient's BMI
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
					
					//adding shown groups to shown collections
					// TODO add to the sorting collection
					if(!shownInjuryLevelGroups.contains(bmiGroup.getInjuryLevelGroup()))
					{
						shownInjuryLevelGroups.add(bmiGroup.getInjuryLevelGroup());
					}
					if(!bmiGroup.getInjuryLevelGroup().getShownBMIGroups().contains(bmiGroup))
					{
						bmiGroup.getInjuryLevelGroup().getShownBMIGroups().add(bmiGroup);
					}
				}
			}
			
			
		}
			
		
		//System.out.println("Patients assigned: "+assignmentCounter);
	}
	
}
