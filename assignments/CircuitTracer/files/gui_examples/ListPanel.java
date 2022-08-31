//********************************************************************
//  ListPanel.java       Authors: Lewis/Loftus
//
//  Represents the list of words for the PickImage program.
//********************************************************************

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListPanel extends JPanel
{
   private JLabel label;
   private JList list;

   //-----------------------------------------------------------------
   //  Loads the list of word names into the list.
   //-----------------------------------------------------------------
   public ListPanel (JLabel wordLabel)
   {
      label = wordLabel;

      String[] words = { "array",
			"binary search tree",
		       	"binary tree", 
			"heap",
			"linked list",
			"priority queue",
			"recursion",
			"stack" };

      list = new JList (words);
      list.addListSelectionListener (new ListListener());
      list.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);

      add (list);
      setBackground (Color.white);
   }

   //*****************************************************************
   //  Represents the listener for the list of words.
   //*****************************************************************
   private class ListListener implements ListSelectionListener
   {
      public void valueChanged (ListSelectionEvent event)
      {
         if (list.isSelectionEmpty())
            label.setIcon (null);
         else
         {
            String word = (String)list.getSelectedValue();
            label.setText (word);
         }
      }
   }
}
