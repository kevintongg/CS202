package lab3;

import java.util.ArrayList;

public class Schedule {

  private ArrayList<Course> courses = new ArrayList<>();
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

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Schedule other = (Schedule) obj;
    if (className == null) {
      if (other.className != null)
        return false;
    } else if (!className.equals(other.className))
      return false;
    if (classScheduled != other.classScheduled)
      return false;
    if (dayHour == null) {
      if (other.dayHour != null)
        return false;
    } else if (!dayHour.equals(other.dayHour))
      return false;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (maxStudents == null) {
      if (other.maxStudents != null)
        return false;
    } else if (!maxStudents.equals(other.maxStudents))
      return false;
    if (numberOfStudentsEnrolled != other.numberOfStudentsEnrolled)
      return false;
    if (studentsEnrolled == null) {
      if (other.studentsEnrolled != null)
        return false;
    } else if (!studentsEnrolled.equals(other.studentsEnrolled))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((className == null) ? 0 : className.hashCode());
    result = prime * result + (classScheduled ? 1231 : 1237);
    result = prime * result + ((dayHour == null) ? 0 : dayHour.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((maxStudents == null) ? 0 : maxStudents.hashCode());
    result = prime * result + numberOfStudentsEnrolled;
    result = prime * result + ((studentsEnrolled == null) ? 0 : studentsEnrolled.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Schedule [className=" + className + ", dayHour=" + dayHour + ", description=" + description
        + ", studentsEnrolled=" + studentsEnrolled + ", numberOfStudentsEnrolled=" + numberOfStudentsEnrolled
        + ", maxStudents=" + maxStudents + ", classScheduled=" + classScheduled + "]";
  }
}
