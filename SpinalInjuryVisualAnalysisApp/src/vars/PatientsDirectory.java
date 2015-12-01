package vars;

public abstract class PatientsDirectory
{
	private static String patientsPath;// = System.getProperty("user.home")+"/patients/";

	
	public static String getPatientsPath()
	{
		if (patientsPath==null)
		{
			if ((System.getProperty("os.name")).toUpperCase().contains("WIN"))
			{
				patientsPath = System.getenv("AppData");
			}
			else
			{
				patientsPath = System.getProperty("user.home");
				patientsPath += "/Library/Application Support";
			}
			patientsPath+="\\SpinalInjuryVisualAnalysis\\patients\\";
			
		}
		return patientsPath;
	}
	
	public static void setPatientsPath(String path)
	{
		patientsPath=path;
	}
}
