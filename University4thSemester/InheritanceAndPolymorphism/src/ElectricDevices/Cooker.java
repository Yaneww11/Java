package ElectricDevices;

public class Cooker extends ElectricDevice{
    private boolean gas;


    public Cooker(Manufacturer manufacturer, int min_warranty, boolean gas) {
        super(manufacturer, min_warranty);
        this.gas = gas;
    }

    public boolean isGas() {
        return gas;
    }

    public int warranty(){
        if (this.gas){
            return super.warranty() + 12;
        }
        return super.warranty();
    }

    @Override
    public String toString() {
        return "Cooker{" +
                "gas=" + gas +
                "} " + super.toString();
    }
}
