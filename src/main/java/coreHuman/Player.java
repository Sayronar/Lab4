package coreHuman;

import coreConsole.Console;

public class Player {
    private int completedLevels;

    protected int involvement;

    public void choseGame(Karlson karlson, Console console) {
        console.enableConsole(karlson);
        System.out.println(karlson.getName() + " выбирает игру " + console.randomGame().getName());
    }

    public void playGame(Karlson karlson, Junior junior, Console console) {
        while (console.getRandomGame().getLevel() != completedLevels && involvement != 2) {
            completedLevels++;
            System.out.println(karlson.getName() + " и " + junior.getName() + " прошли " + completedLevels + " уровень");
            if (console.getRandomGame().getLevel() == completedLevels) {
                System.out.println(karlson.getName() + " и " + junior.getName() + " прошли " + console.randomGame().getName());
                involvement = 0;
                karlson.happy = true;
            } else {
                involvement = (int) (Math.random() * 3);
            }
            switch (involvement) {
                case 0:
                    System.out.println("Уровень вовлеченности игроков высокий");
                    break;
                case 1:
                    System.out.println("Уровень вовлеченности игроков средний");
                    break;
                case 2:
                    System.out.println("Уровень вовлеченности игроков низкий");
                    karlson.happy = false;
                    karlson.miss();
                    console.turnOffConsole();
                    break;
            }
        }
    }

}
