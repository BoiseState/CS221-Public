import java.util.Arrays;
import java.util.Comparator;

/**
 * Demonstrate Comparable vs Comparator sorting using a Contact list.
 *
 * @author mvail
 */
public class ContactList {

	/**
	 * Build Contact list. Sort it by natural ordering and by alternative orderings defined in Comparators.
	 * @param args not used
	 */
	public static void main(String[] args) {
		Contact[] contacts = {new Contact("Doe", "John", 2085552525), new Contact("Doe", "Jane", 2085551234),
				new Contact("Smith", "John", 2085554321), new Contact("Lane", "Lois", 2085550001)};

		System.out.println("Unsorted Contact List:");
		for (Contact c : contacts) {
			System.out.println(c);
		}
		System.out.println();
		
		//compare two Contacts using compareTo()
		System.out.print("Using Natural Order (Last Name, First Name), ");
		int result =contacts[2].compareTo(contacts[3]); 
		if (result == 0) {
			System.out.println(contacts[2] + " is equal to " + contacts[3]);
		} else if (result < 0) {
			System.out.println(contacts[2] + " comes before " + contacts[3]);
		} else {
			System.out.println(contacts[2] + " comes after " + contacts[3]);
		}
		System.out.println();

		//compare two Contacts using ByFirstNameLastNameComparator
		System.out.print("Using ByFirstNameLastNameComparator, ");
		Comparator<Contact> comparator1 = new ByFirstNameLastNameComparator();
		result = comparator1.compare(contacts[2], contacts[3]); 
		if (result == 0) {
			System.out.println(contacts[2] + " is equal to " + contacts[3]);
		} else if (result < 0) {
			System.out.println(contacts[2] + " comes before " + contacts[3]);
		} else {
			System.out.println(contacts[2] + " comes after " + contacts[3]);
		}
		System.out.println();
		
		//compare two Contacts using ByPhoneNumberComparator
		System.out.print("Using ByPhoneNumberComparator, ");
		Comparator<Contact> comparator2 = new ByPhoneNumberComparator();
		result = comparator2.compare(contacts[2], contacts[3]); 
		if (result == 0) {
			System.out.println(contacts[2] + " is equal to " + contacts[3]);
		} else if (result < 0) {
			System.out.println(contacts[2] + " comes before " + contacts[3]);
		} else {
			System.out.println(contacts[2] + " comes after " + contacts[3]);
		}
		System.out.println();
		
		//sort with "natural order" as defined in Contact's compareTo() method
		Arrays.sort(contacts);
		
		System.out.println("Natural Order (Last Name, First Name):");
		for (Contact c : contacts) {
			System.out.println(c);
		}
		System.out.println();
		
		//sort with alternative first name, last name order using a Comparator
		Arrays.sort(contacts, comparator1);
		
		System.out.println("Ordered by First Name, Last Name:");
		for (Contact c : contacts) {
			System.out.println(c);
		}
		System.out.println();

		//sort with alternative phone number order using a Comparator
		Arrays.sort(contacts, comparator2);
		
		System.out.println("Ordered by Phone Number:");
		for (Contact c : contacts) {
			System.out.println(c);
		}
		System.out.println();
		
	}
}
