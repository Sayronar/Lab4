package coreHuman;

import java.util.Objects;

public abstract class HumanWorker {
    private String name;
    protected int nagPower;
    protected int planePower;
    protected int knockTogetherPower;
    protected static boolean isPlanCompleted = false;
    protected static String appointment = null;


    public HumanWorker(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public int getNagPower() {
        return nagPower;
    }

    public int getPlanePower() {
        return planePower;
    }

    public int getKnockTogetherPower() {
        return knockTogetherPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanWorker that = (HumanWorker) o;
        return nagPower == that.nagPower && planePower == that.planePower
                && knockTogetherPower == that.knockTogetherPower && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nagPower, planePower, knockTogetherPower);
    }

    @Override
    public String toString() {
        return "Имя" + getName();
    }
}
