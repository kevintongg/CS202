package lab2;

public class Student {

	public String[] name;
	public char[] gender;
	public int[] SSN;
	public int[] phoneNumber;

	public Student() {

		/*
		 * default constructor
		 */
	}

	public void addStudent(String[] name, char[] gender, int[] SSN, int[] phoneNumber) {

		this.name = name;
		this.gender = gender;
		this.SSN = SSN;
		this.phoneNumber = phoneNumber;

	}
}