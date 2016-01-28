package lab3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class IndividualCourse extends Course {

	private static ArrayList<IndividualCourse> individualCourses = new ArrayList<>();
	private static String instructorName;
	private static int hoursScheduled;
	private static BigDecimal hourlyRate;

	public IndividualCourse(String className, String classDayHours, String description, int studentsEnrolled,
			int maximumAmountOfStudents, boolean classScheduled, String instructorName, int hoursScheduled,
			BigDecimal hourlyRate) {
		super(className, classDayHours, description, studentsEnrolled, maximumAmountOfStudents, classScheduled);
		this.instructorName = instructorName;
		this.hoursScheduled = hoursScheduled;
		this.hourlyRate = hourlyRate;
	}

	public static void askUserForInfo() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a class name: ");
		className = sc.nextLine();
		System.out.println("Enter the class's day/hours (in one line): ");
		classDayHours = sc.nextLine();
		System.out.println("Enter a class description: ");
		description = sc.nextLine();
		System.out.println("Enter the number of students enrolled: ");
		studentsEnrolled = sc.nextInt();
		System.out.println("Enter the maximum amount of students allowed in the class: ");
		maximumAmountOfStudents = sc.nextInt();
		System.out.println("Is the class scheduled? (True/False): ");
		classScheduled = sc.nextBoolean();
		System.out.println("What is the name of the instructor?: ");
		instructorName = sc.next();
		System.out.println("How many hours are you scheduling for the class?: ");
		hoursScheduled = sc.nextInt();
		System.out.println("What is the hourly rate for this class?: ");
		hourlyRate = sc.nextBigDecimal();
		individualCourses.add(new IndividualCourse(className, classDayHours, description, studentsEnrolled,
				maximumAmountOfStudents, classScheduled, instructorName, hoursScheduled, hourlyRate));

	}

	public static void printClassInfo() {
		
		for (int i = 0; i < individualCourses.size(); i++) {
			System.out.println("Individual Course #" + (i + 1) + ":\n");
			System.out.println("\tClass name: " + individualCourses.get(i).getClassName());
			System.out.println("\tClass days/hours: " + individualCourses.get(i).getClassDayHours());
			System.out.println("\tClass description: " + individualCourses.get(i).getDescription());
			System.out.println("\tNumber of students enrolled: " + individualCourses.get(i).getStudentsEnrolled());
			System.out.println("\tMaximum number of students: " + individualCourses.get(i).getMaximumAmountOfStudents());
			System.out.println("\tIs class scheduled: " + individualCourses.get(i).isClassScheduled());
			System.out.println("\tName of instructor: " + individualCourses.get(i).getInstructorName());
			System.out.println("\tHours for class: " + individualCourses.get(i).getHoursScheduled());
			System.out.println("\tClass's hourly rate: " + individualCourses.get(i).getHourlyRate());
			System.out.println("---------------------\n");
		}
	}

	public static ArrayList<IndividualCourse> getIndividuals() {
		return individualCourses;
	}

	public static void setIndividuals(ArrayList<IndividualCourse> individuals) {
		IndividualCourse.individualCourses = individuals;
	}

	public static String getInstructorName() {
		return instructorName;
	}

	public static void setInstructorName(String instructorName) {
		IndividualCourse.instructorName = instructorName;
	}

	public static int getHoursScheduled() {
		return hoursScheduled;
	}

	public static void setHoursScheduled(int hoursScheduled) {
		IndividualCourse.hoursScheduled = hoursScheduled;
	}

	public static BigDecimal getHourlyRate() {
		return hourlyRate;
	}

	public static void setHourlyRate(BigDecimal hourlyRate) {
		IndividualCourse.hourlyRate = hourlyRate;
	}

	@Override
	public String toString() {
		return "IndividualCourse [getStudents()=" + getStudents() + ", getClassName()=" + getClassName()
				+ ", getClassDayHours()=" + getClassDayHours() + ", getDescription()=" + getDescription()
				+ ", getStudentsEnrolled()=" + getStudentsEnrolled() + ", getMaximumAmountOfStudents()="
				+ getMaximumAmountOfStudents() + ", isClassScheduled()=" + isClassScheduled() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
}