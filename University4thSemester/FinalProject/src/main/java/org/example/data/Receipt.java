package org.example.data;

import org.example.service.ReceiptServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Receipt {
    private final UUID uuid;
    private final Cashier cashier;
    private final LocalDateTime createData;
    private final Map<String, Queue<GoodShop>> listOfGoods;
    private final BigDecimal totalSum;

    public Receipt(Cashier cashier, Map<String, Queue<GoodShop>> listOfGoods, BigDecimal totalSum) {
        this.uuid = UUID.randomUUID();
        this.createData = LocalDateTime.now();
        this.cashier = cashier;
        this.listOfGoods = listOfGoods;
        this.totalSum = totalSum;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public LocalDateTime getCreateData() {
        return createData;
    }

    public Map<String, Queue<GoodShop>> getListOfGoods() {
        return listOfGoods;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    @Override
    public String toString() {
        return "            Receipt: " +
                "\nuuid is " + uuid +
                "\ncashier is " + cashier +
                "\nDate of receipt: " + createData +
                "\nProducts: " +
                "\n" + MapWithGoodsToString(listOfGoods) +
                "\ntotalSum = " + totalSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Receipt receipt)) return false;
        return Objects.equals(getUuid(), receipt.getUuid());
    }
    public String MapWithGoodsToString(Map<String, Queue<GoodShop>> map) {
        StringBuilder mapAsString = new StringBuilder("");
        for (Map.Entry<String, Queue<GoodShop>> entry : map.entrySet()) {
            mapAsString.append(entry.getKey()).append(" x ").append(entry.getValue().size())
                    .append(" = ").append(ReceiptServiceImpl.SumAndSaleOfGood(entry.getValue())).append("\n");
        }
        return mapAsString.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid());
    }
}
