package samplemidterm;

public class Rectangle extends GeometricShape {

    double width;
    double height;

    public void Rectangle(String name, String color, double width, double height) {

        super(name, color);
        this.width = width;
        this.height = height;

    }

    public void setWidth(double width) {
        this.width = width;
    }

    public getWidth(double width) {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public getHeight(double height) {
        return height;
    }


    @Override
    public double checkRectangleArea {
        return width * height;
    }

    @Override
    public double checkTriangleArea() {

    }
}
