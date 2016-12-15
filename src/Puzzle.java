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
	private ArrayList<String> solutions;
	private ArrayList<String> people;
	private String tableDisplay;
	
	public Puzzle(int l, int r)
	{
		level = l;
		round = r;
		solutions = new ArrayList<String>();
		people = new ArrayList<String>();
	}
	
	public ArrayList<String> setUpSolutions() throws FileNotFoundException
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
			solutions.add(fileInput.nextLine());
		}
		
		return solutions;
	}

	
	public void connect() throws SQLException, FileNotFoundException {
		Connection dbConnection = null;
		final String DATABASE_URL = "jdbc:sqlserver://DESKTOP-588999M\\SQLEXPRESS:63506;" + "databaseName=ShabbosTable"; //does the same thing regardless of whether or not the ; is there after the db name

		try {
			dbConnection = DriverManager.getConnection(DATABASE_URL, "ShabbosTableLogin", "TableShabbos");
			dbConnection.setAutoCommit(false);
			viewPeople(dbConnection, "ShabbosTable");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("In other words... didn't connect");
		}
		
			
	}
	
	public void viewPeople(Connection con, String dbName) throws SQLException, FileNotFoundException {
		ArrayList<Integer> peopleIds = getPeopleIDs();

		Statement stmt = null;
		
		for(int i = 0; i < peopleIds.size(); i++){
			int j = peopleIds.get(i);
			String query = ("use ShabbosTable select FirstName, LastName, Age, Gender " + "from " + "Person" + " where PersonID ='" + j + "' "); 
			try {
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					String name = rs.getString("LastName");
					System.out.println(name);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				if (stmt != null) {
					stmt.close();
				}
			}
		}


		
	}

	public ArrayList<Integer> getPeopleIDs() throws FileNotFoundException
	{
		ArrayList<Integer> ids = new ArrayList<Integer>();
		String puzzleNum =(level + "-" + round);
		String fileName = (puzzleNum + ".txt");
		File solutionFile = new File(fileName);
		Scanner fileInput = new Scanner(solutionFile);
		while (fileInput.hasNextLine()) 
		{
			if (fileInput.next().equals("PersonID")) 
			{
				break;
			}
		}
		while (fileInput.hasNextInt())
		{
			ids.add(fileInput.nextInt());
		}
		System.out.println(ids.toString());
		return ids;
	
	}
	
	public ArrayList<String> getSolutions()
	{
		return this.solutions;
	}
	
	public String getTableDisplay() throws FileNotFoundException
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
		return sb.toString();
	}
	
	public String getPeople()
	{
		return people.toString();
	}
	
	/*
	public static void main(String[] args)
	{
		Level l = new Level();
		Round r = new Round(1,1);
		Puzzle puz = new Puzzle(1,1);
		try {
			puz.connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(puz.setUpSolutions());
			puz.getPeople();
			puz.getPeopleIDs();
			puz.setUpSolutions();
			puz.getSolutions();
			puz.getTableDisplay();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
