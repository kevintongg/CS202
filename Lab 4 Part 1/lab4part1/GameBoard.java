package lab4part1;

import java.util.Collections;

import static lab4part1.Tile.getTileTypes;

public class GameBoard {

	private static int rows = 4;
	private static int columns = 4;
	private static Tile[][] board = new Tile[rows][columns];

	public GameBoard(int rows, int columns, Tile[][] board) {
		this.rows = rows;
		this.columns = columns;
		this.board = board;

	}

	public static void makeBoard() {

		System.out.println(board.length + " " + board[0].length);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				Collections.shuffle(getTileTypes());
				Tile boardTile = new Tile(getTileTypes().get(0), getTileTypes().get(1));
				board[i][j] = boardTile;
			}
		}
	}

	public static void printBoard() {

		for (Tile[] i : board) {
			System.out.println("\t-------------------------------------------------------------");
			for (Tile j : i) {
				System.out.print("\t|\t" + j);
			}
			System.out.println();
		}
		System.out.println("\n----------\n");
	}

	public static Tile[][] getBoard() {
		return board;
	}

	public static void setBoard(Tile[][] board) {
		GameBoard.board = board;
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
}
