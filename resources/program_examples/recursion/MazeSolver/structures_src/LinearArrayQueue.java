/**
 * CircularArrayQueue represents an array implementation of a queue in 
 * which the indexes for the front and rear of the queue circle back to 0
 * when they reach the end of the array.
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class LinearArrayQueue<T> implements QueueADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;
    private final static int FRONT = 0;
    private int rear;
    private T[] queue; 
  
    /**
     * Creates an empty queue using the specified capacity.
     * @param initialCapacity the initial size of the circular array queue
     */
    @SuppressWarnings("unchecked")
	public LinearArrayQueue (int initialCapacity)
    {
        rear = 0;
        queue = (T[]) (new Object[initialCapacity]);
    }
  
    /**
     * Creates an empty queue using the default capacity.
     */
    public LinearArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }    
	
	/**
     * Adds the specified element to the rear of this queue, expanding
     * the capacity of the queue array if necessary.
     * @param element the element to add to the rear of the queue
     */
    public void enqueue(T element)
    {
        if (size() == queue.length) 
            expandCapacity();
    
        queue[rear] = element;
        rear++;
    }
	
	/**
     * Creates a new array to store the contents of this queue with
     * twice the capacity of the old one.
     */
    @SuppressWarnings("unchecked")
	private void expandCapacity()
    {
        T[] larger = (T[]) (new Object[queue.length *2]);
    
        for (int scan = 0; scan < rear; scan++)
        {
            larger[scan] = queue[scan];
        }
    
        queue = larger;
    }
	
    /**
     * Removes the element at the front of this queue and returns a
     * reference to it. 
	 * @return the element removed from the front of the queue
     * @throws EmptyCollectionException  if the queue is empty
     */
    public T dequeue() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");
    
        T result = queue[FRONT];
        // shift all elements forward so front remains at index 0
        for(int i = 1; i < rear; i++) {
        	queue[i-1] = queue[i];
        }
    
        rear--;
    
        return result;
    }
  
    /** 
     * Returns a reference to the element at the front of this queue.
     * The element is not removed from the queue.  
     * @return the first element in the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T first() throws EmptyCollectionException
    {
        if (isEmpty()) {
        	throw new EmptyCollectionException("attempting to access empty LinearArrayQueue");
        }
        return queue[FRONT];
    }
  
    /**
     * Returns true if this queue is empty and false otherwise.
     * @return true if this queue is empty 
     */
    public boolean isEmpty()
    {
    	return (rear == FRONT);
    }
  
    /**
     * Returns the number of elements currently in this queue.
     * @return the size of the queue
     */
    public int size()
    {
    	return rear;
    }
  
    /**
     * Returns a string representation of this queue. 
     * @return the string representation of the queue
     */
    public String toString()
    {
    	StringBuilder sb = new StringBuilder("LinearArrayQueue [");
    	for (int i = 0; i < rear; i++) {
    		sb.append(queue[i]);
    		if (i < rear-1) {
    			sb.append(", ");
    		}
    	}
    	sb.append("]");
    	return sb.toString();
    }
}
