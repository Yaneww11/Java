package org.example;

import org.example.data.Cashier;
import org.example.data.GoodShop;
import org.example.data.Receipt;
import org.example.service.ReceiptServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptServiceImplTest {
    private ReceiptServiceImpl receiptService;
    private Cashier cashier;
    private Receipt receipt;
    private String testOutputFilename = "test_receipt.txt";
    private String testInputFilename = "test_goods.txt";

    @BeforeEach
    public void setUp() {
        receiptService = new ReceiptServiceImpl();
        cashier = new Cashier("Test Cashier", new BigDecimal("1000"));
        Map<String, Queue<GoodShop>> goods = new HashMap<>();
        receipt = new Receipt(cashier, goods, new BigDecimal("100"));
    }

    @Test
    public void testWriteReceipt_Success() throws IOException {
        String filePath = "src/main/java/org/example/receipts/";
        File testFile = new File(filePath + testOutputFilename);
        testFile.getParentFile().mkdirs();

        receiptService.writeReceipt(testOutputFilename, receipt);

        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            String line = reader.readLine();
            assertEquals(receipt.toString(), line);
        } finally {
            testFile.delete();
            testFile.getParentFile().delete();
        }
    }

    @Test
    public void testWriteReceipt_FileNotFoundException() {
        String invalidDirectory = "/invalid_directory/test_receipt.txt";

        receiptService.writeReceipt(invalidDirectory, receipt);
        fail("Expected an IOException to be thrown");
    }

    @Test
    public void testReadGoodsFromFile_Success() throws IOException {
        File testFile = new File(testInputFilename);
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("Good 1\nGood 2\n");
        }

        List<String> goods = receiptService.readGoodsFromFile(testInputFilename);

        assertEquals(2, goods.size());
        assertEquals("Good 1", goods.get(0));
        assertEquals("Good 2", goods.get(1));

        testFile.delete();
    }

    @Test
    public void testReadGoodsFromFile_IOException() throws IOException {
        String invalidFilename = "/invalid_directory/test_goods.txt";

        List<String> goods = receiptService.readGoodsFromFile(invalidFilename);
        assertTrue(goods.isEmpty());
    }

    @Test
    public void testGetCountOfIssuedReceipt() {
        String filePath = "src/main/java/org/example/receipts/";
        File receiptsDir = new File(filePath);
        receiptsDir.mkdirs();
        File file1 = new File(receiptsDir, "receipt1.txt");
        File file2 = new File(receiptsDir, "receipt2.txt");

        try {
            file1.createNewFile();
            file2.createNewFile();

            int count = receiptService.getCountOfAllIssuedReceipt();
            assertEquals(2, count);
        } catch (IOException e) {
            fail("Setup of test files failed");
        } finally {
            file1.delete();
            file2.delete();
            receiptsDir.delete();
        }
    }
}
