import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {

	private int levelNum;
	private ArrayList<Round> rounds;
	private ArrayList<String> levelRules;
	private String passCode;
	//this is temporary
	private Round currentRound;
	
	private static int numRounds = 5;
	
	public Level(int level, String passCode) throws FileNotFoundException {
		this.passCode = passCode;
		this.levelNum = level;
		this.rounds = new ArrayList<Round>();
		instantiateRounds();
		this.levelRules = new ArrayList<String>();
		this.currentRound = rounds.get(0);
		instantiateRules();
	}
	
	public Round getCurrentRound(){
		return this.currentRound;
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
	
	public String getPasscode(){
		return this.passCode;
	}
	
	

	/*
	public static void main(String[] args)
	{
		Level l;
		try{
		l = new Level(1, "abc1");
		System.out.println(l.getLevelRules());

		l = new Level(1, "abc1");
		System.out.println(l.rounds.get(0).getPuzzle().getSolutions());
		}
		catch(FileNotFoundException e){
			System.out.println("There was an error connecting to the file...contact IT");
		}
	}
	*/
}
