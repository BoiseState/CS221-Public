import java.awt.Color;
import java.awt.Graphics;


/**
 * A thing that can be painted on a given Graphics object.
 * 
 * @author mvail
 */
public abstract class PaintableThing {
	protected int anchorX;
	protected int anchorY;
	protected int width;
	protected int height;
	protected Color primaryColor;
	
	/**
	 * @param anchorX upper left x anchor coordinate
	 * @param anchorY upper left y anchor coordinate
	 * @param width shape/object width or offset from anchor x
	 * @param height shape/object height or offset from anchor y
	 * @param color primary color
	 */
	public PaintableThing(int anchorX, int anchorY, int width, int height, Color color) {
		this.anchorX = anchorX;
		this.anchorY = anchorY;
		this.width = width;
		this.height = height;
		primaryColor = color;
	}
	
	/**
	 * Draws this thing on the given Graphics object.
	 * @param g Graphics context on which to draw
	 */
	public abstract void draw(Graphics g);

	/**
	 * Override default toString() to show shape name and attributes.
	 */
	public abstract String toString();
}
