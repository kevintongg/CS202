package lab2;

import java.util.Scanner;

public class Lab2 {

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
	static Schedule basketball = new Schedule("Class name: Basketball",
			"Class Day(s)/Hours: Thursdays only from 1:00 to 2:00 PM",
			"Description: Come play basketball or learn how to play in this class",
			"Current number of students enrolled: ", basketballStudents, "Maximum amount of students allowed: 20",
			false);
	static Schedule swimming = new Schedule("Class name: Swim",
			"Class Day(s)/Hours: Fridays and Saturdays from 1:00 to 2:00 PM",
			"Description: Come have fun and swim or learn how to swim like a pro!",
			"Current number of students enrolled: ", swimStudents, "Maximum number of students allowed: 10", false);
	static Schedule pingPong = new Schedule("Class name: Ping Pong",
			"Class Day(s)/Hours: Mondays only from 9:00 to 10:00AM",
			"Description: Come play some table tennis in this action-packed class!",
			"Current number of students enrolled: ", pingPongStudents, "Maximum number of students allowed: 10", false);
	static Schedule badminton = new Schedule("Class name: Badminton",
			"Class Day(s)/Hours: Mondays only from 1:00 to 2:00",
			"Description: Come play some badminton in this fun-filled class!", "Current number of students enrolled: ",
			badmintonStudents, "Maximum number of students allowed: 12", false);
	static Schedule yoga = new Schedule("Class name: Yoga", "Class Day(s)/Hours: MFRS from 4:00 to 5:00 PM",
			"Description: Come train your body on how to become more flexible, or just to relieve stress",
			"Current number of students enrolled: ", yogaStudents, "Maximum number of students allowed: 15", false);

