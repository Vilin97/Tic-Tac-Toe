import java.util.Scanner;

public class TTT {
	private Player[] players;
	private int numberOfDraws;
	private static String board = "+-+-+-+\n|1|2|3|\n+-+-+-+\n|4|5|6|\n+-+-+-+\n|7|8|9|\n+-+-+-+\n";
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Tic-Tac-Toe!");
		System.out.println("Enter the name of the first (X) player:");
		String name1 = input.next();
		Player player1 = new Player(name1, "X", true); 
		System.out.println("Enter the name of the second (O) player:");
		String name2 = input.next();
		Player player2 = new Player(name2, "O", false); 
		System.out.println("To make a move, enter the number corresponding to the square you chose:\n"+TTT.board);
		Player[] players = {player1, player2};
		TTT myTTT = new TTT(players);
		while (true) {
			myTTT.playGame();
			System.out.println("Would you like to play again? (y for yes, any key for no)");
			String ans = input.next();
			if (!ans.equals("y")) {
				System.out.println(myTTT);
				System.out.println("Thank you for playing. Have a lovely day.");
				break;
			}
			System.out.println("So far, " + myTTT);
		}
		input.close();
	}
	
	public String toString() {
		String s = "";
		s += players[0].toString() + " ";
		s += players[1].toString() + " ";
		s += String.format("Draw happened %d times", numberOfDraws);
		return s;
	}
	
	private TTT (Player[] players) {
		this.players = players;
		this.numberOfDraws = 0;
	}
	
	private void playGame () {
		Scanner in = new Scanner(System.in);
		Board myBoard = new Board();
		int counter = 0;
		System.out.println(myBoard);
		while (true) {
			int i = counter % 2;
			System.out.println(String.format("%s, enter your move:", players[i].getName()));
			boolean moveOk = false;
			while (!moveOk) {
				int move = in.nextInt();
				moveOk = myBoard.makeMove(move, players[i].getSymbol());
				if (!moveOk) {
					System.out.println("There was a problem with your move. Try again:");
				}
			}
			System.out.println(myBoard);
			if (myBoard.Win(players[0])) {
				System.out.println(String.format("%s wins!", players[0].getName()));
				players[0].incrementWins();
				break;
			}
			if (myBoard.Win(players[1])) {
				System.out.println(String.format("%s wins!", players[1].getName()));
				players[1].incrementWins();
				break;
			}
			counter += 1;
			if (counter == 9) {
				System.out.println("It's a draw!");
				numberOfDraws += 1;
				break;
			}
		}
	}
}
