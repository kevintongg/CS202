public class Test3 {

	public static void main(String[] args) {

		checkNumsPretty(323);
		checkNumsPretty(221);
	}

	public static void checkNumsPretty(int max) {

		int firstMax = Integer.parseInt(Integer.toString(max).substring(0, 1));
		int lastMax = max % 10;

		if (firstMax == lastMax) {
			System.out.println("pretty");
		} else {
			System.out.println(max);
		}
	}
}