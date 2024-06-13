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

        Shop tabacoShop = new Shop("Tabaco Shop", 30,  3,
                BigDecimal.valueOf(50), BigDecimal.valueOf(200), BigDecimal.TEN);

        GoodShop book = new GoodShop("Book", TypeGood.NONFOOD, BigDecimal.valueOf(10),
                LocalDate.of(2040, 7, 1), tabacoShop);
        GoodShop apple1 = new GoodShop("Apple", TypeGood.NUTRITIONAL, BigDecimal.valueOf(3),
                LocalDate.of(2024, 7, 10), tabacoShop);
        GoodShop apple2 = new GoodShop("Apple", TypeGood.NUTRITIONAL, BigDecimal.valueOf(3),
                LocalDate.of(2024, 7, 20), tabacoShop);

        Cashier cashier1 = new Cashier("Ivo", BigDecimal.valueOf(1600));
        Cashier cashier2 = new Cashier("Ivan", BigDecimal.valueOf(1600));
        Cashier cashier3 = new Cashier("Iva", BigDecimal.valueOf(1600));
        Cashier cashier4 = new Cashier("Petyr", BigDecimal.valueOf(1600));

        Client client1 = new Client("Yane", BigDecimal.valueOf(50));

        // add items in shop
        try {
            shopService.putGood(tabacoShop, book, 2);
            shopService.putGood(tabacoShop, apple2, 5);
            shopService.putGood(tabacoShop, apple1, 1);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        // see selling price for apple
        System.out.println("Selling price of " + apple1.getName() + " with sale is "  + apple1.sellingPrice());
        System.out.println("Selling price of " + apple2.getName() + " is "  + apple2.sellingPrice());
        shopService.printGoodsCount(tabacoShop);

        // add cashiers in shop
        cashierService.startWork(cashier1, tabacoShop);
        cashierService.startWork(cashier1, tabacoShop);
        cashierService.startWork(cashier2, tabacoShop);
        cashierService.startWork(cashier3, tabacoShop);
        System.out.println(tabacoShop.getCashRegisters());

        // change cashier
        try {
            cashierService.changeCashier(cashier1, cashier4, tabacoShop);
        } catch (IllegalArgumentException | IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(tabacoShop.getCashRegisters());

        // client add goods
        clientService.putGood(client1, "Apple", 3, tabacoShop);
        clientService.putGood(client1, "Book", tabacoShop);
        // make receipt from client goods
        Receipt receipt1 = clientService.buyGoods(client1, tabacoShop, 1);

        shopService.printGoodsCount(tabacoShop);
        System.out.println("Deliver Goods - " + tabacoShop.getDeliveredGoods().size());
        System.out.println("Sold Goods - " +tabacoShop.getSoldGoods().size());
        System.out.println(receiptService.readGoodsFromFile(receipt1.getUuid().toString()));

        System.out.println("Turnover now in " + tabacoShop.getName() + " is: " +tabacoShop.getTurnover()+ "lv");
        System.out.println("After shopping " + client1.getName() + " has " + client1.getMoney() + "lv");

    }
}