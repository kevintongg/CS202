import java.util.Scanner;

public class IngredientsMain {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String name = new Ingredients();
    String description = new Ingredients();
    double unit = new Ingredients();
    String costPerUnit = new Ingredients();
    Ingredients caloriesPerUnit = new Ingredients();

    System.out.println("What is the name of your ingredient?");
    name = sc.nextLine();
    System.out.println("What is a description of your ingredient?");
    description = sc.nextLine();
    System.out.println("What unit is your ingredient in? (grams, litres, etc.)");
    unit = sc.nextDouble();
    System.out.println("What is the cost per unit of your ingredient?");
    costPerUnit = Double.parseDouble(sc.nextLine());
    System.out.println("How many calories does your ingredient have?");
    caloriesPerUnit = sc.nextDouble();
  }
}
