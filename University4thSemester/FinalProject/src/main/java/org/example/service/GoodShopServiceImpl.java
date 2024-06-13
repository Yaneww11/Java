package org.example.service;

import org.example.data.Good;
import org.example.data.GoodShop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;

public class GoodShopServiceImpl {
    public Comparator<GoodShop> ComparatorByExpirationDate(){
        return Comparator.comparing(Good::getExpirationDate);
    }

    public static boolean checkForSale(GoodShop goodShop, int days){
        return !goodShop.getExpirationDate().minusDays(days).isAfter(LocalDate.now());
    }

    public static BigDecimal getOverchargeTypeGood(GoodShop goodShop) throws IllegalArgumentException {
        return goodShop.getShop().getBaseOverchargeByTypesGood()
                .entrySet()
                .stream()
                .filter(good -> good.getKey() == goodShop.getTypeGood())
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("The shop '" + goodShop.getShop().getName() +"' don't have overcharge for " +
                        goodShop.getTypeGood() + " good"));

    }

    public static BigDecimal sellingPrice(GoodShop goodShop) {
        BigDecimal result = sellingPriceWithoutSale(goodShop);

        boolean isSaleForGood = checkForSale(goodShop, goodShop.getShop().getDaysUntilExpirationDateForSale());

        if (isSaleForGood){
            result = result.subtract(result.multiply(goodShop.getShop().getSale()));
        }
        return result;
    }

    public static BigDecimal sellingPriceWithoutSale(GoodShop goodShop) {
        BigDecimal result = goodShop.getUnitShippingCost();
        BigDecimal overcharge = null;
        try {
            overcharge = getOverchargeTypeGood(goodShop);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        result = result.add(result.multiply(overcharge));
        return result;
    }

    public GoodShopServiceImpl() {
    }
}
