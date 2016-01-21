package lab2;

import java.util.ArrayList;

public class Course {

	public static ArrayList<Student> students = new ArrayList<Student>();

	public Course() {

		/*
		 * default constructor
		 */
	}

	public Course(ArrayList<Student> students) {
		this.students = students;
	}

	public void printArray() {

		for (Student i : students) {
			System.out.println(i);
		}
	}

	public void addStudent(Student studentToAdd) {

	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
}