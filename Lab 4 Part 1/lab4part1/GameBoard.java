package lab4part1;

import java.util.Random;

public class GameBoard {

    private static int rows = 4;
    private static int columns = 4;
    private static String[][] board = new String[rows][columns];

    public GameBoard(int rows, int columns, String[][] board) {
        this.rows = rows;
        this.columns = columns;
        this.board = board;
    }

    public static void makeBoard() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = " ";
            }
        }
    }

    public static void printBoard() {

        for (String[] i : board) {
            System.out.println("\t------------------------");
            for (String j : i) {
                System.out.print("\t|" + j);
            }
            System.out.println();
        }
    }

    public static void assignPieces() {

        Random random = new Random();

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

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }
}
