package clases;

public class WeightedItem extends DeliverableItem{
    private final Material material;
    private double weight;
    private double priceDeliveryPerKg;

    public WeightedItem(boolean isPersonalAddress, Material material, double weight, double priceForDelivery) {
        super(isPersonalAddress);
        this.material = material;
        setWeight(weight);
        setPriceDeliveryPerKg(priceForDelivery);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0){
            this.weight = 1;
        }
        else {
            this.weight = weight;
        }
    }

    public double getPriceDeliveryPerKg() {
        return priceDeliveryPerKg;
    }

    public void setPriceDeliveryPerKg(double priceDeliveryPerKg) {
        if (priceDeliveryPerKg <= 0){
            this.priceDeliveryPerKg = 1;
        }
        else {
            this.priceDeliveryPerKg = priceDeliveryPerKg;
        }
    }

    @Override
    public double deliveryPrice() {
        double priceMaterial = this.weight*this.priceDeliveryPerKg;
        if (isPersonalAddress()){
            priceMaterial = priceMaterial + getAdditionalPrice();
            if (material.isFragile()){
                return priceMaterial + priceMaterial * 0.01;
            }
            else {
                return priceMaterial;
            }
        }
        if (material.isFragile()){
            return priceMaterial + priceMaterial * 0.01;
        }
        return priceMaterial;
    }
}

