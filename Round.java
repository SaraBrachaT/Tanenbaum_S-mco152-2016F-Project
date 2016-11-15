import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.DriverManager;

public class Round {

	private ArrayList<String> people;
	private int roundNum;

	public static int MAXROUNDS = 5;

	public Round(int level, int roundNum) {
		this.roundNum = roundNum;
		getPeople();
		// getRules();
	}

	public void getPeople() {

		
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
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Round r = new Round(1, 1);
	}
}
