package coreInterior.coreFireplace;

import coreInterior.Workbench;

public class Lamp {
    private String name;

    public Lamp() {
        this.name = "Лампа";
    }

    public void hang(Workbench workbench) {
        System.out.println(", которая " + "висела у самого потолка над " + workbench.getName() + "ом");
    }

    public void shine(Workbench workbench) {
        System.out.println(getName() + " осветила теплым,живым светом " + "комнату и " + workbench.getTool() +
                " которые валялись на " + workbench.getName() + "e");
    }

    public String getName() {
        return name;
    }
}
