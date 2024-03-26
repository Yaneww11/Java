package clases;

public class Document extends DeliverableItem{
    private double minPrice;

    public Document(boolean isPersonalAddress, double minPrice) {
        super(isPersonalAddress);
        setMinPrice(minPrice);
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        if (minPrice <= 0){
            this.minPrice = 1;
        }
        else {
            this.minPrice = minPrice;
        }
    }

    @Override
    public double deliveryPrice() {
        if (isPersonalAddress()){
            return this.minPrice + getAdditionalPrice();
        }
        return this.minPrice;
    }
}
