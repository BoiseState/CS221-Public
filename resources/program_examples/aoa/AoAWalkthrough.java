import java.util.Random;

/**
 * Sample algorithms for practicing analysis of algorithms. 
 * 
 * @author mvail
 */
public class AoAWalkthrough {
	
	private void methodJane(int x) { //jane(x) = 4, O(1)
		System.out.println("methodJane"); //1
		int y = x - 5; //1
		int z = x + 5; //1
		System.out.printf("x: %d\ty: %d\tz: %d\n", x, y, z); //1
	}
	
	private void methodJohn(int x) { //john(x) = 20, O(1)
		System.out.println("methodJohn"); //1
		int y = x - 5; //1
		int z = x + 5; //1
		System.out.printf("x: %d\ty: %d\tz: %d\n", x, y, z); //1
		while (x > y) { //1 + 5*3
			System.out.printf("x: %d\ty: %d\tz: %d\n", x, y, z); //1
			y++; //1
		}
	}
	
	private void methodJen(int x) { //jen(x) = 36, O(1)
		System.out.println("methodJen"); //1
		int y = x - 5; //1
		int z = x + 5; //1
		System.out.printf("x: %d\ty: %d\tz: %d\n", x, y, z); //1
		while (x > y) { //1 + 5*3
			System.out.printf("x: %d\ty: %d\tz: %d\n", x, y, z);
			y++;			
		}
		while (z > y) { //1 + 5*3
			System.out.printf("x: %d\ty: %d\tz: %d\n", x, y, z);
			y++;
		}
	}
	
	private void methodJim(int[] array) {
		System.out.println("methodJim");
		int arrayLength = array.length;
		System.out.printf("arrayLength: %d\n", arrayLength);
	}
	
	private void methodJanna(int[] array) { //janna(n) = 4 + 3n, O(n)
		System.out.println("methodJanna"); //1
		int arrayLength = array.length; //1
		int index = 0; //1
		while (index < arrayLength) { //1 + n(3)
			System.out.printf("index: %d\tvalue: %d\n", index, array[index]);
			index++;
		}
	}
	
	private void methodJason(int[] array) { // jason(n) = 5 + 6n, O(n) 
		System.out.println("methodJason"); //1
		int arrayLength = array.length; //1
		int index = 0; //1
		while (index < arrayLength) { //1 + n(3)
			System.out.printf("index: %d\tvalue: %d\n", index, array[index]);
			index++;
		}
		while (index > 0) { //1 + n(3)
			index--;
			System.out.printf("index: %d\tvalue: %d\n", index, array[index]);
		}
	}
	
	private void methodJasmine(int[] array) { //jasmine(n) = 4 + 3.5n, O(n)
		System.out.println("methodJasmine"); //1
		int arrayLength = array.length; //1
		int index = 0; //1
		while (index < arrayLength) { //1 + n(3.5)
			if (index % 2 == 0) { //1
				System.out.printf("index: %d\tvalue: %d\n", index, array[index]); //0.5
			}
			index++; //1
		}
	}

	private void methodJerry(int[] array) { //jerry(n) = 4 + n(4), O(n)
		System.out.println("methodJerry");
		int arrayLength = array.length;
		int index = 0;
		while (index < arrayLength) {
			if (array[index] % 2 == 0) {//1 + 0 if all are odd, //1 + 1 if all are even
				System.out.printf("index: %d\tvalue: %d\n", index, array[index]);
			}
			index++;
		}
	}
	
	private void methodJessie(int[] array) { //jessie(n) = 4 + 3n, 
		System.out.println("methodJessie"); //1
		int arrayLength = array.length; //1
//		for(int index = 0; index < arrayLength; index++) {
//			System.out.printf("index: %d\tvalue: %d\n", index, array[index]);
//		}		
		int index = 0; //1
		while(index < arrayLength) { //1 + n(3)
			System.out.printf("index: %d\tvalue: %d\n", index, array[index]);
			 index++;
		}		
	}
	
	private void methodJep(int[] array) { //jep(n) = 3 + 15n, O(n)
		System.out.println("methodJep"); //1 
		for(int index = 0; index < array.length; index++) { //2 + n(15)
			System.out.printf("value: %d, ", array[index]); //1
			for(int index2 = 0; index2 < 3; index2++) { //2 + 3(3)
				System.out.printf("%d, ", array[index]);
			}
			System.out.println(); //1
		}
	}
	
