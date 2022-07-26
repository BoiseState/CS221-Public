import java.awt.Color;
import java.awt.Graphics;

/**
 * FilledRectangle extends Rectangle which extends PaintableThing.
 * It adds a second color so it can have a separate fill color and outline color.
 */
public class FilledRectangle extends Rectangle {
	private Color fillColor; //new instance variable

	/**
	 * adds one new argument (fill color) to the values its parent(s) expected
	 */
	public FilledRectangle(int anchorX, int anchorY, int width, int height, Color outlineColor, Color fillColor) {
		
		super(anchorX, anchorY, width, height, outlineColor); //let parent initialize inherited variables
		this.fillColor = fillColor; //initialze new variables
		
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(fillColor);
		g.fillRect(anchorX, anchorY, width, height);
		
		super.draw(g); //draws the outline in the primaryColor, aka outlineColor
	}

	@Override
	public String toString() {
		return String.format("FilledRectangle: " +
			"x:%d, y:%d, width:%d, height:%d, " +
			"outlineColor:%s, fillColor:%s",
			anchorX, anchorY, width, height, 
			color.toString(), fillColor.toString());
	}
}
