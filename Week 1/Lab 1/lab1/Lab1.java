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
				System.out.print("\t|" + "\t     " + j + "       ");
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
		// Stores the class names and student count in an array of Strings
		String[] classesDisplay = { "Basketball", "Swim", "Ping Pong", "Badminton", "Yoga" };
		int choice;
		/*
		 * Ideally, these variables below should say if the class can be added
		 * or not depending if the class has already been added or not
		 */
		int yesNo1;
		int yesNo2;
		int yesNo3;
		int yesNo4;
		int yesNo5;
		int scheduleAgain;
		boolean scheduled1 = false;
		boolean scheduled2 = false;
		boolean scheduled3 = false;
		boolean scheduled4 = false;
		boolean scheduled5 = false;

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

		if (choice == 1 && scheduled1 == false) {
			System.out.println("Are you sure you want to schedule this class? (1 for Yes, 2 for No)");
			yesNo1 = sc.nextInt();
			if (scheduled1 == true) {
				System.out.println("Sorry! You cannot schedule this class as it has already been scheduled!");
			} else if (yesNo1 == 1) {
				scheduled1 = true;
				table[2][2] = classesDisplay[0];
			}
		}
		if (choice == 2 && scheduled2 == false) {
			System.out.println("Are you sure you want to schedule this class? (1 for Yes, 2 for No)");
			yesNo2 = sc.nextInt();
			if (yesNo2 == 1) {
				scheduled2 = true;
				table[2][3] = classesDisplay[1];
				table[2][4] = classesDisplay[1];
			} else if (scheduled2 == true) {
				System.out.println("Sorry! You cannot schedule this class as it has already been scheduled!");
			}
		}
		if (choice == 3 && scheduled3 == false) {
			System.out.println("Are you sure you want to schedule this class? (1 for Yes, 2 for No)");
			yesNo3 = sc.nextInt();
			if (yesNo3 == 1) {
				scheduled3 = true;
				table[1][1] = classesDisplay[2];
			} else if (scheduled3 == true) {
				System.out.println("Sorry! You cannot schedule this class as it has already been scheduled!");
			}
		}
		if (choice == 4 && scheduled4 == false) {
			System.out.println("Are you sure you want to schedule this class? (1 for Yes, 2 for No)");
			yesNo4 = sc.nextInt();
			if (yesNo4 == 1) {
				scheduled4 = true;
				table[2][1] = classesDisplay[3];
			} else if (scheduled4 == true) {
				System.out.println("Sorry! You cannot schedule this class as it has already been scheduled!");
			}
		}
		if (choice == 5 && scheduled5 == false) {
			System.out.println("Are you sure you want to schedule this class? (1 for Yes, 2 for No)");
			yesNo5 = sc.nextInt();
			if (yesNo5 == 1) {
				scheduled5 = true;
				table[4][1] = classesDisplay[4];
				table[4][2] = classesDisplay[4];
				table[4][3] = classesDisplay[4];
				table[4][4] = classesDisplay[4];
			} else if (scheduled5 == true) {
				System.out.println("Sorry! You cannot schedule this class as it has already been scheduled!");
			}
		}
		System.out.println("Would you like to schedule another class? (1 for Yes, 2 for No)");
		scheduleAgain = sc.nextInt();
		if (scheduleAgain == 1) {
			scheduling();
		} else if (scheduleAgain == 2) {
			System.out.println("We will now return to the main menu.");
			pickOption();
		}
	}
}
