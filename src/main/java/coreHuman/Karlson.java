package coreHuman;

import coreFurniture.FurnitureJournal;
import coreInterior.*;
import coreInterior.coreBirdhouse.Birdhouse;
import coreInterior.coreFireplace.Lamp;
import coreInterior.coreFireplace.Log;
import exception.checked.KarlsonSpeakException;
import utility.*;
import coreInterior.coreFireplace.Fire;

public class Karlson extends HumanWorker implements Worker, Speakable {
    protected String furniture = "";
    protected boolean isPlanCompleted;
    protected boolean happy; //не используется

    public Karlson() {
        super("Карлсон");
        nagPower = (int) (Math.random() * 6) + 15;
        planePower = (int) (Math.random() * 6) + 15;
        knockTogetherPower = (int) (Math.random() * 6) + 15;
        isPlanCompleted = HumanWorker.isPlanCompleted;
    }

    public void miss()
    {
        // придумаем действия, после которго Карлсону наскучило (думаю, что лучше заменить на метод)
        System.out.print("Но потом " + getName() + "у " + "наскучило играть и он" );
    }

    public void wish(FurnitureJournal furnitureJournal) {
        appointment = furnitureJournal.initialize().getName();
        furniture = appointment; //не используется
        System.out.println("После игры " + getName() + " прочёл " + furnitureJournal.getName() +
                " и решил собрать " + appointment);
    }

    public void throwOff(Workbench workbench, Floor floor) {
        System.out.println("\n" + getName() + " скинул на " + floor.getName().toLowerCase() + " " + workbench.getTool());
    }

    public void pulledOut(Sofa sofa) {
        System.out.println("И вытащил из-под " + sofa.getName().toLowerCase() + "чика " + "доски и чурки.");
    }

    public void moodChange(Player player) {
        switch (player.involvement) {
            case 0:
                System.out.println("Настроение " + getName() + "а" + " изменилось на хорошее");
                nagPower *= 2;
                planePower *= 2;
                knockTogetherPower *= 2;
                break;
            case 1:
                System.out.println("Настроение " + getName() + "а" + " не изменилось");
                break;
            case 2:
                System.out.println("Настроение " + getName() + "а" + " изменилось на плохое");
                nagPower /= 2;
                planePower /= 2;
                knockTogetherPower /= 2;
                break;
        }
    }

    public void gotUp(Sofa sofa) {
        System.out.println(getName() + " встал с " + sofa.getName() + "а");
    }

    public void dropOff(Fire fire, Log log) {
        System.out.println("Затем " + getName() + " подбросил в " + fire.getName()
                + " " + log.countOfLogs() + " " + log.treeType() + " " + log.getName());
    }

    public void ignite(Lamp lamp) {
        System.out.print(", и " + getName() + " зажег керасиновую " + lamp.getName());
    }

    @Override
    public void speak() {
        int answer = (int) (Math.random() * 2);
        if (answer == 0) {
            System.out.println(", и " + getName() + " сказал, что готов");
        } else {
            try {
                throw new KarlsonSpeakException();
            } catch (KarlsonSpeakException e) {
                System.out.println(", и " + getName() + " сказал, что не хочет обмениваться");
                System.out.println("Малыш обиделся на " + getName() + "а");
                System.exit(0);
            }
        }
    }

    public void dismantled() {
        System.out.println("Который " + getName() + " сам разобрал");
    }

    public void collect() {
        System.out.println("А потом собрал");
    }

    public void say(Birdhouse birdhouse, Birdhouse.Bird bird) {
        System.out.println("Карлсон сказал, что должен сделать " +
                birdhouse.getName() + " и повесить его возле своего домика, чтобы там жили маленькие " + bird.getName());
    }

    public void cameOut(Birdhouse birdhouse) {
        System.out.println("Но то, что у него вышло, совсем не походило ни на " + birdhouse.getName() +
                ", ни, впрочем, на что-либо другое");
    }

    public void made() {
        System.out.println("Весьма трудно было сказать, что за штуку он смастерил");
    }

    public void looked() {
        System.out.println(getName() + " склонил набок голову и поглядел на свое произведение");
    }

