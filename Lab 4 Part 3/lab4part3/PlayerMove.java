package lab4part3;

import lab4part3.Tile.CurrentTileToken;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lab4part3.GameBoard.getBoard;

public class PlayerMove {

	private static Scanner sc = new Scanner(System.in);
	private Turn player;
	private int rows;
	private int columns;

	public PlayerMove() {

	}

	public PlayerMove(Turn player, int rows, int columns) {
		this.player = player;
		this.rows = rows;
		this.columns = columns;

		System.out.println(player + " " + rows + " " + columns);
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

	public boolean checkWin() {

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
		return "Current move (Player/Index of Row and Column): " + player + ": " + rows + "/" + columns;
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
