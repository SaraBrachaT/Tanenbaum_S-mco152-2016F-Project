import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {

	private int levelNum;
	private int numRounds;
	private ArrayList<Round> rounds;
	private ArrayList<String> levelRules;
	
	public Level(int roundsNum) throws FileNotFoundException {
		numRounds = roundsNum;
		levelNum = 1;
		rounds = new ArrayList<Round>();
		levelRules = new ArrayList<String>();
		instantiateRounds();
		instantiateRules();

	}
//do super for multiple constructors in all classes
	
	public Level(int level, int roundsNum) {
		// do data validation
		// put in level rules
		levelNum = level;
	}

	public void instantiateRounds()
	{
		for(int i = 0; i < numRounds; i++)
		{
			rounds.add(new Round(levelNum,i+1));
		}
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
	
	public int getLevelNum(){
		return this.levelNum;
	}
	
	public ArrayList<String> getLevelRules()
	{
		return this.levelRules;
	}

	public static void main(String[] args)
	{
		Level l;
		try {
			l = new Level(1);
			System.out.println(l.getLevelRules());
			
		} catch (FileNotFoundException e) {
			System.out.println("Didn't work! Sorry... (to get level rules)");
		}
		
		try {
			l = new Level(1);
			System.out.println(l.rounds.get(0).getPuzzle().getSolutions());
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't get solutions");
		}
		
	}
}
