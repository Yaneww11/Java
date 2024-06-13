package org.example.data;

import org.example.data.enums.TypeGood;
import org.example.service.GoodShopServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GoodShop extends Good{
    private Shop shop;

    public GoodShop(String name, TypeGood typeGood, BigDecimal unitShippingCost, LocalDate expirationDate,
                    Shop shop) {
        super(name, typeGood, unitShippingCost, expirationDate);
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }


    @Override
    public String toString() {
        return "GoodShop{" +
                "Shop=" + this.shop +
                "} " + super.toString();
    }


    @Override
    public BigDecimal sellingPrice() {
        return GoodShopServiceImpl.sellingPrice(this);
    }
}
