package src.role;

import src.access.AccessHandler;
import src.level.Level;
import src.resource.Resource;

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
        this.access.getAccess();
    }

    public void creatResource(String resource) {
        Resource newResource = new Resource(resource, this.level);
        this.access.saveResource(newResource, newResource.getResourcePath());
    }

}
