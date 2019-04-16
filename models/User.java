/**
 * 
 */
package models;

import java.util.ArrayList;

/**
 * @author steve
 *
 */
public abstract class User implements Model {
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<LoginListener> listeners = new ArrayList<LoginListener>();
	private String name;
	private String email;

	User(String name, String email) throws NonUniqueException {
		for (User user : users) {
			if (user.getPrimaryKey().equals(email)) {
				throw new NonUniqueException();
			}
		}
		this.name = name;
		this.email = email;
		users.add(this);
	}

	public abstract boolean hasPermission(String permission);

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void addListener(LoginListener listener) {
		listeners.add(listener);
	}

	public static boolean login(String email) {
		LoginEvent e = null;
		for (User user : users) {
			if (user.getPrimaryKey().equals(email)) {
				e = new LoginEvent(user);
			}
		}

		if (e != null) {
			for (LoginListener listener : listeners) {
				listener.loginEventOccured(e);
			}
			return true;
		} else {
			return false;
		}
	}

	public static void logout() {
		for (LoginListener listener : listeners) {
			listener.logoutEventOccured();
		}
	}

	@Override
	public String getPrimaryKey() {
		return email;
	}

}
