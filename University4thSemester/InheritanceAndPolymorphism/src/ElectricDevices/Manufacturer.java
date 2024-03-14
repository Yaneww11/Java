package ElectricDevices;

public class Manufacturer {
    private String name;
    private boolean warranty;

    public Manufacturer(String name, boolean warranty) {
        this.name = name;
        this.warranty = warranty;
    }

    public String getName() {
        return name;
    }

    public boolean isWarranty() {
        return warranty;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", warranty=" + warranty +
                '}';
    }
}
