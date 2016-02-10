package lab4part1;

import lab4part1.Tile.CurrentTileToken;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static lab4part1.GameBoard.getBoard;

public class PlayerMove {

    private static Turn player = Turn.RED;
    private static boolean win = false;
    private static int rows;
    private static int columns;
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<PlayerMove> moves = new ArrayList<>();

    public static void inputRow() {

        do {
            System.out.println("Enter the row index you would like to occupy (0 to 3): ");
            typeValidation();
            rows = sc.nextInt();
            if (rows < 0 || rows > 3) {
                System.out.println("A value between 0 and 3, please!");
            }
        } while (rows < 0 || rows > 3);
    }

    public static void inputColumn() {

        do {
            System.out.println("Enter the column index you would like to occupy (0 to 3): ");
            typeValidation();
            columns = sc.nextInt();
            if (columns < 0 || columns > 3) {
                System.out.println("A value between 0 and 3, please!");
            }
        } while (columns < 0 || columns > 3);
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

    public static boolean checkWin() {

        for (int i = 0; i < GameBoard.getBoard().length; i++) {
            if (GameBoard.getBoard()[i].equals(CurrentTileToken.BLACK)) {
                return win = true;
            } else if (GameBoard.getBoard()[i].equals(CurrentTileToken.RED)) {
                return win = true;
            }
            for (int j = 0; j < GameBoard.getBoard()[i].length; j++) {
                if (GameBoard.getBoard()[j].equals(CurrentTileToken.BLACK)) {
                    return win = true;
                } else if (GameBoard.getBoard()[j].equals(CurrentTileToken.RED)) {
                    return win = true;
                }
            }
        }
        return win = false;
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
    public String toString() {
        return "PlayerMove{" + "moves=" + moves + '}';
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
