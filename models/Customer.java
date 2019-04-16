/**
 * 
 */
package models;

/**
 * @author steve
 *
 */
public class Customer extends User {

	/**
	 * @param name
	 * @param email
	 * @throws NonUniqueException
	 */
	Customer(String name, String email) throws NonUniqueException {
		super(name, email);
	}

	@Override
	public boolean hasPermission(String permission) {
		if (permission.equals("customer")) {
			return true;
		}
		return false;
	}

}
