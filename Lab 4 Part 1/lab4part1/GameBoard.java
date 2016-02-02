package lab4part1;

public class GameBoard {

	private static int rows = 4;
	private static int columns = 4;
	private static char[][] board = new char[rows][columns];

	public GameBoard(int rows, int columns, char[][] board) {
		this.rows = rows;
		this.columns = columns;
		this.board = board;
	}

	public static void makeBoard() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public static void printBoard() {

		for (char[] i : board) {
			System.out.println("\t------------------------");
			for (char j : i) {
				System.out.print("\t|" + j);
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}
}
