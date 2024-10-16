package src.page;

import src.role.Boss;
import src.role.Contributor;
import src.role.Visitor;
import src.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Page extends JFrame {
    private JPanel contentPane;
    private final Visitor defaultVisitor;
    private final Contributor defaultContributor;
    private final Boss defaultBoss;

    List<User> users;

    public Page() {
        this.defaultVisitor = new Visitor("default visitor");
        this.defaultBoss = new Boss("default boss");
        this.defaultContributor = new Contributor("default contributor");

        this.users = new ArrayList<>();
        this.users.add(new Visitor());
        this.users.add(new Boss());
        this.users.add(new Contributor());

        this.contentPane = new JPanel();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
