package lab4part1;

import java.util.Scanner;

public class Lab4Part1 {

  public static void main(String[] args) {

    System.out.println("Welcome to Niya!");

    Tile.addTiles();
    GameBoard.createTilesAndMakeBoard();
    menu();
  }

  private static void menu() {

    Scanner sc = new Scanner(System.in);

    int choice;

    do {
      System.out.println("Please pick an option from the menu below:");
      System.out.println("0. Quit game");
      System.out.println("1. Play Niya");
      System.out.println("2. Replay saved game");
      while (!sc.hasNextInt()) {
        sc.nextLine();
        System.out.println("Invalid input!");
        System.out.println("Please pick an option from the menu below:");
        System.out.println("1. Play Niya");
        System.out.println("2. Replay saved game");
      }
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          game();
          break;
        case 2:
          readSaveFile();
          break;
      }
      if (choice < 0 || choice > 2) {
        System.out.println("Invalid input!");
        System.out.println("Please pick an option from the menu below:");
        System.out.println("0. Quit game");
        System.out.println("1. Play Niya");
        System.out.println("2. Replay saved game");
      }
      if (choice == 0) {
        System.out.println("Thank you for playing Niya!");
      }
    } while (choice != 0);

  }

  private static void game() {

    while (!PlayerMove.checkWin()) {

      GameBoard.printBoard();
      PlayerMove.whosTurn();
      PlayerMove.inputRow();
      PlayerMove.inputColumn();
      PlayerMove.insertToken();
      PlayerMove.checkWin();
      PlayerMove.switchTurn();

      PlayerMove.writeMovesToFile(GameBoard.getBoard(), PlayerMove.getMoves(), "C:\\Users\\kcr12\\Documents\\JetBrains\\IdeaProjects\\CS202\\Lab 4 Part 1\\NiyaGame" + System.currentTimeMillis() + ".txt");

      game();

    }
  }

  private static void readSaveFile() {

  }
}
