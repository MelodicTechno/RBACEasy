package src.role;

import src.level.Level;
import src.user.User;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Contributor extends User {

    private final Role role;
    private final JLabel label;

    public Contributor() {
        this.role = new Role(Level.middle);
        this.label = new JLabel("Contributor");
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

    public JLabel getLabel() {
        return this.label;
    }

    @Override
    public List<JButton> getOperations() {
        return this.role.getAccess().getButtons();
    }
}
