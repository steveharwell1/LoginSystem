/**
 * 
 */
package models;

/**
 * @author steve
 *
 */
public class Employee extends User {

	/**
	 * @param name
	 * @param email
	 * @throws NonUniqueException
	 */
	public Employee(String name, String email) throws NonUniqueException {
		super(name, email);
	}

	@Override
	public boolean hasPermission(String permission) {
		if (permission.equals("employee")) {
			return true;
		}
		return false;
	}

}
