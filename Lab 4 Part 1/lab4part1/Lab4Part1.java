package lab4part1;

import java.util.Scanner;

public class Lab4Part1 {

    public static void main(String[] args) {

        System.out.println("Welcome to Niya!");

        menu();

    }

    public static void menu() {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Please pick an option from the menu below:");
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
            if (choice < 1 || choice > 2) {
                System.out.println("Invalid input!");
                System.out.println("Please pick an option from the menu below:");
                System.out.println("1. Play Niya");
                System.out.println("2. Replay saved game");
            }
        } while (choice != 0);

    }

    public static void game() {

        GameBoard.makeBoard();
        GameBoard.printBoard();

    }

    public static void readSaveFile() {

    }
}
