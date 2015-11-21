package vars;

public abstract class PatientsDirectory
{
	private static String patientsPath = "D:/patients/";
	
	public static String getPatientsPath()
	{
		return patientsPath;
	}
	
	public static void setPatientsPath(String path)
	{
		patientsPath=path;
	}
}
