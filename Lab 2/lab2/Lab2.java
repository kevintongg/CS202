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

	public static void main(String[] args) {

		Course basketball = new Course("Class name: Basketball",
				"Class Day(s)/Hours: Thursdays only from 1:00 to 2:00 PM",
				"Description: Come play basketball or learn how to play in this class",
				"Current number of students enrolled: " + basketballStudents, "Maximum amount of students allowed: 20",
				false);
		Course swimming = new Course("Class name: Swim",
				"Class Day(s)/Hours: Fridays and Saturdays from 1:00 to 2:00 PM",
				"Description: Come have fun and swim or learn how to swim like a pro!",
				"Current number of students enrolled: " + swimStudents, "Maximum number of students allowed: 10",
				false);
		Course pingPong = new Course("Class name: Ping Pong", "Class Day(s)/Hours: Mondays only from 9:00 to 10:00AM",
				"Description: Come play some table tennis in this action-packed class!",
				"Current number of students enrolled: " + pingPongStudents, "Maximum number of students allowed: 10",
				false);
		Course badminton = new Course("Class name: Badminton", "Class Day(s)/Hours: Mondays only from 1:00 to 2:00",
				"Description: Come play some badminton in this fun-filled class!",
				"Current number of students enrolled: " + badmintonStudents, "Maximum number of students allowed: 12",
				false);
		Course yoga = new Course("Class name: Yoga", "Class Day(s)/Hours: MFRS from 4:00 to 5:00 PM",
				"Description: Come train your body on how to become more flexible, or just to relieve stress",
				"Current number of students enrolled: " + yogaStudents, "Maximum number of students allowed: 15",
				false);

		basketball.print();
		swimming.print();
		pingPong.print();
        badminton.print();
        yoga.print();
	}

	public static void students(String name, char gender, int SSN, int phoneNumber) {

		Student student = new Student();

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

		/* Assigning the times and days onto the table */

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
}
