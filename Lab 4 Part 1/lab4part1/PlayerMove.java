package lab4part1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerMove {

	private static Turn player = Turn.RED;
	private static boolean win = false;
	private static int rows;
	private static int columns;
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<PlayerMove> moves = new ArrayList<>();

	public static void inputRow() {

		do {
			System.out.print("Enter the row you would like to occupy: ");
			System.out.println("1. Row 1");
			System.out.println("2. Row 2");
			System.out.println("3. Row 3");
			System.out.println("4. Row 4");
			typeValidation();
			rows = sc.nextInt() - 1;
			if (rows < 1 || rows > 4) {
				System.out.println("A value between 1 and 4, please!");
			}
		} while (rows < 1 || rows > 4);
	}

	public static void inputColumn() {

		do {
			System.out.print("Enter the column you would like to occupy: ");
			System.out.println("1. Column 1");
			System.out.println("2. Column 2");
			System.out.println("3. Column 3");
			System.out.println("4. Column 4");
			typeValidation();
			columns = sc.nextInt() - 1;
			if (columns < 1 || columns > 4) {
				System.out.println("A value between 1 and 4, please!");
			}
		} while (columns < 1 || columns > 4);
	}

	public static boolean isWin() {

		return win;
	}

	public static void setWin(boolean win) {
		PlayerMove.win = win;

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

	public static void writeMovesToFile(ArrayList<PlayerMove> moves, String fileName) {

		Path path = Paths.get(fileName);
		Charset charset = Charset.forName("UTF-8");
		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
			for (PlayerMove move : moves) {
				writer.write(move.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.format("IOException %s%n", e);
		}
	}

	public static ArrayList<PlayerMove> getMoves() {
		return moves;
	}

	public static void setMoves(ArrayList<PlayerMove> moves) {
		PlayerMove.moves = moves;
	}

	public void insertToken() {

		if (player == Turn.RED) {
		}
	}

	@Override
	public String toString() {
		return "PlayerMove{" +
				"moves=" + moves +
				'}';
	}

	public void switchTurn() {

		if (player == Turn.RED) {
			player = Turn.BLACK;
		} else {
			player = Turn.RED;
		}
	}

	public void checkWin() {

		for (int i = 0; i < 16; i++) {
			char piece = 'R';
			if (player == Turn.RED) {
				piece = 'R';
			}
			while (win == false) {
				if (GameBoard.getBoard()[0][0].equals(piece) && GameBoard.getBoard()[0][1].equals(piece) && GameBoard.getBoard()[0][2].equals(piece) && GameBoard.getBoard()[0][3].equals(piece)) {
					win = true;
				}
				if (GameBoard.getBoard()[1][0].equals(piece) && GameBoard.getBoard()[1][1].equals(piece) && GameBoard.getBoard()[1][2].equals(piece) && GameBoard.getBoard()[1][3].equals(piece)) {
					win = true;
				}
				if (GameBoard.getBoard()[2][0].equals(piece) && GameBoard.getBoard()[2][1].equals(piece) && GameBoard.getBoard()[2][2].equals(piece) && GameBoard.getBoard()[2][3].equals(piece)) {
					win = true;
				}
				if (GameBoard.getBoard()[3][0].equals(piece) && GameBoard.getBoard()[3][1].equals(piece) && GameBoard.getBoard()[3][2].equals(piece) && GameBoard.getBoard()[3][3].equals(piece)) {
					win = true;
				}
				if (GameBoard.getBoard()[0][0].equals(piece) && GameBoard.getBoard()[1][0].equals(piece) && GameBoard.getBoard()[2][0].equals(piece) && GameBoard.getBoard()[3][0].equals(piece)) {
					win = true;
				}
				if (GameBoard.getBoard()[0][1].equals(piece) && GameBoard.getBoard()[1][1].equals(piece) && GameBoard.getBoard()[2][1].equals(piece) && GameBoard.getBoard()[3][1].equals(piece)) {
					win = true;
				}
				if (GameBoard.getBoard()[0][2].equals(piece) && GameBoard.getBoard()[1][2].equals(piece) && GameBoard.getBoard()[2][2].equals(piece) && GameBoard.getBoard()[3][2].equals(piece)) {
					win = true;
				}
				if (GameBoard.getBoard()[0][3].equals(piece) && GameBoard.getBoard()[1][3].equals(piece) && GameBoard.getBoard()[2][3].equals(piece) && GameBoard.getBoard()[3][3].equals(piece)) {
					win = true;
				}
				if (GameBoard.getBoard()[0][0].equals(piece) && GameBoard.getBoard()[1][1].equals(piece) && GameBoard.getBoard()[2][2].equals(piece) && GameBoard.getBoard()[3][3].equals(piece)) {
					win = true;
				}
				if (GameBoard.getBoard()[3][0].equals(piece) && GameBoard.getBoard()[2][1].equals(piece) && GameBoard.getBoard()[1][2].equals(piece) && GameBoard.getBoard()[0][3].equals(piece)) {
					win = true;
				} else {
					win = true;
				}
			}
		}
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public Turn getPlayer() {
		return player;
	}

	public void setPlayer(Turn player) {
		this.player = player;
	}

	public enum Turn {
		RED, BLACK
	}
}
