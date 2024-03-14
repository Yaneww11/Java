package ElectricDevices;

public class ElectricDevice {
    private Manufacturer manufacturer;
    private int min_warranty;


    public ElectricDevice(Manufacturer manufacturer, int min_warranty) {
        this.manufacturer = manufacturer;
        setMin_warranty(min_warranty);
    }

    public int warranty(){
        if (this.manufacturer.isWarranty()){
            return min_warranty + 12;
        }
        return min_warranty;
    }

    public void setMin_warranty(int min_warranty) {
        if (min_warranty <= 6)
            this.min_warranty = 6;
        else
            this.min_warranty = min_warranty;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public int getMin_warranty() {
        return min_warranty;
    }

    @Override
    public String toString() {
        return "ElectricDevice{" +
                "manufacturer=" + manufacturer +
                ", min_warranty=" + min_warranty +
                '}';
    }
}
