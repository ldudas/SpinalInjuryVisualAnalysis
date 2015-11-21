package auxiliary;

import javafx.scene.paint.Color;
import ringChart.PatientOnChart;

public class ConnectionEndColorPicker
{
	private static double maxStrength = 100;
	
	public static Color getConnectionEndColor(PatientOnChart patientOnChart)
	{
		double strength = patientOnChart.getPatient().getStrength();
		double strengthRatio = strength / maxStrength;
		
		double red = strengthRatio<0.5 ? strengthRatio : 1.0;
		double green = strengthRatio<0.5 ? 1.0 : -2 * strengthRatio + 2;
		
		return new Color(red,green,0.0,1.0);
	}
	
	public static double getMaxStrength()
	{
		return maxStrength;
	}
}
