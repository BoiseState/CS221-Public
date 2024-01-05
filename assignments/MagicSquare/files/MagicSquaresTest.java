import java.io.FileNotFoundException;

/**
 * Console app to test MagicSquare class
 * @author mvail
 */
public class MagicSquaresTest {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;
	
	private final String newFile = "newFile";

	private final String valid3x3 = "valid3x3";
	private final int[][] valid3x3grid = {
			{4, 9, 2},
			{3, 5, 7},
			{8, 1, 6}};
	private final String valid4x4 = "valid4x4";
	private final int[][] valid4x4grid = {
			{16, 3, 2, 13},
			{5, 10, 11, 8},
			{9, 6, 7, 12},
			{4, 15, 14, 1}};
	private final String valid5x5 = "valid5x5";
	private final int[][] valid5x5grid = {
			{11, 18, 25, 2, 9},
			{10, 12, 19, 21, 3},
			{4, 6, 13, 20, 22},
			{23, 5, 7, 14, 16},
			{17, 24, 1, 8, 15}};
	private final String valid6x6 = "valid6x6";
	private final int[][] valid6x6grid = {
			{1, 35, 34, 3, 32, 6},
			{30, 8, 28, 27, 11, 7},
			{24, 23, 15, 16, 14, 19},
			{13, 17, 21, 22, 20, 18},
			{12, 26, 9, 10, 29, 25},
			{31, 2, 4, 33, 5, 36}};
	private final String invalid3x3a = "invalid3x3a";
	private final int[][] invalid3x3agrid = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}};
	private final String invalid3x3b = "invalid3x3b";
	private final int[][] invalid3x3bgrid = {
			{5, 5, 5},
			{5, 5, 5},
			{5, 5, 5}};
	private final String invalid4x4 = "invalid4x4";
	private final int[][] invalid4x4grid = {
			{16, 12, 8, 4},
			{15, 11, 7, 3},
			{14, 10, 6, 2},
			{13, 9, 5, 1}};
	private final String invalid6x6 = "invalid6x6";
	private final int[][] invalid6x6grid = {
			{25, 26, 27, 28, 29, 30},
			{1, 2, 3, 4, 5, 6},
			{13, 14, 15, 16, 17, 18},
			{31, 32, 33, 34, 35, 36},
			{7, 8, 9, 10, 11, 12},
			{19, 20, 21, 22, 23, 24}};

	/** @param args not used */
	public static void main(String[] args) {
		MagicSquaresTest tester = new MagicSquaresTest();
		tester.runTests();
	}
	
	/** Run tests on MagicSquare constructor and expected methods */
	private void runTests() {
		//////////////////////////////////////////////////////////////////
		// run tests on all interface methods to confirm correct results
		// and behavior under normal and exceptional use cases
		//////////////////////////////////////////////////////////////////
		
		// XXX tests checking well-formatted files
		
		//tests using valid3x3 file
		printTest("constructorTest_valid3x3", constructorTest(valid3x3));
		printTest("getMatrixTest_valid3x3", getMatrixTest(valid3x3, valid3x3grid));
		printTest("isMagicSquareTest_valid3x3", isMagicSquareTest(valid3x3, true));
		printTest("toStringTest", toStringTest(valid3x3, 3));

		//tests using valid4x4 file
		printTest("constructorTest_valid4x4", constructorTest(valid4x4));
		printTest("getMatrixTest_valid4x4", getMatrixTest(valid4x4, valid4x4grid));
		printTest("isMagicSquareTest_valid4x4", isMagicSquareTest(valid4x4, true));
		printTest("toStringTest", toStringTest(valid4x4, 4));
		
		//tests using valid5x5 file
		printTest("constructorTest_valid5x5", constructorTest(valid5x5));
		printTest("getMatrixTest_valid5x5", getMatrixTest(valid5x5, valid5x5grid));
		printTest("isMagicSquareTest_valid5x5", isMagicSquareTest(valid5x5, true));
		printTest("toStringTest", toStringTest(valid5x5, 5));
		
		//tests using valid6x6 file
		printTest("constructorTest_valid6x6", constructorTest(valid6x6));
		printTest("getMatrixTest_valid6x6", getMatrixTest(valid6x6, valid6x6grid));
		printTest("isMagicSquareTest_valid6x6", isMagicSquareTest(valid6x6, true));
		printTest("toStringTest", toStringTest(valid6x6, 6));
		
		//tests using invalid3x3a file
		printTest("constructorTest_invalid3x3a", constructorTest(invalid3x3a));
		printTest("getMatrixTest_invalid3x3a", getMatrixTest(invalid3x3a, invalid3x3agrid));
		printTest("isMagicSquareTest_invalid3x3a", isMagicSquareTest(invalid3x3a, false));
		printTest("toStringTest", toStringTest(invalid3x3a, 3));

		//tests using invalid3x3b file
		printTest("constructorTest_invalid3x3b", constructorTest(invalid3x3b));
		printTest("getMatrixTest_invalid3x3b", getMatrixTest(invalid3x3b, invalid3x3bgrid));
		printTest("isMagicSquareTest_invalid3x3b", isMagicSquareTest(invalid3x3b, false));
		printTest("toStringTest", toStringTest(invalid3x3b, 3));

		//tests using invalid4x4 file
		printTest("constructorTest_invalid4x4", constructorTest(invalid4x4));
		printTest("getMatrixTest_invalid4x4", getMatrixTest(invalid4x4, invalid4x4grid));
		printTest("isMagicSquareTest_invalid4x4", isMagicSquareTest(invalid4x4, false));
		printTest("toStringTest", toStringTest(invalid4x4, 3));
		
		//tests using invalid6x6 file
		printTest("constructorTest_invalid6x6", constructorTest(invalid6x6));
		printTest("getMatrixTest_invalid6x6", getMatrixTest(invalid6x6, invalid6x6grid));
		printTest("isMagicSquareTest_invalid6x6", isMagicSquareTest(invalid6x6, false));
		printTest("toStringTest", toStringTest(invalid6x6, 6));
		
		//test encapsulation from getMatrix() method
		printTest("getMatrixEncapsulationTest", getMatrixEncapsulationTest(valid3x3, valid3x3grid));
		printTest("getMatrixEncapsulationTest", getMatrixEncapsulationTest(invalid3x3a, invalid3x3agrid));
		
		//test to confirm expected FileNotFoundException for invalid file
		printTest("noSuchFileTest", noSuchFileTest());
		
		// XXX tests for creating a new file
		
		printTest("constructorTest_new3x3", constructorTest(newFile, 3));
		printTest("getMatrixTest_new3x3", getMatrixTest(newFile, 3, valid3x3grid));
		printTest("isMagicSquareTest_new3x3", isMagicSquareTest(newFile, 3, true));
		printTest("toStringTest", toStringTest(newFile, 3, 3));
		printTest("validOutputFormatTest", validOutputFormatTest(newFile, 3, valid3x3grid));
		
		//printTest("constructorTest_new4x4", constructorTest(newFile, 4)); //ArrayIndexOutOfBoundsException
		
		printTest("constructorTest_new5x5", constructorTest(newFile, 5));
		printTest("getMatrixTest_new5x5", getMatrixTest(newFile, 5, valid5x5grid));
		printTest("isMagicSquareTest_new5x5", isMagicSquareTest(newFile, 5, true));
		printTest("toStringTest", toStringTest(newFile, 5, 5));
		printTest("validOutputFormatTest", validOutputFormatTest(newFile, 5, valid5x5grid));
		
		/////////////////
		//final verdict
		/////////////////
		printFinalSummary();
	}
		
	///////////////////////////////
	// XXX Method Tests
	///////////////////////////////

	/** Check for no exceptions when loading a well-formatted input file */
	private boolean constructorTest(String testFile) {
		boolean success = true;		
		try {			
			@SuppressWarnings("unused")
			MagicSquareInterface ms = new MagicSquare(testFile); //should load without Exception
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Check for no exceptions when creating a new matrix */
	private boolean constructorTest(String testFile, int size) {
		boolean success = true;
		try {			
			@SuppressWarnings("unused")
			MagicSquareInterface ms = new MagicSquare(testFile, size); //should run without Exception
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare grid from getMatrix() to expected grid */
	private boolean getMatrixTest(String testFile, int[][] expected) {
		boolean success = true;
		try {			
			MagicSquareInterface ms = new MagicSquare(testFile);
			int[][] returned = ms.getMatrix();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare grid from generated MagicSquare's getMatrix() to expected grid */
	private boolean getMatrixTest(String testFile, int size, int[][] expected) {
		boolean success = true;
		try {			
			MagicSquareInterface ms = new MagicSquare(testFile, size);
			int[][] returned = ms.getMatrix();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from isMagicSquareTest() to expected result */
	private boolean isMagicSquareTest(String testFile, boolean expected) {
		boolean success = true;
		try {			
			MagicSquareInterface ms = new MagicSquare(testFile);
			boolean returned = ms.isMagicSquare();
			if(expected != returned) {
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from generated MagicSquare's isMagicSquareTest() to expected result */
	private boolean isMagicSquareTest(String testFile, int size, boolean expected) {
		boolean success = true;
		try {
			MagicSquareInterface ms = new MagicSquare(testFile, size);
			
			boolean returned = ms.isMagicSquare();
			if(expected != returned) {
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Exercise toString() after loading testFile
	 *    testing toString() is a little challenging because unit tests should
	 *    be automated such that no user evaluation is necessary to determine
	 *    if a test has succeeded or failed - need to compare toString() output
	 *    to expected output */
	private boolean toStringTest(String testFile, int rows) {
		boolean success = true;		
		try {
			MagicSquareInterface ms = new MagicSquare(testFile);
			String str = ms.toString();
			System.out.printf("toString() output:\n%s\n", str);
			if(str.length() < rows*rows || str.startsWith("MagicSquare@")) {
				success = false;
			}
			String[] outRows = str.split("\n");
			if (outRows.length < rows+2) {
				success = false;
			}
		} catch (Exception e) {
			System.out.println("toStringTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Exercise toString() after loading testFile
	 *    testing toString() is a little challenging because unit tests should
	 *    be automated such that no user evaluation is necessary to determine
	 *    if a test has succeeded or failed - need to compare toString() output
	 *    to expected output */
	private boolean toStringTest(String testFile, int size, int rows) {
		boolean success = true;
		try {
			MagicSquareInterface ms = new MagicSquare(testFile, size);
			String str = ms.toString();
			System.out.printf("toString() output:\n%s\n", str);
			if(str.length() < rows*rows || str.startsWith("MagicSquare@")) {
				success = false;
			}
			String[] outRows = str.split("\n");
			if (outRows.length < rows+2) {
				success = false;
			}
		} catch (Exception e) {
			System.out.println("toStringTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** check that a copy of instance variable matrix is being returned by getMatrix() */
	private boolean getMatrixEncapsulationTest(String testFile, int[][] expected) {
		boolean success = true;
		try {			
			MagicSquareInterface ms = new MagicSquare(testFile);
			int[][] returned = ms.getMatrix();
			returned[0][0] = 555; //make a change to referenced matrix

			if(!equivalent2DArrays(expected, ms.getMatrix())) { //confirm no change to instance data
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}
	
	/** check that the file written when generating a new MagicSquare can be read and contains expected values */
	private boolean validOutputFormatTest(String testFile, int size, int[][] expected) {
		boolean success = true;
		try {			
			new MagicSquare(testFile, size); //generate a new MagicSquare (and write to file)
			MagicSquareInterface ms = new MagicSquare(testFile); //try opening the newly-written file
			int[][] returned = ms.getMatrix();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;	
	}
	
	/////////////////////////////////////
	// tests using invalid input files
	/////////////////////////////////////

	/** Confirm that FileNotFoundException is thrown when MagicSquare constructor is called with "noSuch.txt" */
	@SuppressWarnings("unused")
	private boolean noSuchFileTest() {
		final String testFile = "noSuch.txt";
		boolean success = true;
		try {			
			MagicSquareInterface ms = new MagicSquare(testFile);
			System.out.println("noSuchFileTest: FileNotFoundException expected");
			success = false;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {	//We expect a specific exception
			System.out.println("noSuchFileTest: FileNotFoundException expected");
			e.printStackTrace(System.out);
			success = false;
		}
		System.out.println();
		return success;
	}
	
	////////////////////////////////////
	// XXX utility methods for testing
	////////////////////////////////////

	/** Print test results in a consistent format
	 * @param testDesc description of the test
	 * @param result indicates if the test passed or failed
	 */
	private void printTest(String testDesc, boolean result) {
		total++;
		if (result) {
			passes++;
		} else {
			failures++;
		}
		System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
	}

	/** Print a final summary */
	private void printFinalSummary() {
		System.out.printf("\nTotal Tests: %d,  Passed: %d,  Failed: %d\n", total, passes, failures);
	}
	
	/** Compare two two-dimensional int arrays for equivalence.
	 * @param a1 first int[][]
	 * @param a2 second int[][]
	 * @return true if all values in a1 and a2 are equal, else false
	 */
	private boolean equivalent2DArrays(int[][] a1, int[][] a2) {
		boolean equivalent = true;
		if (a1.length != a2.length || (a1.length > 1 && a1[0].length != a2[0].length)) {
			equivalent = false;
		} else {
			for (int row = 0; row < a1.length; row++) {
				for (int col = 0; col < a1[0].length; col++) {
					if (row >= a2.length || a1[row].length != a2[row].length) {
						equivalent = false;
					} else {
						if (a1[row][col] != a2[row][col]) {
							equivalent = false;
						}
					}
				}
			}
		}
		return equivalent;
	}
	
	/** Output a 2D int array in tabular format
	 * @param array 2D int array to print */
	private void print2DArray(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.printf("%14d ", array[row][col]);
			}
			System.out.println();
		}
	}
}
