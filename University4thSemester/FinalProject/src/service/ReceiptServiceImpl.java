package service;

import data.Receipt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReceiptServiceImpl {
    public void writeReceipt(String outputFilename, Receipt receipt) {
        FileWriter fout = null;
        try {
            fout = new FileWriter(new File("receipts/"+outputFilename), true);
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


    public int getCountOfIssuedReceipt(){
        return new File("receipts").list().length;
    }
}
