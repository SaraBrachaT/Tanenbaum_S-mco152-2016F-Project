import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Puzzle {

	private ArrayList<String> solutions;
	private ArrayList<Integer> numPrefsMet;
	private ArrayList<Person> people;
	private Connection dbConnection;
	private String tableDisplay;
	private String puzNum;
	
	public Puzzle(String roundID) throws FileNotFoundException, SQLException
	{
		solutions = new ArrayList<String>();
		numPrefsMet = new ArrayList<Integer>();
		people = new ArrayList<Person>();
		puzNum = roundID;
		this.dbConnection = connect();
	}
	
	public void play() throws FileNotFoundException, SQLException{
		retrievePeople();
		retrieveTableDisplay();
		toString();
	}
	
	public Connection connect() throws FileNotFoundException, SQLException
	{
		Connection conn = null;
		final String DATABASE_URL = "jdbc:sqlserver://DESKTOP-588999M\\SQLEXPRESS:63506;" + "databaseName=ShabbosTable"; //does the same thing regardless of whether or not the ; is there after the db name

		conn = DriverManager.getConnection(DATABASE_URL, "ShabbosTableLogin", "TableShabbos");
		conn.setAutoCommit(false);
		return conn;
	}
	
	public ArrayList<Integer> retrievePeopleIDs() throws SQLException
	{
		ArrayList<Integer> peopleIDs = new ArrayList<Integer>();
		String query = "use ShabbosTable select PersonID from PersonRound where RoundID =" + puzNum;
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next())
		{
			peopleIDs.add(rs.getInt("PersonID"));
		}
	
		return peopleIDs;	
	}
	
	public void retrievePeople() throws SQLException, FileNotFoundException
	{
		ArrayList<Integer> peopleIDs = retrievePeopleIDs();
		for(Integer p : peopleIDs)
		{	
			people.add(new Person(p, this.dbConnection));
		}
		
	}
	
	public ArrayList<String> retrieveSolutions(Connection conn) throws FileNotFoundException, SQLException
	{
		String query = "use ShabbosTable select SolutionDescription, NumPrefsMet from Solutions where RoundID = " + puzNum;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next())
		{
			solutions.add("SolutionDescription");
			numPrefsMet.add(rs.getInt("NumPrefsMet"));
		}
	
		return solutions;
	}
	
	public void retrieveTableDisplay() throws FileNotFoundException, SQLException
	{
		String query = "use ShabbosTable select TableSetup from Rounds where RoundID = " + puzNum;
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		tableDisplay =  rs.getString("TableSetup");
	}
	
	public ArrayList<String> getSolutions()
	{
		return this.solutions;
	}
	
	public int getNumPrefsMet(int sNum)
	{
		return this.numPrefsMet.get(sNum);
	}
	
	public ArrayList<Person> getPeople()
	{
		return people;
	}
	
	public String getTableDisplay()
	{
		return tableDisplay;
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
			sb.append(getPeople());
			sb.append(getTableDisplay());
		return sb.toString();
	}
}
