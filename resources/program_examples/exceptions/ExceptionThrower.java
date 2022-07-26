import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Catching various Exceptions while reading files. 
 * 
 * @author mvail
 */
public class ExceptionThrower {
	private int val1;

	public static void main(String[] args) {
		ExceptionThrower thrower = new ExceptionThrower();
		
		thrower.readVals ( "validFile.txt" );
		thrower.readVals ( "noSuchFile" );
		thrower.readVals ( "invalidFile.txt" );
		thrower.readVals(  "emptyFile.txt" );
	}

	private void readVals ( String fileName ) {
		Scanner fileScan = null;
		/* statements in the try block are those that could throw Exceptions
		 * and statements that depend on successfully executing those dangerous
		 * statements */
		try {
			fileScan = new Scanner ( new File( fileName ) );
			val1 = fileScan.nextInt();
			System.out.println( "Successfully read int " + val1 + " from " + fileName);
		} 
		/* each catch block is an "Exception handler" that matches any compatible
		 * Exception - any valid polymorphic assignment would be a match.
		 * These handlers are checked in order (like switch cases) and the first
		 * matching handler is the one that will be used. If no handlers match,
		 * the Exception is not caught. */
		catch ( FileNotFoundException e ) {
			System.out.println("Could not open or read " + fileName);
			System.out.println( e.toString() ); //gives type of Exception and any associated message
		} 
		catch ( InputMismatchException e ) {
			/* handling an Exception doesn't require doing anything with it - catching
			 * it is all that matters */
			System.out.println( fileScan.next() + " isn't an int in " + fileName );
		} 
		catch ( NoSuchElementException e ) {
			System.out.println( "Missing expected int in " + fileName );
		} 
		catch ( Exception e ) {
			e.printStackTrace(); //same stack trace printed to console for unhandled Exceptions
			//System.exit(1); //Instant death. Only way finally block doesn't happen.
		} 
		/* whether or not an Exception was thrown in the try block, the code in the
		 * optional finally block WILL be executed. This is where you put code you
		 * want to guarantee happens no matter what. */ 
		finally {
			if ( fileScan != null ) {
				fileScan.close();
			}
			System.out.println("Finally!");
		}
		/* if no Exception is thrown in the try block, or a thrown Exception was caught,
		 * the flow of control continues after all catches (and optional finally) */
		System.out.println("Congratulations - either no Exception was thrown, or we handled a thrown Exception.");
	}
}
