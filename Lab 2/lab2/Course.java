package lab2;

public class Course {

    public String className;
    public String dayHour;
    public String description;
    public String studentsEnrolled;
    public String maxStudents;
    public boolean classScheduled;

    public Course() {

		/*
         * default constructor
		 */
    }

    public Course(String className, String dayHour, String description, String studentsEnrolled, String maxStudents, boolean classScheduled) {

        this.className = className;
        this.dayHour = dayHour;
        this.description = description;
        this.studentsEnrolled = studentsEnrolled;
        this.maxStudents = maxStudents;
        this.classScheduled = classScheduled;

    }

    public void print() {

        System.out.println(className);
        System.out.println(dayHour);
        System.out.println(description);
        System.out.println(studentsEnrolled);
        System.out.println(maxStudents);

        if (classScheduled == true) {
            System.out.println("This class has been scheduled.\n");
        } else {
            System.out.println("This class has not been scheduled yet.\n");
        }
    }
}
