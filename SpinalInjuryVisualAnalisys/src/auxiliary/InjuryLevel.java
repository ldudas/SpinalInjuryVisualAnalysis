package auxiliary;

public enum InjuryLevel 
{
	C1,C2,C3,C4,C5,C6,C7,C8,
	T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,
	L1,L2,L3,L4,L5,
	S1,S2,S3,S4,S5;
	
	public static Integer getIndexInInjuryLevel(InjuryLevel injuryLevel)
	{
		int index = 0;
		for(InjuryLevel injuryLevelValue:InjuryLevel.values())
		{
			if(injuryLevelValue==injuryLevel) 
			{
				return index;
			}
			index++;
		}
		return null;
	}
}
