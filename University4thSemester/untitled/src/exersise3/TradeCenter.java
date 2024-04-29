package exersise3;

import java.io.Serializable;

public class TradeCenter implements Serializable {
    protected String name;
    protected transient String address;
    protected static double profit;

    public TradeCenter() {
    }

    public TradeCenter(String name, String address) {
        this.name = name;
        this.address = address;

    }

    public static double getProfit() {
        return profit;
    }

    public static void setProfit(double profit) {
        TradeCenter.profit = profit;
    }

    @Override
    public String toString() {
        return "TradeCenter{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
