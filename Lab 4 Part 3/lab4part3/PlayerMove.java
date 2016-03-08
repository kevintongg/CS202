package lab4part3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static lab4part3.GameBoard.getBoard;

public class PlayerMove {

	private Turn player;
	private int rows;
	private int columns;

	public PlayerMove() {

	}

	public PlayerMove(Turn player, int rows, int columns) {
		this.player = player;
		this.rows = rows;
		this.columns = columns;
	}

	public void writeMovesToFile(Tile[][] board, List<PlayerMove> moves, String fileName) {

		Path path = Paths.get(fileName);
		Charset charset = Charset.forName("UTF-8");
		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
			for (PlayerMove move : moves) {
				writer.write(move.toString());
				writer.newLine();
			}
			for (Tile[] writeBoard : board) {
				for (int j = 0; j < writeBoard.length; j++) {
					writer.write(writeBoard[j].toString() + "\t");
				}
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.format("IOException %s%n", e);
		}
	}

	public static String[][] readMovesFromFile(String fileName) {

		Path path = Paths.get(fileName);
		Charset charset = Charset.forName("UTF-8");
		List<String> allMoves = new ArrayList<>();

		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
			allMoves = Files.readAllLines(path, charset);
		} catch (Exception e) {
			System.err.format("IOException: %s%n", e);
		}

		String[][] moves = new String[100][100];
		for (int i = 0; i < allMoves.size(); i++) {
			moves[i] = allMoves.get(i).split(",");
		}

		return moves;

	}

	public boolean checkWin() {

		for (int i = 0; i < getBoard().length; i++) {
			if (getBoard()[i].equals(Turn.RED)) {
				System.out.println("Congratulations! You have won!");
				return true;
			} else if (getBoard()[i].equals(Turn.BLACK)) {
				System.out.println("Congratulations! You have won!");
				return true;
			}
			for (int j = 0; j < getBoard().length; j++) {
				if (getBoard()[j].equals(Turn.RED)) {
					System.out.println("Congratulations! You have won!");
					return true;
				} else if (getBoard()[j].equals(Turn.BLACK)) {
					System.out.println("Congratulations! You have won!");
					return true;
				}
			}
		}

		return false;
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

	@Override
	public String toString() {
		return "Current move (Player/Index of Row and Column): " + player + ", " + rows + "," + columns;
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
