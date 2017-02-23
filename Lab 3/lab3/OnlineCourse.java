package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class OnlineCourse extends Course {

  private static ArrayList<Course> onlineCourses = new ArrayList<>();
  private static String url;
  private static boolean availableAfterEnd;

  public OnlineCourse(String className, String classDayHours, String description, int studentsEnrolled,
                      int maximumAmountOfStudents, boolean classScheduled, String url, boolean availableAfterEnd) {
    super(className, classDayHours, description, studentsEnrolled, maximumAmountOfStudents, classScheduled);
    OnlineCourse.url = url;
    OnlineCourse.availableAfterEnd = availableAfterEnd;
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
    System.out.println("Please enter a URL for your class: ");
    url = sc.next();
    System.out.println("Please specify if the class is available after it ends (True/False): ");
    availableAfterEnd = sc.nextBoolean();
    onlineCourses.add(new OnlineCourse(className, classDayHours, description, studentsEnrolled,
        maximumAmountOfStudents, availableAfterEnd, url, availableAfterEnd));
  }

  public static void printClassInfo() {

    for (int i = 0; i < onlineCourses.size(); i++) {
      System.out.println("Online Course #" + (i + 1) + ":\n");
      System.out.println("\tClass name: " + onlineCourses.get(i).getClassName());
      System.out.println("\tClass days/hours: " + onlineCourses.get(i).getClassDayHours());
      System.out.println("\tClass description: " + onlineCourses.get(i).getDescription());
      System.out.println("\tNumber of students enrolled: " + onlineCourses.get(i).getStudentsEnrolled());
      System.out.println("\tMaximum number of students: " + onlineCourses.get(i).getMaximumAmountOfStudents());
      System.out.println("\tIs class scheduled: " + onlineCourses.get(i).isClassScheduled());
      System.out.println("\tClass URL: " + ((OnlineCourse) onlineCourses.get(i)).getUrl());
      System.out.println("\tIs class available after end: " + ((OnlineCourse) onlineCourses.get(i)).isAvailableAfterEnd());
    }
  }


  public static ArrayList<Course> getOnlineCourses() {
    return onlineCourses;
  }

  public static void setOnlineCourses(ArrayList<Course> onlineCourses) {
    OnlineCourse.onlineCourses = onlineCourses;
  }

  public static String getUrl() {
    return url;
  }

  public static void setUrl(String url) {
    OnlineCourse.url = url;
  }

  public static boolean isAvailableAfterEnd() {
    return availableAfterEnd;
  }

  public static void setAvailableAfterEnd(boolean availableAfterEnd) {
    OnlineCourse.availableAfterEnd = availableAfterEnd;
  }

  @Override
  public String toString() {
    return "OnlineCourse [url=" + url + ", availableAfterEnd=" + availableAfterEnd + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + (availableAfterEnd ? 1231 : 1237);
    result = prime * result + ((url == null) ? 0 : url.hashCode());
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
    OnlineCourse other = (OnlineCourse) obj;
    if (availableAfterEnd != availableAfterEnd)
      return false;
    if (url == null) {
      if (url != null)
        return false;
    } else if (!url.equals(url))
      return false;
    return true;
  }

}
