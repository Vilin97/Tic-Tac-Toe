public class Player {
	private String symbol;
	private String name; 
	private boolean goesFirst;
	private int winsSoFar;
	
	public Player(String name, String symbol, boolean goesFirst) {
		this.name = name;
		this.symbol = symbol;
		this.goesFirst = goesFirst;
		this.winsSoFar = 0;
	}
	
	public String toString() {
		return String.format("%s won %d times.", name, winsSoFar);
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean goesFirst() {
		return this.goesFirst;
	}
	
	public void setGoesFirst(boolean goesFirst) {
		this.goesFirst = goesFirst;
	}
	
	public int getWins() {
		return this.winsSoFar;
	}
	
	private void setWins(int wins) {
		this.winsSoFar = wins;
	}
	
	public void incrementWins() {
		this.winsSoFar = this.winsSoFar + 1;
	}
}