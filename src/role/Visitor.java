package src.role;

import src.access.AccessHandler;
import src.level.Level;

public class Visitor {
    private final Role role;

    public Visitor() {
        this.role = new Role(Level.low);
    }

    public Visitor(String name) {
        this();
        this.role.setName(name);
    }

    public void getResource() {
        System.out.println(this.role.getAccess().getResources());
    }
}
