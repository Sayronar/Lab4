package coreConsole;

import java.util.Objects;

public abstract class Game {
    private String name;
    protected int level;

    public Game(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return level == game.level && Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }

    @Override
    public String toString() {
        return "Имя " + getName() + " Уровень " + getLevel();
    }
}
