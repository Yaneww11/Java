package ElectricDevices;

public class WashingMachine extends  ElectricDevice{
    private boolean drying;

    public WashingMachine(Manufacturer manufacturer, int min_warranty, boolean drying) {
        super(manufacturer, min_warranty);
        this.drying = drying;
    }

    public boolean isDrying() {
        return drying;
    }

    public int warranty(){
        if (this.drying)
            return (int) (super.warranty() + getMin_warranty() * 0.5);
        return super.warranty();
    }

    @Override
    public String toString() {
        return "WashingMachine{" +
                "drying=" + drying +
                "} " + super.toString();
    }
}
