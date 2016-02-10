package samplemidterm;

public class Triangle extends GeometricShape {

    double base;
    double height;

    public void Rectangle(String name, String color, double base, double height) {

        super(name, color);
        this.base = base;
        this.height = height;

    }

    public void setBase(double base) {
        this.base = base;
    }

    public getBase(double base) {
        return base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public getHeight(double height) {
        return height;
    }


    @Override
    public double checkTriangleArea {
        return (base * height) / 2;
    }

    @Override
    public double checkRectangleArea() {

    }
}
