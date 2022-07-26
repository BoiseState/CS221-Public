import java.awt.Color;
import java.awt.Graphics;

/**
 * RoundFilledThing extends RoundThing which extends PaintableThing.
 * There is one new variable, fillColor, so a filled thing can have
 * a different outline and fill color.
 */
public class RoundFilledThing extends RoundThing {
	private Color fillColor; //new variable

	/**
	 * one additional variable for a second color
	 */
	public RoundFilledThing(int upperLeftX, int upperLeftY, int width,
			int height, Color outlineColor, Color fillColor) {
		super(upperLeftX, upperLeftY, width, height, outlineColor);
		this.fillColor = fillColor;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(fillColor);
		g.fillOval(anchorX, anchorY, width, height);
		super.draw(g);
	}

	@Override
	public String toString() {
		return String.format("RoundFilledThing: " +
			"x:%d, y:%d, width:%d, height:%d, " +
			"outlineColor:%s, fillColor:%s",
			anchorX, anchorY, width, height,
			color.toString(), fillColor.toString());
	}

}
