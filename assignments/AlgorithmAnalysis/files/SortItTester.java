import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Report statement counts for calls to sortIt().
 * SortItTester initializes an array of integers of size n configured according 
 * to input parameters. The required second argument indicates how the input 
 * array will be generated: (a)scending, (d)escending, (r)andom, or 
 * (m)ultiples/duplicates. If (m)ultiples/duplicates is the choice, a third 
 * argument indicating the number of duplicates must be provided as well. Note 
 * that the reported result for any numDuplicates less than n is subject to 
 * vagaries of random distribution. Also note that number of statements to sort
 * a randomized array is always subject to vagaries of random distribution.
 * SortItTester usage:
 *    $ java SortItTester [array size n] [a | d | r | m numDuplicates]
 *    where a → ascending order, d → descending order, r → random order, 
 *    and m → multiples/duplicates, requiring a third argument for the number of 
 *    duplicates up to a maximum of n.
 *     
 * @author mvail
 */
public class SortItTester {

	/** Report number of statements executed in calls to sortIt(). */
	public static void main(String[] args) {
		if (args.length < 2 || args.length > 3) {
			System.out.println("Usage: java SortItTester [array size n] [a | d | r | m numDuplicates]");
			System.out.println("where a → ascending order, d → descending order, r → random order,");
			System.out.println("and m → multiples/duplicates, requiring a third argument for the number of");
			System.out.println("duplicates up to a maximum of n.");
			System.exit(1);
		}
		int n = Integer.parseInt(args[0]);
		if (n < 0) {
			System.out.println("Usage: java SortItTester [array size n] [a | d | r | m numDuplicates]");
			System.out.println("Array size n must be an integer 0 or greater.");
			System.exit(1);			
		}
		if (args[1].equalsIgnoreCase("m") && args.length == 2) {
			System.out.println("Usage: java SortItTester [array size n] [a | d | r | m numDuplicates]");
			System.out.println("Option 'm' must be followed by an integer between 1 and n.");
			System.exit(1);
		}
		
		int[] array = new int[0];
		switch (args[1]) {
		case "a":
			array = ArrayOfInts.ascendingArray(n);
			break;
		case "d":
			array = ArrayOfInts.descendingArray(n);
			break;
		case "r":
			array = ArrayOfInts.randomizedArray(n);
			break;
		case "m":
			int numDuplicates = Integer.parseInt(args[2]);
			array = ArrayOfInts.randomizedArrayWithDuplicates(n, numDuplicates);
			break;
		default:
			System.out.println("Usage: java SortItTester [array size n] [a | d | r | m numDuplicates]");
			System.out.println("where a → ascending order, d → descending order, r → random order,");
			System.out.println("and m → multiples/duplicates, requiring a third argument for the number of");
			System.out.println("duplicates up to a maximum of n.");
			System.exit(1);
		}
		
		MethodsToAnalyze_Data.resetStatements();
		MethodsToAnalyze_Data.sortIt(array);
		long statements = MethodsToAnalyze_Data.getStatements();
		System.out.println("Statements to sort array of size " + n + ": " + statements);
	}
}
