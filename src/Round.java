import java.sql.SQLException;
import java.util.ArrayList;

public class Round<T extends rounds> {

	private ArrayList<Person> people;
	private int roundNum;
	private Class round;

	public static int MAXROUNDS = 5;

	public Round(int level, int roundNum) {
		this.roundNum = roundNum;
		getPeople();
		System.out.println(people.toString());
		// getRules();
		System.out.println(RoundOne.displayTable());
		RoundOne.solutions();
	}

	public Round(T round){
		round.setUpPeople();
	}

	public void getPeople() {
		people = RoundOne.setUpPeople();
		
	}

	
	/*public static void viewTable(Connection con, String dbName) throws SQLException {

		Statement stmt = null;
		String query = "select Title, LastName " + "Age, Gender " + "from " + dbName + ".Person"; //took this out: isNull(FirstName, '');

		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("LastName");
				int age = rs.getInt("Age");
				System.out.println(name + "\t" + age);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
*/
	/*public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Round r = new Round(1, 1);
	}*/
}
