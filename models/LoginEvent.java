/**
 * 
 */
package models;

/**
 * @author steve
 *
 */
public class LoginEvent {
	private User user;

	public LoginEvent(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
