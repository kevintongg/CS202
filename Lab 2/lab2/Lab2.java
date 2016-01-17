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
	}
}
