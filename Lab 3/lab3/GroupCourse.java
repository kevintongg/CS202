package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class GroupCourse extends Course {

  private static ArrayList<GroupCourse> groupCourses = new ArrayList<>();
  private static String roomId;
  private static boolean doesStudentBringOwnEquipment;

  public GroupCourse(String className, String classDayHours, String description, int studentsEnrolled,
                     int maximumAmountOfStudents, boolean classScheduled, String roomId, boolean doesStudentBringOwnEquipment) {
    super(className, classDayHours, description, studentsEnrolled, maximumAmountOfStudents, classScheduled);
    GroupCourse.roomId = roomId;
    GroupCourse.doesStudentBringOwnEquipment = doesStudentBringOwnEquipment;
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
    System.out.println("What is the room ID?: ");
    roomId = sc.next();
    System.out.println("Does the student bring their own equipment? (True/False): ");
    doesStudentBringOwnEquipment = sc.nextBoolean();
    groupCourses.add(new GroupCourse(className, classDayHours, className, studentsEnrolled, maximumAmountOfStudents,
        doesStudentBringOwnEquipment, roomId, doesStudentBringOwnEquipment));
  }

  public static void printClassInfo() {
    for (int i = 0; i < groupCourses.size(); i++) {
      System.out.println("Group Course #" + (i + 1) + ":\n");
      System.out.println("\tClass name: " + groupCourses.get(i).getClassName());
      System.out.println("\tClass days/hours: " + groupCourses.get(i).getClassDayHours());
      System.out.println("\tClass description: " + groupCourses.get(i).getDescription());
      System.out.println("\tNumber of students enrolled: " + groupCourses.get(i).getStudentsEnrolled());
      System.out.println("\tMaximum number of students: " + groupCourses.get(i).getMaximumAmountOfStudents());
      System.out.println("\tIs class scheduled: " + groupCourses.get(i).isClassScheduled());
      System.out.println("\tRoom ID: " + groupCourses.get(i).getRoomId());
      System.out.println("\tDoes the student bring their own equipment?: " + groupCourses.get(i).isDoesStudentBringOwnEquipment());
    }
  }

  public String getRoomId() {
    return roomId;
  }

  public void setRoomId(String roomId) {
    GroupCourse.roomId = roomId;
  }

  public boolean isDoesStudentBringOwnEquipment() {
    return doesStudentBringOwnEquipment;
  }

  public void setDoesStudentBringOwnEquipment(boolean doesStudentBringOwnEquipment) {
    GroupCourse.doesStudentBringOwnEquipment = doesStudentBringOwnEquipment;
  }

  @Override
  public String toString() {
    return "GroupCourse [roomId=" + roomId + ", doesStudentBringOwnEquipment=" + doesStudentBringOwnEquipment + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + (doesStudentBringOwnEquipment ? 1231 : 1237);
    result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    GroupCourse other = (GroupCourse) obj;
    if (doesStudentBringOwnEquipment != doesStudentBringOwnEquipment)
      return false;
    if (roomId == null) {
      if (roomId != null)
        return false;
    } else if (!roomId.equals(roomId))
      return false;
    return true;
  }

}
