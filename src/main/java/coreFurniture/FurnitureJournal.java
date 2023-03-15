package coreFurniture;

import java.util.ArrayList;
import java.util.Objects;

public class FurnitureJournal {
    private String name;
    private Bed bed;
    private Closet closet;
    private Table table;
    protected Furniture furniture;
    private ArrayList<Furniture> list = new ArrayList<>();

    public FurnitureJournal() {
        this.name = "мебельный журнал";
        this.bed = new Bed();
        this.closet = new Closet();
        this.table = new Table();
    }

    public Furniture initialize() {
        //поменять имя метода
        list.add(new Bed());
        list.add(new Closet());
        list.add(new Table());
        furniture = list.get((int) (Math.random() * list.size()));
        return furniture;
    }

    public Bed getBed() {
        return bed;
    }

    public Closet getCloset() {
        return closet;
    }

    public Table getTable() {
        return table;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FurnitureJournal that = (FurnitureJournal) o;
        return Objects.equals(name, that.name) && Objects.equals(bed, that.bed) && Objects.equals(closet, that.closet) &&
                Objects.equals(table, that.table) && Objects.equals(furniture, that.furniture) &&
                Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bed, closet, table, furniture, list);
    }

    @Override
    public String toString() {
        return "FurnitureJournal{" +
                "name='" + name + '\'' +
                ", bed=" + bed +
                ", closet=" + closet +
                ", table=" + table +
                ", furniture=" + furniture +
                ", list=" + list +
                '}';
    }
}
