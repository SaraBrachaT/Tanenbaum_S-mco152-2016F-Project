import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;

public class Round {
	
///	private ArrayList<Person> people;
///	private ArrayList<Integer> solutions;
	private Puzzle puzzle;
	private int levelNum;
	private int roundNum;
///	private Class round;
///	public static int MAXROUNDS = 5;

	public Round(int level, int round) {
		this.roundNum = round;
//		getPeople();
	//	System.out.println(people.toString());
		// getRules();
	//	System.out.println(RoundOne.displayTable());
	//	RoundOne.solutions();
		this.levelNum = level;
		puzzle = new Puzzle(roundNum, levelNum);
	}

	public Round(Round round) {
		puzzle = new Puzzle(round.getRoundNum(), round.getLevelNum());
	}
	
	public static boolean checkSolution() {
		Scanner i = new Scanner(System.in);
		Integer answer = i.nextInt(); // autoboxing
		for (Integer num : puzzle.getSolutions()) {
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
}
