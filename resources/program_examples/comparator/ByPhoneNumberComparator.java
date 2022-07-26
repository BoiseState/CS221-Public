import java.util.Comparator;

/**
 * Comparator for Contacts
 * "Natural order" for Contacts is alphabetical by last name, first name.
 * This Comparator enables sorting by phone number, for a reverse directory.
 * 
 * @author mvail
 */
public class ByPhoneNumberComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact contact0, Contact contact1) {
		return (int)(contact0.getPhoneNumber() - contact1.getPhoneNumber());
	}
	
}
