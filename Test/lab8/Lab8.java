package lab8;

import java.util.Scanner;

public class Lab8 {

	static Scanner sc = new Scanner(System.in);

	static int rows = 3;
	static int columns = 3;
	static Turn player = Turn.X;
	static boolean winCondition = false;
	static boolean tie = true;
	static char[][] gameBoard = new char[rows][columns];

	public static void main(String[] args) {

		System.out.println("Welcome to the Tic-Tac-Toe game!");

		makeBoard();
		game();

	}

	public static void makeBoard() {

		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = ' ';
			}
		}
	}

	public static void printBoard(char[][] myBoard) {

		for (int i = 0; i < myBoard.length; i++) {
			System.out.println("\t------------------------");
			for (int j = 0; j < myBoard[i].length; j++) {
				System.out.print("\t|   " + myBoard[i][j]);

			}
			System.out.println();
		}
	}

	public static void validateRow() {

		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("Invalid input! Please enter an integer value!");
		}
	}

	public static void validateColumn() {

		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("Invalid input! Please enter an integer value!");
		}
	}

	public static void insertPiece() {

		if (player == Turn.X) {
			gameBoard[rows][columns] = 'X';
		} else {
			gameBoard[rows][columns] = 'O';
		}
	}

	public static void inputRow() {

		do {
			System.out.print(
					"\nEnter the row you would like to occupy ('0' for the 1st row, '1' for the 2nd row, or '2' for the 3rd row): ");
			validateRow();
			rows = sc.nextInt();
			if (rows < 0 || rows > 2 && validateMove(gameBoard, rows, columns)) {
				System.out.println("A value between 0 and 2, please!");
			}

		} while (rows < 0 || rows > 2 && validateMove(gameBoard, rows, columns));
	}

	public static void inputColumn() {

		do {
			System.out.print(
					"Enter the column you would like to occupy ('0' for the 1st column, '1' for the 2nd column, or '2' for the 3rd column): ");
			validateColumn();
			columns = sc.nextInt();
			if (columns < 0 || columns > 2 && validateMove(gameBoard, rows, columns)) {
				System.out.println("A value between 0 and 2, please!");
			}
		} while (columns < 0 || columns > 2 && validateMove(gameBoard, rows, columns));
	}

	public static void switchTurn() {

		if (player == Turn.X) {
			player = Turn.O;
		} else {
			player = Turn.X;
		}
	}

	public static void game() {

		printBoard(gameBoard);
		while (endGame(winCondition) != true) {

			whosTurn();
			inputRow();
			inputColumn();
			validateMove(gameBoard, rows, columns);
			insertPiece();
			switchTurn();
			printBoard(gameBoard);
			endGame(winCondition);
		}

	}

	public static void whosTurn() {

		if (player == Turn.X) {
			System.out.println();
			System.out.println("Player 1's move! (X)");
		} else if (player == Turn.O) {
			System.out.println();
			System.out.println("Player 2's move! (O)");
		}
	}

	public static boolean validateMove(char[][] myBoard, int rows, int columns) {

		if (myBoard[rows][columns] == ' ') {
			return true;
		} else {
			System.out.println("Sorry, row " + rows + " and column " + columns + " is not a valid move!");
			inputRow();
			inputColumn();
			return false;
		}

	}

	public static boolean endGame(boolean winCondition) {
		if (check(rows, columns, player)) {
			System.out.println("Player " + Turn.X + " wins!");
			return winCondition = true;
		} else if (check(rows, columns, player)) {
			System.out.println("Player " + Turn.O + " wins!");
			return winCondition = true;
		}
		return winCondition;
	}

	public static boolean check(int rows, int columns, Turn p) {

		for (int i = 0; i < 9; i++) {
			char piece = 'X';
			if (player == Turn.X) {
				piece = 'O';
			}
			if (gameBoard[0][0] == piece && gameBoard[1][0] == piece && gameBoard[2][0] == piece) {
				return winCondition = true;
			}
			if (gameBoard[0][1] == piece && gameBoard[1][1] == piece && gameBoard[2][1] == piece) {
				return winCondition = true;
			}
			if (gameBoard[0][2] == piece && gameBoard[1][2] == piece && gameBoard[2][2] == piece) {
				return winCondition = true;
			}
			if (gameBoard[0][0] == piece && gameBoard[0][1] == piece && gameBoard[0][2] == piece) {
				return winCondition = true;
			}
			if (gameBoard[1][0] == piece && gameBoard[1][1] == piece && gameBoard[1][2] == piece) {
				return winCondition = true;
			}
			if (gameBoard[2][0] == piece && gameBoard[2][1] == piece && gameBoard[2][2] == piece) {
				return winCondition = true;
			}
			if (gameBoard[0][0] == piece && gameBoard[1][1] == piece && gameBoard[2][2] == piece) {
				return winCondition = true;
			}
			if (gameBoard[0][2] == piece && gameBoard[1][1] == piece && gameBoard[3][0] == piece) {
				return winCondition = true;
			}
		}

		return winCondition = false;
	}

	public enum Turn {
		X, O
	}

}