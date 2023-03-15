package coreInterior.coreTool;

public class Perforator extends Tool {

    public Perforator() {
        super("перфоратор");
        sizeValue = (int) (Math.random() * 10) + 1;
    }
}
