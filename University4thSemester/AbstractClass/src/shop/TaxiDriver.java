package shop;

public class TaxiDriver extends RegisterProvider{
    private double distance;
    private double pricePerKm;

    public TaxiDriver(String regNumber, double distance, double pricePerKm) {
        super(regNumber);
        this.distance = distance;
        this.pricePerKm = pricePerKm;
    }

    public double earnings() {
        return this.pricePerKm*this.distance;
    }

    public String toString() {
        return "TaxiDriver{" +
                "distance=" + distance +
                ", pricePerKm=" + pricePerKm +
                "} " + super.toString();
    }
}
