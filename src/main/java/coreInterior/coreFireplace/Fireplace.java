package coreInterior.coreFireplace;

import utility.Rooms;

public class Fireplace {
    private String name;
    private Log log;

    public Fireplace() {
        this.name = "камин";
        log = new Log();
    }

    public void burn() {
        for (int i = 0; i <= log.countLog; i++) {
            System.out.println(getName() + " еще горит");
        }
        System.out.println(getName() + " прогорел");
        System.out.print("Когда " + getName() + " прогорел,");
        Rooms[] rooms = Rooms.values();
        Rooms room = null;
        for (int i = 0; i < 1; i++) {
            room = rooms[(int) (Math.random() * 3)];
        }
        switch (room) {
            case LIVING_ROOM:
                System.out.print(" в гостиной" + " стало темно");
                break;
            case BEDROOM:
                System.out.print(" в спальной" + " стало темно");
                break;
            case KITCHEN:
                System.out.print(" на кухне" + " стало темно");
                break;
        }

    }

    public String getName() {
        return name;
    }
}
