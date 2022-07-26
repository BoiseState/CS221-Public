import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Practice code for basic Big-O analysis of algorithms.
 * @author mvail, algorithms 1-4 based on sample code from Koffman & Wolfgang Data Structures 2E
 */
public class SampleAlgorithms {

	/**
	 * @param args unused
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		final int MAX_N = 100;
		int statements;
		PrintStream out = null;
		
		out = new PrintStream("m1.csv");
		out.println("n, statements");
		for (int n = 1; n < MAX_N; n++) {
			System.out.println("output from m1, n = " + n);
			statements = m1(n);
			out.println(n + ", " + statements);
			System.out.println();
		}
		out.close();

		out = new PrintStream("a1.csv");
		out.println("n, statements");
		for (int n = 1; n < MAX_N; n++) {
			System.out.println("output from algorithm 1, n = " + n);
			statements = algorithm1(n);
			out.println(n + ", " + statements);
			System.out.println();
		}
		out.close();
		
		out = new PrintStream("a2.csv");
		out.println("n, statements");
		for (int n = 1; n < MAX_N; n++) {
			System.out.println("output from algorithm 2, n = " + n);
			statements = algorithm2(n);
			out.println(n + ", " + statements);
			System.out.println();
		}
		out.close();
		
		out = new PrintStream("a3.csv");
		out.println("n, statements");
		for (int n = 1; n < MAX_N; n++) {
			System.out.println("output from algorithm 3, n = " + n);
			statements = algorithm3(n);
			out.println(n + ", " + statements);
			System.out.println();
		}
		out.close();
		
		out = new PrintStream("a4.csv");
		out.println("n, statements");
		for (int n = 1; n < MAX_N; n++) {
			System.out.println("output from algorithm 4, n = " + n);
			statements = algorithm4(n);
			out.println(n + ", " + statements);
			System.out.println();
		}
		out.close();

		out = new PrintStream("a5.csv");
		out.println("n, statements");
		for (int n = 1; n < MAX_N; n++) {
			System.out.println("output from algorithm 5, n = " + n);
			statements = algorithm5(n);
			out.println(n + ", " + statements);
			System.out.println();
		}
		out.close();

		out = new PrintStream("a6.csv");
		out.println("n, statements");
		for (int n = 1; n < MAX_N; n++) {
			System.out.println("output from algorithm 6, n = " + n);
			statements = algorithm6(n);
			out.println(n + ", " + statements);
			System.out.println();
		}
		out.close();

		out = new PrintStream("a7.csv");
		out.println("n, statements");
		for (int n = 1; n < MAX_N; n++) {
			System.out.println("output from algorithm 7, n = " + n);
			statements = algorithm7(n);
			out.println(n + ", " + statements);
			System.out.println();
		}
		out.close();
	}
	
	//t(n) = 4 + 3n
	//O(n)
	private static int m1(int n) {
		int statements = 4; //don't count statements about statement counting
		int sum = 0; 
		int i = 1;
		while (i <= n) {
			sum += i;
			i++;
			statements += 3;
		}
		System.out.println("sum of numbers 1 to " + n + " = " + sum);
		return statements; //don't usually count returns unless there's a calculation
	}
	
	private static int algorithm1(int n) {
		int statements = 2;
		for (int i = 0; i < n; i++) {//+2 + n(3n + 4)
			statements += 4; //+1
			for (int j = 0; j < n; j++) {//1 + 1 +3n
				statements += 3;
				System.out.println(i + " " + j);
			}
		}
		return statements; //t(n) = 4n^2 + 3n + 3
		//O(n^2)
	}
	
//	private static int a1a(int n) {
//		int i = 0; //+1
//		while (i < n) { //+1 + n*...
//			int j = 0; //+1
//			while (j < n) { //+1 + n*...
//				System.out.println(i + " " + j); //+1
//				j++; //+1
//			}
//			i++; //+1
//		}
//	}
	//T(n) = 2 + n*(2 + (2 + n*(2 + 2)))
	// = 2 + n*(2 + 2 + 4n)
	// = 2 + 4n + 3n^2
	
	
	private static int algorithm2(int n) {
		int statements = 2; //not part
		for (int i = 0; i < n; i++) { //2 + n(4 + 8)
			statements += 2; //outer incr, check
			statements += 2; //inner init and 1st check
			for (int j = 0; j < 2; j++) { //2 + 2(3) -> 8 //inner statements, incr, check
				System.out.println(i + " " + j);
				statements += 3; //not part of the algorithm
			}
		}
		return statements;
		//t(n) = 2 + 12n
		//O(n)
	}

	private static int algorithm3(int n) {
		int statements = 2; //outer init/check
		for (int i = 0; i < n; i++) {
			statements += 2; //outer loop
			
			statements += 2; //inner init/check
			for (int j = n - 1; j >= i; j--) {
				statements += 2; //cost of inner loop
				statements += 1; //println
				
				System.out.println(i + " " + j);
			}
		}
		return statements;
	}
	//t(n) = 2 + n(2 + 2 + 3n/2) = 3n^2/2 + 4n + 2
	//O(n^2)
//	private static int algorithm4(int n) {
//		int statements = 0;
//		for (int i = 1; i < n; i++) {
//			for (int j = 0; j < i; j++) {
//				statements++; //not part of the algorithm
//				if (j % i == 0) {
//					System.out.println(i + " " + j);
//					statements++; //not part of the algorithm
//				}
//			}
//		}
//		return statements;
//	}

	private static int algorithm4(int n) {
	int statements = 2;
	for (int i = 1; i < n; i++) { //(n-1)*
		statements += 2;
		
		statements += 2;
		for (int j = 0; j < n; j++) { //n*
			statements += 2;
			
			statements += 1;
			if (j % i == 0) { //1
				statements += 1;
				System.out.println(i + " " + j); //1 assume always - actually 1/2
			}
		}
	}
	return statements;
}
//t(n) = 2 + n(4 + n(4)) = 4n^2 + 4n + 2
//O(n^2)
	
	
	private static int algorithm5(int n) {
		int statements = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j*=2) {
				System.out.println(i + " " + j);
				statements++; //not part of the algorithm
			}
		}
		return statements;
	}
	
	private static int algorithm6(int n) {
		int statements = 0;
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < 2*n; j++) {
				System.out.println(i + " " + j);
				statements++; //not part of the algorithm
			}
		}
		return statements;
	}
	
	private static int algorithm7(int n) {
		int statements = 0;
			for (int j = 1; j < n; j*=2) {
				System.out.println(j);
				statements++; //not part of the algorithm
			}
		return statements;
	}

}
