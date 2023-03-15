package coreInterior;

import coreHuman.Karlson;

public class AlarmClock {
    private String name;

    public AlarmClock() {
        this.name = "будильник";
    }

    public String getName() {
        return name;
    }

    public void dismantled(Karlson karlson) {
        AlarmClockFace face = new AlarmClockFace();
        AlarmClockHand hand = new AlarmClockHand();
        System.out.println(karlson.getName() + " снял с " + getName() + "а " + face.getName() + " и " + hand.getName());
    }

    public void assembled(Karlson karlson) {
        AlarmClockFace face = new AlarmClockFace();
        AlarmClockHand hand = new AlarmClockHand();
        System.out.println(karlson.getName() + " вставил в " + getName() + " " + face.getName() + " и " + hand.getName());
    }
    private class AlarmClockFace {
        private String name;

        public AlarmClockFace() {
            this.name = "циферблат";
        }

        public String getName() {
            return name;
        }
    }

    private class AlarmClockHand {
        private String name;

        public AlarmClockHand() {
            this.name = "стрелку";
        }

        public String getName() {
            return name;
        }
    }
}
