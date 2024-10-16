package src.role;

import src.level.Level;
import src.user.User;

import javax.swing.*;
import java.util.List;

public class Visitor extends User {
    private final Role role;
    private final JLabel label;

    public Visitor() {
        this.role = new Role(Level.low);
        this.label = new JLabel("Visitor");
    }

    public Visitor(String name) {
        this();
        this.role.setName(name);
    }

    public void getResource() {
        System.out.println(this.role.getAccess().getResources());
    }

    public JLabel getPanel() {
        return this.label;
    }

    @Override
    public List<JButton> getOperations() {
        return this.role.getAccess().getButtons();
    }
}