	private void methodJoJo(int[] array) { //jojo(n) = 2 + 6n + 3.5n^2, O(n^2)
		System.out.println("methodJoJo"); //1
		for(int index = 0; index < array.length; index++) { //2 + n(6+ 3.5n)
			System.out.printf("value: %d greater than:\n", array[index]); //1
			for(int index2 = 0; index2 < array.length; index2++) { //2 + n(3.5)
				if (array[index2] > array[index]) { //1 + 0 if all dups, 1 + 0.5 if all diff
					System.out.printf("%d, ", array[index2]);
				}
			}
			System.out.println(); //1
		}
	}
	
	private void methodJackie(int[] array) { //jackie(n) = 6 + 6n, O(n)
		System.out.println("methodJackie"); //1
		for(int index = 0; index < array.length; index++) { //2 + n(3)
			System.out.printf("%d, ", array[index]);
		}
		for(int index = array.length-1; index >= 0; index--) { //2 + n(3)
			System.out.printf("%d, ", array[index]);
		}
		System.out.println(); //1
	}
	
	private void methodJoline(int[] array) { //joline(n) = 7 + 3n + 5n/2 = 7 + 11n/2, O(n)
		for(int index = 0; index < array.length / 2; index++) { //2 + (n/2)(5)
			swap(array, index, array.length-index-1); //method call alert! cost is 3
		}
		System.out.print("array values: ["); //1
		for(int index = 0; index < array.length; index++) { //2 + n(3)
			System.out.printf("%d, ", array[index]);
		}
		System.out.println("]"); //1
	}
	
	private void methodJackson(int[] array) { //jackson(n) = 33 + 15n, O(n)
		System.out.println("methodJackson"); //1
		for(int i = 0; i < 5; i++) { //2 + 5(4 + 3n + 2) = 2 + 30 + 15n
			if ((1 + 1) == 2) { //1
				System.out.println("1+1=2... Just checking."); //1
				for(int index = 0; index < array.length; index++) { //2 + n(3)
					System.out.printf("%d, ", array[index]);
				}
				System.out.println(); //1
			}
		}
	}
	
	private void methodJeanie(int[] array) { //jeanie(n) = 2 + 7n + (11/2)n^2
		System.out.println("methodJeanie"); //1
		for(int index = 0; index < array.length; index++) { //2 + n((2 + 5n/2) + (2 + 3n) + 3)
			reverse(array); //2 + 5n/2
			for(int i = 0; i < array.length; i++) { //2 + n(3)
				System.out.printf("%d, ", array[i]);
			}
			System.out.println(); //1
		}
	}
	
	/** Reverse all elements in the given array
	 * @param array int[] to reverse
	 */
	private void reverse(int[] array) {
		for(int index = 0; index < array.length / 2; index++) { //2 + (n/2)(5)
			swap(array, index, array.length-index-1);
		}
	}
	
	/** Swap two elements in an int[]
	 * @param array array to modify
	 * @param idx1 first index
	 * @param idx2 second index
	 */
	private void swap(int[] array, int idx1, int idx2) {
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
	
	/** Create a new array of random integer from 0 to size-1.
	 * @param size length of the array
	 * @return array containing random values from 0 to size-1
	 */
	private int[] makeRandomArray(int size) {
		int[] array = new int[size];
		Random rand = new Random();
		for(int i = 0; i < size; i++) {
			array[i] = rand.nextInt(size);
		}
		return array;
	}
	
	/** Create a new array of consecutive integers from 0 to size-1.
	 * @param size length of the array
	 * @return array containing consecutive values from 0 to size-1
	 */
	private int[] makeOrderedArray(int size) {
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = i;
		}
		return array;
	}

	private void runMethods() {
		final int NUM = 5;

		methodJane(NUM);
		System.out.println();
		methodJohn(NUM);
		System.out.println();
		methodJen(NUM);
		System.out.println();
		methodJim(makeRandomArray(NUM));
		System.out.println();
		methodJanna(makeRandomArray(NUM));
		System.out.println();
		methodJason(makeRandomArray(NUM));
		System.out.println();
		methodJasmine(makeRandomArray(NUM));
		System.out.println();
		methodJerry(makeRandomArray(NUM));
		System.out.println();
		methodJessie(makeRandomArray(NUM));
		System.out.println();
		methodJoJo(makeOrderedArray(NUM));
		System.out.println();
		methodJep(makeOrderedArray(NUM));
		System.out.println();
		methodJackie(makeOrderedArray(NUM));
		System.out.println();
		methodJoline(makeOrderedArray(NUM));
		System.out.println();
		methodJackson(makeOrderedArray(NUM));
		System.out.println();
		methodJeanie(makeOrderedArray(NUM));
	}
	
	/** @param args unused */
	public static void main(String[] args) {
		AoAWalkthrough aoa = new AoAWalkthrough(); //avoiding static everything
		aoa.runMethods();
	}

}
