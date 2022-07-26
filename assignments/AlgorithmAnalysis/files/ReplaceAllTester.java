import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Report statement counts for calls to replaceAll().
 * ReplaceAllTester initializes an array of integers of size n configured 
 * according to input parameters. If an oldValue argument is provided, 
 * ReplaceAllTester reports the number of statements executed to replace that 
 * value in an array where all elements are in ascending order from 1 to n 
 * inclusive. If no oldValue is provided, ReplaceAllTester reports the average 
 * number of statements to replace a randomly-located element within the array. 
 * If the optional third numDuplicates argument is provided, that number of 
 * duplicate 1s will be randomly distributed in the array and the expectation is 
 * that oldValue will be 1, such that the number of statements to replace all 
 * duplicate values will be reported. Note that the reported result for any 
 * numDuplicates less than n is subject to vagaries of random distribution. 
 * ReplaceAllTester usage:
 *	$ java ReplaceAllTester [array size n] <oldValue> <numDuplicates>
 * 
 * @author mvail
 */
public class ReplaceAllTester {

	/** Report number of statements executed in calls to replaceAll(). */
	public static void main(String[] args) {
		if (args.length < 1 || args.length > 3) {
			System.out.println("Usage: java ReplaceAllTester [array size n] <oldValue> <numDuplicates>");
			System.out.println("If no oldValue is given, the average cost to find a value is returned.");
			System.out.println("If 3rd argument numDuplicates is given (up to n), you can expect that many 1s randomly distributed in the array and oldValue should also be 1.");
			System.exit(1);
		}
		int n = Integer.parseInt(args[0]);
		if (n < 0) {
			System.out.println("Usage: java ReplaceAllTester [array size n] <oldValue> <numDuplicates>");
			System.out.println("Array size n must be an integer 0 or greater.");
			System.exit(1);			
		}
		
		int[] array;
		if (args.length == 3) {
			array = ArrayOfInts.randomizedArrayWithDuplicates(n, Integer.parseInt(args[2]));
		} else {
			array = ArrayOfInts.ascendingArray(n);
		}
		
		MethodsToAnalyze_Data.resetStatements();
		if (args.length == 1) { //replace center value in array, representing average cost
			int oldValue = n / 2;		
			MethodsToAnalyze_Data.replaceAll(array, oldValue, -1);
			long statements = MethodsToAnalyze_Data.getStatements();
			System.out.println("Average cost to replace a value in array of size " +
					n + " is " + statements + " statements.");
		} else { //replaceAll oldValues
			int oldValue = Integer.parseInt(args[1]);
			MethodsToAnalyze_Data.replaceAll(array, oldValue, -1);
			long statements = MethodsToAnalyze_Data.getStatements();
			System.out.println("Statements to replace oldValue " + oldValue + 
					" in array of size " + n + ": " + statements);
		}
	}
}
