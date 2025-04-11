import java.util.Scanner;

/**
 * SolveTowers uses recursion to solve the Towers of Hanoi puzzle.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class SolveTowers
{
    /**
     * Creates a TowersOfHanoi puzzle and solves it.
     */
    public static void main(String[] args)
    {
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int disks = Integer.parseInt(kbd.nextLine().trim());
        kbd.close();
        
        TowersOfHanoi towers = new TowersOfHanoi(disks);
        towers.solve();
        
        System.out.println("\n"+ towers.getMoves() + " moves\n");
    }
}
