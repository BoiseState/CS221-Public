import java.util.*;

/**
 * MazeSolver attempts to iteratively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Java Foundations
 * @author mvail added code necessary to mark solution path,
 * added inner Storage class and StoreType enum for switchable
 * back-end storage data structures
 *  
 * @version 4.0
 */
public class MazeSolver
{
	public enum StoreType{apiArrayStack, apiLinkedStack, apiLinkedQueue, 
		arrayStack, linearArrayQueue,	circularArrayQueue, 
		linkedStack, linkedQueue, callStack}

	private Maze maze;
	private StoreType storeType;
	private long statesEvaluated;
	private int maxStoreSize;
	private int pathLength;
	private Storage store;
	private int callStackDepth;

	/**
	 * Constructor for the MazeSolver class.
	 */
	public MazeSolver(Maze maze, StoreType storeType)
	{
		this.maze = maze;
		this.storeType = storeType;
		statesEvaluated = 0;
		maxStoreSize = 0;
		pathLength = 0;
		callStackDepth = 0;
	}

	public boolean traverse() {
		boolean result = false;
		switch (this.storeType) {
		case callStack:
			result = traverseRecursively(0,0);
			break;
		default:
			result = traverseIteratively();
			break;
		}
		return result;
	}

	/**
	 * Attempts to recursively traverse the maze. Inserts special
	 * characters indicating locations that have been TRIED and that
	 * eventually become part of the solution PATH.
	 *
	 * @param row row index of current location
	 * @param column column index of current location
	 * @return true if the maze has been solved
	 */
	public boolean traverseRecursively(int row, int column)
	{
		boolean done = false;

		callStackDepth++;

		if (maze.validPosition(row, column))
		{
			statesEvaluated++;
			maxStoreSize = Math.max(callStackDepth, maxStoreSize);
			
			maze.tryPosition(row, column);   // mark this cell as tried

			if (row == maze.getRows()-1 && column == maze.getColumns()-1)  
				done = true;  // the maze is solved
			else
			{
				done = traverseRecursively(row+1, column);      // down
				if (!done)
					done = traverseRecursively(row, column+1);  // right
				if (!done)
					done = traverseRecursively(row-1, column);  // up
				if (!done)
					done = traverseRecursively(row, column-1);  // left
			}

			if (done) {  // this location is part of the final path
				maze.markPath(row, column);
				pathLength++;
			}
		}

		callStackDepth--;

		return done;
	}

	/**
	 * Attempts to iteratively traverse the maze. Inserts special
	 * characters indicating locations that have been TRIED and that
	 * eventually become part of the solution PATH.
	 *
	 * @param column column index of current location
	 * @return true if the maze has been solved
	 */
	public boolean traverseIteratively()
	{
		statesEvaluated = 0;
		maxStoreSize = 0;
		pathLength = 0;
		boolean done = false;
		Position pos = new Position();
		store = new Storage();
		store.store(pos);

		while (!(done) && !store.isEmpty())
		{
			pos = store.retrieve();
			statesEvaluated++;
			maze.tryPosition(pos.getRow(),pos.getCol());  // this cell has been tried
			if (pos.getRow() == maze.getRows()-1 && pos.getCol() == maze.getColumns()-1)
				done = true;  // the maze is solved
			else
			{
				//MV: the order of these statements has a profound effect
				//	on the order of evaluation!
				push_new_pos(pos.getRow() + 1,pos.getCol(), pos, store); //down
				push_new_pos(pos.getRow(),pos.getCol() + 1, pos, store); //right
				push_new_pos(pos.getRow() - 1,pos.getCol(), pos, store); //up
				push_new_pos(pos.getRow(),pos.getCol() - 1, pos, store); //left
				maxStoreSize = Math.max(maxStoreSize, store.size());
			}
		}

		//mark all positions that are part of the solution path
		if (done) {
			do {
				maze.markPath(pos.getRow(), pos.getCol());
				pos = pos.getPrev();
				pathLength++;
			} while(pos != null);
		}

		return done;
	}

	/**
	 * Push a new attempted move onto the stack
	 * @param row represents y coordinate
	 * @param col represents x coordinate
	 * @param prev previous position
	 * @param store the working Storage of moves within the grid
	 */
	private void push_new_pos(int row, int col, Position prev,
			Storage store)
	{
		if (maze.validPosition(row,col)) {	
			Position npos = new Position();
			npos.setCol(col);
			npos.setRow(row);
			npos.setPrev(prev);
			store.store(npos);
		}
	}

