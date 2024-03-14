package Figures;

public class Triangle extends Figure{
    public Triangle(double a, double b) {
        super(a, b);
    }

    // override area for right triangle
    @Override
    public double area() {
        System.out.println("Inside Area for Triangle.");
        return dim1 * dim2 / 2;
    }

}
