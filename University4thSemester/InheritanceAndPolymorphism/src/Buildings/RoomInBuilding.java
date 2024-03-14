package Buildings;

public class RoomInBuilding {
    private double area;
    private Building building;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "RoomInBuilding{" +
                "area=" + area +
                ", building=" + building +
                '}';
    }
}
