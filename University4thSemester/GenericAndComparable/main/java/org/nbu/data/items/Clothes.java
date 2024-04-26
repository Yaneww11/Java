package org.nbu.data.items;

import org.nbu.data.items.enums.ClothesType;

import java.util.List;

public class Clothes extends Item {
    private ClothesType clothesType;

    public Clothes(ClothesType clothesType) {
        this.clothesType = clothesType;
    }

    public Clothes(List<Detail> details, ClothesType clothesType) {
        super(details);
        this.clothesType = clothesType;
    }

    public ClothesType getClothesType() {
        return clothesType;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "clothesType=" + clothesType +
                "} " + super.toString();
    }
}
