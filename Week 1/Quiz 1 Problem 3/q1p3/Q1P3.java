package q1p3;

public class Q1P3 {

    public static void main(String[] args) {

        System.out.println("First iteration:");
        checkNumsPretty(101);
        System.out.println("Second iteration:");
		checkNumsPretty(102);
        System.out.println("Third iteration:");
		checkNumsPretty(201);
        System.out.println("Fourth iteration:");
		checkNumsPretty(202);
    }

    public static void checkNumsPretty(int max) {

        for (int i = 1; i <= max; i++) {
            int firstNum = Integer.parseInt(Integer.toString(i).substring(0, 1));
            int lastNum = i % 10;

            if (firstNum == lastNum) {
                System.out.println("\tpretty");
            } else {
                System.out.println("\t" + i);
            }
        }
    }
}
