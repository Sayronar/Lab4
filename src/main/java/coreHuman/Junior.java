package coreHuman;

import coreFurniture.FurnitureJournal;
import coreInterior.Workbench;
import coreInterior.AlarmClock;
import coreInterior.Steamer;
import exception.unchecked.SteamerConstructionException;
import utility.*;

public class Junior extends HumanWorker implements Worker {
    protected boolean isPlanCompleted;

    public Junior() {
        super("Малыш");
        nagPower = (int) (Math.random() * 6) + 10;
        planePower = (int) (Math.random() * 6) + 10;
        knockTogetherPower = (int) (Math.random() * 6) + 10;
        isPlanCompleted = HumanWorker.isPlanCompleted;

    }

    public void moodChange(Player player) {
        switch (player.involvement) {
            case 0:
                System.out.println("Настроение " + getName() + "а" + " изменилось на хорошее");
                nagPower *= 2;
                planePower *= 2;
                knockTogetherPower *= 2;
                break;
            case 1, 2:
                imagine();
                System.out.println("Настроение " + getName() + "а" + " изменилось на хорошее");
                nagPower *= 2;
                planePower *= 2;
                knockTogetherPower *= 2;
                break;
        }
    }

    public void ask() {
        System.out.print(getName() + " спросил, не могут ли они чем-нибудь обменяться");
    }

    public void startAsk(Workbench workbench, AlarmClock alarmClock) {
        System.out.println("И тогда " + getName() + " начал спрашивать разрешения подряд на "
                + workbench.getTool() + " которые лежали на "
                + workbench.getName() + "е, а получил всего-навсего " + alarmClock.getName());
    }

    public void imagine() {
        System.out.println("Но все равно игра эта была такой интересной, что " +
                getName() + " даже представить себе не мог ничего более увлекательного.");
    }

    public void createWish(Steamer steamer) {
        System.out.println("После этого " + getName() + " захотел сделать " + steamer.getName());
    }

    public void createSteamer(Firewood firewood) {
        if (knockTogetherPower > 20) {
            if (firewood.equals(Firewood.BOARD)) {
                System.out.print(getName() + " сбил " + knockTogetherPower + " досточек");
            } else {
                System.out.println(", а сверху приладил " + (knockTogetherPower - 1) + " круглых чурочек");
            }
        } else {
            throw new SteamerConstructionException("Малышу не хватило материалов для изготовления парохода");
        }
    }

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
