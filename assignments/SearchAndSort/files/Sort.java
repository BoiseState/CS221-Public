import java.util.Comparator;
import java.util.ListIterator;
/**
 * Class for sorting lists that implement the IndexedUnsortedList interface,
 * using ordering defined by class of objects in list or a Comparator.
 * As written uses Mergesort algorithm.
 *
 * @author CS221
 */
public class Sort
{	
	/**
	 * Returns a new list that implements the IndexedUnsortedList interface. 
	 * As configured, uses WrappedDLL. Must be changed if using 
	 * your own IUDoubleLinkedList class. 
	 * 
	 * @return a new list that implements the IndexedUnsortedList interface
	 */
	private static <T> IndexedUnsortedList<T> newList() 
	{
		return new WrappedDLL<T>(); //TODO: replace with your IUDoubleLinkedList for extra-credit
	}
	
	/**
	 * Sorts a list that implements the IndexedUnsortedList interface 
	 * using compareTo() method defined by class of objects in list.
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @see IndexedUnsortedList 
	 */
	public static <T extends Comparable<T>> void sort(IndexedUnsortedList<T> list) 
	{
		mergesort(list);
	}

	/**
	 * Sorts a list that implements the IndexedUnsortedList interface 
	 * using given Comparator.
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @param c
	 *            The Comparator used
	 * @see IndexedUnsortedList 
	 */
	public static <T> void sort(IndexedUnsortedList <T> list, Comparator<T> c) 
	{
		mergesort(list, c);
	}
	
	/**
	 * Mergesort algorithm to sort objects in a list 
	 * that implements the IndexedUnsortedList interface, 
	 * using compareTo() method defined by class of objects in list.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 */
	private static <T extends Comparable<T>> void mergesort(IndexedUnsortedList<T> list)
	{
	    if(list.size() <= 1)
		return;

	    System.out.println(list);
	    int mid = list.size() / 2;
	    IndexedUnsortedList<T> left = new WrappedDLL<T>();
	    IndexedUnsortedList<T> right = new WrappedDLL<T>();
	    ListIterator<T> iter = list.listIterator();

	    for(int i = 0; i < list.size(); i++){
		T elem = iter.next();
		if(i < mid){
		    left.add(elem);
		    System.out.println("LEft:" + left);
		} else{
		    right.add(elem);
		    System.out.println("Right: " + right);
		}
	    }

  
	    mergesort(left);
	    mergesort(right);


	    ListIterator<T> lIter = left.listIterator();
	    ListIterator<T> rIter = right.listIterator();
	    iter = list.listIterator();

	    while(iter.hasNext()){
		iter.next();
		iter.remove();
	    }
	    
	    T lElem = lIter.next();
	    T rElem = rIter.next();

	    if(lElem.compareTo(rElem) > 0){
		list.add(lElem);
		list.add(rElem);
	    } else {
		list.add(rElem);
		list.add(lElem);
	    }

	    while(lIter.hasNext() && rIter.hasNext()){
		if(lElem.compareTo(rElem) >= 0){
		    list.add(lElem);
		    lElem = lIter.next();
		} else {
		    list.add(rElem);
		    rElem = rIter.next();
		}
	    }
	    while(lIter.hasNext()){
		list.add(lIter.next());
	    }
	    while(rIter.hasNext()){
		list.add(rIter.next());
	    }
	    
	    
	}
		
	/**
	 * Mergesort algorithm to sort objects in a list 
	 * that implements the IndexedUnsortedList interface,
	 * using the given Comparator.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @param c
	 *            The Comparator used
	 */
	private static <T> void mergesort(IndexedUnsortedList<T> list, Comparator<T> c)
	{
	}
	
}
