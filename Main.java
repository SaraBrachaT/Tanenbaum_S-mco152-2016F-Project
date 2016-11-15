import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		Game g = new Game();
		g.startGame(1,1);
		Level l = new Level();
		l.startRound();
	//	Round r = new Round(); then do people and take it out of round constructor

	}

}
