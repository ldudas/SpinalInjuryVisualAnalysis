package auxiliary;

public class BMIRangeFactory
{

	private static BMIRangeFactory instance = null;
	
	private BMIRange underweight;
	private BMIRange normal;
	private BMIRange overweight;
	private BMIRange adiposity;
	
	private BMIRangeFactory()
	{
		underweight = new BMIRange(Double.MIN_VALUE,18.5);
		normal = new BMIRange(18.5, 24.9);
		overweight = new BMIRange(24.9, 29.9);
		adiposity = new BMIRange(29.9, Double.MAX_VALUE);
	}
	
	public BMIRangeFactory getInstance()
	{
		if(instance==null)
		{
			instance = new BMIRangeFactory();
		}
		return instance;
	}
	
	public BMIRange getBMIRange(BMIRangeName bmiRangeName)
	{
		switch(bmiRangeName)
		{
		case UNDERWEIGHT : return underweight;
		case NORMAL 	 : return normal;
		case OVERWEIGHT  : return overweight;
		case ADIPOSITY   : return adiposity;
		default 		 : return null;
		}
	}
	
}
