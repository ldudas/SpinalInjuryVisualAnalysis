package ringChart;

import javafx.geometry.NodeOrientation;
import javafx.scene.layout.Region;

public abstract class ChartElement
{
	protected RingChart ringChart;
	protected Region region;
	protected boolean shown;
	
	public ChartElement(RingChart ringChart)
	{
		this.ringChart = ringChart;
		region = new Region();
		region.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
		region.setPickOnBounds(false);
		region.setScaleShape(false); 
		region.setCenterShape(false);
		region.setCacheShape(false);
        
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

	public boolean isShown()
	{
		return shown;
	}

	public void setShown(boolean shown)
	{
		this.shown = shown;
	}
	
}
