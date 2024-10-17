package src.page;

import src.role.Boss;
import src.role.Contributor;
import src.role.Visitor;
import src.user.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Page extends JFrame {

    private final List<User> users;

    public Page() {
        Visitor defaultVisitor = new Visitor("default visitor");
        Boss defaultBoss = new Boss("default boss");
        Contributor defaultContributor = new Contributor("default contributor");

        this.users = new ArrayList<>();
        this.users.add(new Visitor());
        this.users.add(new Boss());
        this.users.add(new Contributor());

        UserButton visitorButton = new UserButton(defaultVisitor);
        UserButton contributorButton = new UserButton(defaultContributor);
        UserButton bossButton = new UserButton(defaultBoss);

        JPanel contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        contentPane.add(visitorButton);
        contentPane.add(contributorButton);
        contentPane.add(bossButton);
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

}
