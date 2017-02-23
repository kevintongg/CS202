package lab3;

public class Student {

  private String name;
  private String gender;
  private int socialSecurityNumber;
  private int phoneNumber;

  public Student() {

		/*
     * default constructor
		 */
  }

  public Student(String name, String gender, int socialSecurityNumber, int phoneNumber) {
    this.name = name;
    this.gender = gender;
    this.socialSecurityNumber = socialSecurityNumber;
    this.phoneNumber = phoneNumber;
  }

  public void addStudents() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  public void setSocialSecurityNumber(int socialSecurityNumber) {
    this.socialSecurityNumber = socialSecurityNumber;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

}