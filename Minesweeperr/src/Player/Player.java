package Player;
import minesweeper.Board;
import java.util.Random;
import minesweeper.GameOutcome;

public class Player {
   private Board board;
   LinkedList list;
   
   public Player(Board board){
	   this.board = board;
	   this.list = new LinkedList();
   }
   
   public GameOutcome playTurn() {
	   int size = this.board.getSize();
	   Random rand = new Random();
	   
	   int x = rand.nextInt(size);
	   int y = rand.nextInt(size);
	   while(this.board.isRevealed(x, y)) {
		   x = rand.nextInt(size);
		   y = rand.nextInt(size);
	   }
	   this.board.revealCell(x, y);
	   this.list.insert(new Move(x, y, this.board.isMine(x, y)));
	   return this.board.getGameOutcome();
   }
   
   public LinkedList getMoveHistory() {
		return this.list;
	}
}