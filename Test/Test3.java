import java.util.Scanner;

public class Test3 {

	static Scanner sc = new Scanner(System.in);

	static final double PI = Math.PI;
	static double greatestTriangle = 0;
	static double greatestSphere = 0;
	static double greatestCylinder = 0;

	public static void main(String[] args) {

		int pick = 0;

		do {
			System.out.println("Enter 0 to quit, 1 to calculate the area of a triangle, 2 to calculate the volume of a sphere, 3 to calculate the volume of a cylinder.");
			pick = sc.nextInt();
			switch (pick) {
				case 1:
					System.out.printf("The area for your triangle is: %.2f.\n", calcTriangleArea());
					break;
				case 2:
					System.out.printf("The volume for your sphere is: %.2f.\n", calcSphereVolume());
					break;
				case 3:
					System.out.printf("The volume for your cylinder is: %.2f.\n", calcCylinderVolume());
					break;
			}
			if (pick < 0 || pick > 3) {
				System.out.println("Invalid input. Please enter 0 to quit, 1 to calculate the area of a triangle, 2 to calculate the volume of a sphere, 3 to calculate the volume of a cylinder.");
			}
		} while (pick != 0);

		System.out.printf("The greatest area calculated for your triangle is: %.2f.\n", greatestTriangle);
		System.out.printf("The greatest volume calculated for your sphere is: %.2f.\n", greatestSphere);
		System.out.printf("The greatest volume calculated for your cylinder is: %.2f.\n", greatestCylinder);
	}

	public static double calcTriangleArea() {

		double b;
		double h1;
		double triangleArea;

		do {
			// Asks user for a base
			System.out.println("Please input a base between 0.0 and 123.45.");
			while (!sc.hasNextDouble()) {
				sc.nextLine();
				System.out.println("A base value between 0.0 and 123.45 please!");
			}
			b = sc.nextDouble();
			if (b < 0.0 || b > 123.45) {
				System.out.println("A base value between 0.0 and 123.45 please!");
			}
		} while (b < 0.0 || b > 123.45);

		do {
			// Asks user a height
			System.out.println("Please enter a height between 0.0 and 123.45 (A value that is bigger than your first number, please).");
			while (!sc.hasNextDouble()) {
				sc.nextLine();
				System.out.println("Your input is invalid and cannot be used or is not between 0.0 to 123.45");
			}
			h1 = sc.nextDouble();
			if (b > h1 || h1 > 123.45) {
				System.out.println("A height value that is higher than the first number, but no more than 123.45 please!");
			}
		} while (b > h1 || h1 > 123.45);

		triangleArea = (1/2.0) * b * h1;

		checkTriangle(triangleArea);

		return triangleArea;

	}

	public static double calcSphereVolume() {

		double r2;
		double sphereVolume;

		do {
			// Asks user for a radius
			System.out.println("Please input a radius value between 0.0 and 123.45.");
			while (!sc.hasNextDouble()) {
				sc.nextLine();
				System.out.println("Your input is invalid and cannot be used or is not between 0.0 to 123.45");
			}
			r2 = sc.nextDouble();
			if (r2 < 0.0 || r2 > 123.45) {
				System.out.println("A radius value between 0.0 and 123.45 please!");
			}
		} while (r2 < 0.0 || r2 > 123.45);

		sphereVolume = (4/3.0) * PI * Math.pow(r2, 3);

		checkSphere(sphereVolume);

		return sphereVolume;
	}

	public static double calcCylinderVolume() {

		double r2;
		double h2;
		double cylinderVolume;

		do {
			// Asks user for a radius
			System.out.println("Please input a radius between 0.0 and 123.45.");
			while (!sc.hasNextDouble()) {
				sc.nextLine();
				System.out.println("Your input is invalid and cannot be used or is not between 0.0 to 123.45");
			}
			r2 = sc.nextDouble();
			if (r2 < 0.0 || r2 > 123.45) {
				System.out.println("A radius value between 0.0 and 123.45 please!");
			}
		} while (r2 < 0.0 || r2 > 123.45);

		do {
			// Asks user for a height
			System.out.println("Please input a height between 0.0 and 123.45 (A value that is bigger than your first number, please).");
			while (!sc.hasNextDouble()) {
				sc.nextLine();
				System.out.println("Your input is invalid and cannot be used or is not between 0.0 to 123.45");
			}
			h2 = sc.nextDouble();
			if (r2 > h2 || h2 > 123.45) {
				System.out.println("A height value that is higher than the first number, but no more than 123.45 please!");
			}
		}	while (r2 > h2 || h2 > 123.45);

		cylinderVolume = PI * Math.pow(r2, 2) * h2;

		checkCylinder(cylinderVolume);

		return cylinderVolume;
	}

	public static void checkTriangle(double max) {
		if (max > greatestTriangle) {
			greatestTriangle = max;
		}
	}

	public static void checkSphere(double max) {
		if (max > greatestSphere) {
			greatestSphere = max;
		}
	}

	public static void checkCylinder(double max) {
		if (max > greatestCylinder) {
			greatestCylinder = max;
		}
	}
}