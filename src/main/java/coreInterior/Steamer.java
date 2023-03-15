package coreInterior;

import coreHuman.Junior;

public class Steamer {
    private String name;

    public Steamer() {
        this.name = "пароход";
    }

    public void turnOut(Junior junior) {
        int random = (int) (Math.random() * 2);
        if (random == 0) {
            System.out.println(getName() + " и в самом деле получился очень хороший");
        } else {
            System.out.println(getName() + " получился не очень хороший, но " + junior.getName() +
                    " все равно был счастлив");
        }
    }

    public String getName() {
        return name;
    }

    public void stand(Junior junior) {
        class Nightstand {
            private String name;

            public Nightstand() {
                this.name = "тумбочку";
            }

            public String getName() {
                return name;
            }
        }
        Nightstand nightstand = new Nightstand();
        System.out.println(junior.getName() + " поставил " + getName() + " на " + nightstand.getName());
    }
}
