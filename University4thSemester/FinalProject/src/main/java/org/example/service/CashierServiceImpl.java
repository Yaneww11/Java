package org.example.service;

import org.example.data.Cashier;
import org.example.data.Shop;

import java.util.Iterator;
import java.util.List;

public class CashierServiceImpl {
    public boolean startWork(Cashier cashier, Shop shop){
        if (!cashier.isFree()){
            return false;
        }

        if (shop.getCashRegisters().size() + 1 <= shop.getMaxCountCashRegister()){
            cashierStartWorking(cashier, shop);
            return true;
        }

        Iterator<Cashier> iterator = shop.getCashRegisters().iterator();
        List<Cashier> cashiers = shop.getCashRegisters();
        while (iterator.hasNext()) {
            if (iterator.next() == null){
                cashierStartWorking(cashier, shop);
                return true;
            }
        }
        return false;
    }

    private static void cashierStartWorking(Cashier cashier, Shop shop) {
        shop.getCashRegisters().add(cashier);
        cashier.setFree(false);
    }

    public boolean changeCashier(Cashier workCashier, Cashier freeCashier, Shop shop){
        List<Cashier> cashiers = shop.getCashRegisters();
        changeTwoCashiers(workCashier, freeCashier, cashiers);

        return true;
    }

    private void changeTwoCashiers(Cashier workCashier, Cashier freeCashier, List<Cashier> cashiers) {
        checkIsFree(workCashier, freeCashier);
        int indexWorkCashier = cashiers.indexOf(workCashier);
        cashiers.set(indexWorkCashier, freeCashier);
        changeIsFreeCashiers(workCashier, freeCashier);
    }

    private void checkIsFree(Cashier workCashier, Cashier freeCashier) {
        if (!freeCashier.isFree()) {
            throw new IllegalArgumentException(freeCashier.getName() + " is working can`t change " + workCashier.getName());
        }
    }

    private static void changeIsFreeCashiers(Cashier workCashier, Cashier freeCashier) {
        workCashier.setFree(true);
        freeCashier.setFree(false);
    }

    public void restCashier(Cashier cashier, Shop shop){
        checkIsNotFree(cashier);
        List<Cashier> cashiers = shop.getCashRegisters();
        restCashier(cashier, cashiers);
    }

    private static void restCashier(Cashier cashier, List<Cashier> cashiers) {
        int indexWorkCashier = cashiers.indexOf(cashier);
        cashiers.set(indexWorkCashier, null);
        cashier.setFree(true);
    }

    private static void checkIsNotFree(Cashier cashier) {
        if (cashier.isFree()){
            throw new IllegalArgumentException(cashier.getName() + " is not working");
        }
    }
}
