package lab1;

import java.util.Scanner;

public class Lab1 {

	static Scanner sc = new Scanner(System.in);
	static int basketballStudents = 0;
	static int swimStudents = 0;
	static int pingPongStudents = 0;
	static int badmintonStudents = 0;
	static int yogaStudents = 0;
	static int rows = 5;
	static int columns = 5;
	static String[][] table = new String[rows][columns];
	static String[] classesDisplay = { "Basketball", "Swim", "Ping Pong", "Badminton", "Yoga" };

	public static void main(String[] args) {

		System.out.println("\nWelcome to Gym Class Scheduling!");
		makeTable();
		pickOption();

	}

	public static void makeTable() {

		// Creating the table
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = "  ";
			}
		}
		// Assign the table titles after table is made
		tableTitles();
	}

	public static void printTable(String[][] table) {

		// Printing the table
		for (String[] i : table) {
			System.out.println(
					"\t===============================================================================================================================================");
			for (String j : i) {
				System.out.print("\t|" + "\t  " + j + "       ");
			}
			System.out.println();
		}
	}

	public static void tableTitles() {

		// Assigning the times and days onto the table

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

		// Basically the main menu

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
					currentStudents();
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

		// Here we add students to the class if class is not full

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

	public static void currentStudents() {

		System.out.println("\nBasketball Class: " + basketballStudents + "/" + "20 students");
		System.out.println("Swim Class: " + swimStudents + "/" + "10 students");
		System.out.println("Ping Pong Class: " + pingPongStudents + "/" + "10 students");
		System.out.println("Badminton Class: " + badmintonStudents + "/" + "12 students");
		System.out.println("Yoga Class: " + yogaStudents + "/" + "15 students");
	}

	public static void scheduleAgain() {

		/*
		 * This method will ask the user if they would like to schedule another
		 * class
		 */

		System.out.println("Would you like to schedule another class? (1 for Yes, 2 for No)");
		int scheduleAgain = sc.nextInt();
		if (scheduleAgain == 1) {
			scheduling();
		} else if (scheduleAgain == 2) {
			System.out.println("We will now return to the main menu.");
			pickOption();
		}
	}

	public static void scheduling() {

		// Here we assign classes to the schedule/table

		// Stores all the classes in an array of Strings
		String[] classesShow = {
				"Basketball Class, Thursdays only, 1:00 to 2:00 PM, Maximum Students: 20, Current: "
						+ basketballStudents,
				"Swim Class, Fridays and Saturdays, 1:00 to 2:00 PM, Students: 10, Current: " + swimStudents,
				"Ping Pong Class, Mondays only, 9:00 to 10:00AM, Maximum Students: 10, Current: " + pingPongStudents,
				"Badminton Class, Mondays only, 1:00 to 2:00, Maximum Students: 12, Current: " + badmintonStudents,
				"Yoga Class, MRFS, 4:00 to 5:00 PM, Maximum Students: 15, Current: " + yogaStudents };

		int choice;
		int yesNo;

		System.out.println("The classes available to choose from are as follows:\n");
		for (String i : classesShow) {
			System.out.println("\t" + i);
		}
		System.out.println();

		System.out.println("Classes that have not yet been scheduled:\n");
		displayClassesNotYetScheduled();
		System.out.println();

		/*
		 * The following do... while loop will ask the user if they would like
		 * to add classes, and if classes are already scheduled, display error
		 * message and ask if they would like to schedule another. If not, go
		 * back to main menu
		 */
		System.out.println(
				"Enter one of the following options:\n'0' to return to the main menu\n'1' to schedule the basketball class\n'2' to schedule the swim class\n'3' to schedule the ping pong class\n'4' to schedule the badminton class\n'5' to schedule the yoga class");
		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println(
					"Invalid input! Please enter '0' to return to the main menu\n'1' to schedule the basketball class\n'2' to schedule the swim class\n'3' to schedule the ping pong class\n'4' to schedule the badminton class\n'5' to schedule the yoga class");
		}
		choice = sc.nextInt();
		switch (choice) {
			case 1:
				System.out.println("Are you sure you want to schedule this basketball class? (1 for Yes, 2 for No)");
				yesNo = sc.nextInt();
				if (checkIfBasketballClassIsScheduled()) {
					System.out.println("Sorry! You cannot schedule this class as it has already been scheduled!");
					scheduleAgain();
				} else if (yesNo == 1) {
					table[2][2] = classesDisplay[0];
					System.out.println("You have successfully added the class!\n");
					scheduleAgain();
				}
				break;
			case 2:
				System.out.println("Are you sure you want to schedule this swim class? (1 for Yes, 2 for No)");
				yesNo = sc.nextInt();
				if (checkIfSwimClassIsScheduled()) {
					System.out.println("Sorry! You cannot schedule this class as it has already been scheduled!");
					scheduleAgain();
				} else if (yesNo == 1) {
					table[2][3] = classesDisplay[1];
					table[2][4] = classesDisplay[1];
					System.out.println("You have successfully added the class!\n");
					scheduleAgain();
				}

				break;
			case 3:
				System.out.println("Are you sure you want to schedule this ping pong class? (1 for Yes, 2 for No)");
				yesNo = sc.nextInt();
				if (checkIfPingPongClassIsScheduled()) {
					System.out.println("Sorry! You cannot schedule this class as it has already been scheduled!");
					scheduleAgain();
				} else if (yesNo == 1) {
					table[1][1] = classesDisplay[2];
					System.out.println("You have successfully added the class!\n");
					scheduleAgain();
				}
				break;
			case 4:
				System.out.println("Are you sure you want to schedule this badminton class? (1 for Yes, 2 for No)");
				yesNo = sc.nextInt();
				if (checkIfBadmintonClassIsScheduled()) {
					System.out.println("Sorry! You cannot schedule this class as it has already been scheduled!");
					scheduleAgain();
				} else if (yesNo == 1) {
					table[2][1] = classesDisplay[3];
					System.out.println("You have successfully added the class!\n");
					scheduleAgain();
				}
				break;
			case 5:
				System.out.println("Are you sure you want to schedule this yoga class? (1 for Yes, 2 for No)");
				yesNo = sc.nextInt();
				if (checkIfYogaClassIsScheduled()) {
					System.out.println("Sorry! You cannot schedule this class as it has already been scheduled!");
					scheduleAgain();
				} else if (yesNo == 1) {
					table[4][1] = classesDisplay[4];
					table[4][2] = classesDisplay[4];
					table[4][3] = classesDisplay[4];
					table[4][4] = classesDisplay[4];
					System.out.println("You have successfully added the class!\n");
					scheduleAgain();
				}
				break;
		}
	}

	/*
	 * The following five methods check if the class is scheduled via checking
	 * the index of the two-dimensional array
	 */

	public static boolean checkIfBasketballClassIsScheduled() {

		return table[2][2] == classesDisplay[0];
	}

	public static boolean checkIfSwimClassIsScheduled() {

		return table[2][3] == classesDisplay[1] && table[2][4] == classesDisplay[1];
	}

	public static boolean checkIfPingPongClassIsScheduled() {

		return table[1][1] == classesDisplay[2];
	}

	public static boolean checkIfBadmintonClassIsScheduled() {

		return table[2][1] == classesDisplay[3];
	}

	public static boolean checkIfYogaClassIsScheduled() {

		return table[4][1] == classesDisplay[4] && table[4][2] == classesDisplay[4] && table[4][3] == classesDisplay[4]
				&& table[4][4] == classesDisplay[4];
	}

	public static void displayClassesNotYetScheduled() {

		/*
		 * This method checks if the class has been scheduled or not. If not,
		 * display a message saying that the class has not been scheduled
		 */

		if (table[2][2] != classesDisplay[0]) {
			System.out.println("\tBasketball class has not yet been scheduled.");
		}
		if (table[2][3] != classesDisplay[1] && table[2][4] != classesDisplay[1]) {
			System.out.println("\tSwim class has not yet been scheduled.");
		}
		if (table[1][1] != classesDisplay[2]) {
			System.out.println("\tPing Pong class has not yet been scheduled.");
		}
		if (table[2][1] != classesDisplay[3]) {
			System.out.println("\tBadminton class has not yet been scheduled.");
		}
		if (table[4][1] != classesDisplay[4] && table[4][2] != classesDisplay[4] && table[4][3] != classesDisplay[4]
				&& table[4][4] != classesDisplay[4]) {
			System.out.println("\tYoga class has not yet been scheduled.");
		}
	}
}
