import java.awt.Graphics;

/**
 * A thing that can be painted on a given Graphics object.
 * 
 * @author mvail
 */
public abstract class PaintableThing {
	// TODO: supply appropriate variables common to all PaintableThings

	// TODO: write a constructor to initialize all instance variables
	
	/**
	 * Draws this thing on the given Graphics object.
	 * @param g Graphics context on which to draw
	 */
	public abstract void draw(Graphics g);

	/**
	 * Override default toString() to show name of shape and attribuites.
	 */
	public abstract String toString();
}
