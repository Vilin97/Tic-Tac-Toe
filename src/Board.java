import java.util.Arrays;

public class Board {
	private Cell[] position;
	private String[] allowedSymbols;
	
	public Board() {
		this.position = new Cell[9];
		for (int i = 0; i < 9; i++) {
			position[i] = new Cell();
		}
		this.allowedSymbols = new String[] {"X","O"};
	}
	
	public Cell[] getPosition() {
		return this.position;
	}

	private void setPosition(Cell[] position) {
		this.position = position;
	}
	public boolean makeMove(int move, String symb) {
		// returns true iff the move was made iff the move is legal
		Cell[] position = this.getPosition();
		if (move < 1 || move > 9) {
			return false;
		}
		if (!Arrays.asList(allowedSymbols).contains(symb)) {
			return false;
		}
		//System.out.println(Arrays.toString(position));
		if (!position[move-1].isEmpty()) {
			return false;
		}
		position = this.getPosition();
		position[move-1] = new Cell(symb);
		this.setPosition(position);
		return true;
	}
	
	public String toString() {
		String s = "+-+-+-+\n";
		s += String.format("|%s|%s|%s|\n", position[0],position[1],position[2]);
		s += "+-+-+-+\n";
		s += String.format("|%s|%s|%s|\n", position[3],position[4],position[5]);
		s += "+-+-+-+\n";
		s += String.format("|%s|%s|%s|\n", position[6],position[7],position[8]);
		s += "+-+-+-+\n";
		return s;
	}
	public boolean Win(Player player) {
		// returns true iff player won
		String symbol = player.getSymbol();
		position = this.getPosition();
		for (int i = 0; i <= 2; i++) {
			Cell[] arr = {position[i+3],position[i+6]}; 
			if ( position[i].compare(arr) && position[i].getSymbol() == symbol ) {
				return true;
			}
			arr = new Cell[] {position[3*i+1],position[3*i+2]};
			if ( position[3*i].compare(arr) && position[3*i].getSymbol() == symbol ) {
				return true;
			}
		}
		Cell[] arr = new Cell[] {position[4],position[8]};
		if ( position[0].compare(arr) && position[0].getSymbol() == symbol) {
			return true;
		}
		arr = new Cell[] {position[4],position[6]};
		if ( position[2].compare(arr) && position[2].getSymbol() == symbol) {
			return true;
		}
		return false;
	}
}
