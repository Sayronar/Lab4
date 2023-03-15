package coreHuman;

import coreFurniture.FurnitureJournal;
import coreInterior.Sofa;
import utility.Firewood;

public class Team {
    private String name;

    public Team() {
        this.name = "Они";
    }

    public String getName() {
        return name;
    }

    public void sitDown(Karlson karlson, Junior junior, Sofa sofa) {
        System.out.print(karlson.getName() + " и " + junior.getName() + " сели на ");
        sofa.location();
    }
    public void started(Karlson karlson, Junior junior) {
        System.out.println("И оба " + getName().toLowerCase() + " -- и " + karlson.getName() + " и " + junior.getName() +
                " -- принялись пилить," + "строгать, и сколачивать, так " + "что все загудело вокруг.");
    }

    public void teamNag(Karlson karlson, Junior junior, Firewood firewood, FurnitureJournal furnitureJournal) {
        karlson.saw(furnitureJournal, firewood);
        junior.saw(furnitureJournal, firewood);
    }

    public void teamPlane(Karlson karlson, Junior junior, Firewood firewood, FurnitureJournal furnitureJournal) {
        karlson.plane(furnitureJournal, firewood);
        junior.plane(furnitureJournal, firewood);
    }

    public void teamKnockTogether(Karlson karlson, Junior junior, Firewood firewood, FurnitureJournal furnitureJournal) {
        karlson.knockTogether(furnitureJournal, firewood);
        junior.knockTogether(furnitureJournal, firewood);
    }

    public void finishingStory(Karlson karlson, Junior junior) {
        if (karlson.isPlanCompleted && junior.isPlanCompleted) {
            System.out.println(karlson.getName() + " и " + junior.getName() + " собрали " + karlson.furniture);
        } else {
            System.out.println(karlson.getName() + " и " + junior.getName() + " не смогли собрать " + karlson.furniture);
        }
    }
}
