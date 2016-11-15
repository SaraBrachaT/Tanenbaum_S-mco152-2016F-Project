
public class Game {

	private String[] gameRules;
	private Integer score;
	private Level level;
	private Round round;
	
	public Game(){
		String[] gameRules = new String[4];
		gameRules[0] = "Males and females over age 9 cannot sit next to each other";
		gameRules[1] = "Children under age 1 must sit next to a parent or grandparent";
		gameRules[2] = "Any couple within the first year of marriage must sit together";
		gameRules[3] = "Children under age 4 cannot sit next to the candles";
		
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < gameRules.length; i++){
			s.append(gameRules[i]);
			s.append("\n");
		}
		System.out.println(s.toString());
		
		score = 0;
	}
	
	
	  public Game(int level, int round){
	  super();
	 // score = retrieve from .ser
	  startGame(level, round); 
	  }
	
	
	public int getScore(){ //for Scorekeeper
		return this.score;
	}
	
	public int getScoreCopy(){  //for display purposes
		int retrieveScore = this.score;
		return retrieveScore;
	}
	
	public void startGame(int level, int round){
//		Level level = new Level(level, round);
	}
}
