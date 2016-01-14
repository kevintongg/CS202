package test;

import java.util.Scanner;

public class Test {

	static Scanner sc = new Scanner(System.in);
	static int rows = 4;
	static int columns = 5;
	static char[][] table = new char[rows][columns];


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

		for (char[] i : table) {
			System.out.println("\t=================================");
			for (char j : i) {
				System.out.print("\t|" + j);
			}
			System.out.println();
		}
	}

	public static void welcome() {

		System.out.println("\nWelcome to Gym Class Scheduling!\n");
	}

	public static void pickOption() {

		int choice = 0;

		while (choice != 0) {
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
					schedule();
					break;
				case 3:
					System.out.println("We will add a student to a specified class.");
					addStudent();
					break;
			}
		}
	}

	public static void rowInput() {
		// Getting input for which row to be used
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

		// Getting input for which column to be used
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

	public static void addClassToSchedule(char[] table) {

		final String[] classes = { "Basketball Class, Thursdays only, 1:00 to 2:00 PM, Maximum Students: 20",
				"Swim Class, Fridays and Saturdays, 1:00 to 2:00 PM, Students: 10",
				"Ping Pong Class, Mondays only, 9:00 to 10:00AM, Maximum Students: 10",
				"Badminton Class, Mondays only, 1:00 to 2:00, Maximum Students: 12",
				"Yoga Class, MRFS, 4:00 to 5:00 PM, Maximum Students: 15" };

//		if (rows == 0 && )
	}

	public static void addStudent() {

		int choice = 0;
		int basketballStudents = 0;
		int swimStudents = 0;
		int pingPongStudents = 0;
		int badmintonStudents = 0;
		int yogaStudents = 0;
		String yes;

		System.out.println(
				"Class #1: Basketball\nClass #2: Swim\nClass #3: Ping Pong\nClass #4: Badminton\nClass #5: Yoga");

		do {
			switch (choice) {
				case 1:
					System.out.println("Do you want to add students to the basketball class? (Y/N)");
					yes = sc.nextLine().toLowerCase();
					if (yes == "y" && basketballStudents <= 20) {
						basketballStudents++;
					}
					addStudent();
					break;
				case 2:
					System.out.println("Do you want to add students to the swim class? (Y/N)");
					yes = sc.nextLine().toLowerCase();
					if (yes == "y" && swimStudents <= 10) {
						swimStudents++;
					}
					break;
				case 3:
					System.out.println("Do you want to add students to the Ping Pong class? (Y/N)");
					yes = sc.nextLine().toLowerCase();
					if (yes == "y" && pingPongStudents <= 10) {
						pingPongStudents++;
					} else if (pingPongStudents == 10) {
						System.out.println("Sorry! Class full!");
					}
					break;
				case 4:
					System.out.println("Do you want to add students to the Badminton class? (Y/N)");
					yes = sc.nextLine().toLowerCase();
					if (yes == "y" && badmintonStudents <= 12) {
						badmintonStudents++;
					}
					break;
				case 5:
					System.out.println("Do you want to add students to the Yoga class? (Y/N)");
					yes = sc.nextLine().toLowerCase();
					if (yes == "y" && yogaStudents <= 15) {
						yogaStudents++;
					}
			}
		} while (choice != 0);
	}

	public static void schedule() {

		// Main scheduling method

		pickOption();
		System.out.println("The first column is Monday, second Thursday, third Friday, and fourth Saturday.\n");
		System.out.println("The first row is 9 to 10 AM, second 1 to 2 PM, third 3 to 4 PM, and fourth 4 to 5 PM");
		printTable(table);
		rowInput();
		columnInput();

	}
}
