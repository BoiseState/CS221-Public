//********************************************************************
//  CreatingExceptions.java       Java Foundations
//
//  Demonstrates the ability to define an exception via inheritance.
//********************************************************************

import java.util.Scanner;

/**
 * A class to demonstrate throwing Exceptions
 * 
 * @author JF3
 */
public class CreatingExceptions
{
   //-----------------------------------------------------------------
   //  Creates an exception object and possibly throws it.
   //-----------------------------------------------------------------
	
   /**
    * Causes an exception
    * @param args unused
    * @throws OutOfRangeException
    */
	public static void main (String[] args) throws OutOfRangeException
   {
      final int MIN = 25, MAX = 40;

      Scanner scan = new Scanner (System.in);

      System.out.print ("Enter an integer value between " + MIN +
                        " and " + MAX + ", inclusive: ");
      
      int value = scan.nextInt();
      
      scan.close();

      //  Determine if the exception should be thrown
      if (value < MIN || value > MAX)
         throw new OutOfRangeException ("Input value is out of range.");

      System.out.println ("End of main method.");  // may never reach
   }
}
