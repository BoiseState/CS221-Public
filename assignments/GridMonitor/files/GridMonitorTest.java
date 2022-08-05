import java.io.FileNotFoundException;

/**
 * Console app to test GridMonitor class
 * @author mvail
 */
public class GridMonitorTest {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;
	
	private static final double TOLERANCE = Math.pow(10, -14);

	/** @param args not used */
	public static void main(String[] args) {
		GridMonitorTest tester = new GridMonitorTest(); //to avoid every method being static
		tester.runTests();
	}
	
	/** Run tests on GridMonitor constructor and expected methods */
	private void runTests() {
		//////////////////////////////////////////////////////////////////
		// run tests on all interface methods to confirm correct results
		// and behavior under normal and exceptional use cases
		//////////////////////////////////////////////////////////////////
		printTest("gridMonitorInterfaceTest", gridMonitorInterfaceTest());

		//tests using a 3x3 sample grid
		printTest("loadSampleTest", loadSampleTest());
		printTest("getBaseGridSampleTest", getBaseGridSampleTest());
		printTest("getSurroundingSumGridSampleTest", getSurroundingSumGridSampleTest());
		printTest("getSurroundingAvgGridSampleTest", getSurroundingAvgGridSampleTest());
		printTest("getDeltaGridSampleTest", getDeltaGridSampleTest());
		printTest("getDangerGridSampleTest", getDangerGridSampleTest());
		printTest("lameToStringTest", lameToStringTest());

		//tests for a second valid grid that differs from
		// sample.txt by not having identical row and column dimensions
		printTest("load4x5Test", load4x5Test());
		printTest("getBaseGrid4x5Test", getBaseGrid4x5Test());
		printTest("getSurroundingSumGrid4x5Test", getSurroundingSumGrid4x5Test());
		printTest("getSurroundingAvgGrid4x5Test", getSurroundingAvgGrid4x5Test());
		printTest("getDeltaGrid4x5Test", getDeltaGrid4x5Test());
		printTest("getDangerGrid4x5Test", getDangerGrid4x5Test());
		printTest("lameToString4x5Test", lameToString4x5Test());
		
		//tests to confirm that parsing can handle a file with values
		// specified as doubles
		printTest("loadDoublesTest", loadDoublesTest());
		printTest("getBaseGridDoublesTest", getBaseGridDoublesTest());
		printTest("getSurroundingSumGridDoublesTest", getSurroundingSumGridDoublesTest());
		
		//negatives.txt (negative signal levels)
		printTest("loadNegativesTest", loadNegativesTest());
		printTest("getBaseGridNegativesTest", getBaseGridNegativesTest());
		printTest("getSurroundingSumGridNegativesTest", getSurroundingSumGridNegativesTest());
		printTest("getSurroundingAvgGridNegativesTest", getSurroundingAvgGridNegativesTest());
		printTest("getDeltaGridNegativesTest", getDeltaGridNegativesTest());
		printTest("getDangerGridNegativesTest", getDangerGridNegativesTest());
		
		//oneByOne.txt (1x1)
		printTest("load1x1Test", load1x1Test());
		printTest("getSurroundingSumGrid1x1Test", getSurroundingSumGrid1x1Test());
				
		//wideRange.txt (-1b to 1b)
		printTest("loadWideRangeTest", loadWideRangeTest());
		printTest("getBaseGridWideRangeTest", getBaseGridWideRangeTest());
		
		//test encapsulation from get___() methods
		printTest("getBaseEncapsulationTest", getBaseGridEncapsulationTest());
		printTest("getSurroundingSumGridEncapsulationTest", getSurroundingSumGridEncapsulationTest());
		printTest("getSurroundingAvgGridEncapsulationTest", getSurroundingAvgGridEncapsulationTest());
		printTest("getDangerGridEncapsulationTest", getDangerGridEncapsulationTest());
		
		//tests to confirm expected Exceptions
		printTest("noSuchFileTest", noSuchFileTest());
		
		/////////////////
		//final verdict
		/////////////////
		printFinalSummary();
	}
		
