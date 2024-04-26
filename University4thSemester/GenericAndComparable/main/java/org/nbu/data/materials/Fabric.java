package org.nbu.data.materials;

public class Fabric extends Material {
    private boolean isMachineWashable;

    public Fabric(String name, boolean isMachineWashable) {
        super(name);
        this.isMachineWashable = isMachineWashable;
    }

    public boolean isMachineWashable() {
        return isMachineWashable;
    }

    @Override
    public String toString() {
        return "Fabrics{" +
                "isMachineWashable=" + isMachineWashable +
                "} " + super.toString();
    }
}
