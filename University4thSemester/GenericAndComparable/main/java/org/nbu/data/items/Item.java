package org.nbu.data.items;

import org.nbu.data.materials.Material;

import java.io.Serializable;
import java.util.List;

public class Item implements GetDetails, Serializable {
    private List<Detail> details;

    public Item() {
    }

    public Item(List<Detail> details) {
        this.details = details;
    }

    public List<Detail> getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Item{" +
                "details=" + details +
                '}';
    }
}
