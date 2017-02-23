package samplemidterm;

public class Rectangle extends GeometricShape {

  double width;
  double height;
  String name;
  String color;

  public void Rectangle(String name, String color, double width, double height) {

    super(name, color);
    this.name = name;
    this.width = width;
    this.height = height;

  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getWidth(double width) {
    return width;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getHeight(double height) {
    return height;
  }

  @Override
  public double checkRectangleArea() {
    return width * height;
  }

  @Override
  public double checkTriangleArea() {
    return 0;
  }

}
