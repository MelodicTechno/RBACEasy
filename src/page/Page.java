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
    private final Visitor defaultVisitor;
    private final Contributor defaultContributor;
    private final Boss defaultBoss;

    private final UserButton visitorButton;
    private final UserButton contributorButton;
    private final UserButton bossButton;

    private List<User> users;

    public Page() {
        this.defaultVisitor = new Visitor("default visitor");
        this.defaultBoss = new Boss("default boss");
        this.defaultContributor = new Contributor("default contributor");

        this.users = new ArrayList<>();
        this.users.add(new Visitor());
        this.users.add(new Boss());
        this.users.add(new Contributor());

        this.visitorButton = new UserButton(this.defaultVisitor);
        this.contributorButton = new UserButton(this.defaultContributor);
        this.bossButton = new UserButton(this.defaultBoss);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    public void addUser(User user) {
        this.users.add(user);
    }

}
