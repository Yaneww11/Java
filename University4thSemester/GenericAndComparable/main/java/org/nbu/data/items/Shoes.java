package org.nbu.data.items;

import org.nbu.data.items.enums.ShoesType;

import java.util.List;

public class Shoes extends Item {
    private ShoesType shoesType;

    public Shoes(ShoesType shoesType) {
        this.shoesType = shoesType;
    }

    public Shoes(List<Detail> details, ShoesType shoesType) {
        super(details);
        this.shoesType = shoesType;
    }

    public ShoesType getShoesType() {
        return shoesType;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "shoesType=" + shoesType +
                "} " + super.toString();
    }
}
