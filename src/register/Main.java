package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		Register register = new ArrayRegister(20);

		register.addPerson(new Person("Janko Hrasko", "0900123456"));
		register.addPerson(new Person("Peter Novak", "0905654853"));
		register.addPerson(new Person("Karol Klescinsky", "0918456321"));
		register.addPerson(new Person("Juraj Sveda", "0904852963"));
		register.addPerson(new Person("Martin Slavny", "0942356742"));

		// TODO: Utriedenie abedecne
//		String[] helpArray;
//		helpArray = new String[20];
//
//		for (int i = 0; i < register.getCount(); i++) {
//			helpArray[i] = register.getPerson(i).getName();
//		}
//
//		boolean isSwapped = true;
//
//		String helpString;
//		int j = 0;
//
//		while (isSwapped) {
//			isSwapped = false;
//			j++;
//			for (int i = 0; i < helpArray.length - j; i++) {
//				if (helpArray[i] < helpArray[i + 1]) {
//					helpString = helpArray[i];
//					helpArray[i] = helpArray[i + 1];
//					helpArray[i + 1] = helpString;
//					isSwapped = true;
//
//				}
//			}
//		}
		ConsoleUI ui = new ConsoleUI(register);
		ui.run();

	}
}