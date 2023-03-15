package coreInterior;

import utility.Location;
import utility.Rooms;

public class Sofa extends Interior implements Location {
    public Sofa() {
        super("диван");
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
                System.out.println(getName() + " который находился в гостиной");
                break;
            case BEDROOM:
                System.out.println(getName() + " который находился в спальной");
                break;
            case KITCHEN:
                System.out.println(getName() + " который находился на кухне");
                break;
        }
    }// можно сделать метод, который будет выводить материал дивана
}