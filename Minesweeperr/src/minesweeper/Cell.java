package minesweeper;

public class Cell {

	private Boolean mine;
	private CellState cellState;
	private int adjacentMines;
	
	public Cell(boolean Mine) {
        this.mine = Mine;
        this.cellState = CellState.HIDDEN;
        this.adjacentMines = 0;
    }

	public Boolean getMine() {
		return mine;
	}

	public void setMine(Boolean mine) {
		this.mine = mine;
	}

	public CellState getCellState() {
		return cellState;
	}

	public void setCellState(CellState cellState) {
		this.cellState = cellState;
	}

	public int getAdjacentMines() {
		return adjacentMines;
	}

	public void setAdjacentMines(int adjacentMines) {
		this.adjacentMines = adjacentMines;
	}
	
	
}
