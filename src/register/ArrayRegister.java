package register;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
	/** register.Person array. */
	private Person[] persons;

	/** Number of persons in this register. */
	private int count;

	/**
	 * Constructor creates an empty register with maximum size specified.
	 * 
	 * @param size
	 *            maximum size of the register
	 */
	public ArrayRegister(int size) {
		persons = new Person[size];
		count = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getCount()
	 */
	@Override
	public int getCount() {
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getSize()
	 */
	@Override
	public int getSize() {
		return persons.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getPerson(int)
	 */
	@Override
	public Person getPerson(int index) {
		return persons[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#addPerson(register.Person)
	 */
	@Override
	public void addPerson(Person person) {
		persons[count] = person;
		count++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#findPersonByName(java.lang.String)
	 */
	@Override
	public Person findPersonByName(String name) {

		Person help = new Person("0", "0");

		for (int i = 0; i < getCount(); i++) {

			if (name.equals(getPerson(i).getName())) {
				System.out.println(getPerson(i));
				help = getPerson(i);
				break;
			}
			if (i == getCount() - 1) {
				System.out.println("Person not found.");
				help = null;
				break;
			}
		}
		return help;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#findPersonByPhoneNumber(java.lang.String)
	 */
	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) {

		Person help = new Person("0", "0");

		for (int i = 0; i < getCount(); i++) {

			if (phoneNumber.equals(getPerson(i).getPhoneNumber())) {
				System.out.println(getPerson(i));
				help = getPerson(i);
				break;
			}
			if (i == getCount() - 1) {
				System.out.println("Person not found.");
				help = null;
				break;
			}
		}
		return help;
	}

	// TODO: Implement the method removePerson
	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#removePerson(register.Person)
	 */
	@Override
	public void removePerson(Person person) {

		for (int i = 0; i < getCount(); i++) {
			if (person == getPerson(i)) {
				for (int z = i + 1; z < getCount(); z++) {
					Person person2 = getPerson(z - 1);
					person2.setName(getPerson(z).getName());
					person2.setPhoneNumber(getPerson(z).getPhoneNumber());
				}
			}
		}
		count--;
	}
}
