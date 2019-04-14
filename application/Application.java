/**
 * 
 */
package application;

import java.util.HashMap;
import java.util.Map;

import models.User;
import models.UserFactory;
import views.CustomerMainView;
import views.EmployeeMainView;
import views.LoginView;
import views.View;

/**
 * @author steve
 *
 */
public class Application implements RedirectListener {
	private Map<String, View> views = new HashMap<String, View>();
	private View currentView;

	/**
	 * 
	 */
	public Application() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application app = new Application();

		UserFactory userFactory = new UserFactory();
		userFactory.createUser("Steve", "steve@steve.com", "customer");
		userFactory.createUser("admin", "admin@admin.com", "manager");

		LoginView loginView = new LoginView(app);
		User.addListener(loginView);
		app.addView("loginView", loginView);
		app.currentView = loginView;

		EmployeeMainView employeeMainView = new EmployeeMainView(app);
		User.addListener(employeeMainView);
		app.addView("employeeMainView", employeeMainView);

		CustomerMainView customerMainView = new CustomerMainView(app);
		User.addListener(customerMainView);
		app.addView("customerMainView", customerMainView);

		while (true) {
			app.currentView.displayView();
			System.out.println();
		}
	}

	@Override
	public void redirect(String target) {
		currentView = views.getOrDefault(target, currentView);
	}

	/**
	 * @return the views
	 */
	public Map<String, View> getViews() {
		return views;
	}

	/**
	 * @param views the views to set
	 */
	public void addView(String name, View view) {
		views.put(name, view);
	}

}
