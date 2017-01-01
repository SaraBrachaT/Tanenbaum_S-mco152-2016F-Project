import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Game {  //serializable

	private String[] gameRules;
	private Integer gameScore;
	private Round currentRound;   //? Do we need to store this   
	private Level currentLevel;
	private String userName;
	
	private final int numLevels = 5;
	
	//New Game Constructor
	public Game() throws FileNotFoundException, SQLException {
		currentLevel = new Level(1);
		gameScore = 0;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		this.gameRules = getGameRules();
		this.gameScore = 0;
		this.levels = new Level[numLevels];
		//instantiateLevels();
		this.currentLevel = new Level(1);
	}

	public void Game(int levelNum, String password)
	{
		//TODO
	}
	
	public void Game(String userName)
	{
		//TODO
	}
	
	public void playGame()
	{
		//TODO
		/*
		 * this will be uses and fixed when we have a bunch of levels to work with, for now we only have 1
	public void doLevels(){
		for(int i = 0; i < this.levels.length; i++){
			
		}
	}
		 */
	}
	//the pass codes are left simple now, really this info should be read in from a file
	/*
	private void instantiateLevels() throws FileNotFoundException{
		for(int i= 0; i < levels.length; i++){
			levels[i] = new Level((i+1), ("ttsbtmbg" + i));
		}
	}
	*/
	public int getScore() { 
		int score =  this.gameScore;
		return score;
	}
	
	public Level getCurrentLevel(){
		return this.currentLevel;
	}

	private String getGameRules() {
		gameRules = new String[3];
		gameRules[0] = "Males and females over age 9 cannot sit next to each other";
		gameRules[1] = "Children under age 1 must sit next to a parent or grandparent";
		gameRules[2] = "Any couple within the first year of marriage must sit together";
		
		StringBuffer s = new StringBuffer();
		s.append("\nObject of the Game: \n You will see a list of people, their specifications "
				+ "and a table format, you must figure out a way to seat them around the table.\n Game general rules:\n");
		for (int i = 0; i < this.gameRules.length; i++) {
			s.append("\n");
			s.append(gameRules[i]);
		}
		return s.toString();
	}
	

	public Round getCurrentRound()
	{
		return this.currentRound;
	}
	

	public static void main(String []args){
		try{
			Game shabbosTable = new Game();
			boolean won = false; //put in round
			while(!won){
			System.out.println(shabbosTable.displayRules());
			System.out.println(shabbosTable.displayLevelRules());
			
			System.out.println(shabbosTable.getCurrentLevel().getCurrentRound().getRoundDisplay());
			
			System.out.println("Enter your solution starting from the left head, moving clockwise."
					+ " Make sure to enter a - between each number. Sample input: 2-5-6-1-3-4");
			Scanner user = new Scanner(System.in);
			String UserAnswer = user.nextLine();
			for(int i=0; i<shabbosTable.getCurrentLevel().getCurrentRound().getPuzzle().getSolutions().size(); i++)
			{
				if(UserAnswer.equals(shabbosTable.getCurrentLevel().getCurrentRound().getPuzzle().getSolutions().get(i)))
					{
						System.out.println("Great Job, You got it! You won the game!");
						won = true;
						//obviously, when our project is finished at this point the user would be given the next level
					}
			}
			if(!won){
				System.out.println("Sorry, that was the wrong answer, try again!");
			}
			
			}
			
			System.exit(0);
		}
		catch(FileNotFoundException e){
			System.out.println("We are sorry, something went wrong with the file system. Closing application...Contact IT.");
			System.exit(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}