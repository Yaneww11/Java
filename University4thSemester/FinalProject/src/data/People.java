package data;

import java.util.Objects;
import java.util.UUID;

public class People {
    private final UUID uuid;
    private String name;

    public People(String name) {
        this.uuid = UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People people)) return false;
        return Objects.equals(getUuid(), people.getUuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid());
    }
}
