import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Game {  //serializable

	private String[] gameRules;
	private Integer gameScore;
	private Level currentLevel;
	private String userName;
	
	private static Connection dbConnection;
	
	private final int numLevels = 5;
	
	//New Game Constructor
	public Game() throws FileNotFoundException, SQLException {
		connect();
		currentLevel = new Level(1);
		gameScore = 0;
		gameRules = new String[3];  //get the rules from TT
		instantiateGameRules();
				
	}

	public void Game(String userName)
	{
		//TODO
	}
	
	public void playGame()
	{
		//TODO
	}
	
	public Connection connect() throws FileNotFoundException, SQLException
	{
		Connection conn = null;
		final String DATABASE_URL = "jdbc:sqlserver://DESKTOP-588999M\\SQLEXPRESS:63506;" + "databaseName=ShabbosTable"; //does the same thing regardless of whether or not the ; is there after the db name

		conn = DriverManager.getConnection(DATABASE_URL, "ShabbosTableLogin", "TableShabbos");
		conn.setAutoCommit(false);
		return conn;
	}
	
	private void instantiateGameRules() {
		//TODO
	}
	
	public void setUsername(String user)
	{
		this.userName = user;
	}
	public int getScore() { 
		int score =  this.gameScore;
		return score;
	}
	
	public Level getCurrentLevel(){
		return this.currentLevel;
	}
	
	public static Connection getConnection()
	{
		Connection c = Game.dbConnection;
		return c;
	}

	private String getGameRules() {
		
		
		StringBuffer s = new StringBuffer();
		s.append("\nObject of the Game: \n You will see a list of people, their specifications "
				+ "and a table format, you must figure out a way to seat them around the table.\n Game general rules:\n");
		for(String st : gameRules)
		{
			s.append(st);
		}
		return s.toString();
	}
	}