package data;

import data.enums.TypeGood;

import java.math.BigDecimal;
import java.util.*;

public class Shop implements CanGetGoods {
    private String name;
    private int daysUntilExpirationDateForSale;
    private BigDecimal sale;
    private int countCashRegister;
    private BigDecimal overchargeNutritional;
    private BigDecimal overchargeNonFood;
    private BigDecimal turnover;
    private int countReceipts;
    private EnumMap<TypeGood, BigDecimal> baseOverchargeByTypeGood;
    private Map<String, Queue<GoodShop>> dictWithGoods;
    private List<Cashier> cashRegisters;
    private List<GoodShop> deliveredGoods;
    private List<GoodShop> soldGoods;


    public Shop(String name, int daysUntilExpirationDateForSale, int countCashRegister, BigDecimal sale,
                BigDecimal overchargeNutritional, BigDecimal overchargeNonFood) {
        this.name = name;
        this.daysUntilExpirationDateForSale = daysUntilExpirationDateForSale;
        this.countCashRegister = countCashRegister;
        this.sale = sale.divide(BigDecimal.valueOf(100));;
        this.overchargeNutritional = overchargeNutritional.divide(BigDecimal.valueOf(100));
        this.overchargeNonFood = overchargeNonFood.divide(BigDecimal.valueOf(100));
        this.baseOverchargeByTypeGood = new EnumMap<>(TypeGood.class);
        this.dictWithGoods = new HashMap<>();
        this.cashRegisters = new ArrayList<>();
        this.turnover = BigDecimal.ZERO;
        this.countReceipts = 0;
        putGoodTypeOvercharge(this, TypeGood.NONFOOD, this.getOverchargeNonFood());
        putGoodTypeOvercharge(this, TypeGood.NUTRITIONAL, this.getOverchargeNutritional());
        this.deliveredGoods = new LinkedList<>();
        this.soldGoods = new LinkedList<>();
    }

    private void putGoodTypeOvercharge(Shop shop, TypeGood typeGood, BigDecimal overcharge){
        if (overcharge.compareTo(BigDecimal.ZERO) == -1){
            throw new IllegalArgumentException("The value of "
                    + "the argument must be more than 0 "
                    + "! The argument is: "
                    + overcharge);
        }
        shop.getBaseOverchargeByTypesGood().put(typeGood, overcharge);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysUntilExpirationDateForSale() {
        return daysUntilExpirationDateForSale;
    }

    public void setDaysUntilExpirationDateForSale(int daysUntilExpirationDateForSale) {
        this.daysUntilExpirationDateForSale = daysUntilExpirationDateForSale;
    }

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }

    public int getCountCashRegister() {
        return countCashRegister;
    }

    public void setCountCashRegister(int countCashRegister) {
        this.countCashRegister = countCashRegister;
    }

    public BigDecimal getOverchargeNutritional() {
        return overchargeNutritional;
    }

    public void setOverchargeNutritional(BigDecimal overchargeNutritional) {
        this.overchargeNutritional = overchargeNutritional;
    }

    public BigDecimal getOverchargeNonFood() {
        return overchargeNonFood;
    }

    public void setOverchargeNonFood(BigDecimal overchargeNonFood) {
        this.overchargeNonFood = overchargeNonFood;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public EnumMap<TypeGood, BigDecimal> getBaseOverchargeByTypesGood() {
        return baseOverchargeByTypeGood;
    }

    public Map<String, Queue<GoodShop>> getGoods() {
        return dictWithGoods;
    }

    public EnumMap<TypeGood, BigDecimal> getBaseOverchargeByTypeGood() {
        return baseOverchargeByTypeGood;
    }

    public List<Cashier> getCashRegisters() {
        return cashRegisters;
    }

    public Map<String, Queue<GoodShop>> getDictWithGoods() {
        return dictWithGoods;
    }

    public List<GoodShop> getDeliveredGoods() {
        return deliveredGoods;
    }

    public void setCountReceipts(int countReceipts) {
        this.countReceipts = countReceipts;
    }

    public int getCountReceipts() {
        return countReceipts;
    }

    public List<GoodShop> getSoldGoods() {
        return soldGoods;
    }

    private BigDecimal putGoodTypeOvercharge(TypeGood typeGood, BigDecimal overcharge){
        if (overcharge.compareTo(BigDecimal.ZERO) == -1){
            throw new IllegalArgumentException("The value of "
                    + "the argument must be more than 0 "
                    + "! The argument is: "
                    + overcharge);
        }
        return this.getBaseOverchargeByTypesGood().put(typeGood, overcharge);
    }

}
