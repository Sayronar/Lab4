package coreInterior.coreBirdhouse;

public class Birdhouse {
    private String name;

    public Birdhouse() {
        this.name = "скворечник";
    }

    public String getName() {
        return name;
    }

    public static class Bird {
        private String name;

        public Bird() {
            this.name = "птицы";
        }

        public String getName() {
            return name;
        }
    }
}
