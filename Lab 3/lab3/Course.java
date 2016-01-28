package lab3;

import java.util.ArrayList;

public class Course {

	protected static ArrayList<Student> students = new ArrayList<>();
	protected static String className;
	protected static String classDayHours;
	protected static String description;
	protected static int studentsEnrolled;
	protected static int maximumAmountOfStudents;
	protected static boolean classScheduled;

	public Course(String className, String classDayHours, String description, int studentsEnrolled,
			int maximumAmountOfStudents, boolean classScheduled) {
		this.className = className;
		this.classDayHours = classDayHours;
		this.description = description;
		this.studentsEnrolled = studentsEnrolled;
		this.maximumAmountOfStudents = maximumAmountOfStudents;
		this.classScheduled = classScheduled;
	}

	public Course(ArrayList<Student> students) {
		this.students = students;
	}

	public static void printArray() {

		System.out.println("\nStudent information:\n");
		for (int i = 0; i < students.size(); i++) {
			System.out.println("Student #" + (i + 1) + ":\n");
			System.out.println("\tName: " + students.get(i).getName());
			System.out.println("\tGender: " + students.get(i).getGender());
			System.out.println("\tSSN: " + students.get(i).getSocialSecurityNumber());
			System.out.println("\tPhone Number: " + students.get(i).getPhoneNumber() + "\n");
			System.out.println("---------------------\n");
		}
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDayHours() {
		return classDayHours;
	}

	public void setClassDayHours(String classDayHours) {
		this.classDayHours = classDayHours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(int studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}

	public int getMaximumAmountOfStudents() {
		return maximumAmountOfStudents;
	}

	public void setMaximumAmountOfStudents(int maximumAmountOfStudents) {
		this.maximumAmountOfStudents = maximumAmountOfStudents;
	}

	public boolean isClassScheduled() {
		return classScheduled;
	}

	public void setClassScheduled(boolean classScheduled) {
		this.classScheduled = classScheduled;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (classDayHours == null) {
			if (other.classDayHours != null)
				return false;
		} else if (!classDayHours.equals(other.classDayHours))
			return false;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (maximumAmountOfStudents != other.maximumAmountOfStudents)
			return false;
		if (studentsEnrolled != other.studentsEnrolled)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classDayHours == null) ? 0 : classDayHours.hashCode());
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + maximumAmountOfStudents;
		result = prime * result + studentsEnrolled;
		return result;
	}

	@Override
	public String toString() {
		return "Course []";
	}
}