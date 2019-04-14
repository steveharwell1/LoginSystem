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
public class CustomerMainView extends View implements LoginListener {
	private User activeUser;

	/**
	 * @param redirectListener
	 */
	public CustomerMainView(RedirectListener redirectListener) {
		super(redirectListener);
	}

	@Override
	public void loginEventOccured(LoginEvent e) {
		// TODO Auto-generated method stub
		this.activeUser = e.getUser();
	}

	@Override
	public void logoutEventOccured() {
		this.activeUser = null;
	}

	@Override
	public void displayView() {
		String message = String.format("Hello %s this is the customer menu", activeUser.getName());
		System.out.println(message);
		getUserInput("Type logout to logout", "(logout)");
		User.logout();
	}

}
