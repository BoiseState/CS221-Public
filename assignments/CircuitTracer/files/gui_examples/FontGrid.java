import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/** FontGrid generates a simple frame that shows how components
*   are arranged using Grid Layout.
*   @author Koffman & Wolfgang with modifications by Teresa Cole
* */

public class FontGrid
    extends JFrame {

    private static Font[] fonts = { new Font( "sanserif", Font.PLAIN, 12), 
	new Font( "sanserif", Font.PLAIN, 18), 
	new Font( "sanserif", Font.PLAIN, 24), 
	new Font( "sanserif", Font.PLAIN, 36), 
	new Font( "sanserif", Font.PLAIN, 72)}; 
    private static Color [] colors = { Color.black, Color.blue, Color.red, 
	new Color( 0, 102, 0), new Color(255, 102, 0)};

  // Main Method
  public static void main(String args[]) {
    // Construct a FontGrid object.
    JFrame frame = new FontGrid();
    // Display the frame.
    frame.show();
  }

  // Constructor
  public FontGrid() {
    setTitle("FontGrid");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Create a JPanel to hold a grid.
    JPanel thePanel = new JPanel();
    thePanel.setLayout(new GridLayout(5, 5));
    Border blackBorder =
        BorderFactory.createLineBorder(Color.BLACK);
    // Create some labels and add them to the panel.
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        JLabel aLabel = new JLabel
            (Integer.toString(i) + ", "
             + Integer.toString(j),
             JLabel.CENTER);
	aLabel.setFont( fonts[i]);
	aLabel.setForeground( colors[j]);
        aLabel.setBorder(blackBorder);
        thePanel.add(aLabel);
      }
    }
    setContentPane(thePanel);
    pack();
  }
}
