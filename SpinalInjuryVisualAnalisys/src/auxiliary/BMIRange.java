package auxiliary;

public class BMIRange
{
	private BMIRangeName bmiRangeName;
	private double fromBMI;
	private double toBMI;
		
	public BMIRange(BMIRangeName bmiRangeName,double fromBMI, double toBMI)
	{
		this.bmiRangeName = bmiRangeName;
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

	public BMIRangeName getBmiRangeName()
	{
		return bmiRangeName;
	}

	public void setBmiRangeName(BMIRangeName bmiRangeName)
	{
		this.bmiRangeName = bmiRangeName;
	}

	@Override
	public String toString()
	{
		if(fromBMI==Double.MIN_VALUE)
		{
			return "<"+toBMI;
		}
		else if (toBMI==Double.MAX_VALUE)
		{
			return ">"+fromBMI;
		}
		else
		{
			return "( " + fromBMI + ", " + toBMI + " >";
		}
	}
}
