package org.example;

import org.example.data.Cashier;
import org.example.data.Shop;
import org.example.service.CashierServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CashierServiceImplTest {
    private CashierServiceImpl cashierService;
    private Shop shop;
    private Cashier cashier1;
    private Cashier cashier2;
    private Cashier cashier3;

    @BeforeEach
    public void setUp() {
        cashierService = new CashierServiceImpl();
        shop = new Shop("Test Shop", 10, 2, new BigDecimal("0.1"), new BigDecimal("0.2"), new BigDecimal("0.3"));
        cashier1 = new Cashier("Cashier 1", new BigDecimal("1000"));
        cashier2 = new Cashier("Cashier 2", new BigDecimal("1000"));
        cashier3 = new Cashier("Cashier 3", new BigDecimal("1000"));
    }

    @Test
    public void testStartWork_Success() {
        boolean result = cashierService.startWork(cashier1, shop);
        assertTrue(result);
        assertFalse(cashier1.isFree());
        assertEquals(1, shop.getCashRegisters().size());
        assertTrue(shop.getCashRegisters().contains(cashier1));
    }

    @Test
    public void testStartWork_CashierAlreadyWorking() {
        cashier1.setFree(false);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            cashierService.startWork(cashier1, shop);
        });
        assertEquals(cashier1.getName() + " is working", exception.getMessage());
    }

    @Test
    public void testStartWork_NoSpace() {
        cashierService.startWork(cashier1, shop);
        cashierService.startWork(cashier2, shop);
        boolean result = cashierService.startWork(cashier3, shop);
        assertFalse(result);
    }

    @Test
    public void testChangeCashier_Success() {
        cashierService.startWork(cashier1, shop);
        cashierService.startWork(cashier2, shop);
        boolean result = cashierService.changeCashier(cashier1, cashier3, shop);
        assertTrue(result);
        assertTrue(cashier1.isFree());
        assertFalse(cashier3.isFree());
        assertTrue(shop.getCashRegisters().contains(cashier3));
        assertFalse(shop.getCashRegisters().contains(cashier1));
    }

    @Test
    public void testChangeCashier_FreeCashierNotFree() {
        cashierService.startWork(cashier1, shop);
        cashier3.setFree(false);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            cashierService.changeCashier(cashier1, cashier3, shop);
        });
        assertEquals(cashier1.getName() + " is working", exception.getMessage());
    }

    @Test
    public void testRestCashier_Success() {
        cashierService.startWork(cashier1, shop);
        boolean result = cashierService.restCashier(cashier1, shop);
        assertTrue(result);
        assertTrue(cashier1.isFree());
        assertFalse(shop.getCashRegisters().contains(cashier1));
    }

    @Test
    public void testRestCashier_CashierNotWorking() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            cashierService.restCashier(cashier1, shop);
        });
        assertEquals(cashier1.getName() +" is not working", exception.getMessage());
    }
}
