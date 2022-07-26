import java.awt.Color;
import java.awt.Graphics;

/**
 * RoundThing uses only the inherited variables of its parent, PaintableThing
 */
public class RoundThing extends PaintableThing {

	/**
	 * constructor passes through all values to super() for initialization
	 */
	public RoundThing(int upperLeftX, int upperLeftY, int width, int height,
			Color color) {
		super(upperLeftX, upperLeftY, width, height, color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(primaryColor);
		g.drawOval(anchorX, anchorY, width, height);
	}

	@Override
	public String toString() {
		return String.format("RoundThing: x:%d, y:%d, width:%d, height:%d, color:%s",
			anchorX, anchorY, width, height, color.toString());
	}

}
