import java.util.*;
import java.io.*;

/**
 * MazeTester uses a stack in an iterative search algorithm
 * to determine if a maze can be traversed.
 *
 * @author Java Foundations
 * @author mvail adapted to handle MazeSover that can use one of several
 * possible back-end storage data structures.
 * @version 4.0
 */
public class MazeTester
{
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file containing the maze: ");
        String filename = scan.nextLine();
        MazeSolver solver;
        Maze labyrinth = new Maze(filename);
      
        System.out.println(labyrinth);
        
        // STACKS
        
//        System.out.println("Testing using a Stack (java.util.Stack)\n");
//        solver = new MazeSolver(labyrinth, MazeSolver.StoreType.apiArrayStack);

//        System.out.println("Testing using a Stack (java.util.LinkedList)\n");
//        solver = new MazeSolver(labyrinth, MazeSolver.StoreType.apiLinkedStack);
        
//        System.out.println("Testing using a Stack (custom ArrayStack)\n");
//        solver = new MazeSolver(labyrinth, MazeSolver.StoreType.arrayStack);
        
        System.out.println("Testing using a Stack (custom LinkedStack)\n");
        solver = new MazeSolver(labyrinth, MazeSolver.StoreType.linkedStack);

        if (solver.traverse())
            System.out.println("The maze was successfully traversed!");
        else
            System.out.println("There is no possible path.");

        System.out.println(labyrinth);
        
        System.out.println("Positions explored: " + solver.getStatesEvaluated());
        System.out.println("Max storage size: " + solver.getMaxStoreSize());
        System.out.println("Positions in storage when search ended: " + solver.getCurrentStoreSize());
        System.out.println("Path length: " + solver.getPathLength());
        System.out.println();
        
        // QUEUE
        labyrinth = new Maze(filename);

//        System.out.println("Testing using a Queue (java.util.LinkedList)\n");
//        solver = new MazeSolver(labyrinth, MazeSolver.StoreType.apiLinkedQueue);

//        System.out.println("Testing using a Queue (custom LinearArrayQueue)\n");
//        solver = new MazeSolver(labyrinth, MazeSolver.StoreType.linearArrayQueue);

        System.out.println("Testing using a Queue (custom CircularArrayQueue)\n");
        solver = new MazeSolver(labyrinth, MazeSolver.StoreType.circularArrayQueue);

//        System.out.println("Testing using a Queue (custom LinkedQueue)\n");
//        solver = new MazeSolver(labyrinth, MazeSolver.StoreType.linkedQueue);

        if (solver.traverse())
            System.out.println("The maze was successfully traversed!");
        else
            System.out.println("There is no possible path.");

        System.out.println(labyrinth);
        
        System.out.println("Positions explored: " + solver.getStatesEvaluated());
        System.out.println("Max storage size: " + solver.getMaxStoreSize());
        System.out.println("Positions in storage when search ended: " + solver.getCurrentStoreSize());
        System.out.println("Path length: " + solver.getPathLength());
        System.out.println();

        // RECURSIVE SEARCH
        labyrinth = new Maze(filename);

        System.out.println("Testing using Recursion (call stack)\n");
        solver = new MazeSolver(labyrinth, MazeSolver.StoreType.callStack);

        if (solver.traverse())
            System.out.println("The maze was successfully traversed!");
        else
            System.out.println("There is no possible path.");

        System.out.println(labyrinth);
        
        System.out.println("Positions explored: " + solver.getStatesEvaluated());
        System.out.println("Max storage size: " + solver.getMaxStoreSize());
        System.out.println("Positions in storage when search ended: " + solver.getCurrentStoreSize());
        System.out.println("Path length: " + solver.getPathLength());
        System.out.println();

    }
}
