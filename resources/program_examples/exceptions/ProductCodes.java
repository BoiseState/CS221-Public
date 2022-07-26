//********************************************************************
//  ProductCodes.java       Java Foundations
//
//  Demonstrates the use of a try-catch block.
//********************************************************************

import java.util.Scanner;

public class ProductCodes
{
   //-----------------------------------------------------------------
   //  Counts the number of product codes that are entered with a
   //  zone of R and and district greater than 2000.
   // 10-char Code Format: XXXDDDDXXZ where DDDD must be numeric and Z is a zone char
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      String code;
      char zone;
      int district, valid = 0, banned = 0;

      Scanner scan = new Scanner (System.in);

      System.out.print ("Enter product code (STOP to quit): ");
      code = scan.nextLine();

      while (!code.equals ("STOP"))
      {
         try
         {
//        	 int[] array = new int[1];
//        	 System.out.println(array[2]);
        	 
            zone = code.charAt(9);
            district = Integer.parseInt(code.substring(3, 7));
            valid++;
            if (zone == 'R' && district > 2000)
               banned++;
         }
//         catch (Exception e) {
//        	 e.printStackTrace();
//         }
         catch (StringIndexOutOfBoundsException exception)
         {
          	System.out.println(exception.getMessage());
            System.out.println ("Improper code length: " + code);
         }
         catch (NumberFormatException exception)
         {
        	 System.out.println(exception.getMessage());
            System.out.println ("District is not numeric: " + code);
         }
//         catch (Exception e)
//         {
//			e.printStackTrace();
//		 }
//         finally {
//        	 System.out.println("Look at me!");
//         }

         System.out.print ("Enter product code (STOP to quit): ");
         code = scan.nextLine();
      }

      System.out.println ("# of valid codes entered: " + valid);
      System.out.println ("# of banned codes entered: " + banned);
   }
}
