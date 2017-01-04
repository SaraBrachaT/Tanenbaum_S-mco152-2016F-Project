import java.io.FileNotFoundException;
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
	
	public Level(int level) throws FileNotFoundException, SQLException {
		this.levelNum = level;
		this.levelRules = new ArrayList<String>();
		this.currentRound = new Round(levelNum, 1);
		instantiateRules();
	}

	public void playLevel() throws FileNotFoundException, SQLException
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
			
			int temp = currentRound.getRoundNum();
			currentRound = new Round(levelNum, ++temp);
		}
	}
	
	public void instantiateRules() throws FileNotFoundException, SQLException
	{
		String query = "use ShabbosTable select RuleDescription from LevelRule inner join Rules on LevelRule.RuleID = Rules.RuleID where LevelNum = " + this.levelNum;
		Statement stmt = Game.getConnection().createStatement();
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
