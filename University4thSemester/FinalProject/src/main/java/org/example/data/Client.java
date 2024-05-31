package org.example.data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Client extends People implements CanGetGoods {
    private BigDecimal money;
    private Map<String, Queue<GoodShop>> dictWithGoods;

    public Client(String name, BigDecimal money) {
        super(name);
        this.money = money;
        this.dictWithGoods = new HashMap<>();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "Client{" +
                "money=" + money +
                "} " + super.toString();
    }

    @Override
    public HashMap<String, Queue<GoodShop>> getGoods() {
        return (HashMap<String, Queue<GoodShop>>) dictWithGoods;
    }


}
