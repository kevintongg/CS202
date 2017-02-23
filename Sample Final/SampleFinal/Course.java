package SampleFinal;

public class Course {

  private String courseName;

  public Course() {

  }

  public Course(String courseName) {
    this.courseName = courseName;
  }

  @Override
  public String toString() {
    return courseName;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

}
