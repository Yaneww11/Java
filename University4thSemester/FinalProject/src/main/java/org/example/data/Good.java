package org.example.data;

import org.example.data.enums.TypeGood;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class Good implements CanBeSold{
    private final UUID uuid;
    private String name;
    private TypeGood typeGood;
    private BigDecimal unitShippingCost;
    private LocalDate expirationDate;

    public Good(String name,TypeGood typeGood,  BigDecimal unitShippingCost, LocalDate expirationDate) {
        this.uuid = UUID.randomUUID();;
        this.name = name;
        setUnitShippingCost(unitShippingCost);
        setExpirationDate(expirationDate);
        this.typeGood = typeGood;
    }

    private void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate.isAfter(LocalDate.now())){
            this.expirationDate = expirationDate;
        }
        else {
            throw new IllegalArgumentException("The value of "
                    + "the argument must be date after "
                    + LocalDate.now()
                    + "! The argument is: "
                    + expirationDate);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitShippingCost() {
        return this.unitShippingCost;
    }

    public void setUnitShippingCost(BigDecimal unitShippingCost) {
        if (unitShippingCost.compareTo(BigDecimal.ZERO) == 1){
            this.unitShippingCost = unitShippingCost;
        }
        else {
            throw new IllegalArgumentException("The value of "
                    + "the argument must be positive number more than 0"
                    + "! The argument is: "
                    + unitShippingCost);
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public TypeGood getTypeGood() {
        return this.typeGood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Good good)) return false;
        return Objects.equals(getUuid(), good.getUuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid());
    }

    @Override
    public String toString() {
        return "Good{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", unitShippingCost=" + unitShippingCost +
                '}';
    }
}
