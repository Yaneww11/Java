package exersise3;

public class TradeCenter {
    protected String name;
    protected String address;
    protected double profit;

    public TradeCenter(String name, String address, double profit) {
        this.name = name;
        this.address = address;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "TradeCenter{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", profit=" + profit +
                '}';
    }
}
