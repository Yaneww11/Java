package Figures;

public class Rectangle extends Figure{
    public Rectangle(double a, double b) {
        super(a, b);
    }
    // override area for rectangle
    @Override
    public double area() {
        System.out.println("Inside Area for Rectangle.");
        return dim1 * dim2;
    }

}
