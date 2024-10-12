package src.role;

import src.access.AccessHandler;
import src.level.Level;

public class Role {
    private final Level level;
    private final AccessHandler access;

    public Role(Level level, AccessHandler access) {
        this.level = level;
        this.access = access;
    }

    public Level getLevel() {
        return level;
    }

    public void getResource() {
        access.getAccess();
    }
}
