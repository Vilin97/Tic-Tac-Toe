
public class Cell {
	private String symbol;
	
	public Cell() {
		symbol = " ";
	}
	
	public Cell(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public boolean isEqual(Cell cell) {
		// returns true iff this and cell have the same symbol
		return getSymbol() == cell.getSymbol();
	}
	
	public boolean isEmpty() {
		Cell empty = new Cell();
		return this.isEqual(empty);
	}
	
	public boolean compare(Cell[] cells) {
		// returns true iff cells and this are all the same
		for (int i = 0; i < cells.length; i++) {
			if (!isEqual(cells[i])) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		return symbol;
	}
}
