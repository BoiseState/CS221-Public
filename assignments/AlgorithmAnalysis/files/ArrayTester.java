
/**
 * Simple driver class to visually confirm correct operation of ArrayOfInts and MethodsToAnalyze methods.
 * 
 * @author mvail
 */
public class ArrayTester {

	public static void main(String[] args) {
	
		///////////////////////////////////////////////////
		// Confirm ArrayOfInts returns arrays as requested
		///////////////////////////////////////////////////
		
		int[] array;
		
		array = ArrayOfInts.randomizedArray(10);
		System.out.println("randomized array:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		array = ArrayOfInts.randomizedArrayWithDuplicates(10,3);
		System.out.println("randomized array with replication factor 3:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		array = ArrayOfInts.randomizedArrayWithDuplicates(10,1);
		System.out.println("randomized array with replication factor 1:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		array = ArrayOfInts.randomizedArrayWithDuplicates(10,10);
		System.out.println("randomized array with replication factor 10:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		array = ArrayOfInts.ascendingArray(10);
		System.out.println("ascending array:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		array = ArrayOfInts.descendingArray(10);
		System.out.println("descending array:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		System.out.println();
		System.out.println();

		///////////////////////////////////////////////////
		// Confirm MethodsToAnalyze.find() works correctly
		///////////////////////////////////////////////////
		
		array = ArrayOfInts.randomizedArray(10);
		System.out.println("random array:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println("index of 10: " + MethodsToAnalyze.find(array, 10));

		System.out.println();
		System.out.println();

		/////////////////////////////////////////////////////////
		// Confirm MethodsToAnalyze.replaceAll() works correctly
		/////////////////////////////////////////////////////////
		
		System.out.println("random array with duplicates");
		array = ArrayOfInts.randomizedArrayWithDuplicates(10, 3);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println("after replacing all 2s with 0s:");
		MethodsToAnalyze.replaceAll(array, 2, 0);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		System.out.println();
		System.out.println();
		
		//////////////////////////////////////////////////////
		// Confirm MethodsToAnalyze.order1() works correctly
		//////////////////////////////////////////////////////
		
		array = ArrayOfInts.randomizedArray(10);
		int[] copy;
		System.out.println("random array:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println("after order1():");
		copy = ArrayOfInts.copyArray(array);
		MethodsToAnalyze.order1(copy);
		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		System.out.println();

		//////////////////////////////////////////////////////
		// Confirm MethodsToAnalyze.order2() works correctly
		//////////////////////////////////////////////////////
		
		System.out.println("after order2():");
		copy = ArrayOfInts.copyArray(array);
		MethodsToAnalyze.order2(copy);
		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		System.out.println();

		//////////////////////////////////////////////////////
		// Confirm MethodsToAnalyze.order3() works correctly
		//////////////////////////////////////////////////////
		
		System.out.println("after order3():");
		copy = ArrayOfInts.copyArray(array);
		MethodsToAnalyze.order3(copy);
		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		System.out.println();

	}

}
