package Buildings;

public class Building {
    private double area;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "area=" + area +
                '}';
    }
}
