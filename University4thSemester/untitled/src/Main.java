import exersiseGoods.Goods;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void readGoodsPrice() {
        System.out.println("Enter the price of the goods: ");
        double price = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            while ((price = scanner.nextDouble()) <= 0) {
                System.out.println("Enter positive number!");
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public static void writeGoods(String outputFilename, Goods goods) {
        FileWriter fout = null;
        try {
            fout = new FileWriter(new File(outputFilename), true);
            if (goods != null) {
                fout.write(goods.toString() + System.lineSeparator());
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

    public static List<String> readGoodsFromFile(String inputFilename) {
        List<String> listOfGoods = new ArrayList<>();
        try (FileReader fis = new FileReader(new File(inputFilename))) {
            BufferedReader bufferedReader = new BufferedReader(fis);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listOfGoods.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfGoods;
    }

    public static void main(String[] args) {

        // Creating folder named "files" in the project folder
        File filesDirectory = new File("files");
        System.out.println("Folder named files is created: " + filesDirectory.mkdir());

        /* Task 1
        {
            readGoodsPrice();
        }
        */
        // Task 2
        {
            Goods goods1 = new Goods("meat", 15);
            Goods goods2 = new Goods("butter", 6);
            Goods goods3 = new Goods("milk", 2);

            String filename = "files/GoodsData.txt";

            /*
            writeGoods(filename, goods1);
            writeGoods(filename, goods2);
            writeGoods(filename, goods3);
             */

            List<String> goodsFromFile = new ArrayList<>(readGoodsFromFile(filename));
            System.out.println(goodsFromFile);
        }

    }
}