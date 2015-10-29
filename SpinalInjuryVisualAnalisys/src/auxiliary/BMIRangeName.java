package auxiliary;

public enum BMIRangeName
{
	UNDERWEIGHT,NORMAL,OVERWEIGHT,ADIPOSITY;
	
	public static Integer getIndexInBMIRangeName(BMIRangeName bmiRangeName)
	{
		int index = 0;
		for(BMIRangeName bmiRangeNameValue: BMIRangeName.values())
		{
			if(bmiRangeName==bmiRangeNameValue)
			{
				return index;
			}
			index++;
		}
		return null;
	}
}
