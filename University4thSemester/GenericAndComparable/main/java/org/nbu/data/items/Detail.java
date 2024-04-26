package org.nbu.data.items;

import org.nbu.data.items.enums.DifficultyLevel;
import org.nbu.data.materials.Material;

import java.util.Objects;
import java.util.UUID;

public class Detail implements Comparable<Detail>{
    private final UUID uuid;
    private String name;
    private Material material;

    private DifficultyLevel difficultyLevel;

    public Detail(String name, Material material, DifficultyLevel difficultyLevel) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.material = material;
        this.difficultyLevel = difficultyLevel;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "name='" + name + '\'' +
                ", material=" + material +
                ", difficultyLevel=" + difficultyLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return Objects.equals(uuid, detail.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public int compareTo(Detail o) {
        return this.getName().compareTo(o.getName());
    }
}
