import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Puzzle {

	private int level;
	private int round;
	private String levelS;
	private String roundS;
	private String tableDisplay;
	
	public Puzzle(int l, int r)
	{
		level = l;
		round = r;
	}
	
	public ArrayList<Integer> getSolutions() throws FileNotFoundException
	{
		ArrayList<Integer> solutions = new ArrayList<Integer>();
		String puzzleNum = getPuzzleNumAsString();
		String fileName = (puzzleNum + ".txt");
		File solutionFile = new File(fileName);
		Scanner fileInput = new Scanner(solutionFile);
		
		while(fileInput.hasNextLine())
		{
			solutions.add(fileInput.nextInt());
		}
		
		return solutions;
	}
	
	public String getPuzzleNumAsString()
	{
		switch (level)
		{
		case 1:
			levelS = "one";
			break;
		case 2:
			levelS = "two";
			break;
		case 3:
			levelS = "three";
			break;
		case 4: 
			levelS = "four";
			break;
		}
		switch (round)
		{
			case 1:
				roundS = "one";
				break;
			case 2:
				roundS = "two";
				break;
			case 3: 
				roundS = "three";
				break;
			case 4:
				roundS = "four";
				break;
		}
		String puzzleNum = (levelS + "-" + roundS);
		return puzzleNum;
		
	}
	
	public void connect() throws SQLException {
		Connection dbConnection = null;
		final String DATABASE_URL = "jdbc:sqlserver://DESKTOP-588999M//SQLEXPRESS:63506;" + "databaseName=ShabbosTable;";
		try {
			// to connect using windows authentication on my laptop
		//	dbConnection = DriverManager.getConnection(DATABASE_URL);
			dbConnection = DriverManager.getConnection(DATABASE_URL, "ShabbosTableLogin", "TableShabbos");
			// to enable transaction processing do not automatically commit (bec no 'undo' but what if or...)
			dbConnection.setAutoCommit(false);
			
			viewTable(dbConnection, "ShabbosTable");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("In other words... didn't connect");

		}
		
		String query = "Select * FROM Person";
		try{
			ArrayList<String> people = new ArrayList<String>();
			
		}
		catch(Exception e){
			System.out.println("Exception caught");
		}

		
	}
	
	public void viewTable(Connection con, String dbName) throws SQLException {

		Statement stmt = null;
		String query = "select Title, LastName " + "Age, Gender " + "from " + dbName + ".Person"; // took out: isNull(FirstName,'');

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


	
	public void tableDisplay()
	{
		//Also from file?
	}
	public static void main(String[] args)
	{
		Level l = new Level(1,1);
		Round r = new Round(1,1);
		Puzzle puz = new Puzzle(1,1);
		try {
			puz.connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println(puz.getSolutions());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
