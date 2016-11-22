
public class Game {

	private String[] gameRules;
	private Integer score;
	private Level level;
	private Round round;

	public Game() {
		this.gameRules = getGameRules();
		System.out.println(displayRules());

		score = 0;
	}

	public Game(int level, int round) {
		super();
		// score = retrieve from .ser
		startGame(level, round);
	}

	public int getScore() { // for Scorekeeper
		return this.score;
	}

	public int getScoreCopy() { // for display purposes
		int retrieveScore = this.score;
		return retrieveScore;
	}

	public void startGame(int level, int round) {
		// Level level = new Level(level, round);
	}

	public String[] getGameRules() {
		gameRules = new String[4];
		gameRules[0] = "Males and females over age 9 cannot sit next to each other";
		gameRules[1] = "Children under age 1 must sit next to a parent or grandparent";
		gameRules[2] = "Any couple within the first year of marriage must sit together";
		gameRules[3] = "Children under age 4 cannot sit next to the candles";

		return gameRules; // do with return although field so can be called from
							// other classes if necessary

	}

	public String displayRules() {
		StringBuffer s = new StringBuffer();
		s.append("\nThe Rules of the Game: \n");
		for (int i = 0; i < this.gameRules.length; i++) {
			s.append("\n");
			s.append(gameRules[i]);
		}
		return s.toString();
	}
}
