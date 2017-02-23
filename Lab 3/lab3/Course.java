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
    Course.className = className;
    Course.classDayHours = classDayHours;
    Course.description = description;
    Course.studentsEnrolled = studentsEnrolled;
    Course.maximumAmountOfStudents = maximumAmountOfStudents;
    Course.classScheduled = classScheduled;
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

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    Course.className = className;
  }

  public String getClassDayHours() {
    return classDayHours;
  }

  public void setClassDayHours(String classDayHours) {
    Course.classDayHours = classDayHours;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    Course.description = description;
  }

  public int getStudentsEnrolled() {
    return studentsEnrolled;
  }

  public void setStudentsEnrolled(int studentsEnrolled) {
    Course.studentsEnrolled = studentsEnrolled;
  }

  public int getMaximumAmountOfStudents() {
    return maximumAmountOfStudents;
  }

  public void setMaximumAmountOfStudents(int maximumAmountOfStudents) {
    Course.maximumAmountOfStudents = maximumAmountOfStudents;
  }

  public boolean isClassScheduled() {
    return classScheduled;
  }

  public void setClassScheduled(boolean classScheduled) {
    Course.classScheduled = classScheduled;
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
      if (classDayHours != null)
        return false;
    } else if (!classDayHours.equals(classDayHours))
      return false;
    if (className == null) {
      if (className != null)
        return false;
    } else if (!className.equals(className))
      return false;
    if (description == null) {
      if (description != null)
        return false;
    } else if (!description.equals(description))
      return false;
    if (maximumAmountOfStudents != maximumAmountOfStudents)
      return false;
    return studentsEnrolled == studentsEnrolled;
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