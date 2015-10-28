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
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class RingChart extends Chart
{
	private static double minRadiusOuterInjuryLevel = 5;
	private static double radiusMultiplierInnerInjuryLevel = 0.9;
	private static double injuryLevelBmiGap = 1;
	private static double radiusMultiplierInnerBmi = 0.9;
	private static double deltaWNM = 0.1;
	private static double patientRegionRadius = 4;
	private static double patientsGap = patientRegionRadius*1.5;
	
	
	
	
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
  		animateStartAngleChange(get());
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
        
        
        double startAnglePads = getCurrentStartAngle();
        double xPad=0d;
        double yPad=0d;
        
        //count number of shown InjuryLevelGroups
        int numbOfShownInjuryLevelGroups = shownInjuryLevelGroups.size();
        double sizeOfRingPart = (numbOfShownInjuryLevelGroups != 0) ? 360.0 / numbOfShownInjuryLevelGroups : 0; 
        for(InjuryLevelGroup injuryLevelGroup: shownInjuryLevelGroups.values())
        {
        	//count number of shown bmi groups inside InjuryLevelGroups
            int shownBMIGroups = injuryLevelGroup.getShownBMIGroups().size();
            
            double sizeOfBMIRingPart = (shownBMIGroups != 0) ? sizeOfRingPart / shownBMIGroups : 0; 
        	double startAngleBMIGroup = startAnglePads;
        	
        	for(BMIGroup bmiGroup:injuryLevelGroup.getShownBMIGroups().values())
        	{
        		double radiusMen = bmiGroup.getShownPatientsOnChartMen().size()*(patientsGap+2*patientRegionRadius)+patientsGap;
        		double angleMen = normalizeAngle(startAngleBMIGroup+(sizeOfBMIRingPart/4));
        		double currXPadMen = calcX(angleMen,radiusMen,0);
        		double currYPadMen = calcY(angleMen,radiusMen,0);
        		
        		double radiusWomen = bmiGroup.getShownPatientsOnChartWomen().size()*(patientsGap+2*patientRegionRadius)+patientsGap;
        		double angleWomen = normalizeAngle(startAngleBMIGroup+(3*sizeOfBMIRingPart/4));
        		double currXPadWomen = calcX(angleWomen,radiusWomen,0);
        		double actYPadWomen = calcY(angleWomen,radiusWomen,0);
        		
        		double maxXPad = 2 * Math.max(Math.abs(currXPadMen), Math.abs(currXPadWomen)); 
        		double maxYPad = 2 * Math.max(Math.abs(currYPadMen), Math.abs(actYPadWomen));
        		
        		xPad = Math.max(xPad, maxXPad);
        		yPad = Math.max(yPad, maxYPad);
        		
        		startAngleBMIGroup += sizeOfBMIRingPart;
        		
        		
        	}
        	
        	startAnglePads+=sizeOfRingPart;
        }
        
        
       radiusOuterInjuryLevel = Math.min(width-xPad,height-yPad) / 2;
       if(radiusOuterInjuryLevel<minRadiusOuterInjuryLevel) radiusOuterInjuryLevel=minRadiusOuterInjuryLevel;
       
       
     
        
       // double sizeOfRingPart = (numbOfShownInjuryLevelGroups != 0) ? 360.0 / numbOfShownInjuryLevelGroups : 0;   
        double startAngle = getCurrentStartAngle();
        double innerInjuryArcRadius = radiusMultiplierInnerInjuryLevel*radiusOuterInjuryLevel;
        double outerBMIArcRadius = innerInjuryArcRadius - injuryLevelBmiGap;
        double innerBMIArcRadius = outerBMIArcRadius * radiusMultiplierInnerBmi;
        
        List<Text> drawnTexts = new LinkedList<Text>();
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
                
                //drawing text
                double injuryGroupCenterAngle = startAngle + sizeOfRingPart / 2;
                double textInjuryX = calcX(injuryGroupCenterAngle, radiusOuterInjuryLevel-(radiusOuterInjuryLevel-innerInjuryArcRadius)/2, centerX);
                double textInjuryY = calcY(injuryGroupCenterAngle, radiusOuterInjuryLevel-(radiusOuterInjuryLevel-innerInjuryArcRadius)/2, centerY);
                double fontInjurySize = (radiusOuterInjuryLevel-innerInjuryArcRadius)/2;
                
                Region textInjuryDot = injuryGroup.getTextDotRegion();
                textInjuryDot.setLayoutX(textInjuryX);
                textInjuryDot.setLayoutY(textInjuryY);
                ((Circle)textInjuryDot.getShape()).setRadius(fontInjurySize/3);
                
                
                Text textInjuryGroup = injuryGroup.getText();
                Font fontInjuryGroup = new Font("Verdana", fontInjurySize);
                textInjuryGroup.setFont(fontInjuryGroup);
                textInjuryGroup.setLayoutX(textInjuryX);
                textInjuryGroup.setLayoutY(textInjuryY);
                
                drawnTexts.add(textInjuryGroup);
                
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
                        
                        //drawing text
                        double bmiArcCenterAngle = startAngleBMIGroup + sizeOfBMIRingPart/2;
                        double textBmiX = calcX(bmiArcCenterAngle, outerBMIArcRadius-(outerBMIArcRadius-innerBMIArcRadius)/2, centerX);
                        double textBmiY = calcY(bmiArcCenterAngle, outerBMIArcRadius-(outerBMIArcRadius-innerBMIArcRadius)/2, centerY);
                        double fontBMISize = (outerBMIArcRadius-innerBMIArcRadius)/2.5;
                        
                        Region textBMIDot = bmiGroup.getTextDotRegion();
                        textBMIDot.setLayoutX(textBmiX);
                        textBMIDot.setLayoutY(textBmiY);
                        ((Circle)textBMIDot.getShape()).setRadius(fontBMISize/5);
                        
                        Text textBMIGroup = bmiGroup.getText();
                        Font fontBMIGroup = new Font("Verdana", fontBMISize);
                        textBMIGroup.setFont(fontBMIGroup);
                        textBMIGroup.setLayoutX(textBmiX);
                        textBMIGroup.setLayoutY(textBmiY);
                        
                        drawnTexts.add(textBMIGroup);
                        
                        
                        
                        double radiusMen = (bmiGroup.getShownPatientsOnChartMen().size()*(patientsGap+2*patientRegionRadius))+patientsGap;
                		double angleMen = startAngleBMIGroup+(sizeOfBMIRingPart/4);
                		double radiusWomen = (bmiGroup.getShownPatientsOnChartWomen().size()*(patientsGap+2*patientRegionRadius))+patientsGap;
                		double angleWomen = startAngleBMIGroup+(3*sizeOfBMIRingPart/4);
                        
                        
                        //drawing men region
                		Region ringPartMenRegion = bmiGroup.getMenRegion();
                		Arc outerArcMen = bmiGroup.getOuterArcMen();
                        Arc innerArcMen = bmiGroup.getInnerArcMen();
                        
                        outerArcMen.setStartAngle(startAngleBMIGroup); //ustaw k¹t pocz¹tkowy
                        outerArcMen.setLength(sizeOfSexGroup); //ustaw k¹t
                        outerArcMen.setRadiusX(radiusOuterInjuryLevel+radiusMen); //ustawX promienia (bo arc to kawa³ek elipsy)
                        outerArcMen.setRadiusY(radiusOuterInjuryLevel+radiusMen); //ustawY promienia (bo arc to kawa³ek elipsy)
                        
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
                        outerArcWomen.setRadiusX(radiusOuterInjuryLevel+radiusWomen); //ustawX promienia (bo arc to kawa³ek elipsy)
                        outerArcWomen.setRadiusY(radiusOuterInjuryLevel+radiusWomen); //ustawY promienia (bo arc to kawa³ek elipsy)
                        
                        innerArcWomen.setStartAngle(startAngleBMIGroup+sizeOfSexGroup); //ustaw k¹t pocz¹tkowy
                        innerArcWomen.setLength(sizeOfSexGroup); //ustaw k¹t
                        innerArcWomen.setRadiusX(radiusOuterInjuryLevel); //ustawX promienia (bo arc to kawa³ek elipsy)
                        innerArcWomen.setRadiusY(radiusOuterInjuryLevel); //ustawY promienia (bo arc to kawa³ek elipsy)
                        
                        
                        ringPartWomenRegion.setShape(Shape.subtract(outerArcWomen, innerArcWomen));
                        ringPartWomenRegion.setLayoutX(centerX);
                        ringPartWomenRegion.setLayoutY(centerY);
                        
                        //drawing men patients
                        double firstPatientsRegionRadius = radiusOuterInjuryLevel+patientsGap+patientRegionRadius;
                        double xManArcWidthFirstPoint = calcX(startAngleBMIGroup,firstPatientsRegionRadius,centerX);
                        double yManArcWidthFirstPoint = calcY(startAngleBMIGroup,firstPatientsRegionRadius,centerY);
                        double xManArcWidthSecondPoint = calcX(startAngleBMIGroup+sizeOfSexGroup,firstPatientsRegionRadius,centerX);
                        double yManArcWidthSecondPoint = calcY(startAngleBMIGroup+sizeOfSexGroup,firstPatientsRegionRadius,centerY);
                        
                        double pointsDistanceMen = pointsDistance(xManArcWidthFirstPoint, yManArcWidthFirstPoint, xManArcWidthSecondPoint, yManArcWidthSecondPoint);
                        int manCounter = 1;
                        double patientMenRadius = 0d;
                        for(PatientOnChart patientOnChatMen:bmiGroup.getShownPatientsOnChartMen())
                        {
                        	double regionX; 
                        	double regionY;
                        	
                        	if(manCounter==1)
                        	{
                        		regionX = calcX(angleMen,radiusOuterInjuryLevel+patientsGap+patientRegionRadius,centerX);
                        		regionY = calcY(angleMen,radiusOuterInjuryLevel+patientsGap+patientRegionRadius,centerY);
                        	}
                        	else
                        	{
                        		regionX = calcX(angleMen,radiusOuterInjuryLevel+((manCounter-1)*(patientsGap+2*patientRegionRadius))+(patientsGap+patientRegionRadius),centerX);
                        		regionY = calcY(angleMen,radiusOuterInjuryLevel+((manCounter-1)*(patientsGap+2*patientRegionRadius))+(patientsGap+patientRegionRadius),centerY);
                        	}
                        	
                        	Region patientOnChartMenRegion = patientOnChatMen.getRegion();
                        	patientOnChartMenRegion.setLayoutX(regionX);
                        	patientOnChartMenRegion.setLayoutY(regionY);
                        	
                        	if(manCounter==1)
                        	{
                        		patientMenRadius = pointsDistanceMen<2*patientRegionRadius? pointsDistanceMen/2:patientRegionRadius;
                        	}
                        	
                        	((Circle)patientOnChartMenRegion.getShape()).setRadius(patientMenRadius);
                        	manCounter++;
                        }
                        
                        //drawing women patients
                        double xWomanArcWidthFirstPoint = calcX(startAngleBMIGroup+sizeOfSexGroup,firstPatientsRegionRadius,centerX);
                        double yWomanArcWidthFirstPoint = calcY(startAngleBMIGroup+sizeOfSexGroup,firstPatientsRegionRadius,centerY);
                        double xWomanArcWidthSecondPoint = calcX(startAngleBMIGroup+2*sizeOfSexGroup,firstPatientsRegionRadius,centerX);
                        double yWomanArcWidthSecondPoint = calcY(startAngleBMIGroup+2*sizeOfSexGroup,firstPatientsRegionRadius,centerY);
                        
                        double pointsDistanceWomen = pointsDistance(xWomanArcWidthFirstPoint, yWomanArcWidthFirstPoint, xWomanArcWidthSecondPoint, yWomanArcWidthSecondPoint);
                        
                        int womanCounter = 1;
                        double patientWomenRadius=0d;
                        for(PatientOnChart patientOnChatWomen:bmiGroup.getShownPatientsOnChartWomen())
                        {
                        	double regionX; 
                        	double regionY;
                        	
                        	if(womanCounter==1)
                        	{
                        		regionX = calcX(angleWomen,radiusOuterInjuryLevel+patientsGap+patientRegionRadius,centerX);
                        		regionY = calcY(angleWomen,radiusOuterInjuryLevel+patientsGap+patientRegionRadius,centerY);
                        	}
                        	else
                        	{
                        		regionX = calcX(angleWomen,radiusOuterInjuryLevel+((womanCounter-1)*(patientsGap+2*patientRegionRadius))+(patientsGap+patientRegionRadius),centerX);
                        		regionY = calcY(angleWomen,radiusOuterInjuryLevel+((womanCounter-1)*(patientsGap+2*patientRegionRadius))+(patientsGap+patientRegionRadius),centerY);
                        	}
                        	
                        	Region patientOnChartWomenRegion = patientOnChatWomen.getRegion();
                        	patientOnChartWomenRegion.setLayoutX(regionX);
                        	patientOnChartWomenRegion.setLayoutY(regionY);
                        	
                        	if(womanCounter==1)
                        	{
                        		patientWomenRadius = pointsDistanceWomen<2*patientRegionRadius? pointsDistanceWomen/2:patientRegionRadius;
                        	}
                        	
                        	((Circle)patientOnChartWomenRegion.getShape()).setRadius(patientWomenRadius);
                        	womanCounter++;
                        }
                        
                        
                        startAngleBMIGroup += sizeOfBMIRingPart;
                	
                
                }
                
                startAngle+=sizeOfRingPart;
        }
        
        
        //drawing patients connections
        
        for(PatientsOnChartConnection patientsConnection:shownPatientsOnChartConnections)
        {
        	PatientOnChart patientFirst = patientsConnection.getPatientFrom();
        	PatientOnChart patientSecond = patientsConnection.getPatientTo();
        	
        	Arc patientFirstBMIGroupInnerArc = patientFirst.getBmiGroup().getInnerArc();
        	
        	double radiusFirst = patientFirstBMIGroupInnerArc.getRadiusX();
        	double startAngleFirst = patientFirstBMIGroupInnerArc.getStartAngle();
        	double sizeFirst = patientFirstBMIGroupInnerArc.getLength();
        	
        	double patientsFirstAngle = startAngleFirst + 
        							(patientFirst.getPatient().getSex()==Sex.MAN? 0.25 : 0.75) * sizeFirst;
        	
        	double firstX = calcX(patientsFirstAngle,radiusFirst,centerX);
        	double firstY = calcY(patientsFirstAngle,radiusFirst,centerY);
        	
        	
        	Arc patientSecondBMIGroupInnerArc = patientSecond.getBmiGroup().getInnerArc();
        	
        	double radiusSecond = patientSecondBMIGroupInnerArc.getRadiusX();
        	double startAngleSecond = patientSecondBMIGroupInnerArc.getStartAngle();
        	double sizeSecond = patientSecondBMIGroupInnerArc.getLength();
        	
        	double patientsSecondAngle = startAngleSecond + 
        							(patientSecond.getPatient().getSex()==Sex.MAN? 0.25 : 0.75) * sizeSecond;
        	
        	double secondX = calcX(patientsSecondAngle,radiusSecond,centerX);
        	double secondY = calcY(patientsSecondAngle,radiusSecond,centerY);
        	

        	
        	QuadCurve curve = patientsConnection.getQuadCurve();
        	curve.setStartX(firstX);
        	curve.setStartY(firstY);
        	curve.setEndX(secondX);
        	curve.setEndY(secondY);
        	curve.setControlX(centerX);
        	curve.setControlY(centerY);   
        	
        	Stop[] stops = new Stop[] { new Stop(0, Color.YELLOW), new Stop(1, Color.RED)};
            
            curve.setStroke(gradientForCoordinates(firstX,firstY,secondX,secondY,stops));
        	
        }
        
        drawnTexts.stream().forEach(text->text.toFront());
    
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
					
				 //add patient region to drawn chartChidren
					
					// patient was added to bmi subgroup and injury level group, so they are not empty
					patientsBmiGroup.setEmpty(false); 
					patientsBmiGroup.getInjuryLevelGroup().setEmpty(false);
					
					//adding shown groups to shown collections
					if(!shownInjuryLevelGroups.containsValue(patientsBmiGroup.getInjuryLevelGroup()))
					{
						shownInjuryLevelGroups.put(getIndexInInjuryLevel(patientsBmiGroup.getInjuryLevelGroup().getInjuryLevel()),patientsBmiGroup.getInjuryLevelGroup());
						getChartChildren().addAll(patientsBmiGroup.getInjuryLevelGroup().getRegion(),patientsBmiGroup.getInjuryLevelGroup().getTextDotRegion(),patientsBmiGroup.getInjuryLevelGroup().getText());
					}
					if(!patientsBmiGroup.getInjuryLevelGroup().getShownBMIGroups().values().contains(patientsBmiGroup))
					{
						patientsBmiGroup.getInjuryLevelGroup().getShownBMIGroups().put(getIndexOfBMIRange(patientsBmiGroup.getBmiRange().getBmiRangeName()),patientsBmiGroup);
						getChartChildren().addAll(patientsBmiGroup.getRegion(),patientsBmiGroup.getMenRegion(),patientsBmiGroup.getWomenRegion(),patientsBmiGroup.getTextDotRegion(),patientsBmiGroup.getText());
					}
					
					getChartChildren().add(patientOnChart.getRegion());
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
					getChartChildren().add(connection.getQuadCurve());
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
	
	 private void animateStartAngleChange(double newValue) 
     {
		
     	 if (shouldAnimate()) {
              animate(
                  new KeyFrame(Duration.ZERO, new KeyValue(currentStartAngleProperty(),getCurrentStartAngle())),
                  new KeyFrame(Duration.millis(1000),new KeyValue(currentStartAngleProperty(),
                          newValue, Interpolator.EASE_BOTH))
              );
          } else {
              requestChartLayout();
          }
			
	}
	 

	private Paint gradientForCoordinates(double firstX, double firstY, double secondX, double secondY, Stop[] stops)
	{
		double yDiff = Math.abs(secondY-firstY);
        double xDiff = Math.abs(secondX-firstX);
        
        double side = Math.max(xDiff, yDiff);
        
        double gradStartX=0d;
        double gradStartY=0d;
        double gradAddY=0d;
        double gradAddX=0d;
        
        if(secondX>firstX && secondY>=firstY)
        {
        	gradStartX = 0;
        	gradStartY = 0;
        	gradAddX = xDiff / side;
        	gradAddY = yDiff / side;
        }
        else if (secondX<=firstX && secondY>firstY)
        {
        	gradStartX = 1;
        	gradStartY = 0;
        	gradAddX = - xDiff / side;
        	gradAddY = yDiff / side;
        }
        else if (secondX<firstX && secondY<=firstY)
        {
        	gradStartX = 1;
        	gradStartY = 1;
        	gradAddX = - xDiff / side;
        	gradAddY = - yDiff / side;
        }
        else if (secondX>=firstX && secondY<firstY)
        {
        	gradStartX = 0;
        	gradStartY = 1;
        	gradAddX = xDiff / side;
        	gradAddY = - yDiff / side;
        }
        
        return  new LinearGradient(gradStartX, gradStartY, gradStartX+gradAddX, gradStartY+gradAddY, true, CycleMethod.NO_CYCLE, stops);
	}
	
	 //wylicz x na podstawie k¹ta, d³ugoœci ramienia i x œrodka
    private static double calcX(double angle, double radius, double centerX) {
        return (double)(centerX + radius * Math.cos(Math.toRadians(-angle)));
    }

    //wylicz y na podstawie k¹ta, d³ugoœci ramienia i y œrodka
    private static double calcY(double angle, double radius, double centerY) {
        return (double)(centerY + radius * Math.sin(Math.toRadians(-angle)));
    }
    
    /** Normalize any angle into -180 to 180 deg range */
    //potrzebne do funkcji sin/cos
    private static double normalizeAngle(double angle) {
        double a = angle % 360; //a = reszta z dzielenia k¹ta przez 360
        if (a <= -180) a += 360; //je¿eli k¹t jest mniejszy od -180, dodaj 360
        if (a > 180) a -= 360; //je¿eli k¹t wiêkszy od 180, odejmij 180
        return a;
    }
    
    private static double pointsDistance(double firstX,double firstY,double secondX,double secondY)
    {
    	return Math.sqrt(Math.pow(secondX-firstX, 2)+Math.pow(secondY-firstY,2));
    }
	

}
