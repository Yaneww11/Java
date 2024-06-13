package org.example.service;

import org.example.data.*;

import java.util.PriorityQueue;


public class ShopServiceImpl extends MapGoodService {
    private final GoodShopServiceImpl goodShopService;
    private final ClientServiceImpl clientService;
    public ShopServiceImpl(GoodShopServiceImpl goodShopService, ClientServiceImpl clientService) {
        this.goodShopService = goodShopService;
        this.clientService = clientService;
    }

    public void putGood(Shop shop, GoodShop goodShop){
        if (!shop.getGoods().containsKey(goodShop.getName())){
            shop.getGoods().put(goodShop.getName(),
                    new PriorityQueue<GoodShop>(goodShopService.ComparatorByExpirationDate()));
        }
        if (!shop.getGoods().get(goodShop.getName()).isEmpty() &&
                shop.getGoods().get(goodShop.getName()).peek().getUnitShippingCost() != goodShop.getUnitShippingCost()){
            throw new IllegalArgumentException("In shop have that "
                    + goodShop.getName()
                    + " for another price! Change the name of good ");
        }
        shop.getDeliveredGoods().add(goodShop);
        shop.getGoods().get(goodShop.getName()).add(goodShop);
    }
    public void clearAllGoods(Shop shop){
        shop.getGoods().clear();
        shop.getDeliveredGoods().clear();
    }

    public void putGood(Shop shop, GoodShop goodShop, int countGoods){
        if (countGoods < 1){
            return;
        }
        for (int i = 0; i < countGoods; i++) {
            putGood(shop, goodShop);
        }
    }

    public void printBaseGoodTypeOvercharge(Shop shop){
        shop.getBaseOverchargeByTypesGood()
                .entrySet()
                .stream()
                .forEach(good -> System.out.println("The overcharge for " + good.getKey() + " product is " + good.getValue()));
    }
}
