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

    private static Scanner sc = new Scanner(System.in);
    private static List<PlayerMove> moves = new ArrayList<>();
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

    public static void userInputAndTurn() {

        PlayerMove playerMove = new PlayerMove();
        Turn currentPlayer = Turn.RED;
        int userRow;
        int userColumn;
        int maxMovesCounter = 0;

        if (currentPlayer == Turn.RED) {
            System.out.println();
            System.out.println("Player 1's turn! (Red)");
        } else if ( currentPlayer == Turn.BLACK) {
            System.out.println();
            System.out.println("Player 2's turn! (Black)");
        }
        do {
            System.out.println("Enter the row index you would like to occupy (0 to 3): ");
            typeValidation();
            userRow = sc.nextInt();
            playerMove.setRows(userRow);
            if (userRow < 0 || userRow > 3) {
                System.out.println("A value between 0 and 3, please!");
            }
        } while (userRow < 0 || userRow > 3);

        do {
            System.out.println("Enter the column index you would like to occupy (0 to 3): ");
            typeValidation();
            userColumn = sc.nextInt();
            playerMove.setColumns(userColumn);
            if (userColumn < 0 || userColumn > 3) {
                System.out.println("A value between 0 and 3, please!");
            }
        } while (userColumn < 0 || userColumn > 3);

        if (currentPlayer == Turn.RED) {
            getBoard()[userRow][userColumn].setTokenOnTile(CurrentTileToken.RED);
        } else {
            getBoard()[userRow][userColumn].setTokenOnTile(CurrentTileToken.BLACK);
        }



        if (currentPlayer == Turn.RED) {
            playerMove.setPlayer(Turn.RED);
            moves.add(new PlayerMove(currentPlayer, userRow, userColumn));
        }
        else {
            currentPlayer = Turn.BLACK;
            moves.add(new PlayerMove(currentPlayer, userRow, userColumn));
            currentPlayer = Turn.RED;
        }

        maxMovesCounter++;

        if (maxMovesCounter == 15) {
            System.out.println("Tie game.");
        }
    }

    public static void whosTurn() {


    }

    public static void typeValidation() {

        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.println("Invalid input! Please enter an integer value!");
        }
    }

    public static void writeMovesToFile(Tile[][] board, List<PlayerMove> moves, String fileName) {

        Path path = Paths.get(fileName);
        Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
            for (int i = 0; i < moves.size(); i++) {
                writer.write(moves.get(i).toString());
                writer.newLine();
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    writer.write(board[i][j].toString() + "\t");
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


    }

    public static void switchTurn() {


    }

    public static List<PlayerMove> getMoves() {
        return moves;
    }

    public static void setMoves(List<PlayerMove> moves) {
        PlayerMove.moves = moves;
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
