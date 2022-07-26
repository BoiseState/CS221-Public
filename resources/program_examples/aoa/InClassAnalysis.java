import java.util.ArrayList;

/**
 * In-class exercises for analyzing algorithms for growth function and order.
 * @author mvail
 */
public class InClassAnalysis {

	/**
	 * @param args unused
	 */
	public static void main(String[] args) {
		InClassAnalysis ica = new InClassAnalysis();
		
		final int MAX_N = 100;
		final int INTERVAL = 10;
		
		for( int n = INTERVAL; n <= MAX_N; n += INTERVAL ) {
			ica.algorithmBill( n );
		}

		for( int n = INTERVAL; n <= MAX_N; n += INTERVAL ) {
			ica.algorithmJill( n );
		}

		for( int n = INTERVAL; n <= MAX_N; n += INTERVAL ) {
			ica.algorithmSam( n );
		}

		for( int n = INTERVAL; n <= MAX_N; n += INTERVAL ) {
			ica.algorithmPam( n );
		}

		for( int n = INTERVAL; n <= MAX_N; n += INTERVAL ) {
			ica.algorithmDenny( n );
		}

		for( int n = INTERVAL; n <= MAX_N; n += INTERVAL ) {
			ica.algorithmJenny( n );
		}

	}
	
	private void algorithmBill( int n ) { //f(n) = 5 + n11.5	-> O(n)
		int k = n*3; //1
		int i = 1; //1
		ArrayList<Integer> evens = new ArrayList<Integer>(); //1
		while( i <= k ) { //1 + 3n*(1.5 + 1 +  1)
			if( i % 2 == 0 ) {
				evens.add(i);
			}
			i++;
		}
		System.out.println("n: " + n + ", Even numbers between 0 and " + k + ": " + evens); //1
	}
	
	private void algorithmJill( int n ) {
		int count = 0;
		for( int i = 0; i < n; i += 2 ) {
			count++; 
		}
		System.out.println("n: " + n + ", loop count: " + count);
	}
			
	private void algorithmSam( int n ) {
		int number = 0;
		for( int i = n; i > n/2; i-- ) {
			number += i;
		}
		for( int i = n/2; i > 0; i-- ) {
			number += i;
		}
		System.out.println("n: " + n + ", Sam number: " + number);
	}
	
	private void algorithmPam( int n ) {
		int statements = 4;
		int number = 0;
		for( int i = 0; i < n; i++ ) {
			int k = 0;
			while( k < i ) {
				number += k;
				k++;
				statements += 3;
			}
			statements += 4;
		}
		System.out.println("n: " + n + ", Pam number: " + number);
		
		System.out.println("n: " + n + ", Pan statements:  " + statements);
	}

	private void algorithmDenny( int n ) {
		int number = n;
		ArrayList<Integer> factors = new ArrayList<Integer>();
		while( n > 0 ) {
			if( number % n == 0 ) {
				factors.add(n);
			}
			n--;
		}
		System.out.println("factors of " + number + ": " + factors);
	}
	
	private void algorithmJenny( int n ) {
		int count = 0;
		int i = 1;
		while( i <= n ) {
			count++;
			i *= 2;
		}
		System.out.println("n: " + n + ", loop count: " + count);
	}
}
