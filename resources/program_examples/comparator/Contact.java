/**
 * Simple phone book contact to demonstrate Comparable vs Comparator.
 * The "natural order" of these contacts, as defined by the Comparable interface's
 * compareTo() method, is alphabetical by last name, first name.
 * 
 * @author mvail
 */
public class Contact implements Comparable<Contact> {
	private String lastName;
	private String firstName;
	private long phoneNumber;
	
	/**
	 * Constructor
	 * @param lastName
	 * @param firstName
	 * @param phoneNumber
	 */
	public Contact(String lastName, String firstName, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the phoneNumber
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName + ", " + phoneNumber;
	}
	
	/**
	 * Overloads equals() method for Contact arguments. Other object references will still use default equals().
	 * @param other
	 * @return true if last name and first name match
	 */
	public boolean equals(Contact other) {
		return (this.lastName.equals(other.lastName) && this.firstName.equals(other.firstName));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * This method defines the "natural ordering" for Contacts.
	 */
	@Override
	public int compareTo(Contact other) {
		int result = this.lastName.compareTo(other.lastName);
		if (result == 0) {
			result = this.firstName.compareTo(other.firstName);
		}
		return result;
	}
}
