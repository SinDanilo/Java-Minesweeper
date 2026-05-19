package Player;
import java.io.FileWriter;
import java.io.IOException;
import minesweeper.Board;
import minesweeper.GameOutcome;


public class GameSimulator {
	public Player createBot(Board board) {
		return new Player(board);
	}
	
	public static void main(String[] args) throws IOException {
		FileWriter writer = new FileWriter("src/matches.csv");
		writer.append("MatchId,BotType,Result,TimeMs,TotalClicks\n");
		
		for(int i = 0; i < 1000; i++) {
			Board board = new Board(8, 6);
			Player player = new Player(board);
			long start = System.nanoTime();
			GameOutcome gameOutcome = board.getGameOutcome();
			while(gameOutcome == GameOutcome.IN_PROGRESS) {
				gameOutcome = player.playTurn();
			}

			long end = System.nanoTime();
			double totalTime = (end - start) / 1000000.0f;
			
			LinkedList list = player.getMoveHistory();
		
			NodeMove Node = list.getHead();
			int moveCount = 0;
			while(Node != null) {
				Node = Node.getNext();
				moveCount++;
			}
			
			writer.append(i + "," + "Bot0" + "," + gameOutcome + "," + String.format("%.5f", totalTime) + "," + moveCount + "\n");
		}
		writer.close();
	}
}
