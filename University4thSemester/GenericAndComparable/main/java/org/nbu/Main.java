package org.nbu;

import org.nbu.data.items.Clothes;
import org.nbu.data.items.Detail;
import org.nbu.data.items.Shoes;
import org.nbu.data.items.enums.ClothesType;
import org.nbu.data.items.enums.DifficultyLevel;
import org.nbu.data.items.enums.ShoesType;
import org.nbu.data.materials.Fabric;
import org.nbu.data.materials.Leather;
import org.nbu.data.materials.Material;
import org.nbu.service.DetailsServiceImpl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Material material = new Material("Rubber");
        Leather leather = new Leather("Leather", false);
        Fabric fabric = new Fabric("Silk", true);

        Detail detail1 = new Detail("Sleeve", fabric, DifficultyLevel.HIGH);
        Detail detail2 = new Detail("Front Part", fabric, DifficultyLevel.LOW);
        Detail detail3 = new Detail("Back Part", fabric, DifficultyLevel.LOW);

        List<Detail> clothesDetails = List.of(detail1, detail2, detail3);
        Clothes clothes = new Clothes(clothesDetails, ClothesType.SHIRT);

        Detail detail4 = new Detail("Upper Part", leather, DifficultyLevel.MEDIUM);
        Detail detail5 = new Detail("Lower Part", material, DifficultyLevel.MEDIUM);
        Detail detail6 = new Detail("Lower Part", material, DifficultyLevel.MEDIUM);

        System.out.println(detail5.equals(detail6));

        List<Detail> shoesDetails = Arrays.asList(detail1,detail4, detail1, detail5);
        Shoes shoes = new Shoes(shoesDetails, ShoesType.SNEAKERS);

        System.out.println(clothes);
        System.out.println();
        System.out.println(shoes);
        System.out.println();
        System.out.println(shoesDetails);
        shoesDetails.sort(Comparator.naturalOrder());
        System.out.println();
        System.out.println(shoesDetails);
        DetailsServiceImpl detailsService = new DetailsServiceImpl();
        shoesDetails.sort(detailsService.comparatorByDifficultyLevel().thenComparing(Comparator.naturalOrder()));
    }
}