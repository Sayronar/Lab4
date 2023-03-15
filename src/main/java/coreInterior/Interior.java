package coreInterior;

import java.util.Objects;

public abstract class Interior {
    private String name;

    public Interior(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interior)) return false;
        Interior interior = (Interior) o;
        return Objects.equals(name, interior.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Имя" + getName();
    }
}