	/** Confirm that GridMonitor implements GridMonitorInterface */
	@SuppressWarnings("unused")
	private boolean gridMonitorInterfaceTest() {
		boolean success = true;
		
		try {
			GridMonitor grid = null;
			//if GridMonitor does not implement GridMonitorInterface, the following
			// invalid assignment will prevent the test class from even compiling
			GridMonitorInterface gridInterface = grid;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}
	
	/////////////////////////////
	// Tests using "sample.txt"
	/////////////////////////////

	/** Call GridMonitor constructor with "sample.txt" */
	@SuppressWarnings("unused")
	private boolean loadSampleTest() {
		final String testFile = "sample.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile); //should load without Exception
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare grid from getBaseGrid() to expected grid from "sample.txt" */
	private boolean getBaseGridSampleTest() {
		final double[][] expected = {
			{2, 10, 7},
			{4, 5, 8},
			{5, 6, 9}};
		final String testFile = "sample.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);

			if(!equivalent2DArrays(expected, grid.getBaseGrid())) {
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getSurroundingSumGrid() to expected grid for "sample.txt" */
	private boolean getSurroundingSumGridSampleTest() {
		final double[][] expected = {
				{18, 24, 32},
				{16, 28, 29},
				{20, 25, 32}};
		final String testFile = "sample.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);
			
			double[][] returned = grid.getSurroundingSumGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getSurroundingSumGridSampleTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getSurroundingAvgGrid() to expected grid for "sample.txt" */
	private boolean getSurroundingAvgGridSampleTest() {
		final double[][] expected = {
				{4.5, 6.0, 8.0},
				{4.0, 7.0, 7.25},
				{5.0, 6.25, 8.0}};
		final String testFile = "sample.txt";
		boolean success = true;
		
		try {
			GridMonitor grid = new GridMonitor(testFile);
			
			double[][] returned = grid.getSurroundingAvgGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getSurroundingAvgGridSampleTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getDeltaGrid() to expected grid for "sample.txt" */
	private boolean getDeltaGridSampleTest() {
		final double[][] expected = {
				{2.25, 3.0, 4.0},
				{2.0, 3.5, 3.625},
				{2.5, 3.125, 4.0}};
		final String testFile = "sample.txt";
		boolean success = true;
		
		try {
			GridMonitor grid = new GridMonitor(testFile);
			
			double[][] returned = grid.getDeltaGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getDeltaGridSampleTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getDangerGrid() to expected grid for "sample.txt" */
	private boolean getDangerGridSampleTest() {
		final boolean[][] expected = {
				{true, true, false},
				{false, false, false},
				{false, false, false}};
		final String testFile = "sample.txt";
		boolean success = true;
		
		try {
			GridMonitor grid = new GridMonitor(testFile);
			
			boolean[][] returned = grid.getDangerGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getDangerGridSampleTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Exercise toString() after loading "sample.txt" 
	 *    testing toString() is a little challenging because unit tests should
	 *    be automated such that no user evaluation is necessary to determine
	 *    if a test has succeeded or failed - need to compare toString() output
	 *    to expected output */
	private boolean lameToStringTest() {
		final String testFile = "sample.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);

			String str = grid.toString();
			System.out.printf("toString() output:\n%s\n", str);
			if(str.length() == 0 || str.startsWith("GridMonitor@")) {
				success = false;
			}
		} catch (Exception e) {
			System.out.println("lameToStringTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** check that a copy of base grid is being returned by getBaseGrid() */
	private boolean getBaseGridEncapsulationTest() {
		final double[][] expected = {
				{2, 10, 7},
				{4, 5, 8},
				{5, 6, 9}};
		final String testFile = "sample.txt";
		boolean success = true;

		try {			
			GridMonitor grid = new GridMonitor(testFile);
			double[][] bm = grid.getBaseGrid();
			bm[0][0] = 555;

			if(!equivalent2DArrays(expected, grid.getBaseGrid())) {
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}
	
	/** get sum grid, make a change via returned reference, confirm original is unchanged */
	private boolean getSurroundingSumGridEncapsulationTest() {
		final double[][] expected = {
				{18, 24, 32}, 
				{16, 28, 29}, 
				{20, 25, 32}};
		final String testFile = "sample.txt";
		boolean success = true;

		try {			
			GridMonitor grid = new GridMonitor(testFile);
			double[][] sem = grid.getSurroundingSumGrid();
			sem[0][0] = 555;

			double[][] returned = grid.getSurroundingSumGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getSurroundingSumGridEncapsulationTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}
	
	/** get avg grid, make a change via returned reference, confirm original is unchanged */
	private boolean getSurroundingAvgGridEncapsulationTest() {
		final double[][] expected = {
				{4.5, 6.0, 8.0},
				{4.0, 7.0, 7.25},
				{5.0, 6.25, 8.0}};
		final String testFile = "sample.txt";
		boolean success = true;

		try {			
			GridMonitor grid = new GridMonitor(testFile);
			double[][] sem = grid.getSurroundingAvgGrid();
			sem[0][0] = 555;

			double[][] returned = grid.getSurroundingAvgGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getSurroundingAvgGridEncapsulationTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}
	
	/** get danger grid, make a change via returned reference, confirm original is unchanged */
	private boolean getDangerGridEncapsulationTest() {
		final boolean[][] expected = {
				{true, true, false},
				{false, false, false},
				{false, false, false}};
		final String testFile = "sample.txt";
		boolean success = true;

		try {			
			GridMonitor grid = new GridMonitor(testFile);
			boolean[][] sem = grid.getDangerGrid();
			sem[0][0] = false;

			boolean[][] returned = grid.getDangerGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getDangerGridEncapsulationTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	///////////////////////////////////
	// tests using "sample4x5.txt"
	///////////////////////////////////
	
	/** Call GridMonitor constructor with "sample4x5.txt" */
	@SuppressWarnings("unused")
	private boolean load4x5Test() {
		final String testFile = "sample4x5.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile); //should load without Exception
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare grid from getBaseGrid() to expected grid from "sample4x5.txt" */
	private boolean getBaseGrid4x5Test() {
		final double[][] expected = {
			{1, 3, 7, 6, 5},
			{4, 10, 8, 7, 4},
			{5, 5, 7, 8, 7},
			{3, 6, 8, 9, 6}};
		final String testFile = "sample4x5.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);

			if(!equivalent2DArrays(expected, grid.getBaseGrid())) {
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getSurroundingSumGrid() to expected grid for "sample4x5.txt" */
	private boolean getSurroundingSumGrid4x5Test() {
		final double[][] expected = {
				{9, 21, 24, 25, 20},
				{20, 20, 31, 26, 23},
				{17, 28, 29, 30, 25},
				{17, 22, 30, 31, 28}}; 
		final String testFile = "sample4x5.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);
			
			double[][] returned = grid.getSurroundingSumGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getSurroundingSumGrid4x5Test: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getSurroundingAvgGrid() to expected grid for "sample4x5.txt" */
	private boolean getSurroundingAvgGrid4x5Test() {
		final double[][] expected = {
				{2.25, 5.25, 6.0, 6.25, 5.0},
				{5.0, 5.0, 7.75, 6.5, 5.75},
				{4.25, 7.0, 7.25, 7.5, 6.25},
				{4.25, 5.5, 7.5, 7.75, 7.0}}; 
		final String testFile = "sample4x5.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);
			
			double[][] returned = grid.getSurroundingAvgGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getSurroundingAvgGrid4x5Test: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getDeltaGrid() to expected grid for "sample4x5.txt" */
	private boolean getDeltaGrid4x5Test() {
		final double[][] expected = {
				{1.125, 2.625, 3.0, 3.125, 2.5},
				{2.5, 2.5, 3.875, 3.25, 2.875},
				{2.125, 3.5, 3.625, 3.75, 3.125},
				{2.125, 2.75, 3.75, 3.875, 3.5}}; 
		final String testFile = "sample4x5.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);
			
			double[][] returned = grid.getDeltaGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getDeltaGrid4x5Test: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getDangerGrid() to expected grid for "sample4x5.txt" */
	private boolean getDangerGrid4x5Test() {
		final boolean[][] expected = {
				{true, false, false, false, false},
				{false, true, false, false, false},
				{false, false, false, false, false},
				{false, false, false, false, false}}; 
		final String testFile = "sample4x5.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);
			
			boolean[][] returned = grid.getDangerGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getDangerGrid4x5Test: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Exercise toString() after loading "sample4x5.txt" */
	private boolean lameToString4x5Test() {
		final String testFile = "sample4x5.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);

			String str = grid.toString();
			System.out.printf("toString() output:\n%s\n", str);
			if(str.length() == 0 || str.startsWith("GridMonitor@")) {
				success = false;
			}
		} catch (Exception e) {
			System.out.println("lameToString4x5Test: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	///////////////////////////////////////
	// tests using "sampleDoubles.txt"
	///////////////////////////////////////
	
	/** Call GridMonitor constructor with "sampleDoubles.txt" */
	@SuppressWarnings("unused")
	private boolean loadDoublesTest() {
		final String testFile = "sampleDoubles.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile); //should load without Exception
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare grid from getBaseGrid() to expected grid from "sampleDoubles.txt" */
	private boolean getBaseGridDoublesTest() {
		final double[][] expected = {
				{2.5, 10.5, 7.5},
				{4.5, 5.5, 8.5},
				{5.5, 6.5, 9.5}};
		final String testFile = "sampleDoubles.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);

			if(!equivalent2DArrays(expected, grid.getBaseGrid())) {
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getSurroundingSumGrid() to expected grid for "sampleDoubles.txt" */
	private boolean getSurroundingSumGridDoublesTest() {
		final double[][] expected = {
			{20, 26, 34},
			{18, 30, 31},
			{22, 27, 34}};
		final String testFile = "sampleDoubles.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);
			
			double[][] returned = grid.getSurroundingSumGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getSurroundingSumGridDoublesTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}
	
	////////////////////////////////
	// tests using "negatives.txt"
	////////////////////////////////

	/** Call GridMonitor constructor with "negatives.txt" */
	@SuppressWarnings("unused")
	private boolean loadNegativesTest() {
		final String testFile = "negatives.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile); //should load without Exception
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare grid from getBaseGrid() to expected grid from "sampleNegatives.txt" */
	private boolean getBaseGridNegativesTest() {
		final double[][] expected = {
				{-5, -4, -5},
				{-2, -1, -2},
				{-1, -3, -1}};
		final String testFile = "negatives.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);

			if(!equivalent2DArrays(expected, grid.getBaseGrid())) {
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getSurroundingSumGrid() to expected grid for "negatives.txt" */
	private boolean getSurroundingSumGridNegativesTest() {
		final double[][] expected = {
			{-16, -15, -16}, 
			{-9, -11, -9}, 
			{-7, -6, -7}};
		final String testFile = "negatives.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);
			
			double[][] returned = grid.getSurroundingSumGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getSurroundingSumGridNegativesTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}
	
	/** Compare result from getSurroundingAvgGrid() to expected grid for "negatives.txt" */
	private boolean getSurroundingAvgGridNegativesTest() {
		final double[][] expected = {
			{-4.0, -3.75, -4.0}, 
			{-2.25, -2.75, -2.25}, 
			{-1.75, -1.5, -1.75}};
		final String testFile = "negatives.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);
			
			double[][] returned = grid.getSurroundingAvgGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getSurroundingAvgGridNegativesTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getDeltaGrid() to expected grid for "negatives.txt" */
	private boolean getDeltaGridNegativesTest() {
		final double[][] expected = {
			{2.0, 1.875, 2.0}, 
			{1.125, 1.375, 1.125}, 
			{0.875, 0.75, 0.875}};
		final String testFile = "negatives.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);
			
			double[][] returned = grid.getDeltaGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getDeltaGridNegativesTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getDangerGrid() to expected grid for "negatives.txt" */
	private boolean getDangerGridNegativesTest() {
		final boolean[][] expected = {
			{false, false, false}, 
			{false, true, false}, 
			{false, true, false}};
		final String testFile = "negatives.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);
			
			boolean[][] returned = grid.getDangerGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getDangerGridNegativesTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/////////////////////////////////
	// tests using "oneByOne.txt"
	/////////////////////////////////

	/** Call GridMonitor constructor with "oneByOne.txt" */
	@SuppressWarnings("unused")
	private boolean load1x1Test() {
		final String testFile = "oneByOne.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile); //should load without Exception
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getSurroundingMaxGrid() to expected grid for "oneByOne.txt" */
	private boolean getSurroundingSumGrid1x1Test() {
		final double[][] expected = {{20}};
		final String testFile = "oneByOne.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);
			
			double[][] returned = grid.getSurroundingSumGrid();
			if(!equivalent2DArrays(expected, returned)) {
				success = false;
				System.out.println("Expected :");
				print2DArray(expected);
				System.out.println("Returned :");
				print2DArray(returned);
			}
		} catch (Exception e) {
			System.out.println("getSurroundingSumGrid1x1Test: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	////////////////////////////////
	// tests using "wideRange.txt"
	////////////////////////////////
	
	/** Call GridMonitor constructor with "wideRange.txt" */
	@SuppressWarnings("unused")
	private boolean loadWideRangeTest() {
		final String testFile = "wideRange.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile); //should load without Exception
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare grid from getBaseGrid() to expected grid from "wideRange.txt" */
	private boolean getBaseGridWideRangeTest() {
		final double[][] expected = {
			{0, 0, 0},
			{-2000000000, 10, 2000000000},
			{0, 0, 0}};
		final String testFile = "wideRange.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);

			if(!equivalent2DArrays(expected, grid.getBaseGrid())) {
				success = false;
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

	/** Confirm that FileNotFoundException is thrown when GridMonitor constructor is called with "noSuch.txt" */
	@SuppressWarnings("unused")
	private boolean noSuchFileTest() {
		final String testFile = "noSuch.txt";
		boolean success = true;
		
		try {			
			GridMonitor grid = new GridMonitor(testFile);
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
	
	////////////////////////////////
	// utility methods for testing
	////////////////////////////////

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
	
	/** Compare two doubles and return true if they are within TOLERANCE, else false
	 * @param v1 first value to compare
	 * @param v2 second value to compare
	 * @return true if v1 and v2 are within TOLERANCE, else false
	 */
	private boolean isClose(double v1, double v2) {
		return (Math.abs(v1 - v2) < TOLERANCE);
	}

	/** Compare two two-dimensional double arrays for equivalence.
	 * @param a1 first double[][]
	 * @param a2 second double[][]
	 * @return true if all values in a1 and a2 are within the given tolerance, else false
	 */
	private boolean equivalent2DArrays(double[][] a1, double[][] a2) {
		boolean equivalent = true;
		if (a1.length != a2.length || (a1.length > 1 && a1[0].length != a2[0].length)) {
			equivalent = false;
		} else {
			for (int row = 0; row < a1.length; row++) {
				for (int col = 0; col < a1[0].length; col++) {
					if (row >= a2.length || a1[row].length != a2[row].length) {
						equivalent = false;
					} else {
						if (!isClose(a1[row][col], a2[row][col])) {
							equivalent = false;
						}
					}
				}
			}
		}
		return equivalent;
	}
	
	/** Compare two two-dimensional boolean arrays for equivalence.
	 * @param a1 first boolean[][]
	 * @param a2 second boolean[][]
	 * @return true if all values in a1 and a2 are identical, else false
	 */
	private boolean equivalent2DArrays(boolean[][] a1, boolean[][] a2) {
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
	
	/** Output a 2D double array in tabular format
	 * @param array 2D double array to print */
	private void print2DArray(double[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.printf("%14.3f ", array[row][col]);
			}
			System.out.println();
		}
	}

	/** Output a 2D boolean array in tabular format
	 * @param array 2D boolean array to print */
	private void print2DArray(boolean[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.printf("%-5b ", array[row][col]);
			}
			System.out.println();
		}
	}
}
