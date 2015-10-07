package ringChart;

import javafx.scene.shape.Shape;

public class PatientsOnChartConnection
{

	private PatientOnChart patientFrom;
	private PatientOnChart patientTo;
	private Shape connectorShape;
	

	public PatientsOnChartConnection(PatientOnChart patientFrom, PatientOnChart patientTo)
	{
		this.patientFrom = patientFrom;
		this.patientTo = patientTo;
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

	public Shape getConnectorShape()
	{
		return connectorShape;
	}

	public void setConnectorShape(Shape connectorShape)
	{
		this.connectorShape = connectorShape;
	}
	
}
