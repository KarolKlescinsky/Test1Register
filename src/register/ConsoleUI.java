package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User interface of the application.
 */
public class ConsoleUI {
	/** register.Register of persons. */
	private Register register;

	/**
	 * In JDK 6 use Console class instead.
	 * 
	 * @see readLine()
	 */
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Menu options.
	 */
	private enum Option {
		PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
	};

	public ConsoleUI(Register register) {
		this.register = register;
	}

	public void run() {
		while (true) {
			switch (showMenu()) {
			case PRINT:
				printRegister();
				break;
			case ADD:
				addToRegister();
				break;
			case UPDATE:
				updateRegister();
				break;
			case REMOVE:
				removeFromRegister();
				break;
			case FIND:
				findInRegister();
				break;
			case EXIT:
				return;
			}
		}
	}

	private String readLine() {
		// In JDK 6.0 and above Console class can be used
		// return System.console().readLine();

		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	private Option showMenu() {
		System.out.println("Menu.");
		for (Option option : Option.values()) {
			System.out.printf("%d. %s%n", option.ordinal() + 1, option);
		}
		System.out.println("-----------------------------------------------");

		int selection = -1;
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(readLine());
		} while (selection <= 0 || selection > Option.values().length);

		return Option.values()[selection - 1];
	}

	private void printRegister() {

		for (int i = 0; i < register.getCount(); i++) {

			System.out.println((i + 1) + ". " + register.getPerson(i));
		}
	}

	private void addToRegister() {

		boolean goodName = false;
		boolean goodPhoneNumber = false;

		System.out.println("Enter Name: ");
		String name = readLine();

		for (int i = 0; i < register.getCount(); i++) {
			if (register.getPerson(i).getName().equals(name)) {
				System.out.println("Person whit this name already exists.");
				goodName = false;
			} else {
				goodName = true;
			}
		}

		System.out.println("Enter Phone Number: ");
		String phoneNumber = readLine();

		for (int i = 0; i < register.getCount(); i++) {
			if (register.getPerson(i).getPhoneNumber().equals(phoneNumber)) {
				System.out.println("Person with this phone number already exists.");
				goodPhoneNumber = false;
			} else {
				goodPhoneNumber = true;
			}
		}

		if (goodName && goodPhoneNumber) {
			register.addPerson(new Person(name, phoneNumber));
		}
	}

	private void updateRegister() {

		System.out.println("Enter index: ");
		int index = Integer.parseInt(readLine());
		Person person = register.getPerson(index - 1);

		System.out.println("Enter New Name: ");
		String name = readLine();
		person.setName(name);

		System.out.println("Enter New Phone Number: ");
		String phoneNumber = readLine();
		person.setPhoneNumber(phoneNumber);

	}

	private void findInRegister() {

		System.out.println("Find by name or phoneNumber? // enter: " + "1" + " for name or " + "2" + " for phone");
		int userInput = Integer.parseInt(readLine());

		if (userInput == 1) {
			System.out.println("Enter Name: ");
			String name = readLine();
			register.findPersonByName(name);
		} else {
			if (userInput == 2) {
				System.out.println("Enter Phone Number: ");
				String phoneNumber = readLine();
				register.findPersonByPhoneNumber(phoneNumber);
			} else {
				System.out.println("Wrong input!");
			}
		}
	}

	private void removeFromRegister() {
		System.out.println("Enter index: ");
		int index = Integer.parseInt(readLine());
		Person person = register.getPerson(index - 1);
		register.removePerson(person);

	}
}
