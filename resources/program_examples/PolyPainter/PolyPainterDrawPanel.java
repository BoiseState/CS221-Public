import java.awt.*;
import javax.swing.*;

/**
 * JPanel that paints polymorphic PaintableThings.
 * DO NOT EDIT. THIS CLASS IS COMPLETE.
 * 
 * @author mvail
 */
@SuppressWarnings("serial")
public class PolyPainterDrawPanel extends JPanel
{
	private PaintableThing[] things;
	
	/**
	 * Constructor - initialize panel
	 */
	public PolyPainterDrawPanel() {
		setBackground(Color.white);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{		
		super.paintComponent(g);
		
		if (things != null)
		{
			//Lots of polymorphism in this for-each loop! For-each loops
			// operate on collections that are Iterable. The loop doesn't
			// care that things is an array of PaintableThings. It only
			// requires that things "is-a" Iterable.
			//Inside the loop, we are calling the draw() method on an
			// object that "is-a" PaintableThing. The exact version of
			// draw() that actually gets called will depend on the type
			// of the object at the other end of the thing reference,
			// which may be any class that directly or indirectly
			// extends PaintableThing.
			for (PaintableThing thing : things) {
				thing.draw(g); //paint this thing on Graphics g
				System.out.println(thing.toString()); //print corresponding text
			}
			System.out.println(); //blank line separator in case of re-draw
		}
	}

	/**
	 * Update shapes and call repaint()
	 * @param things - collection of things to paint
	 */
	public void paintThings(PaintableThing[] things)
	{
		this.things = things;
		repaint();
	}
	
	/**
	 * Set shapes to null and repaint()
	 */
	public void clear()
	{
		this.things = null;
		repaint();
	}
}
