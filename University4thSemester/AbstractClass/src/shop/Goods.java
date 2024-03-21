package shop;

public abstract class Goods implements CanBeSold{
    private double overcharge;

    public Goods(double overcharge) {
        this.overcharge = overcharge;
    }

    public double getOvercharge() {
        return overcharge;
    }

    public double sellingPrice(){
        return this.productionPrice() + this.productionPrice()/this.overcharge;
    }


    public String toString() {
        return "Goods{" +
                "overcharge=" + overcharge +
                '}';
    }
}
