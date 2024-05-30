package data;

import java.math.BigDecimal;

public class Cashier extends People{
    private BigDecimal salary;
    private boolean isFree;

    public Cashier(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
        this.isFree = true;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return
                this.getName();
    }
}
