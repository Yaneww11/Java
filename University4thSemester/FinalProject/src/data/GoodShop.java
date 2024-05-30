package data;

import data.enums.TypeGood;
import service.GoodShopServiceImpl;
import service.ShopServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GoodShop extends Good{
    private final GoodShopServiceImpl goodShopService;
    private Shop shop;

    public GoodShop(String name, TypeGood typeGood, BigDecimal unitShippingCost, LocalDate expirationDate,
                    Shop shop, GoodShopServiceImpl goodShopService) {
        super(name, typeGood, unitShippingCost, expirationDate);
        this.shop = shop;
        this.goodShopService = goodShopService;
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
        return goodShopService.sellingPrice(this);
    }
}
