package src.role;

import src.access.AccessHandler;
import src.level.Level;
import src.resource.Resource;

public class Role {
    private final Level level;
    private final AccessHandler access;
    private final RoleDict roleType;

    public String name;

    public Role(Level level) {
        this.level = level;
        this.access = new AccessHandler(this.level);
        this.roleType = levelToRoleDict(this.level);
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

    public RoleDict getRoleType() {
        return this.roleType;
    }

    public RoleDict levelToRoleDict(Level level) {
        if (level == Level.low) {
            return RoleDict.Visitor;
        }
        else if (level == Level.middle) {
            return RoleDict.Contributor;
        }
        else {
            return RoleDict.Boss;
        }
    }
}
