import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {

	private int levelNum;
	private ArrayList<String> levelRules;
	private Round currentRound;
	private int levelScore;
	
	private static int numRounds = 4;
	
	public Level(int level) throws SQLException {
		this.levelNum = level;
		this.levelRules = new ArrayList<String>();
		this.currentRound = new Round(levelNum, 1);
		instantiateRules();
	}

	public void playLevel() throws SQLException
	{
		
		while(currentRound.getRoundNum() <= numRounds)
		{
			System.out.println(toString());
			System.out.println(currentRound.playRound());
			Scanner keyboard = new Scanner(System.in);
			String answer = keyboard.nextLine();
			LocalTime endTime = LocalTime.now();
			currentRound.afterPuzzle(answer, endTime);
			levelScore += currentRound.getRoundScore();
			
			currentRound = new Round(levelNum, currentRound.getRoundNum()+1);
		}
	}
	
	public void instantiateRules() throws SQLException
	{
		String query = "use ShabbosTable select RuleDescription from LevelRule inner join Rules on LevelRule.RuleID = Rules.RuleID where LevelNum = " + this.levelNum;
		Connection con = Game.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next())
		{
			this.levelRules.add(rs.getString("RuleDescription"));
		}

	}

	public int getLevelScore()
	{
		return this.levelScore;
	}
	
	public int getLevelNum(){
		return this.levelNum;
	}
	
	public ArrayList<String> getLevelRules()
	{
		return this.levelRules;
	}

	public Round getCurrentRound(){
		return this.currentRound;
	}
	
	public int getNumRounds()
	{
		return Level.numRounds;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\nLevel Rules:");
		for(String s : levelRules)
		{
			sb.append(s);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
