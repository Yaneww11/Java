package org.example.service;

import org.example.data.GoodShop;
import org.example.data.Receipt;
import org.example.data.Shop;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class ReceiptServiceImpl {
    public void writeReceipt(String outputFilename, Receipt receipt) {
        FileWriter fout = null;
        try {
            String filePath = "src/main/java/org/example/receipts/";
            fout = new FileWriter(new File(filePath + outputFilename), true);
            if (receipt != null) {
                fout.write(receipt.toString() + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (IOException e) {
            System.out.println("IOException " + e);
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public List<String> readGoodsFromFile(String inputFilename) {
        String filePath = "src/main/java/org/example/receipts/";
        List<String> listOfGoods = new ArrayList<>();
        try (FileReader fis = new FileReader(new File(filePath + inputFilename))) {
            BufferedReader bufferedReader = new BufferedReader(fis);
            String line;
            int counter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (counter != 0 && counter != 4 ){ // Skip to add 'Receipt:' and 'Products:' in list
                    listOfGoods.add(line.strip());
                }
                counter++;
            }
            int last_index = listOfGoods.size() -1;
            listOfGoods.set(0, listOfGoods.get(0).replace("uuid is ",""));
            listOfGoods.set(1, listOfGoods.get(1).replace("cashier is ",""));
            listOfGoods.set(2, listOfGoods.get(2).replace("Date of receipt: ",""));
            listOfGoods.set(last_index, listOfGoods.get(last_index).replace("totalSum = ",""));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfGoods;
    }

    public static String SumAndSaleOfGood(Queue<GoodShop> queue){
        StringBuilder result = new StringBuilder();
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal sale = BigDecimal.ZERO;
        for (GoodShop good : queue) {
            BigDecimal goodPr = good.sellingPrice();
            BigDecimal goodPrWithoutSale = GoodShopServiceImpl.sellingPriceWithoutSale(good);
            sum = sum.add(goodPr);
            if (goodPr.compareTo(goodPrWithoutSale) != 0) {
                sale = goodPrWithoutSale.subtract(goodPr);
            }
        }
        sum = sum.add(sale);
        result.append(sum.toString());
        if (sale.compareTo(BigDecimal.ZERO) != 0){
            addSaleToString(result, sum, sale);
        }

        return result.toString();
    }

    private static void addSaleToString(StringBuilder result, BigDecimal sum, BigDecimal sale) {
        result.append("\n");
        result.append("            -").append(sale.toString());
    }

    public void removeReceipt(Shop shop, Receipt receipt){
        String filePath = "src/main/java/org/example/receipts/"+receipt.getUuid();
        File myObj = new File(filePath);
        if (!removeFile(myObj))
            return;
        if (removeReceiptFromShop(shop, receipt)){
            System.out.println("Receipt is removed from shop");
            return;
        }
        System.out.println("In "+ shop.getName() + " does not have this receipt: " + receipt.getUuid());
    }

    private static boolean removeReceiptFromShop(Shop shop, Receipt receipt) {
        return shop.getReceiptSet().remove(receipt);
    }

    private static boolean removeFile(File myObj) {
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
            return false;
        }
        return true;
    }


    public static int getCountOfAllIssuedReceipt(){
        return new File("receipts").list().length;
    }
}
