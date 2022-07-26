//********************************************************************
//  Zero.java       Java Foundations
//
//  Demonstrates an uncaught exception.
//********************************************************************

public class Zero
{
   //-----------------------------------------------------------------
   //  Deliberately divides by zero to produce an exception.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {

      System.out.println ("Before the attempt to divide by zero.");
      
      doIt();

      System.out.println ("This text will not be printed.");
   }
   
   private static void doIt() {
			noYouDoIt();
			
//			   try {
//					noYouDoIt();
//			   } catch (ArithmeticException ae) {
//				   System.err.println("Guess I should have done it..");
//			   }
   }
   
   private static void noYouDoIt() {
	   iSaidDoIt();
   }
   
   private static void iSaidDoIt() {
	   youAskedForIt();
   }
   
   private static void youAskedForIt() {
	      int numerator = 10;
	      int denominator = 0;
	      System.out.println (numerator / denominator);	   
   }
}
