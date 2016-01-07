import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        checkNumsPretty(1);
        checkNumsPretty(1);
    }

    public static void checkNumsPretty(int max) {

//        Scanner sc = new Scanner(System.in);
//        int num;
//
//        System.out.println("Please enter a number.");
//        while (!sc.hasNextInt()) {
//            sc.next();
//            System.out.println("Invalid input. Please enter a valid number.");
//        }
//        num = sc.nextInt();

        int num = 1001;
        int firstNum = Integer.parseInt(Integer.toString(num).substring(0));

        int last = num % 10;

        if (firstNum == last) {
            System.out.println("pretty");
        } else {
            System.out.println(num);
        }
    }
}
