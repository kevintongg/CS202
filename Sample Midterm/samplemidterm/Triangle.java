package samplemidterm;

public class Triangle extends GeometricShape {

  double base;
  double height;

  public void Rectangle(String name, String color, double base, double height) {

    super(name, color);
    this.base = base;
    this.height = height;

  }

  @Override
  public String toString() {
    return "Triangle{" +
        "base=" + base +
        ", height=" + height +
        '}';
  }

  public double getBase() {
    return base;
  }

  public void setBase(double base) {
    this.base = base;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  @Override
  public double checkRectangleArea() {
    return base * height;
  }
}
