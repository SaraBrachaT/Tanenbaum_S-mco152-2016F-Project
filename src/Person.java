import java.util.ArrayList;

public class Person {

	private int pid;
	private String firstName; //or title
	private String lastName;
	private Integer age;
	private Gender gender; // enum
	private boolean married; // if so, to who
	private Person spouse; // could be null
	private ArrayList<Restriction> restrictions;
	private ArrayList<Restriction> preferences;

	private static int id = 0;
	
	public Person(String firstName, String lastName, int age, Gender gender, boolean married,
			ArrayList<Restriction> rest, ArrayList<Restriction> pref, Person spouse) {
		// check for valid data, no nulls. If issues throw new exceptions
		int id = ++this.id;
		this.pid = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.married = married;
		restrictions = new ArrayList<Restriction>();
		if(rest != null ){
			for (Restriction r : rest) {
				this.restrictions.add(r);
			}
		}
		if(pref != null){
		preferences = new ArrayList<Restriction>();
		for (Restriction r : pref) {
			this.preferences.add(r);
		}
		}
		this.spouse = spouse; // maybe just do spouse.getName() here, we'll see
								// if we end up using other fields of spouse

	}
	
	public void setSpouse(Person s){
		this.spouse = s;
	}


	public String getName() {
		StringBuilder s = new StringBuilder();

		s.append(firstName);
		s.append(" ");
		s.append(lastName);

		return s.toString();

	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("\nPerson Number: ");
		s.append(id);
		s.append("\nName: ");
		s.append(firstName);
		s.append(" ");
		s.append(lastName);
		s.append("\nAge: ");
		s.append(age);
		s.append("\nGender: ");
		s.append(gender);
		if (married) {
			s.append(spouse.getName());
		}
		if (restrictions!=null) {
			s.append("\nRestrictions: ");
			for (Restriction r : restrictions) {
				s.append(r.getRestrictionDescr().toString());
			}
		}
		if (preferences!=null){
			s.append("\nPreferences: ");
			for (Restriction r : restrictions) {
				s.append(r.getRestrictionDescr().toString());
			}

		}

		return s.toString();
	}
	/*
	 * methods -getters
	 *
	 *
	 *
	 *
	 * -setters spouse
	 *
	 *
	 *
	 * -equals -compareTo //what will be our primary key to compare based on??
	 * Should people be numbered?? Probably, so we can refer to them in code
	 * -toString -findSpouse(primary key) throws PersonNotFoundException
	 * -findSpouse(firstName, lastName) throws PersonNotFoundException
	 */
} // end class
