package lab2;

public class Schedule extends Course {

	private String className;
	private String dayHour;
	private String description;
	private String studentsEnrolled;
	private int numberOfStudentsEnrolled;
	private String maxStudents;
	private boolean classScheduled = true;

	public Schedule() {

		/*
		 * default constructor
		 */

	}

	public void printInfo() {

		System.out.println(className);
		System.out.println(dayHour);
		System.out.println(studentsEnrolled + numberOfStudentsEnrolled);
		System.out.println(maxStudents);

		if (classScheduled) {
			System.out.println("This class has been scheduled.");
		} else {
			System.out.println("This class has not been scheduled yet.");
		}
	}

	public Schedule(String className, String dayHour, String description, String studentsEnrolled,
					int studentsEnrolledNumber, String maxStudents, boolean classScheduled) {
		this.className = className;
		this.dayHour = dayHour;
		this.description = description;
		this.studentsEnrolled = studentsEnrolled;
		this.numberOfStudentsEnrolled = studentsEnrolledNumber;
		this.maxStudents = maxStudents;
		this.classScheduled = classScheduled;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDayHour() {
		return dayHour;
	}

	public void setDayHour(String dayHour) {
		this.dayHour = dayHour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(String studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}

	public int getNumberOfStudentsEnrolled() {
		return numberOfStudentsEnrolled;
	}

	public void setNumberOfStudentsEnrolled(int studentsEnrolledNumber) {
		this.numberOfStudentsEnrolled = studentsEnrolledNumber;
	}

	public String getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(String maxStudents) {
		this.maxStudents = maxStudents;
	}

	public boolean isClassScheduled() {
		return classScheduled;
	}

	public void setClassScheduled(boolean classScheduled) {
		this.classScheduled = classScheduled;
	}
}
