/**
 * 
 */
package views;

import application.RedirectListener;
import models.LoginEvent;
import models.LoginListener;
import models.User;

/**
 * @author steve
 *
 */
public class LoginView extends View implements LoginListener {

	User activeUser;

	/**
	 * 
	 */
	public LoginView(RedirectListener redirectListener) {
		super(redirectListener);
	}

	@Override
	public void displayView() {
		System.out.println("Welcome to the hotel booking system!");
		String email;
		String message = "Please enter your email address to login.";
		do {
			email = getUserInput(message, "([a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,})");
			System.out.println("A valid email of " + email + " was entered.");
		} while (!User.login(email));
	}

	@Override
	public void loginEventOccured(LoginEvent e) {
		this.activeUser = e.getUser();
		if (activeUser.hasPermission("employee")) {
			redirectListener.redirect("employeeMainView");
		} else if (activeUser.hasPermission("customer")) {
			redirectListener.redirect("customerMainView");
		} else {
			System.out.println("You don't have permission to use this system");
			User.logout();
		}
	}

	@Override
	public void logoutEventOccured() {
		this.activeUser = null;
		redirectListener.redirect("loginView");
	}

}
