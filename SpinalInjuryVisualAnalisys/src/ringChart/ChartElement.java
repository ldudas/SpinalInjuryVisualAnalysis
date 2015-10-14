package ringChart;

import javafx.scene.layout.Region;

public abstract class ChartElement
{
	protected RingChart ringChart;
	protected Region region;
	
	public ChartElement(RingChart ringChart)
	{
		this.ringChart = ringChart;
		region = new Region();
	}
	
	public RingChart getRingChart()
	{
		return ringChart;
	}
	public void setRingChart(RingChart ringChart)
	{
		this.ringChart = ringChart;
	}
	public Region getRegion()
	{
		return region;
	}
	public void setRegion(Region region)
	{
		this.region = region;
	}
	
}
