import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Puzzle {

	private int level;
	private int round;
	private ArrayList<Integer> solutions;
	private ArrayList<String> people;
	private String tableDisplay;
	
	public Puzzle(int l, int r)
	{
		level = l;
		round = r;
		solutions = new ArrayList<Integer>();
		people = new ArrayList<String>();
	}
	
	public ArrayList<Integer> setUpSolutions() throws FileNotFoundException
	{
		String puzzleNum =(level + "-" + round);
		String fileName = (puzzleNum + ".txt");
		File solutionFile = new File(fileName);
		Scanner fileInput = new Scanner(solutionFile);
		while (fileInput.hasNextLine()) 
		{
			if (fileInput.next().equals("Solution")) 
			{
				break;
			}
		}
	
		while(fileInput.hasNextInt())
		{
			solutions.add(fileInput.nextInt());
		}
		
		return solutions;
	}

	
	public void connect() throws SQLException {
		Connection dbConnection = null;
		final String DATABASE_URL = "jdbc:sqlserver://DESKTOP-588999M\\SQLEXPRESS:63506;" + "databaseName=ShabbosTable"; //does the same thing regardless of whether or not the ; is there after the db name
	       
		try {
			// to connect using windows authentication on my laptop
		//	dbConnection = DriverManager.getConnection(DATABASE_URL);
			dbConnection = DriverManager.getConnection(DATABASE_URL, "ShabbosTableLogin", "TableShabbos");
			JOptionPane.showMessageDialog(null, "connected to TCRealEstateAgency database");
			// to enable transaction processing do not automatically commit (bec no 'undo' but what if or...)
			dbConnection.setAutoCommit(false);
			
			viewTable(dbConnection, "ShabbosTable");

		} catch (SQLException sqlException) {
			JOptionPane.showMessageDialog(null,"connection not completed " + sqlException.getMessage());
			sqlException.printStackTrace();
			System.out.println("In other words... didn't connect");

		}
		
		String query = "Select * FROM Person";		
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

	public ArrayList<Integer> getSolutions()
	{
		return this.solutions;
	}
	
	public void tableDisplay() throws FileNotFoundException
	{
		StringBuffer sb = new StringBuffer();
		String puzzleNum = level + "-" + round;
		String fileName = (puzzleNum + ".txt");
		File solutionFile = new File(fileName);
		Scanner fileInput = new Scanner(solutionFile);
		while (fileInput.hasNextLine()) {
			if (fileInput.next().equals("TableSetup")) {
				break;
			}
		}
		while (fileInput.hasNextLine()) {
			sb.append(fileInput.nextLine());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void main(String[] args)
	{
		Level l = new Level(1);
		Round r = new Round(1,1);
		Puzzle puz = new Puzzle(1,1);
		/*try {
			puz.connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}*/
		try {
			System.out.println(puz.setUpSolutions());
			puz.tableDisplay();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
