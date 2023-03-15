package coreInterior.coreTool;

public class Screwdriver extends Tool {
    public Screwdriver() {
        super("шуруповерт");
        sizeValue = (int) (Math.random() * 15) + 1;
    }
}
