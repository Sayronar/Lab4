package coreInterior.coreFireplace;

import utility.DeciduousTrees;

public class Log {
    private String name;
    protected static int countLog;

    public Log() {
        this.name = "полено";
    }

    public String treeType() {
        DeciduousTrees[] deciduousTrees = DeciduousTrees.values();
        DeciduousTrees deciduousTree = null;
        for (int i = 0; i < 1; i++) {
            deciduousTree = deciduousTrees[(int) (Math.random() * 3)];
        }
        switch (deciduousTree) {
            case BIRCH:
                return "березовых";
            case OAK:
                return "дубовых";
            case WILLOW:
                return "ивовых";
        }
        return null;
    }

    public String countOfLogs() {
        countLog = (int) (Math.random() * 3) + 1;
        switch (countLog) {
            case 1:
                return "два больших";
            case 2:
                return "три больших";
            case 3:
                return "четыре больших";
        }
        return String.valueOf(countLog);
    }

    public String getName() {
        return name;
    }
}
