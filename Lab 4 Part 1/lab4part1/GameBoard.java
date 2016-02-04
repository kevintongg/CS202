package lab4part1;

import java.util.Collections;

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


		for (Tile[] i : board) {
			for (Tile j : i) {
				Collections.shuffle(Tile.getTileTypes());
				Tile.setIconOne(Tile.getTileTypes().get(0));
				Tile.setIconTwo(Tile.getTileTypes().get(1));
			}
		}
	}

	public static void printBoard() {

		for (Tile[] i : board) {
			System.out.println("\t------------------------");
			for (Tile j : i) {
				System.out.print("\t|" + j);
			}
			System.out.println();
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

	public static Tile[][] getBoard() {
		return board;
	}

	public static void setBoard(Tile[][] board) {
		GameBoard.board = board;
	}
}
