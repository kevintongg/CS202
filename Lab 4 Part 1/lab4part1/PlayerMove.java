package lab4part1;

import java.util.Scanner;

public class PlayerMove {

    private static Turn player = Turn.BLACK;
    private static boolean win = false;
    private Scanner sc = new Scanner(System.in);

    public static void whosTurn() {

        if (player == Turn.BLACK) {
            System.out.println();
            System.out.println("Player 1's turn! (Black)");
        } else if (player == Turn.RED) {
            System.out.println();
            System.out.println("Player 2's turn! (Red)");
        }

    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public void switchTurn() {

        if (player == Turn.BLACK) {
            player = Turn.RED;
        } else {
            player = Turn.BLACK;
        }

    }

    public void checkMove() {

        for (int i = 0; i < 16; i++) {
            String piece = "black";
            if (player == Turn.BLACK) {
                piece = "red";
            }
        }

    }

    public Turn getPlayer() {
        return player;
    }

    public void setPlayer(Turn player) {
        this.player = player;
    }

    public enum Turn {
        BLACK, RED
    }
}
