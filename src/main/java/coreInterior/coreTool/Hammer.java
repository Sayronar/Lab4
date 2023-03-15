package coreInterior.coreTool;

public class Hammer extends Tool {

    public Hammer() {
        super("молоток");
        sizeValue = (int) (Math.random() * 5) + 1;
    }
}
