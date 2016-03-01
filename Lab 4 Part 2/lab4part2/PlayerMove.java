package lab4part2;

import lab4part2.Tile.CurrentTileToken;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lab4part2.GameBoard.getBoard;

public class PlayerMove {

	private static Turn player = Turn.RED;
	private static int rows;
	private static int columns;
	private static Scanner sc = new Scanner(System.in);
	private static List<PlayerMove> moves = new ArrayList<>();

	public PlayerMove(Turn player, int rows, int columns) {
		PlayerMove.player = player;
		PlayerMove.rows = rows;
		PlayerMove.columns = columns;
	}

	public static void userInput() {

		do {
			System.out.println("Enter the row index you would like to occupy (0 to 3): ");
			typeValidation();
			rows = sc.nextInt();
			if (rows < 0 || rows > 3) {
				System.out.println("A value between 0 and 3, please!");
			}
		} while (rows < 0 || rows > 3);

		do {
			System.out.println("Enter the column index you would like to occupy (0 to 3): ");
			typeValidation();
			columns = sc.nextInt();
			if (columns < 0 || columns > 3) {
				System.out.println("A value between 0 and 3, please!");
			}
		} while (columns < 0 || columns > 3);

		if (player == Turn.RED) {
			moves.add(new PlayerMove(Turn.RED, rows, columns));
		} else if (player == Turn.BLACK) {
			moves.add(new PlayerMove(Turn.BLACK, rows, columns));
		}
	}

	public static int getRows() {
		return rows;
	}

	public static void setRows(int rows) {
		PlayerMove.rows = rows;
	}

	public static int getColumns() {
		return columns;
	}

	public static void setColumns(int columns) {
		PlayerMove.columns = columns;
	}

	public static void whosTurn() {

		if (player == Turn.RED) {
			System.out.println();
			System.out.println("Player 1's turn! (Red)");
		} else if (player == Turn.BLACK) {
			System.out.println();
			System.out.println("Player 2's turn! (Black)");
		}
	}

	public static void typeValidation() {

		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("Invalid input! Please enter an integer value!");
		}
	}

	public static List<PlayerMove> getMoves() {
		return moves;
	}

	public static void setMoves(List<PlayerMove> moves) {
		PlayerMove.moves = moves;
	}

	public static void writeMovesToFile(Tile[][] board, List<PlayerMove> moves, String fileName) {

		Path path = Paths.get(fileName);
		Charset charset = Charset.forName("UTF-8");
		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
			for (PlayerMove move : moves) {
				writer.write(board.toString());
				writer.write(move.toString());
				writer.newLine();
			}

			for (Tile[] i : board) {
				for (Tile j : i) {
					writer.write(j.toString() + "\t");
				}
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.format("IOException %s%n", e);
		}
	}

	public static boolean checkWin() {

		for (int i = 0; i < getBoard().length; i++) {
			if (getBoard()[i].equals(CurrentTileToken.RED)) {
				System.out.println("Congratulations! You have won!");
				return true;
			} else if (getBoard()[i].equals(CurrentTileToken.BLACK)) {
				System.out.println("Congratulations! You have won!");
				return true;
			}
			for (int j = 0; j < getBoard().length; j++) {
				if (getBoard()[j].equals(CurrentTileToken.RED)) {
					System.out.println("Congratulations! You have won!");
					return true;
				} else if (getBoard()[j].equals(CurrentTileToken.BLACK)) {
					System.out.println("Congratulations! You have won!");
					return true;
				}
			}
		}

		return false;
	}

	public static void insertToken() {

		if (player == Turn.RED) {
			getBoard()[rows][columns].setTokenOnTile(CurrentTileToken.RED);
		} else {
			getBoard()[rows][columns].setTokenOnTile(CurrentTileToken.BLACK);
		}
	}

	public static void switchTurn() {

		if (player == Turn.RED) {
			player = Turn.BLACK;
		} else {
			player = Turn.RED;
		}
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "PlayerMove{" + "moves=" + moves + '}';
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		PlayerMove.sc = sc;
	}

	public Turn getPlayer() {
		return player;
	}

	public void setPlayer(Turn player) {
		PlayerMove.player = player;
	}

	public enum Turn {
		RED, BLACK
	}
}
