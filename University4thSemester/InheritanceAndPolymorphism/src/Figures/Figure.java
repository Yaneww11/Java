package Figures;

public class Figure {
    protected double dim1;
    protected double dim2;

    public Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }
    public double area() {
        System.out.println("Area for Figure is undefined.");
        return 0;
    }

}
