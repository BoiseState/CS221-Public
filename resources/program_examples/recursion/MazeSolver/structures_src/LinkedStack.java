/**
 * A linked node implementation of a stack.
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedStack<T> implements StackADT<T>
{
	private LinearNode<T> top;
	private int size;

	/**
	 * default constructor
	 */
	public LinkedStack() {
		size = 0;
		top = null;
	}
	
	@Override
	public void push(T element) {
		LinearNode<T> temp = new LinearNode<T>(element);
		temp.setNext(top);
		top = temp;
		size++;
	}

	@Override
	public T pop() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("attempting to pop from an empty stack");
		}
		LinearNode<T> temp = top;
		top = top.getNext();
		size--;
		return temp.getElement();
	}

	@Override
	public T peek() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("attempting to pop from an empty stack");
		}
		return top.getElement();
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = new String();
		LinearNode<T> next = top;
		while (next != null) {
			s += next.getElement() + "\n";
			next = next.getNext();
		}
		return s;
	}
}

