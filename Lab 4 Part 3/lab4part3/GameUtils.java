package lab4part3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lab4part3.GameBoard.getBoard;

public class GameUtils {

	private static final Scanner sc = new Scanner(System.in);
	private static List<PlayerMove> moves = new ArrayList<>();
	private static PlayerMove playerMove = new PlayerMove();
	private static PlayerMove.Turn player = PlayerMove.Turn.RED;

	public static void gameUtils() {

		int rows;
		int columns;

		if (player == PlayerMove.Turn.RED) {
			System.out.println();
			System.out.println("Player 1's turn! (Red)");
		} else if (player == PlayerMove.Turn.BLACK) {
			System.out.println();
			System.out.println("Player 2's turn! (Black)");
		}

		do {
			System.out.println("Enter the row index you would like to occupy (0 to 3): ");
			typeValidation();
			rows = sc.nextInt();
			playerMove.setRows(rows);
			if (rows < 0 || rows > 3) {
				System.out.println("A value between 0 and 3, please!");
			}
		} while (rows < 0 || rows > 3);

		do {
			System.out.println("Enter the column index you would like to occupy (0 to 3): ");
			typeValidation();
			columns = sc.nextInt();
			playerMove.setColumns(columns);
			if (columns < 0 || columns > 3) {
				System.out.println("A value between 0 and 3, please!");
			}
		} while (columns < 0 || columns > 3);

		if (player == PlayerMove.Turn.RED) {
			getBoard()[playerMove.getRows()][playerMove.getColumns()].setTokenOnTile(Tile.CurrentTileToken.RED);
			moves.add((new PlayerMove(PlayerMove.Turn.RED, playerMove.getRows(), playerMove.getColumns())));
			player = PlayerMove.Turn.BLACK;
		} else {
			getBoard()[playerMove.getRows()][playerMove.getColumns()].setTokenOnTile(Tile.CurrentTileToken.BLACK);
			moves.add(new PlayerMove(PlayerMove.Turn.BLACK, playerMove.getRows(), playerMove.getColumns()));
			player = PlayerMove.Turn.RED;
		}
	}

	private static void typeValidation() {

		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("Invalid input! Please enter an integer value!");
		}
	}

	public List<PlayerMove> getMoves() {
		return moves;
	}

	public static void setMoves(List<PlayerMove> moves) {
		GameUtils.moves = moves;
	}
}