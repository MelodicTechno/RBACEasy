package src.access;

import src.level.Level;

public class AccessHandler {

    private final Level level;

    public AccessHandler(Level level) {
        this.level = level;
    }

    public void getAccess() {
        switch (this.level) {
            case low -> System.out.println("low");
            case middle -> System.out.println("middle");
            case high -> System.out.println("high");
        }
    }

    public Level getLevel() {
        return level;
    }
}
