import java.io.FileNotFoundException;
import java.sql.Connection;
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
	}

	public void retrievePerson(int personID) throws SQLException {

		Statement stmt = null;

		String queryPerson = "use ShabbosTable select Person.PersonID, FirstName, LastName , Age, Gender, SpouseID from Person where PersonID = "
				+ personID;

		stmt = Game.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(queryPerson);

		this.personID = rs.getInt("PersonID");
		this.firstName = rs.getString("FirstName");
		this.lastName = rs.getString("LastName");
		this.age = rs.getInt("Age");
		this.gender = rs.getString("Gender").charAt(0);

		String queryRestriction = "use ShabbosTable select SpecificationDescription As Restriction from Specification inner join PersonSpecification  on Specification.SpecificationID = PersonSpecification.SpecificationID  inner join Person on  Person.PersonID = PersonSpecification.PersonID where Person.PersonID = "
				+ personID + " and PersonSpecificationType = 'Restriction' ";

		stmt = Game.getConnection().createStatement();
		ResultSet rs2 = stmt.executeQuery(queryRestriction);

		while (rs.next()) {
			this.restrictions.add(rs.getString("Restriction"));
		}

		String queryPreference = "use ShabbosTable select SpecificationDescription As Preference from Specification inner join PersonSpecification on Specification.SpecificationID = PersonSpecification.SpecificationID inner join Person on  Person.PersonID = PersonSpecification.PersonID where Person.PersonID = "
				+ personID + " and PersonSpecificationType = 'Preference' ";

		stmt = Game.getConnection().createStatement();
		ResultSet rs3 = stmt.executeQuery(queryPreference);

		while (rs.next()) {
			this.preferences.add("Preference");
		}
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
