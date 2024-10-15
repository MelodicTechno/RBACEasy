package src.role;

import src.access.AccessHandler;
import src.level.Level;
import src.resource.Resource;

public class Role {
    private final Level level;
    private final AccessHandler access;

    public String name;

    public Role(Level level) {
        this.level = level;
        this.access = new AccessHandler(level);
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

    public AccessHandler getAccess() {
        return this.access;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
