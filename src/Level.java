import java.sql.SQLException;

public class Level {

	int levelNum;
	int roundNum;
	String[] levelRules;
	
	public Level(){
		//do data validation
		//put in level rules
		levelNum = 1;
	}
	
	public Level(int level, int round){
		//do data validation
		//put in level rules
		
	}
	
	
	
	
	public void startRound(){
		Round round = new Round(levelNum, roundNum);
	}
	
}
