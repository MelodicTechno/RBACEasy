package src.role;

import src.level.Level;

import java.io.IOException;

public class Contributor {

    private final Role role;

    public Contributor() {
        this.role = new Role(Level.middle);
    }

    public Contributor(String name) {
        this();
        this.role.setName(name);
    }

    public Role getRole() {
        return role;
    }

    public void addResource(String name) throws IOException {
        this.role.getAccess().addResource(name);
    }

    public void addResource(String name, Level level) throws IOException {
        this.role.getAccess().addResource(name, level);
    }

    public void getResource() {
        System.out.println(this.role.getAccess().getResources());
    }
}
