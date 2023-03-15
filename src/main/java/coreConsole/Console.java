package coreConsole;

import coreHuman.Karlson;
import coreInterior.Interior;

import java.util.ArrayList;

public class Console extends Interior {
    private GameOne gameOne;
    private GameTwo gameTwo;
    private Game randomGame;
    private ArrayList<Game> list = new ArrayList<>();

    public Console() {
        super("Playstation");
        this.gameOne = new GameOne();
        this.gameTwo = new GameTwo();
    }

    public void enableConsole(Karlson karlson) {
        System.out.println(karlson.getName() + " включил консоль");
    }

    public void turnOffConsole() {
        System.out.println(" выключил консоль");
    }

    public Game randomGame() {
        list.add(gameOne);
        list.add(gameTwo);
        randomGame = list.get((int) (Math.random() * 2));
        return randomGame;
    }

    public GameOne getGameOne() {
        return gameOne;
    }

    public GameTwo getGameTwo() {
        return gameTwo;
    }

    public Game getRandomGame() {
        return randomGame;
    }
}
