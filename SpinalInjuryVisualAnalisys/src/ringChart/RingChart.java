package ringChart;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import javafx.scene.layout.Region;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;

public class RingChart extends Chart
{
	
	private static double radiusMultiplierInnerInjuryLevel = 0.9;
	private static double injuryLevelBmiGap = 1;
	private static double radiusMultiplierInnerBmi = 0.9;
	private static double deltaWNM = 0.1;
	
	
	
	private Map<InjuryLevel,InjuryLevelGroup> injuryLevelGroups;
	private Map<Integer,InjuryLevelGroup> shownInjuryLevelGroups;
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
			        
			        clearChartChildren();
					clearGroupsFromPatients(); //clear groups from patients
					clearShownInjuryGroupsBMIGroupsWomanManGroups(); //clear shown injury groups and bmi subgroups
					clearPatientsOnChartConnections();
					
					if(current!= null) //if new list exists
					{
						assignPatientsToGroups(current); //assign patients from new list to chart groups, subgroups
						createPatientsOnChartConnections(current);
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
		shownInjuryLevelGroups = new TreeMap<Integer,InjuryLevelGroup>();
		patientsOnChartConnections = new LinkedList<PatientsOnChartConnection>();
		shownPatientsOnChartConnections = new LinkedList<PatientsOnChartConnection>();
		createGroups();
		setPatients(patients);
		setLegend(legend);
		useChartContentMirroring = false;
	}
	 
	/*------------------- METHODS -----------------------------------------------------------------*/ 
	
	 
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
        
        
        for(InjuryLevelGroup injuryGroup: shownInjuryLevelGroups.values())
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
                
                
                
                // drawing bmi subgroup ring parts
                
                //count number of shown bmi groups inside InjuryLevelGroups
                int shownBMIGroups = injuryGroup.getShownBMIGroups().size();
                
                double sizeOfBMIRingPart = (shownBMIGroups != 0) ? sizeOfRingPart / shownBMIGroups : 0;
                double startAngleBMIGroup = startAngle;
                double sizeOfSexGroup = sizeOfBMIRingPart/2;
                for(BMIGroup bmiGroup: injuryGroup.getShownBMIGroups().values())
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
	
	private void clearShownInjuryGroupsBMIGroupsWomanManGroups()
	{
		for(InjuryLevelGroup injuryLevelGr: shownInjuryLevelGroups.values())
		{
			for(BMIGroup bmiGroup : injuryLevelGr.getBmiGroups().values())
			{
				bmiGroup.getShownPatientsOnChartWomen().clear();
				bmiGroup.getShownPatientsOnChartMen().clear();
			}
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
					BMIGroup patientsBmiGroup = patientsInjuryLevelGroup.getBmiGroups().get(bmiRangeName); // get bmi subgroup for injury level group of patient
					
					//assignmentCounter++;
					
					PatientOnChart patientOnChart = null;
					if(patient.getSex()==Sex.MAN) //if patient is a man
					{
						patientOnChart = new PatientOnChart(patient,patientsBmiGroup,this);
						patient.setPatientOnChart(patientOnChart);
						patientsBmiGroup.getPatientsOnChartMen().add(patientOnChart);
						patientsBmiGroup.getShownPatientsOnChartMen().add(patientOnChart); //patient will be shown
					}
					else if (patient.getSex()==Sex.WOMAN) //if patient is a woman
					{
						patientOnChart = new PatientOnChart(patient,patientsBmiGroup,this);
						patient.setPatientOnChart(patientOnChart);
						patientsBmiGroup.getPatientsOnChartWomen().add(patientOnChart);
						patientsBmiGroup.getShownPatientsOnChartWomen().add(patientOnChart); //patient will be shown
					}
					
					//getChartChildren().add(patientOnChart.getRegion()); //add patient region to drawn chartChidren
					
					// patient was added to bmi subgroup and injury level group, so they are not empty
					patientsBmiGroup.setEmpty(false); 
					patientsBmiGroup.getInjuryLevelGroup().setEmpty(false);
					
					//adding shown groups to shown collections
					// TODO add to the sorting collection
					if(!shownInjuryLevelGroups.containsValue(patientsBmiGroup.getInjuryLevelGroup()))
					{
						shownInjuryLevelGroups.put(getIndexInInjuryLevel(patientsBmiGroup.getInjuryLevelGroup().getInjuryLevel()),patientsBmiGroup.getInjuryLevelGroup());
						getChartChildren().add(patientsBmiGroup.getInjuryLevelGroup().getRegion());
					}
					if(!patientsBmiGroup.getInjuryLevelGroup().getShownBMIGroups().values().contains(patientsBmiGroup))
					{
						patientsBmiGroup.getInjuryLevelGroup().getShownBMIGroups().put(getIndexOfBMIRange(patientsBmiGroup.getBmiRange().getBmiRangeName()),patientsBmiGroup);
						getChartChildren().add(patientsBmiGroup.getRegion());
						getChartChildren().add(patientsBmiGroup.getMenRegion());
						getChartChildren().add(patientsBmiGroup.getWomenRegion());
					}
				}
			}
			
			
		}
			
		
		//System.out.println("Patients assigned: "+assignmentCounter);
	}
	
	
	
	
	private void createPatientsOnChartConnections(ObservableList<Patient> patients)
	{
		for(int i=0;i<patients.size()-1;i++)
		{
			for(int j=i+1;j<patients.size();j++)
			{
				Patient p1 = patients.get(i);
				Patient p2 = patients.get(j);
				
				if(Math.abs(p1.getWnm()-p2.getWnm())<deltaWNM)
				{
					PatientsOnChartConnection connection = new PatientsOnChartConnection(p1.getPatientOnChart(), p2.getPatientOnChart());
					patientsOnChartConnections.add(connection);
					shownPatientsOnChartConnections.add(connection);
				}
			}
		}
		
	}
	
	private void clearPatientsOnChartConnections()
	{
		patientsOnChartConnections.clear();
		shownPatientsOnChartConnections.clear();		
	}
	
	private void clearChartChildren()
	{
		getChartChildren().clear();
	}
	
	private Integer getIndexInInjuryLevel(InjuryLevel injuryLevel)
	{
		int index = 0;
		for(InjuryLevel injuryLevelValue:InjuryLevel.values())
		{
			if(injuryLevelValue==injuryLevel) 
			{
				return index;
			}
			index++;
		}
		return null;
	}
	
	private Integer getIndexOfBMIRange(BMIRangeName bmiRangeName)
	{
		int index = 0;
		for(BMIRangeName bmiRangeNameValue: BMIRangeName.values())
		{
			if(bmiRangeName==bmiRangeNameValue)
			{
				return index;
			}
			index++;
		}
		return null;
	}
	

}
