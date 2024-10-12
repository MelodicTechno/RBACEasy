package src.access;

public class AccessHandler {
    private Level level;

    public AccessHandler(Level level) {
        this.level = level;
    }

    public void getAccess(Level level) {
        switch (level) {
            case low -> System.out.println("low");
            case middle -> System.out.println("middle");
            case high -> System.out.println("high");
        }
    }
}
