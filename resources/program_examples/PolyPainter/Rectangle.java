import java.awt.Color;
import java.awt.Graphics;

/**
 * Paints a rectangle using values specified at the time of instantiation.
 */
public class Rectangle extends PaintableThing {

	/**
	 * expects the same arguments as PaintableThing and passes them all through to the super constructor for initialization
	 */
	public Rectangle(int anchorX, int anchorY, int width, int height, Color color) {
		super(anchorX, anchorY, width, height, color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(primaryColor);
		g.drawRect(anchorX, anchorY, width, height);
	}

	@Override
	public String toString() {
		return String.format("Rectangle: x:%d, y:%d, width:%d, height:%d, color:%s",
			anchorX, anchorY, width, height, color.toString());
	}
}
