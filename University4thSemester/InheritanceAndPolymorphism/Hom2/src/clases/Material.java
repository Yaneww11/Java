package clases;

public class Material {
    private String name;
    private boolean isFragile;

    public Material(String name, boolean isFragile) {
        this.name = name;
        this.isFragile = isFragile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }
}
