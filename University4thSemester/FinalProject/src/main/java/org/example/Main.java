package org.example;

import org.example.data.*;
import org.example.data.enums.TypeGood;
import org.example.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        GoodShopServiceImpl shopGoodService = new GoodShopServiceImpl();
        ReceiptServiceImpl receiptService = new ReceiptServiceImpl();
        ClientServiceImpl clientService = new ClientServiceImpl(receiptService);
        ShopServiceImpl shopService = new ShopServiceImpl(shopGoodService, clientService);
        CashierServiceImpl cashierService = new CashierServiceImpl();

        Shop s1 = new Shop("Tabaco Shop", 5,  3,
                BigDecimal.valueOf(50), BigDecimal.valueOf(200), BigDecimal.TEN);


        GoodShop g1 = new GoodShop("Book", TypeGood.NONFOOD, BigDecimal.valueOf(10),
                LocalDate.of(2024, 6, 1), s1, shopGoodService);
        GoodShop g2 = new GoodShop("Apple", TypeGood.NUTRITIONAL, BigDecimal.valueOf(3),
                LocalDate.of(2024, 6, 1), s1, shopGoodService);
        GoodShop apple2 = new GoodShop("Apple", TypeGood.NUTRITIONAL, BigDecimal.valueOf(3),
                LocalDate.of(2024, 7, 30), s1, shopGoodService);

        Cashier cashier1 = new Cashier("Ivo", BigDecimal.valueOf(1600));
        Cashier cashier2 = new Cashier("Ivan", BigDecimal.valueOf(1600));
        Cashier cashier3 = new Cashier("Iva", BigDecimal.valueOf(1600));
        Cashier cashier4 = new Cashier("Petyr", BigDecimal.valueOf(1600));

        Client client1 = new Client("Yane", BigDecimal.valueOf(50));

        System.out.println(g1);



        shopService.putGood(s1, g1);
        shopService.putGood(s1, apple2, 2);
        shopService.putGood(s1, g2, 1);
        System.out.println(apple2.sellingPrice());
        shopService.printGoodsCount(s1);

        cashierService.startWork(cashier1, s1);
        cashierService.startWork(cashier2, s1);
        cashierService.startWork(cashier3, s1);
        System.out.println(s1.getCashRegisters());
        cashierService.changeCashier(cashier1, cashier4, s1);

        clientService.putGood(client1, "Apple", 3, s1);
        Receipt receipt1 = clientService.buyGoods(client1, s1, 2);
        shopService.printGoodsCount(s1);
        shopService.printGoodsCount(s1);
        clientService.putGood(client1, "Book", s1);
        Receipt receipt = clientService.buyGoods(client1, s1, 2);
        shopService.printGoodsCount(s1);
        System.out.println(s1.getTurnover());

        shopService.printGoods(s1);
        System.out.println("Deliver Goods - " + s1.getDeliveredGoods().size());
        System.out.println("Sold Goods - " +s1.getSoldGoods().size());
        receiptService.removeReceipt(s1, receipt);
        receiptService.removeReceipt(s1, receipt);
        System.out.println(s1.getReceiptSet());
    }
}