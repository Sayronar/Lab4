package run;

import coreConsole.Console;
import coreFurniture.FurnitureJournal;
import coreHuman.*;
import coreInterior.*;
import coreInterior.coreBirdhouse.Birdhouse;
import coreInterior.coreFireplace.*;
import utility.*;

public class Story {
    public static void main(String[] args) {
        Karlson karlson = new Karlson();
        Junior junior = new Junior();
        Team team = new Team();
        Workbench workbench = new Workbench();
        Sofa sofa = new Sofa();
        FurnitureJournal furnitureJournal = new FurnitureJournal();
        Console console = new Console();
        Player player = new Player();
        Floor floor = new Floor();
        Fire fire = new Fire();
        Fireplace fireplace = new Fireplace();
        Lamp lamp = new Lamp();
        Log log = new Log();
        AlarmClock alarmClock = new AlarmClock();
        Steamer steamer = new Steamer();
        Birdhouse birdhouse = new Birdhouse();
        Birdhouse.Bird bird = new Birdhouse.Bird();

        karlson.gotUp(sofa);
        karlson.dropOff(fire, log);
        fireplace.burn();
        karlson.ignite(lamp);
        lamp.hang(workbench);
        lamp.shine(workbench);
        junior.ask();
        karlson.speak();
        junior.startAsk(workbench, alarmClock);
        karlson.dismantled();
        alarmClock.dismantled(karlson);
        karlson.collect();
        alarmClock.assembled(karlson);

        Speakable speakable = () -> System.out.println("После этого Малыш и Карлсон решили поиграть в консоль");
        speakable.speak();
        team.sitDown(karlson,junior, sofa);
        player.choseGame(karlson,console);
        player.playGame(karlson,junior,console);
        karlson.moodChange(player);
        junior.moodChange(player);

        karlson.wish(furnitureJournal);
        workbench.location();
        workbench.contained();
        karlson.throwOff(workbench, floor);
        karlson.pulledOut(sofa);
        team.started(karlson, junior);

        team.teamNag(karlson, junior, Firewood.BOARD, furnitureJournal);
        team.teamNag(karlson, junior, Firewood.CHOCK, furnitureJournal);
        team.teamPlane(karlson, junior, Firewood.BOARD, furnitureJournal);
        team.teamPlane(karlson, junior, Firewood.CHOCK, furnitureJournal);
        team.teamKnockTogether(karlson, junior, Firewood.BOARD, furnitureJournal);
        team.teamKnockTogether(karlson, junior, Firewood.CHOCK, furnitureJournal);

        team.finishingStory(karlson, junior);
        junior.createWish(steamer);
        junior.createSteamer(Firewood.BOARD);
        junior.createSteamer(Firewood.CHOCK);
        steamer.turnOut(junior);
        steamer.stand(junior);
        karlson.say(birdhouse, bird);
        karlson.cameOut(birdhouse);
        karlson.made();
        karlson.looked();
    }
}