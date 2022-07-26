import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Program to demonstrate a two-Scanner approach to reading text file input.
 * Reading a line at a time with the first Scanner and then breaking lines into tokens
 *  with the second Scanner avoids the problem of unconsumed newline characters
 *  from using next(), nextInt(), nextDouble(), etc.
 *   
 * @author mvail
 */
public class TextFileReader {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileScan = new Scanner(new File("multiwordtext.txt")); //Scanner to read lines from the file
		
		String sentence = "";
		
		String line;
		while (fileScan.hasNextLine()) {
			line = fileScan.nextLine();
			if (line.length() > 0) {
				Scanner lineScan = new Scanner(line); //Scanner to break current line into tokens
				while (lineScan.hasNext()) {
					sentence += lineScan.next();
					if (lineScan.hasNext()) {
						sentence += " ";
					}
				}
				lineScan.close();
				if (fileScan.hasNextLine()) {
					sentence += " ";
				}
			}
		}
		
		System.out.println(sentence);

		fileScan.close();
	}

}
