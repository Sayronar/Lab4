package coreInterior.coreTool;

import java.util.Objects;

public abstract class Tool {
    protected int sizeValue;
    private String name;

    public Tool(String name) {
        this.name = name;
    }

    public String size() {
        if (sizeValue <= 5) {
            name = "маленький " + getName();
        } else if (sizeValue <= 10) {
            name = "средний " + getName();
        } else {
            name = "большой " + getName();
        }
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tool tool = (Tool) o;
        return sizeValue == tool.sizeValue && Objects.equals(name, tool.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeValue, name);
    }

    @Override
    public String toString() {
        return "Имя" + getName();
    }
}
