package lab1;

import java.util.Scanner;

public class Lab1 {

	static Scanner sc = new Scanner(System.in);
	static int rows = 4;
	static int columns = 5;
	static char[][] table = new char[rows][columns];
	final static String[] CLASSES = { "Basketball Class, Thursdays only, 1:00 to 2:00 PM, Maximum Students: 20",
			"Swim Class, Fridays and Saturdays, 1:00 to 2:00 PM, Students: 10" };

	public static void main(String[] args) {

		welcome();
		makeTable();
		schedule();

	}

	public static void makeTable() {

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = ' ';
			}
		}
	}

	public static void printTable(char[][] table) {

		for (int i = 0; i < table.length; i++) {
			System.out.println("\t=================================");
			for (int j = 0; j < table[i].length; j++) {
				System.out.print("\t|" + table[i][j]);

			}
			System.out.println();
		}
	}

	public static void welcome() {

		System.out.println("\nWelcome to Gym Class Scheduling!\n");
	}

	public static void pickOption() {

		int choice = 0;

		do {
			System.out.println(
					"Enter '0' to quit, '1' to show the current schedule, '2' to schedule a class, and '3' to add students.");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("The current schedule is:");
					printTable(table);
					break;
				case 2:
					System.out.println("We will now schedule a class.");
					break;
				case 3:
					System.out.println("We will add a student to a specified class.");
					break;
			}
			if (choice < 0 || choice > 3) {
				System.out.println(
						"Invalid input. Please enter '0' to quit, '1' to show the current schedule, '2' to schedule a class, and '3' to add students.");
			}
		} while (choice != 0);
	}

	public static void rowInput() {

		do {
			System.out.print(
					"\nPlease pick the row of the day you would like to schedule. \n('1' for the first row, '2' for the second row, '3' for the third row, or '4' for the fourth row.): \n");
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println("Invalid input! Please enter either 1, 2, 3, or 4!");
			}
			rows = sc.nextInt() - 1;
			if (rows < 0 || rows > 3) {
				System.out.println("A row number between 1 and 4, please!");
			}

		} while (rows < 0 || rows > 3);
	}

	public static void columnInput() {

		do {
			System.out.print(
					"\nPlease pick the column of the day you would like to schedule. \n('1' for the first column, '2' for the second column, '3' for the third column, or '4' for the fourth column.): \n");
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println("Invalid input! Please enter either 1, 2, 3, or 4!");
			}
			columns = sc.nextInt() - 1;
			if (columns < 0 || columns > 3) {
				System.out.println("A column number between 1 and 3, please!");
			}

		} while (rows < 0 || rows > 3);
	}

	public static void schedule() {


		pickOption();
		System.out.println("The first column is Monday, second Thursday, third Friday, and fourth Saturday.\n");
		printTable(table);
		rowInput();
		columnInput();

	}
}
