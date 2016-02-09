package samplemidterm;

public class GameBoard {

    private static int rows = 3;
    private static int columns = 3;
    private static String[][] board = new String[rows][columns];

    public static void makeBoard() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = " ";
            }
        }
    }

    public static void printBoard(String[][] board) {

        for (int i = 0; i < board.length; i++) {
            System.out.println("\t----------------------");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("\t|" + board[i][j]);
            }
        }
    }

    public static int getRows() {
        return rows;
    }

    public static void setRows(int rows) {
        GameBoard.rows = rows;
    }

    public static int getColumns() {
        return columns;
    }

    public static void setColumns(int columns) {
        GameBoard.columns = columns;
    }

    public static String[][] getBoard() {
        return board;
    }

    public static void setBoard(String[][] board) {
        GameBoard.board = board;
    }
}
