package src.user;

import src.role.Role;

import javax.swing.*;
import java.util.List;

public abstract class User {
    private Role role;

    public abstract Role getRole();
    public abstract List<JButton> getOperations();
}
