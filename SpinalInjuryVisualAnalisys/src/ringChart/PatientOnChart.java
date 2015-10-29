package ringChart;

import java.util.LinkedList;
import java.util.List;

import auxiliary.Patient;
import auxiliary.Sex;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PatientOnChart extends ChartElement
{

	private Patient patient;
	private BMIGroup bmiGroup;
	
    
    public PatientOnChart(Patient patient, BMIGroup bmiGroup, RingChart ringChart)
	{
    	super(ringChart);
		this.patient = patient;
		this.bmiGroup= bmiGroup;
		
		Circle circle = new Circle();
		region.setShape(circle);
		region.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
	}
    
    public Patient getPatient()
	{
		return patient;
	}
	public void setPatient(Patient patient)
	{
		this.patient = patient;
	}
	public BMIGroup getBmiGroup()
	{
		return bmiGroup;
	}
	public void setBmiGroup(BMIGroup bmiGroup)
	{
		this.bmiGroup = bmiGroup;
	}
	
	@Override
	public final void setShown(boolean value) 
	{ 
		if(value!=shown)
		{
			List<PatientOnChart> shownPatientsList = patient.getSex() == Sex.MAN ? bmiGroup.getShownPatientsOnChartMen() : bmiGroup.getShownPatientsOnChartWomen();
	      	List<PatientOnChart> shownPatientsList2 = patient.getSex() == Sex.MAN ? bmiGroup.getShownPatientsOnChartWomen() : bmiGroup.getShownPatientsOnChartMen();
	      	  
			
			if(value)
	        {
				
	      	  if(!shownPatientsList.isEmpty() || !shownPatientsList2.isEmpty())
	      	  {
	      		  shownPatientsList.add(PatientOnChart.this);
	        	  ringChart.getChartChildren().add(PatientOnChart.this.region);
	        	  
	        	  for(PatientsOnChartConnection connection: ringChart.getPatientsOnChartConnections())
	        	  {
	        		  if(connection.getPatientFrom()==PatientOnChart.this || connection.getPatientTo()==PatientOnChart.this)
	        		  {
	        			  ringChart.getShownPatientsOnChartConnections().add(connection);
	        			  ringChart.getChartChildren().add(connection.getQuadCurve());
	        		  }
	        	  }
	        	  
	        	  ringChart.requestChartLayout();
	      	  }
	      	  
	        }
	        else
	        {
	      	
	      	  if(shownPatientsList.size()==1 && shownPatientsList2.isEmpty())
	      	  {
	      		  bmiGroup.setShown(false);
	      	  }
	      	  else
	      	  {
		        	  shownPatientsList.remove(PatientOnChart.this);
		        	  ringChart.getChartChildren().remove(PatientOnChart.this.region);
		        	  
		        	  List<PatientsOnChartConnection> connectionsToHide = new LinkedList<>();
		        	  for(PatientsOnChartConnection connection: ringChart.getShownPatientsOnChartConnections())
		        	  {
		        		  if(connection.getPatientFrom()==PatientOnChart.this || connection.getPatientTo()==PatientOnChart.this)
		        		  {
		        			  connectionsToHide.add(connection);
		        			  ringChart.getChartChildren().remove(connection.getQuadCurve());
		        		  }
		        	  }
		        	  
		        	  ringChart.getShownPatientsOnChartConnections().removeAll(connectionsToHide);
		        	
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
    
	
}
