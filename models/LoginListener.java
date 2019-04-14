/**
 * 
 */
package models;

/**
 * @author steve
 *
 */
public interface LoginListener {
	void loginEventOccured(LoginEvent e);
	void logoutEventOccured();
}
