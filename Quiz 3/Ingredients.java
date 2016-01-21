import java.util.Scanner;

public class Ingredients {

    public String name;
    public String description;
    public double unit;
    public String costPerUnit;
    public double caloriesPerUnit;
    static Scanner sc = new Scanner(System.in);

    public Ingredients() {
        // default constructor
    }

    public Ingredients(String name, String description, String costPerUnit, double unit, double caloriesPerUnit) {
        this.name = name;
        this.description = description;
        this.costPerUnit = costPerUnit;
        this.unit = unit;
        this.caloriesPerUnit = caloriesPerUnit;
    }

    public void askForInfo() {
        System.out.println("What is the name of your ingredient?");
        name = sc.next();
        System.out.println("What is a description of your ingredient?");
        description = sc.next();
        System.out.println("What unit is your ingredient in? (grams, litres, etc.)");
        unit = sc.nextDouble();
        System.out.println("What is the cost per unit of your ingredient?");
        costPerUnit = sc.next();
        System.out.println("How many calories does your ingredient have?");
        caloriesPerUnit = sc.nextDouble();

    }

    public void printInfo() {

        System.out.println(name);
        System.out.println(description);
        System.out.println(unit);
        System.out.println(costPerUnit);
        System.out.println(caloriesPerUnit);

    }


}
