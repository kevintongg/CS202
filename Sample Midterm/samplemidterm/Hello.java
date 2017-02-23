package samplemidterm;

import java.util.ArrayList;

public class Hello {

  public static void main(String[] args) {

    ArrayList<GeometricShape> shapes = new ArrayList<>();

    Rectangle rectangle = new Rectangle("Rectangle", "red", 20, 20);
    Triangle triangle = new Triangle("Triangle", "yellow", 20, 20);

    shapes.add(rectangle);
    shapes.add(triangle);

    for (GeometricShape i : shapes) {
      System.out.println(i);
    }
  }
}
