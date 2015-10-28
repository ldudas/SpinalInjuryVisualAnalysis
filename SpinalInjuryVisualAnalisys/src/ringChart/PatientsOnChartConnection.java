package ringChart;

import javafx.scene.shape.QuadCurve;

public class PatientsOnChartConnection
{

	private PatientOnChart patientFrom;
	private PatientOnChart patientTo;
	private QuadCurve quadCurve;

	public PatientsOnChartConnection(PatientOnChart patientFrom, PatientOnChart patientTo)
	{	
		this.patientFrom = patientFrom;
		this.patientTo = patientTo;
		
		quadCurve = new QuadCurve();
		quadCurve.setFill(null);
		quadCurve.setStrokeWidth(1.5);
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
	
	
}
