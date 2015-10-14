package auxiliary;

public class BMIRange
{
	private double fromBMI;
	private double toBMI;
		
	public BMIRange(double fromBMI, double toBMI)
	{
		this.fromBMI = fromBMI;
		this.toBMI = toBMI;
	}
	
	public double getFromBMI()
	{
		return fromBMI;
	}
	public void setFromBMI(double fromBMI)
	{
		this.fromBMI = fromBMI;
	}
	public double getToBMI()
	{
		return toBMI;
	}
	public void setToBMI(double toBMI)
	{
		this.toBMI = toBMI;
	}

	@Override
	public String toString()
	{
		return "BMIRange: ( " + fromBMI + ", " + toBMI + ">";
	}
}
