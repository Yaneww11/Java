package service;

import data.Cashier;
import data.Shop;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class CashierServiceImpl {
    public boolean startWork(Cashier cashier, Shop shop){
        if (!cashier.isFree()){
            throw new IllegalArgumentException(cashier.getName() + " is working");
        }

        if (shop.getCashRegisters().size() + 1 <= shop.getCountCashRegister()){
            shop.getCashRegisters().add(cashier);
            cashier.setFree(false);
            return true;
        }

        Iterator<Cashier> iterator = shop.getCashRegisters().iterator();
        List<Cashier> cashiers = shop.getCashRegisters();
        int indexWorkCashier = -1;
        while (iterator.hasNext()) {
            indexWorkCashier++;
            if (iterator.next() == null){
                cashiers.set(indexWorkCashier, cashier);
                cashier.setFree(false);
                return true;
            }
        }

        return false;
    }
    public boolean changeCashier(Cashier workCashier, Cashier freeCashier, Shop shop){
        List<Cashier> cashiers = shop.getCashRegisters();
        if (!freeCashier.isFree()){
            throw new IllegalArgumentException(workCashier.getName() + " is working");
        }
        int indexWorkCashier = cashiers.indexOf(workCashier);
        cashiers.set(indexWorkCashier, freeCashier);
        workCashier.setFree(true);
        freeCashier.setFree(false);
        return true;
    }

    public boolean restCashier(Cashier cashier, Shop shop){
        if (cashier.isFree()){
            throw new IllegalArgumentException(cashier.getName() + " is not working");
        }
        List<Cashier> cashiers = shop.getCashRegisters();
        int indexWorkCashier = cashiers.indexOf(cashier);
        cashiers.set(indexWorkCashier, null);
        cashier.setFree(true);
        return true;
    }
}
