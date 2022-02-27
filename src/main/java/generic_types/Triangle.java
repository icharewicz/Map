package generic_types;

public class Triangle implements  IShape{
    private int a;
    private int h;

    public Triangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public double getArea() {
        return (double) a * h / 2;
    }
}
