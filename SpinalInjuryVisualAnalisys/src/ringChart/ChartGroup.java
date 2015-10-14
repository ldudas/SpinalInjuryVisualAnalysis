package ringChart;

public abstract class ChartGroup extends ChartElement
{
	protected boolean isEmpty;

	
	public ChartGroup(RingChart ringChart)
	{
		super(ringChart);
	}
	
	public boolean isEmpty()
	{
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty)
	{
		this.isEmpty = isEmpty;
	}
	
}
