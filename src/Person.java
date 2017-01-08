import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Person {

	private int personID;
	private String firstName; // or title
	private String lastName;
	private int age;
	private char gender;
	private Integer spouseID; // could be null
	private ArrayList<String> restrictions;
	private ArrayList<String> preferences;

	public Person(int pID) throws SQLException {
		retrievePerson(pID);
		retrieveRestrictions(pID);
		retrievePreferences(pID);
	}

	public void retrievePerson(int personID) throws SQLException {

		String queryPerson = "use ShabbosTable select Person.PersonID, FirstName, LastName , Age, Gender, SpouseID from Person where PersonID = "
				+ personID;

		Statement stmt = Game.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(queryPerson);
		

		while(rs.next())
		{
			this.personID = rs.getInt("PersonID");
			this.firstName = rs.getString("FirstName");
			this.lastName = rs.getString("LastName");
			this.age = rs.getInt("Age");
			this.gender = rs.getString("Gender").charAt(0);
			if((Integer)rs.getInt("SpouseID") != null)
			{
				this.spouseID = rs.getInt("SpouseID");
			}
		}
	}
	
	public void retrieveRestrictions(int personID) throws SQLException
	{
		String queryRestriction = "use ShabbosTable select SpecificationDescription from Specification inner join PersonSpecification  on Specification.SpecificationID = PersonSpecification.SpecificationID  inner join Person on  Person.PersonID = PersonSpecification.PersonID where Person.PersonID = "
				+ personID + " and PersonSpecificationType = 'Restriction' ";

		Statement stmt = Game.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(queryRestriction);

		while (rs.next()) {
			this.restrictions.add(rs.getString("SpecificationDescription"));
		}
	}
	
	public void retrievePreferences(int personID) throws SQLException
	{
		String queryPreference = "use ShabbosTable select SpecificationDescription As Preference from Specification inner join PersonSpecification on Specification.SpecificationID = PersonSpecification.SpecificationID inner join Person on  Person.PersonID = PersonSpecification.PersonID where Person.PersonID = "
				+ personID + " and PersonSpecificationType = 'Preference' ";

		Statement stmt = Game.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(queryPreference);

		while (rs.next()) {
			this.preferences.add("Preference");
		}

	}

	public int getPersonID() {
		return personID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public char getGender() {
		return gender;
	}

	public Integer getSpouseID() {
		return spouseID;
	}

	public ArrayList<String> getRestrictions() {
		return restrictions;
	}

	public ArrayList<String> getPreferences() {
		return preferences;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("\nPerson Number: ");
		s.append(personID);
		s.append("\nName: ");
		s.append(firstName);
		s.append(" ");
		s.append(lastName);
		s.append("\nAge: ");
		s.append(age);
		s.append("\nGender: ");
		s.append(gender);
		if(spouseID != null)
		{
			s.append("\nSpouse ID: ");
			s.append(spouseID);
		}
		if (restrictions != null) {
			s.append("\nRestrictions: ");
			for (String r : restrictions) {
				s.append(r);
			}
		}
		if (preferences != null) {
			s.append("\nPreferences: ");
			for (String r : restrictions) {
				s.append(r);
			}

		}

		return s.toString();
	}

}
