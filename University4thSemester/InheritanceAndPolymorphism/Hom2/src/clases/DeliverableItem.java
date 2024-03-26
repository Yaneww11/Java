package clases;

public abstract class DeliverableItem implements Deliverable{
    private boolean isPersonalAddress;
    static double additionalPrice;

    public DeliverableItem(boolean isPersonalAddress) {
        this.isPersonalAddress = isPersonalAddress;
    }

    public boolean isPersonalAddress() {
        return isPersonalAddress;
    }

    public void setPersonalAddress(boolean personalAddress) {
        isPersonalAddress = personalAddress;
    }

    public static double getAdditionalPrice() {
        return additionalPrice;
    }

    public static void setAdditionalPrice(double additionalPrice) {
        if (additionalPrice <= 0){
            DeliverableItem.additionalPrice = 1;
        }
        else {
            DeliverableItem.additionalPrice = additionalPrice;
        }

    }
}
