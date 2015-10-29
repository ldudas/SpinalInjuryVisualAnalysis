package ringChart;

import auxiliary.ConnectionEndColorPicker;
import javafx.scene.paint.Stop;
import javafx.scene.shape.QuadCurve;

public class PatientsOnChartConnection
{

	private PatientOnChart patientFrom;
	private PatientOnChart patientTo;
	private QuadCurve quadCurve;
	private Stop[] quadCurveConnectionGradientStops;

	public PatientsOnChartConnection(PatientOnChart patientFrom, PatientOnChart patientTo)
	{	
		this.patientFrom = patientFrom;
		this.patientTo = patientTo;
		
		quadCurve = new QuadCurve();
		quadCurve.setFill(null);
		quadCurve.setStrokeWidth(1.5);
		
		quadCurveConnectionGradientStops = new Stop[] { 
														new Stop(0, ConnectionEndColorPicker.getConnectionEndColor(patientFrom)), 
														new Stop(1, ConnectionEndColorPicker.getConnectionEndColor(patientTo))
														};
	}

	
	public PatientOnChart getPatientFrom()
	{
		return patientFrom;
	}

	public void setPatientFrom(PatientOnChart patientFrom)
	{
		this.patientFrom = patientFrom;
	}

	public PatientOnChart getPatientTo()
	{
		return patientTo;
	}

	public void setPatientTo(PatientOnChart patientTo)
	{
		this.patientTo = patientTo;
	}


	public QuadCurve getQuadCurve()
	{
		return quadCurve;
	}


	public void setQuadCurve(QuadCurve quadCurve)
	{
		this.quadCurve = quadCurve;
	}


	public Stop[] getQuadCurveConnectionGradientStops()
	{
		return quadCurveConnectionGradientStops;
	}


	public void setQuadCurveConnectionGradientStops(Stop[] quadCurveConnectionGradientStops)
	{
		this.quadCurveConnectionGradientStops = quadCurveConnectionGradientStops;
	}
	
	
}
