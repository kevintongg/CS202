package q1p3;

public class Q1P3 {

	public static void main(String[] args) {

		checkNumsPretty(3583);
		checkNumsPretty(2024);
		checkNumsPretty(323);
		checkNumsPretty(221);
	}

	public static void checkNumsPretty(int max) {

		int firstNum = Integer.parseInt(Integer.toString(max).substring(0, 1));
		int lastNum = max % 10;

		if (firstNum == lastNum) {
			System.out.println("pretty");
		} else {
			System.out.println(max);
		}
	}
}
