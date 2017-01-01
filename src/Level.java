import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {

	private int levelNum;
	private ArrayList<String> levelRules;
	private Round currentRound;
	private int levelScore;
	
	private static int numRounds = 5;
	
	public Level(int level) throws FileNotFoundException, SQLException {
		this.levelNum = level;
		this.levelRules = new ArrayList<String>();
		this.currentRound = new Round(levelNum, 1);
		instantiateRules();
	}

	public void playRounds()
	{
		//TODO
		
	}
	
	public void instantiateRules() throws FileNotFoundException
	{
		String fileName = (levelNum + ".txt");
		File rulesFile = new File("LevelRules\\" + fileName);
		Scanner fileInput = new Scanner(rulesFile);
		
		while(fileInput.hasNextLine())
		{
			levelRules.add(fileInput.nextLine());
		}

	}
	
	public void calculateLevelScore()
	{
		//TODO
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
		//TODO
		sb.append("\nLevel Rules:");
		sb.append(getLevelRules());
		
		
		return sb.toString();
	}
}
