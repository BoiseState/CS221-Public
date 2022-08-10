//********************************************************************
//  PickWord.java       Authors: Lewis/Loftus
//
//  Demonstrates the use a split pane and a list.
//********************************************************************

import java.awt.*;
import javax.swing.*;

public class PickWord
{
   //-----------------------------------------------------------------
   //  Creates and displays a frame containing a split pane. The
   //  user selects an word name from the list to be displayed.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Pick Image");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      JLabel wordLabel = new JLabel();
      wordLabel.setFont( new Font( "sanserif", Font.BOLD, 144));
      JPanel wordPanel = new JPanel();
      /*wordPanel.setPreferredSize( new Dimension( 100,100));*/
      /*wordPanel.add ( new JScrollPane( wordLabel));*/
      wordPanel.add ( wordLabel);
      wordPanel.setBackground (Color.white);

      ListPanel wordList = new ListPanel ( wordLabel);

      JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                     wordList, new JScrollPane( wordPanel));

      sp.setOneTouchExpandable (true);

      frame.getContentPane().add (sp);
      frame.pack();
      frame.setVisible(true);
   }
}
