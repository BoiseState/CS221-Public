import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * "Good" implementation of IndexedUnsortedList interface 
 * using Java API LinkedList class.  
 * 
 * @param <T>  - type of elements held in this collection
 * @author CS 221
 */
public class GoodList<T> implements IndexedUnsortedList<T> {
	private LinkedList<T> list;
	
	public GoodList() {
		list = new LinkedList<T>();
	}

	@Override
	public void addToFront(T element) {
		list.addFirst(element);
	}

	@Override
	public void addToRear(T element) {
		list.addLast(element);
	}

	@Override
	public void addAfter(T element, T target) {
		int targetIdx = list.indexOf(target);
		if (targetIdx < 0) {
			throw new NoSuchElementException();
		} else {
			list.add(targetIdx+1, element);
		}
	}
	
	@Override
	public void add(int index, T element) {
		list.add(index, element);
	}

	@Override
	public void add(T element) {
		list.add(element);
	}

	@Override
	public T removeFirst() {
		return list.removeFirst();
	}

	@Override
	public T removeLast() {
		return list.removeLast();
	}

	@Override
	public T remove(T element) {
		int idx = list.indexOf(element);
		if (idx < 0) {
			throw new NoSuchElementException();
		}
		T t = list.get(idx);
		list.remove(t);
		return t;
	}

	@Override
	public T remove(int index) {
		return list.remove(index);
	}

	@Override
	public T first() {
		return list.getFirst();
	}

	@Override
	public T last() {
		return list.getLast();
	}

	@Override
	public boolean contains(T target) {
		return list.contains(target);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public void set(int index, T element) {
		list.set(index, element);
	}

	@Override
	public T get(int index) {
		return list.get(index);
	}

	@Override
	public int indexOf(T element) {
		return list.indexOf(element);
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return list.toString();
	}
}
