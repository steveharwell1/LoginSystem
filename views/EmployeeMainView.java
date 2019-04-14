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
public class EmployeeMainView extends View implements LoginListener {
	private User activeUser;

	/**
	 * @param redirectListener
	 */
	public EmployeeMainView(RedirectListener redirectListener) {
		super(redirectListener);
	}

	@Override
	public void loginEventOccured(LoginEvent e) {
		activeUser = e.getUser();
	}

	@Override
	public void logoutEventOccured() {
		activeUser = null;
	}

	@Override
	public void displayView() {
		String message = String.format("Hello %s this is the employee menu", activeUser.getName());
		System.out.println(message);
		getUserInput("Type logout to logout", "(logout)");
		User.logout();
	}

}
