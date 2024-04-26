package org.nbu.data.materials;

public class Leather extends Material {
    private boolean isSynthetic;

    public Leather(String name, boolean isSynthetic) {
        super(name);
        this.isSynthetic = isSynthetic;
    }

    public boolean isSynthetic() {
        return isSynthetic;
    }

    @Override
    public String toString() {
        return "Leather{" +
                "isSynthetic=" + isSynthetic +
                "} " + super.toString();
    }
}
