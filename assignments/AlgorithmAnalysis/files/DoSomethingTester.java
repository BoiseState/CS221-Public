import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Report statement counts for calls to doSomething().
 * DoSomethingTester initializes an array of integers of size n configured
 * according to input parameters. The required second argument indicates how the 
 * input array will be generated: (a)scending, (d)escending, (r)andom, or 
 * (m)ultiples/duplicates. If (m)ultiples/duplicates is the choice, a third 
 * argument indicating the number of duplicates must be provided as well. Note 
 * that the reported result for any numDuplicates less than n is subject to 
 * vagaries of random distribution. Also note that number of statements to sort
 * a randomized array is always subject to vagaries of random distribution.
 * DoSomethingTester usage:
 *    $ java DoSomethingTester [array size n] [a | d | r | m numDuplicates]
 *    where a → ascending order, d → descending order, r → random order, 
 *    and m → multiples/duplicates, requiring a third argument for the number of 
 *    duplicates up to a maximum of n.
 *
 * @author mvail
 */
public class DoSomethingTester {
	
	/** Report number of statements executed in calls to doSomething(). */
	public static void main(String[] args) {	
		if (args.length < 2 || args.length > 3) {
			System.out.println("Usage: java DoSomethingTester [array size n] [a | d | r | m numDuplicates]");
			System.out.println("where a → ascending order, d → descending order, r → random order,");
			System.out.println("and m → multiples/duplicates, requiring a third argument for the number of");
			System.out.println("duplicates up to a maximum of n.");
			System.exit(1);
		}
		int n = Integer.parseInt(args[0]);
		if (n < 0) {
			System.out.println("Usage: java DoSomethingTester [array size n] [a | d | r | m numDuplicates]");
			System.out.println("Array size n must be an integer 0 or greater.");
			System.exit(1);			
		}
		if (args[1].equalsIgnoreCase("m") && args.length == 2) {
			System.out.println("Usage: java DoSomethingTester [array size n] [a | d | r | m numDuplicates]");
			System.out.println("Option 'm' must be followed by an integer between 1 and n.");
			System.exit(1);
		}
		
		String arrayType = "";
		int[] array = new int[0];
		switch (args[1]) {
		case "a":
			array = ArrayOfInts.ascendingArray(n);
			arrayType = "ascending";
			break;
		case "d":
			array = ArrayOfInts.descendingArray(n);
			arrayType = "descending";
			break;
		case "r":
			array = ArrayOfInts.randomizedArray(n);
			arrayType = "randomized";
			break;
		case "m":
			int numDuplicates = Integer.parseInt(args[2]);
			array = ArrayOfInts.randomizedArrayWithDuplicates(n, numDuplicates);
			arrayType = "duplicates";
			break;
		default:
			System.out.println("Usage: java DoSomethingTester [array size n] [a | d | r | m numDuplicates]");
			System.out.println("where a → ascending order, d → descending order, r → random order,");
			System.out.println("and m → multiples/duplicates, requiring a third argument for the number of");
			System.out.println("duplicates up to a maximum of n.");
			System.exit(1);
		}
		
		DoSomething.doSomething(array);
		long statements = DoSomething.getStatements();
		System.out.println("Statements with " + arrayType + " array of size " 
				+ n + ": " + statements);
		
		
		/*
		 * The following code is an example of how you could create a CSV output
		 * file for calls using increasing array sizes, which can be very
		 * interesting.
		 */
//		//call modified doSomething() with different array sizes and write results to
//		// "doSomething.csv" with a PrintStream
//		PrintStream outfile = new PrintStream("doSomething.csv");
//		outfile.println("size, statements");
//		for (int size = 1; size < 101; size += 1) {
//			int[] array = ArrayOfInts.randomizedArray(size);
//			DoSomething.doSomething(array); //this is the call we want to measure
//			long statements = DoSomething.getStatements();
//			outfile.println(size + ", " + statements);
//
//			//summary
//			System.out.printf("\nfor n = %d, took %d statements\n",
//					size, statements);
//
//			//show "sorted" array
////			for (int i = 0; i < array.length; i++) {
////				System.out.print(array[i] + " ");
////			}
////			System.out.println();
//		}
//		outfile.close();
	}
}