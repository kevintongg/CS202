package lab2;

import java.util.ArrayList;

public class Course {

  public static ArrayList<Student> students = new ArrayList<>();

  public Course() {

		/*
     * default constructor
		 */
  }

  public Course(ArrayList<Student> students) {
    Course.students = students;
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
    Course.students = students;
  }
}