package org.nbu.data.materials;

import java.io.Serializable;
import java.util.UUID;

public class Material implements Serializable {
    private UUID uuid;
    private String name;

    public Material(String name) {
        this.uuid = UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Material{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                '}';
    }
}
