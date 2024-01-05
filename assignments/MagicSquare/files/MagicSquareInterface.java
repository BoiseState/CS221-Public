
/**
 * Methods required for a class that validates
 * or creates magic squares in files with format:
 *   dimensionN
 *   v1 v2 ... vn
 *   ...
 *   vn1 vn2 ... vnn
 * e.g.
 *   3
 *   4 9 2
 *   3 5 7
 *   8 1 6
 * 
 * Two constructors are required.
 * 
 * The first constructor takes a filename, only,
 * and attempts to read that file. If the file
 * cannot be opened or is not in the correct
 * format, a FileNotFoundException should be thrown.
 *   public MagicSquare(String filename) throws FileNotFoundException
 * This constructor is required to call a private
 * utility method
 *   private int[][] readMatrix(String filename) throws FileNotFoundException
 * to open and read the file into a 2D int array.
 * 
 * The second constructor takes a filename and
 * an int for the dimension N of a new NxN magic
 * square. A generated matrix should be written
 * in the required format to a file with the given
 * name.
 *   public MagicSquare(String filename, int dimension) throws IOException
 * This constructor is required to call a private
 * utility method
 *   private void writeMatrix(int[][] matrix, String filename) throws IOException
 * to write the matrix to the file.
 * 
 * @author mvail
 */
public interface MagicSquareInterface {
	/**
	 * Evaluate the matrix (whether read from file or
	 * generated) and return a boolean verdict of
	 * whether the matrix is a magic square.
	 * 
	 * @return true if matrix is a magic square, else false
	 */
	public boolean isMagicSquare();
	
	/**
	 * Return a copy of the matrix (whether read from file 
	 * or generated) as a 2D array of ints. Be sure this
	 * method does not compromise encapsulation.
	 * 
	 * @return 2D array of ints that may or may not be a valid magic square
	 */
	public int[][] getMatrix();
	
	/**
	 * Return a string formatted as in these examples:
	 *   The matrix
	 *     4 9 2
	 *     3 5 7
	 *     8 1 6
	 *   is a magic square.
	 *  or
	 *    The matrix
	 *      5 3 7
	 *      9 4 2
	 *      1 6 5
	 *    is not a magic square.
	 *    
	 * @return formatted string showing the matrix and whether it is a valid magic square
	 */
	public String toString();
}
