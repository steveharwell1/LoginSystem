/**
 * 
 */
package models;

import java.util.Optional;

/**
 * @author steve
 *
 */
public class UserFactory {
	public Optional<User> createUser(String name, String email, String type) {
		User user = null;
		try {
			switch (type) {
			case "customer":
				user = new Customer(name, email);
				break;
			case "employee":
				user = new Employee(name, email);
				break;
			case "manager":
				user = new Manager(name, email);
			}
		} catch (NonUniqueException e) {
			return Optional.empty();
		}
		return Optional.ofNullable(user);
	}
}
