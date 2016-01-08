public class Test2 {

	public static void main(String[] args) {

		int number = 534;
		int firstDigit = Integer.parseInt(Integer.toString(number).substring(0, 1));

		System.out.println(firstDigit);

	}
}
