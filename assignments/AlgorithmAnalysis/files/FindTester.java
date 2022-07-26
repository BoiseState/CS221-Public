import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Report statement counts for calls to find().
 * FindTester initializes an array of integers in ascending order from 1 to n 
 * inclusive. If a target value is provided, FindTester reports the number of 
 * statements executed before a result is returned. If no target value is 
 * provided, FindTester reports the average number of statements to find all 
 * values in the array. FindTester usage:
 *	$ java FindTester [array size n] <optional target value>
 *
 * @author mvail
 */
public class FindTester {

	/** Report number of statements executed in calls to find(). */
	public static void main(String[] args) {
		if (args.length < 1 || args.length > 2) {
			System.out.println("Usage: java FindTester [array size n] <target value>");
			System.out.println("If no target value is given, the average cost to find a value is returned.");
			System.exit(1);
		}
		int n = Integer.parseInt(args[0]);
		if (n < 0) {
			System.out.println("Usage: java FindTester [array size n] <target value>");
			System.out.println("Array size n must be an integer 0 or greater.");
			System.exit(1);			
		}
		if (args.length == 1 && n == 0) {
			System.out.println("Usage: java FindTester [array size n] <target value>");
			System.out.println("Array size n must be an integer 1 or greater if target value is omitted.");
			System.exit(1);						
		}
		
		int[] array = ArrayOfInts.ascendingArray(n);
		MethodsToAnalyze_Data.resetStatements();
		if (args.length == 2) { //find target value in array
			int targetValue = Integer.parseInt(args[1]);		
			int index = MethodsToAnalyze_Data.find(array, targetValue);
			long statements = MethodsToAnalyze_Data.getStatements();
			System.out.println("Find returned index " + index + " for target value " + targetValue
					+ " in array of size " + n + " after " + statements + " statements.");
		} else { //return average 
			// find the index of every element
			for (int i = 1; i <= array.length; i++) {
				// this is the method of interest, but you'll need to average
				// the number of statements needed to find each element for
				// meaningful results
				int index = MethodsToAnalyze_Data.find(array, i);
//				System.out.printf("%d found at index %d\n", i, index);
			}
			long sum = MethodsToAnalyze_Data.getStatements();
			System.out.println("Average statements to find a value in array of size " + n
					+ " is " + (sum / array.length) + ".");
		}
	}
}
