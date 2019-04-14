/**
 * 
 */
package models;

/**
 * @author steve
 *
 */
public class Manager extends User {

	/**
	 * @param name
	 * @param email
	 * @throws NonUniqueException
	 */
	public Manager(String name, String email) throws NonUniqueException {
		super(name, email);
	}

	@Override
	public boolean hasPermission(String permission) {
		switch (permission) {
		case "employee":
		case "manager":
			return true;
		}
		return false;
	}

}
