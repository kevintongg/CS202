package lab4part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lab4part3.Tile.getTileTypes;

public class GameBoard {

    private static int rows = 4;
    private static int columns = 4;
    private static Tile[][] board = new Tile[rows][columns];


    public GameBoard() {

    }

    public GameBoard(int rows, int columns, Tile[][] board) {
        GameBoard.rows = rows;
        GameBoard.columns = columns;
        GameBoard.board = board;

    }

    public static void createTilesAndMakeBoard() {

        List<Tile> gameTiles = new ArrayList<>();

        do {
            Collections.shuffle(getTileTypes());
            Tile gameTile = new Tile(getTileTypes().get(0), getTileTypes().get(1));
            boolean duplicate = false;
            for (Tile existingTile : gameTiles) {
                if (existingTile.equals(gameTile)) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                continue;
            } else {
                gameTiles.add(gameTile);
            }


        } while (gameTiles.size() < 16);

        int counter = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = gameTiles.get(counter);
                counter++;
            }
        }
    }

    public static void printBoard() {

        for (Tile[] i : board) {
            System.out.println("\t-------------------------------------------------------------------------------------------");
            for (Tile j : i) {
                System.out.print("\t|\t" + j);
            }
            System.out.println();
        }
        System.out.println("\n----------\n");
    }

    @Override
    public String toString() {
        return " "  + board;
    }

    public static Tile[][] getBoard() {
        return board;
    }

    public static void setBoard(Tile[][] board) {
        GameBoard.board = board;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        GameBoard.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        GameBoard.columns = columns;
    }
}
