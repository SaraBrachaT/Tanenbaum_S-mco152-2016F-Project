import java.io.FileNotFoundException;
import java.util.Scanner;

public class Round {
	
	private Puzzle puzzle;
	private int levelNum;
	private int roundNum;

	public Round(int level, int round) {
		this.roundNum = round;
		this.levelNum = level;
		puzzle = new Puzzle(roundNum, levelNum);
	}
	
	public boolean checkSolution(Integer answer) {
		for (String num : puzzle.getSolutions()) {
			if (answer.equals(num)) {
				return true;
			}
		}
		return false;
	}

	public int getRoundNum()
	{
		return roundNum;
	}
	

	public int getLevelNum()
	{
		return this.levelNum;
	}

	public Puzzle getPuzzle()
	{
		return this.puzzle;
	}
	
	public String getRoundDisplay() throws FileNotFoundException
	{
		StringBuffer sb = new StringBuffer();
		sb.append(puzzle.getPeople());
		sb.append(puzzle.getTableDisplay());
		return sb.toString();
	}
}
