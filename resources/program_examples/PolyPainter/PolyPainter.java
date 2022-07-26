import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

/**
 * Draw polymorphic PaintableThings on a panel.
 * This class is the program driver, the JFrame,
 * and the ActionListener, all rolled into one.
 *  
 * @author mvail
 */
@SuppressWarnings("serial")
public class PolyPainter extends JFrame implements ActionListener
{
	private PolyPainterDrawPanel drawPanel;
	private int numShapes;
	private JButton drawButton;
	private PaintableThing[] shapes;

	/**
	 * extended JFrame constructor
	 */
	public PolyPainter(String title)
	{
		super(title); //JFrame constructor
				
		// Control Panel
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		drawButton = new JButton("Draw");
		drawButton.addActionListener(this);
		
		controlPanel.add(Box.createVerticalGlue());
		controlPanel.add(drawButton);
		controlPanel.add(Box.createVerticalGlue());
		
		// Draw Panel
		drawPanel = new PolyPainterDrawPanel();
		drawPanel.setPreferredSize(new Dimension(400, 400));

		// Main Panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		mainPanel.add(controlPanel, BorderLayout.WEST);
		mainPanel.add(drawPanel, BorderLayout.CENTER);
		getContentPane().add(mainPanel);
	}
	
	/**
	 * ActionListener method to coordinate text box (or button) input and the draw panel 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int width = drawPanel.getWidth();
		int height = drawPanel.getHeight();
		Random rand = new Random();

		//set numShapes to the total number of PaintableThings you want drawn
		numShapes = 5;
		shapes = new PaintableThing[numShapes];

		//set some limits to make elements show up within the screen
		int maxWidth = width/2;
		int maxHeight = height/2;
		//create objects that extend PaintableThings and add them to shapes
		shapes[0] = new Rectangle(rand.nextInt(maxWidth), rand.nextInt(maxHeight), rand.nextInt(maxWidth), rand.nextInt(maxHeight), 
				new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
		shapes[1] = new Square(rand.nextInt(maxWidth), rand.nextInt(maxHeight), rand.nextInt(maxWidth), 
				new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
		shapes[2] = new FilledRectangle(rand.nextInt(maxWidth), rand.nextInt(maxHeight), rand.nextInt(maxWidth), rand.nextInt(height), 
				new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)),
				new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
		shapes[3] = new RoundThing(rand.nextInt(maxWidth), rand.nextInt(maxHeight), rand.nextInt(maxWidth), rand.nextInt(maxHeight), 
				new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
		shapes[4] = new RoundFilledThing(rand.nextInt(maxWidth), rand.nextInt(maxHeight), rand.nextInt(maxWidth), rand.nextInt(height), 
				new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)),
				new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

		// now pass the collection of all PaintableThings to the drawPanel for display
		drawPanel.paintThings(shapes);
	}

	/**
	 * Creates an instance of this class and sets the size and
	 * visibility of its JFrame. An anonymous class is used to create an
	 * instance of the WindowListener class, which handles the window close
	 * events for the application.
	 */
	public static void main(String args[])
	{
		final PolyPainter f = new PolyPainter("PolyPainter");
		f.setSize(550, 450);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null); //centers frame on screen
		f.setVisible(true);
	}
}
