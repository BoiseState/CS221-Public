import java.util.Arrays;

/**
 * An array implementation of a stack in which the bottom of the
 * stack is fixed at index 0.
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class ArrayStack<T> implements StackADT<T>
{
	private final static int DEFAULT_CAPACITY = 100;
	private T[] stack;
	private int top;
	
	/**
	 * default constructor
	 */
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * constructor
	 * @param initialCapacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		top = 0;
		stack = (T[])(new Object[initialCapacity]);
	}

	@Override
	public void push(T element) {
		if (top == stack.length) {
			expandCapacity();
		}
		stack[top] = element;
		top++;
	}
	
	/**
	 * double capacity of stack
	 */
	private void expandCapacity() {
		stack = Arrays.copyOf(stack, stack.length * 2);
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new EmptyCollectionException("ArrayStack");
		}
		T retVal = stack[top-1];
		stack[top] = null;
		top--;
		return retVal;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyCollectionException("ArrayStack");
		}
		return stack[top-1];
	}

	@Override
	public boolean isEmpty() {
		return (top == 0);
	}

	@Override
	public int size() {
		return top;
	}
}

