package minesweeper;
import java.util.Random;

public class Board {
	int size;
	int numMines;
	Cell[][] board;
	public Board(int size, int numMines) {
		if(size < 0 || size*size < numMines || numMines < 0) {
			throw new IllegalArgumentException("Wrong input");
		}
		this.size = size;
		this.numMines = numMines;
		this.board = new Cell[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				board[i][j] = new Cell(false);
			}
		}
		
		generateMines(this.numMines);
		calculateAdjacentMines();
		
	}
	
	private void generateMines(int n) {
		Random rand = new Random();
		for(int i = 0; i < n; i++) {
			int randX = rand.nextInt(this.size);
			int randY = rand.nextInt(this.size);
			
			while(this.board[randY][randX].getMine()) {
				randX = rand.nextInt(this.size);
				randY = rand.nextInt(this.size);
			}
			this.board[randY][randX].setMine(true);
		}
	}
	
	private void calculateAdjacentMines() {
		int[][] dir = {
			    {-1, -1}, {-1,  0}, {-1,  1},
			    { 0, -1},			{ 0,  1},
			    { 1, -1}, { 1,  0}, { 1,  1}
		};
		
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				int counter = 0;
				for(int k = 0; k < 8; k++) {
					int dx = dir[k][0] + j;
					int dy = dir[k][1] + i;
					
					if(dx >= 0 && dy >= 0 && dx < this.size && dy < this.size) {
						if(this.board[dy][dx].getMine()) {
							counter++;
						}
					}
				}
				this.board[i][j].setAdjacentMines(counter);
			}
		}
	}
	
	public void revealCell(int row, int col) {
		this.board[row][col].setCellState(CellState.REVEALED);
		if(this.board[row][col].getAdjacentMines() != 0)return;
		
		int[][] dir = {
			    {-1, -1}, {-1,  0}, {-1,  1}, { 0, -1},{ 0,  1}, { 1, -1}, { 1,  0}, { 1,  1}
		};
		
		CoordinateQueue queue = new CoordinateQueue();

	    queue.push(row, col);

	    while (!queue.isEmpty()) {

	        int[] current = queue.pop();

	        int currentRow = current[0];
	        int currentCol = current[1];
	        
	        if (board[currentRow][currentCol].getAdjacentMines() != 0) {
	            continue;
	        }

	        for (int i = 0; i < 8; i++) {

	            int newRow = currentRow + dir[i][0];
	            int newCol = currentCol + dir[i][1];

	            if (newRow < 0 || newCol < 0 ||
	                newRow >= size || newCol >= size) {
	                continue;
	            }

	            if (board[newRow][newCol].getMine() ||
	                board[newRow][newCol].getCellState() == CellState.REVEALED) {
	                continue;
	            }

	            board[newRow][newCol].setCellState(CellState.REVEALED);

	            if (board[newRow][newCol].getAdjacentMines() == 0) {
	                queue.push(newRow, newCol);
	            }
	        }
	    }
		
	}
	
	public GameOutcome getGameOutcome() {
		boolean isOver = false;
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				if(this.board[i][j].getCellState() == CellState.REVEALED && this.board[i][j].getMine()) {
					return GameOutcome.DEFEAT;
				}else if(!this.board[i][j].getMine() && this.board[i][j].getCellState() == CellState.HIDDEN) {
					isOver = true;
				}
			}
		}
		if(isOver) return GameOutcome.IN_PROGRESS;
		return GameOutcome.VICTORY;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isRevealed(int x, int y) {
		return this.board[x][y].getCellState() == CellState.REVEALED;
	}
	
	public boolean isMine(int x, int y) {
		return this.board[x][y].getMine();
	}
}
