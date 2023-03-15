package coreInterior;

import coreInterior.coreTool.*;
import utility.Location;
import utility.Rooms;

import java.util.ArrayList;

public class Workbench extends Interior implements Location {
    private Hammer hammer;
    private Perforator perforator;
    private Screwdriver screwdriver;
    ArrayList<Tool> list = new ArrayList<>();
    public Workbench() {
        super("верстак");
        this.hammer = new Hammer();
        this.perforator = new Perforator();
        this.screwdriver = new Screwdriver();
        list.add(hammer);
        list.add(perforator);
        list.add(screwdriver);
    }

    public void contained() {
        System.out.print(getName() + " содержал в себе ");
        for (Tool tool : list) {
            System.out.print(tool.size() + " ");
        }
    }

    public String getTool() {
        String tools = "";
        for (Tool tool : list) {
            tools += tool.getName() + ", ";
        }
        return String.valueOf(new StringBuilder(tools).deleteCharAt(tools.length() - 1)).trim();
    }

    @Override
    public void location() {
        Rooms[] rooms = Rooms.values();
        Rooms room = null;
        for (int i = 0; i < 1; i++) {
            room = rooms[(int) (Math.random() * 3)];
        }
        switch (room) {
            case LIVING_ROOM:
                System.out.println(getName() + " находился в гостиной");
                break;
            case BEDROOM:
                System.out.println(getName() + " находился в спальной");
                break;
            case KITCHEN:
                System.out.println(getName() + " находился на кухне");
                break;
        }
    }
}