	/**
	 * @return pathLength
	 */
	public int getPathLength() {
		return pathLength;
	}

	/**
	 * @return number of states evaluated during search
	 */
	public long getStatesEvaluated() {
		return statesEvaluated;
	}

	/**
	 * @return maximum number of search states stored during search
	 */
	public int getMaxStoreSize() {
		return maxStoreSize;
	}

	/**
	 * @return current number of search states in storage
	 */
	public int getCurrentStoreSize() {
		if (this.storeType == StoreType.callStack) {
			return callStackDepth;
		} else if (store != null) {
			return store.size();
		}
		return 0;
	}

	/**
	 * Private inner class to manage creation of and access to appropriate
	 * methods for one of several back-end data structures for MazeSolver.
	 * @author mvail
	 */
	private class Storage {

		private Stack<Position> stack; //apiArrayStack
		private Deque<Position> lStack; //apiLinkedStack
		private Queue<Position> queue; //apiLinkedQueue
		private StackADT<Position> cStack; //arrayStack, linkedStack
		private QueueADT<Position> cQueue; //linearArrayQueue, circularArrayQueue, linkedQueue

		/**
		 * initialize the appropriate storage structure
		 */
		public Storage() {
			switch (storeType) {
			case apiArrayStack:
				stack = new Stack<Position>();
				break;
			case apiLinkedStack:
				lStack = new LinkedList<Position>();
				break;
			case apiLinkedQueue:
				queue = new LinkedList<Position>();
				break;
			case arrayStack:
				cStack = new ArrayStack<Position>();
				break;
			case linkedStack:
				cStack = new LinkedStack<Position>();
				break;
			case linearArrayQueue:
				cQueue = new LinearArrayQueue<Position>();
				break;
			case circularArrayQueue:
				cQueue = new CircularArrayQueue<Position>();
				break;
			case linkedQueue:
				cQueue = new LinkedQueue<Position>();
				break;
			}
		}

		/**
		 * Store a Position
		 * @param p the position to store
		 */
		public void store(Position p) {
			switch (storeType) {
			case apiArrayStack:
				stack.push(p);
				break;
			case apiLinkedStack:
				lStack.push(p);
				break;
			case apiLinkedQueue:
				queue.add(p);
				break;
			case arrayStack:
				cStack.push(p);
				break;
			case linkedStack:
				cStack.push(p);
				break;
			case linearArrayQueue:
				cQueue.enqueue(p);
				break;
			case circularArrayQueue:
				cQueue.enqueue(p);
				break;
			case linkedQueue:
				cQueue.enqueue(p);
				break;   		
			}
		}

		/**
		 * Store a Position
		 * @param p the position to store
		 */
		public Position retrieve() {
			switch (storeType) {
			case apiArrayStack:
				return stack.pop();
				//break;
			case apiLinkedStack:
				return lStack.pop();
				//break;
			case apiLinkedQueue:
				return queue.remove();
				//break;
			case arrayStack:
				return cStack.pop();
				//break;
			case linkedStack:
				return cStack.pop();
				//break;
			case linearArrayQueue:
				return cQueue.dequeue();
				//break;
			case circularArrayQueue:
				return cQueue.dequeue();
				//break;
			case linkedQueue:
				return cQueue.dequeue();
				//break;   		
			}
			return null;
		}

		/**
		 * @return number of elements in Storage
		 */
		private int size() {
			switch (storeType) {
			case apiArrayStack:
				return stack.size();
				//break;
			case apiLinkedStack:
				return lStack.size();
				//break;
			case apiLinkedQueue:
				return queue.size();
				//break;
			case arrayStack:
				return cStack.size();
				//break;
			case linkedStack:
				return cStack.size();
				//break;
			case linearArrayQueue:
				return cQueue.size();
				//break;
			case circularArrayQueue:
				return cQueue.size();
				//break;
			case linkedQueue:
				return cQueue.size();
				//break;   		
			}
			return -1;
		}

		/**
		 * @return true if Storage contains no elements, else false
		 */
		private boolean isEmpty() {
			return (size() == 0);
		}
	}
}
