package lab4part3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lab4part3.GameBoard.getBoard;

public class GameUtils {

    private static final Scanner sc = new Scanner(System.in);
    private static List<PlayerMove> moves = new ArrayList<>();

    public List<PlayerMove> getMoves() {
        return moves;
    }

    public static void setMoves(List<PlayerMove> moves) {
        GameUtils.moves = moves;
    }

    public static void gameUtils() {

        PlayerMove playerMove = new PlayerMove();

        if (playerMove.getPlayer() == null) {
            playerMove.setPlayer(PlayerMove.Turn.RED);
        } else if (playerMove.getPlayer() == PlayerMove.Turn.RED) {
            playerMove.setPlayer(PlayerMove.Turn.BLACK);
        }

        if (playerMove.getPlayer() == PlayerMove.Turn.RED) {
            System.out.println();
            System.out.println("Player 1's turn! (Red)");
        } else if (playerMove.getPlayer() == PlayerMove.Turn.BLACK) {
            System.out.println();
            System.out.println("Player 2's turn! (Black)");
        }

        int userRow;

        do {
            System.out.println("Enter the row index you would like to occupy (0 to 3): ");
            typeValidation();
            userRow = sc.nextInt();
            playerMove.setRows(userRow);
            if (userRow < 0 || userRow > 3) {
                System.out.println("A value between 0 and 3, please!");
            }
        } while (userRow < 0 || userRow > 3);


        int userColumn;

        do {
            System.out.println("Enter the column index you would like to occupy (0 to 3): ");
            typeValidation();
            userColumn = sc.nextInt();
            playerMove.setColumns(userColumn);
            if (userColumn < 0 || userColumn > 3) {
                System.out.println("A value between 0 and 3, please!");
            }
        } while (userColumn < 0 || userColumn > 3);

        if (playerMove.getPlayer() == PlayerMove.Turn.RED) {
            getBoard()[playerMove.getRows()][playerMove.getColumns()].setTokenOnTile(Tile.CurrentTileToken.RED);
        } else {

            getBoard()[playerMove.getRows()][playerMove.getColumns()].setTokenOnTile(Tile.CurrentTileToken.BLACK);
        }

        if (playerMove.getPlayer() == PlayerMove.Turn.RED) {
            moves.add(new PlayerMove(PlayerMove.Turn.BLACK, playerMove.getRows(), playerMove.getColumns()));
        } else if (playerMove.getPlayer() == PlayerMove.Turn.BLACK) {
            moves.add(new PlayerMove(PlayerMove.Turn.BLACK, playerMove.getRows(), playerMove.getColumns()));
        }


        if (playerMove.getPlayer() == PlayerMove.Turn.RED) {
            playerMove.setPlayer(PlayerMove.Turn.BLACK);
        } else {
            playerMove.setPlayer(PlayerMove.Turn.RED);
        }


    }

    private static void typeValidation() {

        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.println("Invalid input! Please enter an integer value!");
        }
    }
}