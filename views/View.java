/**
 * 
 */
package views;

import java.util.Scanner;

import application.RedirectListener;

/**
 * @author Stephen Harwell
 *
 */
public abstract class View {
	protected RedirectListener redirectListener;
	protected static Scanner stdin = new Scanner(System.in);

	public View(RedirectListener redirectListener) {
		this.redirectListener = redirectListener;
	}

	public abstract void displayView();

	protected static String getUserInput(String message, String pattern) {
		System.out.println(message);
		boolean validChoice = false;
		String input = "";
		while (!validChoice) {
			if (stdin.hasNext(pattern)) {
				input = stdin.next(pattern);
				// LOGGER.info(String.format("A correct input was chosen: %s", input));
				validChoice = true;

			} else {
				System.out.println("Invalid input. Please try again.");
				System.out.println(message);
				// LOGGER.info("Sinking a line of input");
				stdin.next();
			}

		}

		return input;
	}
}
