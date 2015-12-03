package auxiliary;

import java.util.ArrayList;
import java.util.List;

public class BMIRangeFactory
{

	private static BMIRangeFactory instance = null;
	
	/*private BMIRange underweight;
	private BMIRange normal;
	private BMIRange overweight;
	private BMIRange adiposity;*/
	
	private List<BMIRange> bmiRanges;
	
	private BMIRangeFactory()
	{
		bmiRanges = new ArrayList<>(4);
		bmiRanges.add(new BMIRange(BMIRangeName.UNDERWEIGHT,Double.MIN_VALUE,18.5));
		bmiRanges.add(new BMIRange(BMIRangeName.NORMAL,18.5, 25));
		bmiRanges.add(new BMIRange(BMIRangeName.OVERWEIGHT,25, 30));
		bmiRanges.add(new BMIRange(BMIRangeName.ADIPOSITY,30, Double.MAX_VALUE));
		/*underweight = new BMIRange(BMIRangeName.UNDERWEIGHT,Double.MIN_VALUE,18.5);
		normal = new BMIRange(BMIRangeName.NORMAL,18.5, 25);
		overweight = new BMIRange(BMIRangeName.OVERWEIGHT,25, 30);
		adiposity = new BMIRange(BMIRangeName.ADIPOSITY,30, Double.MAX_VALUE);*/

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
		case UNDERWEIGHT : return bmiRanges.get(0);//underweight
		case NORMAL 	 : return bmiRanges.get(1);//normal
		case OVERWEIGHT  : return bmiRanges.get(2);//overweight
		case ADIPOSITY   : return bmiRanges.get(3);//adiposity
		default 		 : return null;
		}
	}
	
	
}
