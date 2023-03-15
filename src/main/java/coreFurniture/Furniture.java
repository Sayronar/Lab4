package coreFurniture;

import java.util.Objects;

public abstract class Furniture {
    protected int sawValue;
    protected int planeValue;
    protected int knockTogetherValue;
    private String name;

    public Furniture(String name) {
        this.name = name;
    }

    public int getSawValue() {
        return sawValue;
    }

    public int getPlaneValue() {
        return planeValue;
    }

    public int getKnockTogetherValue() {
        return knockTogetherValue;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return sawValue == furniture.sawValue && planeValue == furniture.planeValue
                && knockTogetherValue == furniture.knockTogetherValue && Objects.equals(name, furniture.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sawValue, planeValue, knockTogetherValue, name);
    }

    @Override
    public String toString() {
        return "Имя" + getName();
    }
}
