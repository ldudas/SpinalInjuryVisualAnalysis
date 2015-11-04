package ringChart;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import auxiliary.BMIRange;
import auxiliary.BMIRangeName;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class BMIGroup extends ChartGroup
{

	private List<PatientOnChart> patientsOnChartMen;
	private List<PatientOnChart> shownPatientsOnChartMen;
	private Region menRegion;
	private Arc outerArcMen;
	private Arc innerArcMen;
	
	private List<PatientOnChart> patientsOnChartWomen;
	private List<PatientOnChart> shownPatientsOnChartWomen;
	private Region womenRegion;
	private Arc outerArcWomen;
	private Arc innerArcWomen;
	
	
	private InjuryLevelGroup injuryLevelGroup;
	private BMIRange bmiRange;
    
    
    
    public BMIGroup(InjuryLevelGroup injuryLevelGroup, BMIRange bmiRange, RingChart ringChart)
	{
    	super(ringChart);
    	this.injuryLevelGroup = injuryLevelGroup;
    	this.bmiRange = bmiRange;
    	patientsOnChartMen = new LinkedList<PatientOnChart>();
    	shownPatientsOnChartMen = new LinkedList<PatientOnChart>();
    	patientsOnChartWomen = new LinkedList<PatientOnChart>();
    	shownPatientsOnChartWomen = new LinkedList<PatientOnChart>();
    	isEmpty = true;
    	
    	outerArcMen= new Arc();
    	innerArcMen = new Arc();
    	outerArcWomen = new Arc();
    	innerArcWomen = new Arc();
    	
    	innerArcMen.setType(ArcType.ROUND);
		outerArcMen.setType(ArcType.ROUND);
		innerArcWomen.setType(ArcType.ROUND);
		outerArcWomen.setType(ArcType.ROUND);
    	
    	region.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
    	region.setStyle("-fx-border-color: grey; -fx-border-width: 0.5;");
		
		menRegion = new Region();
		menRegion.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        menRegion.setPickOnBounds(false);
        menRegion.setScaleShape(false); 
        menRegion.setCenterShape(false);
        menRegion.setCacheShape(false);
		menRegion.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		menRegion.setStyle("-fx-border-color: -fx-background; -fx-border-width: 1;");
		
		womenRegion = new Region();
		womenRegion.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        womenRegion.setPickOnBounds(false);
        womenRegion.setScaleShape(false); 
        womenRegion.setCenterShape(false);
        womenRegion.setCacheShape(false);
		womenRegion.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, CornerRadii.EMPTY, Insets.EMPTY)));
		womenRegion.setStyle("-fx-border-color: -fx-background; -fx-border-width: 1;");
		
		text.setText(bmiRange.getBmiRangeName().toString().charAt(0)+"");
	}
    
    
    public void hideWithoutRelayout()
    {
    	List<PatientsOnChartConnection> connectionsToHide = new LinkedList<>();
  	  
  	  
  	  for(PatientOnChart patientMan: shownPatientsOnChartMen)
  	  {
  		  ringChart.getChartChildren().remove(patientMan.getRegion());
  		  for(PatientsOnChartConnection connection: ringChart.getShownPatientsOnChartConnections())
      	  {
      		  if(connection.getPatientFrom()==patientMan || connection.getPatientTo()==patientMan)
      		  {
      			  connectionsToHide.add(connection);
      			  ringChart.getChartChildren().remove(connection.getQuadCurve());
      		  }
      	  }
  		patientMan.setShownUnchecked(false);
  	  }
  	  shownPatientsOnChartMen.clear();
  	  
  	  for(PatientOnChart patientWoman: shownPatientsOnChartWomen)
  	  {
  		  ringChart.getChartChildren().remove(patientWoman.getRegion());
  		  for(PatientsOnChartConnection connection: ringChart.getShownPatientsOnChartConnections())
      	  {
      		  if(connection.getPatientFrom()==patientWoman || connection.getPatientTo()==patientWoman)
      		  {
      			  connectionsToHide.add(connection);
      			  ringChart.getChartChildren().remove(connection.getQuadCurve());
      		  }
      	  }
  		patientWoman.setShownUnchecked(false);
  	  }
  	  shownPatientsOnChartWomen.clear();
  	  
  	  ringChart.getShownPatientsOnChartConnections().removeAll(connectionsToHide);
  	
  	  ringChart.getChartChildren().removeAll(menRegion,womenRegion,region,text,textDotRegion);
  	  
  	  
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
	public Region getMenRegion()
	{
		return menRegion;
	}
	public void setMenRegion(Region menRegion)
	{
		this.menRegion = menRegion;
	}
	public Arc getOuterArcMen()
	{
		return outerArcMen;
	}
	public void setOuterArcMen(Arc outerArcMen)
	{
		this.outerArcMen = outerArcMen;
	}
	public Arc getInnerArcMen()
	{
		return innerArcMen;
	}
	public void setInnerArcMen(Arc innerArcMen)
	{
		this.innerArcMen = innerArcMen;
	}
	public Region getWomenRegion()
	{
		return womenRegion;
	}
	public void setWomenRegion(Region womenRegion)
	{
		this.womenRegion = womenRegion;
	}
	public Arc getOuterArcWomen()
	{
		return outerArcWomen;
	}
	public void setOuterArcWomen(Arc outerArcWomen)
	{
		this.outerArcWomen = outerArcWomen;
	}
	public Arc getInnerArcWomen()
	{
		return innerArcWomen;
	}
	public void setInnerArcWomen(Arc innerArcWomen)
	{
		this.innerArcWomen = innerArcWomen;
	}
	public List<PatientOnChart> getShownPatientsOnChartMen()
	{
		return shownPatientsOnChartMen;
	}
	public void setShownPatientsOnChartMen(List<PatientOnChart> shownPatientsOnChartMen)
	{
		this.shownPatientsOnChartMen = shownPatientsOnChartMen;
	}
	public List<PatientOnChart> getShownPatientsOnChartWomen()
	{
		return shownPatientsOnChartWomen;
	}
	public void setShownPatientsOnChartWomen(List<PatientOnChart> shownPatientsOnChartWomen)
	{
		this.shownPatientsOnChartWomen = shownPatientsOnChartWomen;
	}
	
	@Override
	public final void setShown(boolean value) 
	{ 
		if(value!=shown)
		{
			 if(value)
	         {
	       	  	System.out.println("show bmigroup");
				 ringChart.getChartChildren().addAll(menRegion,womenRegion,region,textDotRegion,text);
			  	  
				 
				 for(PatientOnChart patientMan: patientsOnChartMen)
			  	  {
			  		patientMan.setShown(true);
			  	  }
				 
				 for(PatientOnChart patientWoman: patientsOnChartWomen)
			  	  {
			  		patientWoman.setShown(true);
			  	  }
				 
				 injuryLevelGroup.getShownBMIGroups().put(BMIRangeName.getIndexInBMIRangeName(this.getBmiRange().getBmiRangeName()),BMIGroup.this);
	         }
	         else
	         {
	       	  
	       	  Collection<BMIGroup> shownBMIGroups =  injuryLevelGroup.getShownBMIGroups().values();
	       	  
	       	  if(shownBMIGroups.size() == 1 )
	       	  {
	       		  injuryLevelGroup.setShown(false);
	       	  }
	       	  else
	       	  {
		        	 hideWithoutRelayout(); 
		        	 shownBMIGroups.remove(BMIGroup.this);
		        	 ringChart.requestChartLayout();
	       	  }
	       	  
	         }
			 
			 shown = value;
		}
	}
	
	public void setShownUnchecked(boolean value)
	{
		shown = value;
	}


	@Override
	public String toString()
	{
		return bmiRange.getBmiRangeName().toString();
	}
	

}
