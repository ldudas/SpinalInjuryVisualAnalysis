package ringChart;

import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public abstract class ChartGroup extends ChartElement
{
	protected boolean isEmpty;
	protected Arc innerArc, outerArc;
	protected Text text;
	protected Region textDotRegion;

	
	public ChartGroup(RingChart ringChart)
	{
		super(ringChart);
		innerArc = new Arc();
		outerArc = new Arc();
		innerArc.setType(ArcType.ROUND);
		outerArc.setType(ArcType.ROUND);
		text = new Text();
		
		
		textDotRegion = new Region();
		textDotRegion.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        textDotRegion.setPickOnBounds(false);
        textDotRegion.setScaleShape(false); 
        textDotRegion.setCenterShape(false);
        textDotRegion.setCacheShape(false);
		
		textDotRegion.setShape(new Circle());
		textDotRegion.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		textDotRegion.setOpacity(0.8);
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

	public Text getText()
	{
		return text;
	}

	public void setText(Text text)
	{
		this.text = text;
	}

	public Region getTextDotRegion()
	{
		return textDotRegion;
	}

	public void setTextDotRegion(Region textDotRegion)
	{
		this.textDotRegion = textDotRegion;
	}


	
}