	public static void main(String[] args) {

		System.out.println("\nWelcome to Gym Class Scheduling!\n");
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
					"Please enter one of the following:\n'0' to quit\n'1' to show the current schedule\n'2' to schedule a class\n'3' to add students\n'4' to register a student\n'5' to display current class information.");
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println(
						"Invalid input! Please enter '0' to quit, '1' to show the current schedule, '2' to schedule a class, '3' to add students, '4' to register a student, and '5' to display current class information.");
			}
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("\nThe current schedule is:\n");
					printTable(table);
					currentStudents();
					break;
				case 2:
					System.out.println("We will now schedule a class.\n");
					scheduling();
					break;
				case 3:
					System.out.println("We will now add a student to a specific class.\n");
					addStudent();
					break;
				case 4:
					System.out.println("We will now begin student registration.");
					studentRegistration();
					break;
				case 5:
					displayClasses();
					break;
			}
			if (choice < 0 || choice > 5) {
				System.out.println(
						"Invalid input! Please enter '0' to quit, '1' to show the current schedule, '2' to schedule a class, '3' to add students, '4' to register a student, and '5' to display current class information.");
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
						basketball.setNumberOfStudentsEnrolled(basketballStudents);
					} else {
						System.out.println("Sorry, this class has reached the maximum number of students allowed.");
						addStudent();
					}
					break;
				case 2:
					if (swimStudents < 10) {
						swimStudents++;
						System.out.println("Current students in the swim class: " + swimStudents);
						swimming.setNumberOfStudentsEnrolled(swimStudents);
					} else {
						System.out.println("Sorry, this class has reached the maximum number of students allowed.");
						addStudent();
					}
					break;
				case 3:
					if (pingPongStudents < 10) {
						pingPongStudents++;
						System.out.println("Current students in the ping pong class: " + pingPongStudents);
						pingPong.setNumberOfStudentsEnrolled(pingPongStudents);
					} else {
						System.out.println("Sorry, this class has reached the maximum number of students allowed.");
						addStudent();
					}
					break;
				case 4:
					if (badmintonStudents < 12) {
						badmintonStudents++;
						System.out.println("Current students in the badminton class: " + badmintonStudents);
						badminton.setNumberOfStudentsEnrolled(badmintonStudents);
					} else {
						System.out.println("Sorry, this class has reached the maximum number of students allowed.");
						addStudent();
					}
					break;
				case 5:
					if (yogaStudents < 15) {
						yogaStudents++;
						System.out.println("Current students in the yoga class: " + yogaStudents);
						yoga.setNumberOfStudentsEnrolled(yogaStudents);
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
				"Basketball Class: Thursdays only, 1:00 to 2:00 PM, Maximum Students: 20, Current: "
						+ basketballStudents,
				"Swim Class: Fridays and Saturdays, 1:00 to 2:00 PM, Students: 10, Current: " + swimStudents,
				"Ping Pong Class: Mondays only, 9:00 to 10:00AM, Maximum Students: 10, Current: " + pingPongStudents,
				"Badminton Class: Mondays only, 1:00 to 2:00, Maximum Students: 12, Current: " + badmintonStudents,
				"Yoga Class: MRFS, 4:00 to 5:00 PM, Maximum Students: 15, Current: " + yogaStudents };

		int choice;
		int yesNo;

		System.out.println("The classes that are available to choose from are as follows:\n");
		for (String i : classesShow) {
			System.out.println("\t" + i);
		}
		System.out.println();

		displayClassesNotYetScheduled();

		/*
		 * The following do... while loop will ask the user if they would like
		 * to add classes, and if classes are already scheduled, display error
		 * message and ask if they would like to schedule another. If not, go
		 * back to main menu
		 */
		do {
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
						basketball.setClassScheduled(true);
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
						swimming.setClassScheduled(true);

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
						pingPong.setClassScheduled(true);
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
						basketball.setClassScheduled(true);
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
						yoga.setClassScheduled(true);
						scheduleAgain();
					}
					break;
			}
		} while (choice != 0);
	}

	public static void studentRegistration() {

		int choice;
		int repeat;
		int pickStudent;
		int pickClass;
		int socialSecurityNumber;
		int phoneNumber;
		String name;
		String gender;
		String[] studentsInBasketball = new String[20];

		do {
			System.out.println(
					"Enter one of the following options:\n'0' to quit and return to the main menu\n'1' to register a new student");
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println(
						"Invalid input! Please enter '0' to quit and return to the main menu or '1' to register a new student.");
			}
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("\nWe will enter information for the new student.");
					System.out.println("Please enter the student's name: ");
					name = sc.next();
					System.out.println("Please enter the gender of the student: ");
					gender = sc.next();
					System.out.println("Please enter the student's social security number: ");
					socialSecurityNumber = sc.nextInt();
					System.out.println("Please enter a phone number for the student;");
					phoneNumber = sc.nextInt();
					Course.students.add(new Student(name, gender, socialSecurityNumber, phoneNumber));
					Course.printArray();
				/*
				 * When you add a student to a class, you pick from the list of students in the system
				 * If a student already signed up for this class, do not show the student in the list
				 *
				 * Not sure how to implement this
				 *
				 */
					System.out.println("Pick a student to sign up for a class.");
					pickStudent = sc.nextInt() - 1;
					System.out.println("Pick a class to sign the student up for:\n'1' for Basketball\n'2' for Swim\n'3' for Ping Pong\n'4' for Badminton\n'5' for Yoga");
					pickClass = sc.nextInt();
					switch (pickClass) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
					}
					System.out.println("Do you want to register another student in the system?");
					System.out.println(
							"Please enter one of the following options:\n'0' to return to the main menu\n'1' to continue");
					repeat = sc.nextInt();
					if (repeat == 0) {
						studentRegistration();
					} else if (repeat == 1) {
						pickOption();
					}
			}
		} while (choice != 0);
	}

	public static void displayClasses() {

		System.out.println();
		basketball.printInfo();
		System.out.println();
		swimming.printInfo();
		System.out.println();
		pingPong.printInfo();
		System.out.println();
		badminton.printInfo();
		System.out.println();
		yoga.printInfo();
		System.out.println("\nWe will now return to the main menu.\n");

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

		System.out.println("The following classes have not been scheduled yet:\n");
		if (table[2][2] != classesDisplay[0]) {
			System.out.println("\t" + classesDisplay[0]);
		}
		if (table[2][3] != classesDisplay[1] && table[2][4] != classesDisplay[1]) {
			System.out.println("\t" + classesDisplay[1]);
		}
		if (table[1][1] != classesDisplay[2]) {
			System.out.println("\t" + classesDisplay[2]);
		}
		if (table[2][1] != classesDisplay[3]) {
			System.out.println("\t" + classesDisplay[3]);
		}
		if (table[4][1] != classesDisplay[4] && table[4][2] != classesDisplay[4] && table[4][3] != classesDisplay[4]
				&& table[4][4] != classesDisplay[4]) {
			System.out.println("\t" + classesDisplay[4] + "\n");
		}
	}
}
