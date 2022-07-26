/**
 * Takes an array and reorders it (incorrectly) in an attempt to put elements in ascending order.
 * @author mvail
 */
public class DoSomething {
	//NEW VARIABLE ADDED FOR DATA COLLECTION
	private static long numStatements;

	/**
	 * Fails to take an int[] and get it into ascending order.
	 * @param array ints that need to be ordered 
	 */
	public static void doSomething(int[] array) {
		//ADDED FOR DATA COLLECTION
		numStatements = 2; //for loop init and 1st condition check
		
		for (int i = 0; i < array.length; i++) {
			//ADDED FOR DATA COLLECTION
			numStatements += 3; //left and right initializations, plus 1st while condition check

			int left = 0;
			int right = array.length - 1;

			//reorder the array so elements at mirrored indexes are in order
			while (left < right) {

				//ADDED FOR DATA COLLECTION
				numStatements += 4; //condition check, 2 increments, checking while condition again

				if (array[left] > array[right]) {
					int temp = array[left];
					array[left] = array[right];
					array[right] = temp;

					//ADDED FOR DATA COLLECTION
					numStatements += 3; //3 statements in swap sequence
				}	
				left++;
				right--;
			}
			
			//ADDED FOR DATA COLLECTION
			numStatements += 2; //for loop increment and condition check
		}
	}

	/**
	 * ADDED FOR DATA COLLECTION
	 * method added just to collect data about wrongSort()
	 * @return approximate statements executed on last call to order()
	 */
	public static long getStatements() {
		return numStatements;
	}
}