    @Override
    public void saw(FurnitureJournal furnitureJournal, Firewood firewood) {
        if (firewood.equals(Firewood.BOARD)) {
            System.out.println(getName() + " сначала принялся пилить доски");
            switch (appointment) {
                case ("кровать"):
                    System.out.println("Для кровати " + getName() + "у" + " нужно спилить " +
                                    furnitureJournal.getBed().getSawValue() + " досок и " +
                                    furnitureJournal.getBed().getSawValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getBed().getSawValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getBed().getSawValue() + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getNagPower() + " досок");
                    }
                    break;
                case ("стол"):
                    System.out.println("Для стола " + getName() + "у" + " нужно спилить " +
                            furnitureJournal.getTable().getSawValue() + " досок и " +
                            furnitureJournal.getTable().getSawValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getTable().getSawValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getTable().getSawValue() + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getNagPower() + " досок");
                    }
                    break;
                case ("шкаф"):
                    System.out.println("Для шкафа " + getName() + "у" + " нужно спилить " +
                            furnitureJournal.getCloset().getSawValue() + " досок и " +
                            furnitureJournal.getCloset().getSawValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getCloset().getSawValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getCloset().getSawValue() + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getNagPower() + " досок");
                    }
                    break;
            }
        } else {
            System.out.println(getName() + " сначала принялся пилить чурки");
            switch (appointment) {
                case ("кровать"):
                    System.out.println("Для кровати " + getName() + "у" + " нужно спилить " +
                            furnitureJournal.getBed().getSawValue() + " досок и " +
                            furnitureJournal.getBed().getSawValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getBed().getSawValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getBed().getSawValue() + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getNagPower() + " чурок");
                    }
                    break;
                case ("стол"):
                    System.out.println("Для стола " + getName() + "у" + " нужно спилить " +
                            furnitureJournal.getTable().getSawValue() + " досок и " +
                            furnitureJournal.getTable().getSawValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getTable().getSawValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getTable().getSawValue() + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getNagPower() + " чурок");
                    }
                    break;
                case ("шкаф"):
                    System.out.println("Для шкафа " + getName() + "у" + " нужно спилить " +
                            furnitureJournal.getCloset().getSawValue() + " досок и " +
                            furnitureJournal.getCloset().getSawValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getCloset().getSawValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getCloset().getSawValue() + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getNagPower() + " чурок");
                    }
                    break;
            }
        }
    }

    @Override
    public void plane(FurnitureJournal furnitureJournal, Firewood firewood) {
        if (firewood.equals(Firewood.BOARD)) {
            System.out.println(getName() + " сначала принялся строгать доски");
            switch (appointment) {
                case ("кровать"):
                    System.out.println("Для кровати " + getName() + "у" + " нужно настрогать " +
                            furnitureJournal.getBed().getPlaneValue() + " досок и " +
                            furnitureJournal.getBed().getPlaneValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getBed().getPlaneValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getBed().getPlaneValue() + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getPlanePower() + " досок");
                    }
                    break;
                case ("стол"):
                    System.out.println("Для стола " + getName() + "у" + " нужно настрогать " +
                            furnitureJournal.getTable().getPlaneValue() + " досок и " +
                            furnitureJournal.getTable().getPlaneValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getTable().getPlaneValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getTable().getPlaneValue() + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getPlanePower() + " досок");
                    }
                    break;
                case ("шкаф"):
                    System.out.println("Для шкафа " + getName() + "у" + " нужно настрогать " +
                            furnitureJournal.getCloset().getPlaneValue() + " досок и " +
                            furnitureJournal.getCloset().getPlaneValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getCloset().getPlaneValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getCloset().getPlaneValue() + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getPlanePower() + " досок");
                    }
                    break;
            }
        } else {
            System.out.println(getName() + " сначала принялся строгать чурки");
            switch (appointment) {
                case ("кровать"):
                    System.out.println("Для кровати " + getName() + "у" + " нужно настрогать " +
                            furnitureJournal.getBed().getPlaneValue() + " досок и " +
                            furnitureJournal.getBed().getPlaneValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getBed().getPlaneValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getBed().getPlaneValue() + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getPlanePower() + " чурок");
                    }
                    break;
                case ("стол"):
                    System.out.println("Для стола " + getName() + "у" + " нужно настрогать " +
                            furnitureJournal.getTable().getPlaneValue() + " досок и " +
                            furnitureJournal.getTable().getPlaneValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getTable().getPlaneValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getTable().getPlaneValue() + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getPlanePower() + " чурок");
                    }
                    break;
                case ("шкаф"):
                    System.out.println("Для шкафа " + getName() + "у" + " нужно настрогать " +
                            furnitureJournal.getCloset().getPlaneValue() + " досок и " +
                            furnitureJournal.getCloset().getPlaneValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getCloset().getPlaneValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getCloset().getPlaneValue() + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getPlanePower() + " чурок");
                    }
                    break;
            }
        }
    }

    @Override
    public void knockTogether(FurnitureJournal furnitureJournal, Firewood firewood) {
        if (firewood.equals(Firewood.BOARD)) {
            System.out.println(getName() + " сначала принялся сколачивать доски");
            switch (appointment) {
                case ("кровать"):
                    System.out.println("Для кровати " + getName() + "у" + " нужно сколотить " +
                            furnitureJournal.getBed().getKnockTogetherValue() + " досок и " +
                            furnitureJournal.getBed().getKnockTogetherValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getBed().getKnockTogetherValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getBed().getKnockTogetherValue()
                                + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getKnockTogetherPower() + " досок");
                    }
                    break;
                case ("стол"):
                    System.out.println("Для стола " + getName() + "у" + " нужно сколотить " +
                            furnitureJournal.getTable().getKnockTogetherValue() + " досок и " +
                            furnitureJournal.getTable().getKnockTogetherValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getTable().getKnockTogetherValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getTable().getKnockTogetherValue()
                                + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getKnockTogetherPower() + " досок");
                    }
                    break;
                case ("шкаф"):
                    System.out.println("Для шкафа " + getName() + "у" + " нужно сколотить " +
                            furnitureJournal.getCloset().getKnockTogetherValue() + " досок и " +
                            furnitureJournal.getCloset().getKnockTogetherValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getCloset().getKnockTogetherValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getCloset().getKnockTogetherValue()
                                + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getKnockTogetherPower() + " досок");
                    }
                    break;
            }
        } else {
            System.out.println(getName() + " сначала принялся сколачивать чурки");
            switch (appointment) {
                case ("кровать"):
                    System.out.println("Для кровати " + getName() + "у" + " нужно сколотить " +
                            furnitureJournal.getBed().getKnockTogetherValue() + " досок и " +
                            furnitureJournal.getBed().getKnockTogetherValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getBed().getKnockTogetherValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getBed().getKnockTogetherValue()
                                + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getKnockTogetherPower() + " чурок");
                    }
                    break;
                case ("стол"):
                    System.out.println("Для стола " + getName() + "у" + " нужно сколотить " +
                            furnitureJournal.getTable().getKnockTogetherValue() + " досок и " +
                            furnitureJournal.getTable().getKnockTogetherValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getTable().getKnockTogetherValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getTable().getKnockTogetherValue()
                                + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getKnockTogetherPower() + " чурок");
                    }
                    break;
                case ("шкаф"):
                    System.out.println("Для шкафа " + getName() + "у" + " нужно сколотить " +
                            furnitureJournal.getCloset().getKnockTogetherValue() + " досок и " +
                            furnitureJournal.getCloset().getKnockTogetherValue() + " чурок");
                    if (getNagPower() >= furnitureJournal.getCloset().getKnockTogetherValue()) {
                        isPlanCompleted = true;
                        System.out.println(getName() + " спилил " + furnitureJournal.getCloset().getKnockTogetherValue()
                                + " досок");
                    } else {
                        isPlanCompleted = false;
                        System.out.println(getName() + " спилил " + getKnockTogetherPower() + " чурок");
                    }
                    break;
            }
        }
    }
}
