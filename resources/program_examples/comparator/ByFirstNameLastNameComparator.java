import java.util.Comparator;

/**
 * Comparator for Contacts
 * "Natural order" for Contacts is alphabetical by last name, first name.
 * This Comparator enables sorting by first name, last name.

 * @author mvail
 */
public class ByFirstNameLastNameComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact contact1, Contact contact2) {
		int result = contact1.getFirstName().compareTo(contact2.getFirstName());
		if (result == 0) {
			result = contact1.getLastName().compareTo(contact2.getLastName());
		}
		return result;
	}

}
