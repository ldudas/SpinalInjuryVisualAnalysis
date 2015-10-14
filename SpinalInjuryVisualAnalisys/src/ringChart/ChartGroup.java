package ringChart;

import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public abstract class ChartGroup extends ChartElement
{
	protected boolean isEmpty;
	protected Arc innerArc, outerArc;

	
	public ChartGroup(RingChart ringChart)
	{
		super(ringChart);
		innerArc = new Arc();
		outerArc = new Arc();
		innerArc.setType(ArcType.ROUND);
		outerArc.setType(ArcType.ROUND);
	}
	
	public boolean isEmpty()
	{
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty)
	{
		this.isEmpty = isEmpty;
	}

	public Arc getInnerArc()
	{
		return innerArc;
	}

	public void setInnerArc(Arc innerArc)
	{
		this.innerArc = innerArc;
	}

	public Arc getOuterArc()
	{
		return outerArc;
	}

	public void setOuterArc(Arc outerArc)
	{
		this.outerArc = outerArc;
	}
	
}
