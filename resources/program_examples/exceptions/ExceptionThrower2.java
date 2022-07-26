import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Simple propagation example
 * 
 * @author mvail
 */
public class ExceptionThrower2 {
	private int val1;

	public static void main(String[] args) {
		ExceptionThrower2 thrower = new ExceptionThrower2();

		try {
			/* the call to readVals is in a try block, so if an
			 * Exception is propagated by readVals, the catch blocks
			 * below have a chance to handle it */
			thrower.readVals ( "noSuchFile" );
		} catch ( FileNotFoundException e ) {
			System.out.println( e.toString() );
		}
	}

	/* this method declares that it will NOT handle any FileNotFoundExceptions,
	 * and will throw them (propagate them) to whatever method called readVals */
	private void readVals ( String fileName ) throws FileNotFoundException {
		Scanner fileScan = null;
		fileScan = new Scanner ( new File( fileName ) );
		val1 = fileScan.nextInt();
		System.out.println( "Successfully read int " + val1 + " from " + fileName);
		fileScan.close();
	}
}
