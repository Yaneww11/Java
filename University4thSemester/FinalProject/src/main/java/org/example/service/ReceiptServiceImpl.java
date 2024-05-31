package org.example.service;

import org.example.data.GoodShop;
import org.example.data.Receipt;
import org.example.data.Shop;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class ReceiptServiceImpl {
    public void writeReceipt(String outputFilename, Receipt receipt) {
        FileWriter fout = null;
        try {
            String filePath = "src/main/java/org/example/receipts/";
            fout = new FileWriter(new File(filePath+outputFilename), true);
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
        List<String> listOfGoods = new ArrayList<>();
        try (FileReader fis = new FileReader(new File(inputFilename))) {
            BufferedReader bufferedReader = new BufferedReader(fis);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listOfGoods.add(line.strip());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfGoods;
    }

    public static String SumAndSaleOfGood(Queue<GoodShop> queue){
        StringBuilder result = new StringBuilder();
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal sale = BigDecimal.ZERO;
        Iterator<GoodShop> it = queue.iterator();
        int counter = 0;
        while (it.hasNext()) {
            counter++;
            GoodShop good = it.next();
            BigDecimal goodPr = good.sellingPrice();
            sum = sum.add(goodPr);
            if (!it.hasNext()){
                break;
            }
            GoodShop nextGood = it.next();
            BigDecimal goodNextPr = nextGood.sellingPrice();
            if (!goodNextPr.equals(goodPr)){
                sale = goodNextPr.multiply(BigDecimal.valueOf(counter)).subtract(goodPr.multiply(BigDecimal.valueOf(counter)));
            }
            counter++;
            sum = sum.add(goodNextPr);

        }
        if (sale != BigDecimal.ZERO){
            sum = sum.add(sale);
            result.append(sum.toString());result.append("\n");
            result.append("            -").append(sale.toString());
        }
        else {
            result.append(sum);
        }

        return result.toString();
    }

    public void removeReceipt(Shop shop, Receipt receipt){
        String filePath = "src/main/java/org/example/receipts/"+receipt.getUuid();
        File myObj = new File(filePath);
        if (removeFile(myObj)) return;
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
            return true;
        }
        return false;
    }


    public static int getCountOfAllIssuedReceipt(){
        return new File("receipts").list().length;
    }
}
