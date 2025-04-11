import java.util.Stack;

/**
 * Java program for iterative Tower of Hanoi
 * @author Sumit Ghosh - original author
 * @author mvail - refactored to use Java API Stacks, add javadocs, other functionally neutral refactoring
 */
public class TowersOfHanoiIterative {
	private final static int TOTAL_NUM_DISKS = 3;

	/**
	 * Driver code
	 * @param args unused
	 */
	public static void main(String[] args) {

		TowersOfHanoiIterative toh = new TowersOfHanoiIterative();

		// Create three stacks to hold the disks
		Stack<Integer> src = new Stack<Integer>();
		Stack<Integer> dest = new Stack<Integer>();
		Stack<Integer> aux = new Stack<Integer>();

		toh.tohIterative(TOTAL_NUM_DISKS, src, aux, dest);
	}

	/** 
	 * Function to implement TOH puzzle
	 * @param num_of_disks number of disks in the puzzle
	 * @param src source peg stack
	 * @param aux auxiliary/temporary peg stack
	 * @param dest destination peg stack
	 */
	private void tohIterative(int num_of_disks, Stack<Integer> src, Stack<Integer> aux, Stack<Integer> dest) {
		int i, total_num_of_moves;
		char s = 'S', d = 'D', a = 'A';

		// If number of disks is even, then interchange destination pole and
		// auxiliary pole
		if (num_of_disks % 2 == 0) {
			char temp = d;
			d = a;
			a = temp;
		}
		total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1);

		// Larger disks will be pushed first
		for (i = num_of_disks; i >= 1; i--)
			src.push(i);

		for (i = 1; i <= total_num_of_moves; i++) {
			if (i == 1)
				moveDisksBetweenTwoPoles(src, dest, s, d);

			else if (i % 3 == 2)
				moveDisksBetweenTwoPoles(src, aux, s, a);

			else if (i % 3 == 0)
				moveDisksBetweenTwoPoles(aux, dest, a, d);
		}
	}

	/**
	 * Function to implement legal movement between two poles
	 * @param src source peg stack from the perspective of this move
	 * @param dest destination peg stack from the perspective of this move
	 * @param s character corresponding to this move's source peg
	 * @param d character corresponding to this move's destination peg
	 */
	private void moveDisksBetweenTwoPoles(Stack<Integer> src, Stack<Integer> dest, char s, char d) {
		int pole1TopDisk = (src.isEmpty() ? Integer.MIN_VALUE : src.pop());
		int pole2TopDisk = (dest.isEmpty() ? Integer.MIN_VALUE : dest.pop());

		// When pole 1 is empty
		if (pole1TopDisk == Integer.MIN_VALUE) {
			src.push(pole2TopDisk);
			moveDisk(d, s, pole2TopDisk);
		}

		// When pole2 pole is empty
		else if (pole2TopDisk == Integer.MIN_VALUE) {
			dest.push(pole1TopDisk);
			moveDisk(s, d, pole1TopDisk);
		}

		// When top disk of pole1 > top disk of pole2
		else if (pole1TopDisk > pole2TopDisk) {
			src.push(pole1TopDisk);
			src.push(pole2TopDisk);
			moveDisk(d, s, pole2TopDisk);
		}
		// When top disk of pole1 < top disk of pole2
		else {
			dest.push(pole2TopDisk);
			dest.push(pole1TopDisk);
			moveDisk(s, d, pole1TopDisk);
		}
	}

	/**
	 * Function to show the movement of disks
	 * @param fromPeg character corresponding to the source peg for this move
	 * @param toPeg character corresponding to the destination peg for this move
	 * @param disk number corresponding to the size of the disk from 1 (smallest) to n (largest)
	 */
	private void moveDisk(char fromPeg, char toPeg, int disk) {
		System.out.println("Move disk " + disk + " from " + fromPeg + " to " + toPeg);
	}
}
