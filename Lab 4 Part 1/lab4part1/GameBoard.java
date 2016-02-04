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


//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//			}
//		}
//	}

		// Create all combinations of tile
		for (int i = 0; i < Tile.getTileTypes().size(); i++) {
			for (int j = 0; j < Tile.getTileTypes().size(); j++) {
				// Avoid making "sun, sun" tiles (for example)
				if (j != i) {
					// Assuming the constructor takes in 2 ints - one for tileOne and one for tileTwo
//					TilesArray.add(new Tile(i, j));
//					Tile.getTileTypes().add(new Tile());
//					Tile.getTileTypes().add(i, j);
				}
			}
		}


		// Assign tiles to gameboard
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				// Randomise array
				Collections.shuffle(Tile.getTileTypes());
				// Take the first element
//				board[i][j] = Tile.setTileTypes();
				// Remove the first element
//				Tile.getTileTypes().remove(0)
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

	public static void assignTiles() {

		for (int i = 0; i < Tile.getTileTypes().size(); i++) {

			Tile.setIconOne(Tile.getTileTypes().get(Tile.getRandom().nextInt(Tile.getTileTypes().size())));
//			System.out.println(Tile.getIconOne());
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
