package lab1;

import java.util.Scanner;

public class Lab1 {

	static Scanner sc = new Scanner(System.in);
	static int rows = 5;
	static int columns = 5;
	static String[][] table = new String[rows][columns];
	static int basketballStudents = 0;
	static int swimStudents = 0;
	static int pingPongStudents = 0;
	static int badmintonStudents = 0;
	static int yogaStudents = 0;

	public static void main(String[] args) {

		System.out.println("\nWelcome to Gym Class Scheduling!");
		makeTable();
		tableHeaders();
		pickOption();

	}

	public static void makeTable() {

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = "";
			}
		}
	}

	public static void printTable(String[][] table) {

		for (String[] i : table) {
			System.out.println(
					"\t=======================================================================================================");
			for (String j : i) {
				System.out.print("\t|" + "\t" + j);
			}
			System.out.println();
		}
	}

	public static void tableHeaders() {

		table[0][0] = "Gym Schedule";
		table[0][1] = "M";
		table[0][2] = "R";
		table[0][3] = "F";
		table[0][4] = "S";
		table[1][0] = "9 to 10 AM";
		table[2][0] = "1 to 2 PM";
		table[3][0] = "3 to 4 PM";
		table[4][0] = "4 to 5 PM";

	}

	public static void pickOption() {

		int choice;

		do {
			System.out.println(
					"\nEnter '0' to quit, '1' to show the current schedule, '2' to schedule a class, and '3' to add students.");
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println(
						"Invalid input! Please enter '0' to quit, '1' to show the current schedule, '2' to schedule a class, and '3' to add students.");
			}
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("\nThe current schedule is:");
					printTable(table);
					break;
				case 2:
					System.out.println("We will now schedule a class.");
					scheduling();
					break;
				case 3:
					System.out.println("We will add a student to a specified class.");
					addStudent();
					break;
			}
			if (choice < 0 || choice > 3) {
				System.out.println(
						"Invalid input! Please enter '0' to quit, '1' to show the current schedule, '2' to schedule a class, and '3' to add students.");
			}
		} while (choice != 0);
	}

	public static void addStudent() {

		int choice;

		do {
			System.out.println(
					"Enter one of the following options:\n'0' to quit this part of the program\n'1' to add students to Basketball Class\n'2' to add students to Swim Class\n'3' to add students to Ping Pong Class\n'4' to add students to Badminton Class\n'5' to add students to Yoga Class");
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println(
						"Invalid input! Enter one of the following options:\n'0' to quit this part of the program\n'1' to add students to Basketball Class\n'2' to add students to Swim Class\n'3' to add students to Ping Pong Class\n'4' to add students to Badminton Class\n'5' to add students to Yoga Class");
			}
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					if (basketballStudents < 20) {
						basketballStudents++;
						System.out.println("Current students in the basketball class: " + basketballStudents);
					} else {
						System.out.println("Sorry, this class has reached the maximum number of students allowed.");
						addStudent();
					}
					break;
				case 2:
					if (swimStudents < 10) {
						swimStudents++;
						System.out.println("Current students in the swim class: " + swimStudents);
					} else {
						System.out.println("Sorry, this class has reached the maximum number of students allowed.");
						addStudent();
					}
					break;
				case 3:
					if (pingPongStudents < 10) {
						pingPongStudents++;
						System.out.println("Current students in the ping pong class: " + pingPongStudents);
					} else {
						System.out.println("Sorry, this class has reached the maximum number of students allowed.");
						addStudent();
					}
					break;
				case 4:
					if (badmintonStudents < 12) {
						badmintonStudents++;
						System.out.println("Current students in the badminton class: " + badmintonStudents);
					} else {
						System.out.println("Sorry, this class has reached the maximum number of students allowed.");
						addStudent();
					}
					break;
				case 5:
					if (yogaStudents < 15) {
						yogaStudents++;
						System.out.println("Current students in the yoga class: " + yogaStudents);
					} else {
						System.out.println("Sorry, this class has reached the maximum number of students allowed.");
						addStudent();
					}
					break;
			}
			if (choice < 0 || choice > 5) {
				System.out.println(
						"Invalid input! Enter one of the following options:\n'0' to quit this part of the program\n'1' to add students to Basketball Class\n'2' to add students to Swim Class\n'3' to add students to Ping Pong Class\n'4' to add students to Badminton Class\n'5' to add students to Yoga Class");
			}
		} while (choice != 0);

		System.out.println("\nWe will now go back to the main menu.");
		pickOption();
	}

	public static void scheduling() {

		String[] classesShow = {
				"Basketball Class, Thursdays only, 1:00 to 2:00 PM, Maximum Students: 20, Current: "
						+ basketballStudents,
				"Swim Class, Fridays and Saturdays, 1:00 to 2:00 PM, Students: 10, Current: " + swimStudents,
				"Ping Pong Class, Mondays only, 9:00 to 10:00AM, Maximum Students: 10, Current: " + pingPongStudents,
				"Badminton Class, Mondays only, 1:00 to 2:00, Maximum Students: 12, Current: " + badmintonStudents,
				"Yoga Class, MRFS, 4:00 to 5:00 PM, Maximum Students: 15, Current: " + yogaStudents};
		String[] classesDisplay = {"Basketball: " + basketballStudents + " out of 20 students",
				"Swim: " + swimStudents + " out of 10 students",
				"Ping Pong: " + pingPongStudents + " out of 10 students",
				"Badminton: " + badmintonStudents + " out of 12 students",
				"Yoga: " + yogaStudents + " out of 15 students"};

		int choice;

		System.out.println("The classes available to choose from are as follows:\n");
		for (String i : classesShow) {
			System.out.println("\t" + i);
		}
		System.out.println();

		System.out.println(
				"Enter one of the following options:\n'0' to return to the main menu\n'1' to schedule the basketball class\n'2' to schedule the swim class\n'3' to schedule the ping pong class\n'4' to schedule the badminton class\n'5' to schedule the yoga class");
		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println(
					"Invalid input! Please enter '0' to return to the main menu\n'1' to schedule the basketball class\n'2' to schedule the swim class\n'3' to schedule the ping pong class\n'4' to schedule the badminton class\n'5' to schedule the yoga class");
		}
		choice = sc.nextInt();

		if (choice == 1) {
			table[2][2] = classesDisplay[0];
		} else if (choice == 2) {
			table[2][3] = classesDisplay[1];
			table[2][4] = classesDisplay[1];
		} else if (choice == 3) {
			table[1][1] = classesDisplay[2];
		} else if (choice == 4) {
			table[2][1] = classesDisplay[3];
		} else if (choice == 5) {
			table[4][1] = classesDisplay[4];
			table[4][2] = classesDisplay[4];
			table[4][3] = classesDisplay[4];
			table[4][4] = classesDisplay[4];
		}
	}
}
