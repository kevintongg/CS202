package samplemidterm;

public abstract class GeometricShape {

    String name;
    String color;

    public void GeometricShape(String name, String color) {

        this.name = name;
        this.color = color;

    }

    abstract public double checkRectangleArea();
    abstract public double checkTriangleArea();

    public void setName(String name) {
        this.name = name;
    }

    public getName(String name) {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public getColor(String color) {
        return color;
    }

    @Override
    public String toString() {
        return /* some toString body here */;
    }

}