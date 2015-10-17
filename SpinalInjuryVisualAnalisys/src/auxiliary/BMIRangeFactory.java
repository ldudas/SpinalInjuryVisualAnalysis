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
		underweight = new BMIRange(BMIRangeName.UNDERWEIGHT,Double.MIN_VALUE,18.5);
		normal = new BMIRange(BMIRangeName.NORMAL,18.5, 25);
		overweight = new BMIRange(BMIRangeName.OVERWEIGHT,25, 30);
		adiposity = new BMIRange(BMIRangeName.ADIPOSITY,30, Double.MAX_VALUE);

	}
	
	public static BMIRangeFactory getInstance()
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
