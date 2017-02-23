package samplemidterm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements PlayTTT {

  List<SetMoves> moves = new ArrayList<>();

  @Override
  public String[][] getTurn(String[][] board, String piece) {

    Scanner sc = new Scanner(System.in);
    Turn player = Turn.X;

    boolean valid = false;

    do {
      GameBoard.printBoard(GameBoard.getBoard());
      if (player == Turn.X) {
        System.out.println("\nPlayer 1's Turn! (X)");
      } else if (player == Turn.O) {
        System.out.println("\nPlayer 2's Turn! (O)");
      }

      System.out.println("Please enter the row and column you want to play in.");
      System.out.println("\nPlease enter the row:");
      int rows = sc.nextInt();
      System.out.print("\nPlease enter the column:");
      int columns = sc.nextInt();

      if (!board[rows][columns].equals("_")) {
        System.out.print("Sorry, that doesn't work!");
      } else {
        if (player == Turn.X) {
          board[rows][columns] = "X";
        } else {
          board[rows][columns] = "O";
        }
        this.moves.add(new SetMoves(rows, columns));
      }
    } while (!valid);
    return board;
  }

  @Override
  public boolean checkWin(String[][] board, String piece) {
    return false;
  }

  public enum Turn {
    X, O
  }
}
