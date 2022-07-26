import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Throwing and catching Exceptions while reading files.
 * 
 * @author mvail
 */
public class ExceptionThrower3 {

	public static void main(String[] args) {
		ExceptionThrower3 thrower = new ExceptionThrower3();
		
		thrower.readVals ( "validFile.txt" );
		thrower.readVals ( "noSuchFile" );
		thrower.readVals ( "invalidFile1.txt" );
		thrower.readVals ( "invalidFile2.txt" );
		thrower.readVals( "invalidFile3.txt" );
	}

	private void readVals ( String fileName ) {
		int val1;
		int val2;
		
		Scanner fileScan = null;
		try {
			fileScan = new Scanner ( new File( fileName ) );
			/* in the following sequence, if we detect anything wrong while
			 * reading the file, we're throwing an InvalidFileFormatException */
			if ( !fileScan.hasNextInt() ) {
				throw new InvalidFileFormatException ( "first value in " + fileName + " is not an integer");
			}
			val1 = fileScan.nextInt();
			if ( !fileScan.hasNextInt() ) {
				throw new InvalidFileFormatException ( "second value in " + fileName + " is not an integer");
			}
			val2 = fileScan.nextInt();
			if ( fileScan.hasNext() ) {
				throw new InvalidFileFormatException ( "extra unexpected values in " + fileName);
			}
			System.out.println("Successfully read val1: " + val1 + ", val2: " + val2 + " from " + fileName);
		} 
		catch ( FileNotFoundException e ) {
			System.out.println( e.toString() );
		} 
		catch ( InvalidFileFormatException e ) {
			System.out.println( e.toString() );
		} 
		catch ( Exception e ) {
			e.printStackTrace();
			//throw new UnknownException("No idea. Run and hide.");
		} 
		finally {
			if ( fileScan != null ) {
				fileScan.close();
			}
		}
		System.out.println("Are we dead?");
	}
	
//	private void checkFile ( String fileName ) throws Exception {
//		Scanner fileScan = new Scanner ( new File ( fileName ) );
//		if ( !fileScan.hasNextInt() ) {
//			fileScan.close();
//			throw new InvalidFileFormatException ( "first value in " + fileName + " is not an integer");
//		}
//		val1 = fileScan.nextInt();
//		if ( !fileScan.hasNextInt() ) {
//			fileScan.close();
//			throw new InvalidFileFormatException ( "second value in " + fileName + " is not an integer");
//		}
//		val2 = fileScan.nextInt();
//		if ( fileScan.hasNext() ) {
//			fileScan.close();
//			throw new InvalidFileFormatException ( "extra unexpected values in " + fileName);
//		}
//		fileScan.close();
//	}
}
