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
public class TextFileReader2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileScan = new Scanner(new File("moretext.txt")); //Scanner to read each line of the file
		
		String sentence1 = "";
		String sentence2 = "";
		int sum = 0;
		
		String line;
		while (fileScan.hasNextLine()) {
			line = fileScan.nextLine();
			if (line.length() > 0) {
				Scanner lineScan = new Scanner(line); //Scanner to break the current line into tokens
				if (lineScan.hasNext()) {
					sentence1 += lineScan.next();
				}
				if (lineScan.hasNext()) {
					sentence2 += lineScan.next();
				}
				if (lineScan.hasNextInt()) {
					sum += lineScan.nextInt();
				}
				lineScan.close();
				if (fileScan.hasNextLine()) {
					sentence1 += " ";
					sentence2 += " ";
				}
			}
		}
		
		System.out.println(sentence1);
		System.out.println(sentence2);
		System.out.println("My running sum was " + sum);

		fileScan.close();
	}
}
