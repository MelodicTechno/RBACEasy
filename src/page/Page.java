package src.page;

import src.access.AccessHandler;
import src.role.Boss;
import src.role.Contributor;
import src.role.Visitor;
import src.user.User;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Page extends JFrame {

    private final static Visitor defaultVisitor = new Visitor("default visitor");
    private final static Contributor defaultContributor = new Contributor("default contributor");
    private final static Boss defaultBoss = new Boss("default boss");

    private final JPanel operationPane;

    private User currentUser;
    private final List<User> users;
    private AccessHandler access;

    public Page() {
        FlatDarkLaf.setup();

        this.currentUser = defaultVisitor;

        this.users = new ArrayList<>();
        this.users.add(new Visitor());
        this.users.add(new Boss());
        this.users.add(new Contributor());
        this.access = new AccessHandler(this.currentUser.getRole().getLevel());

        UserButton visitorButton = new UserButton(defaultVisitor);
        UserButton contributorButton = new UserButton(defaultContributor);
        UserButton bossButton = new UserButton(defaultBoss);

        this.operationPane = new JPanel();
        JPanel contentPane = new JPanel();

        visitorButton.addActionListener(e -> {
           this.currentUser = defaultVisitor;
           this.access = new AccessHandler(this.currentUser.getRole().getLevel());
            System.out.println("change to: " + this.currentUser.getRole().getRoleType());
            this.flushPage();
            System.out.println(this.access.getButtons());
        });
        contributorButton.addActionListener(e -> {
            this.currentUser = defaultContributor;
            this.access = new AccessHandler(this.currentUser.getRole().getLevel());
            System.out.println("change to: " + this.currentUser.getRole().getRoleType());
            this.flushPage();
            System.out.println(this.access.getButtons());
        });
        bossButton.addActionListener(e -> {
            this.currentUser = defaultBoss;
            this.access = new AccessHandler(this.currentUser.getRole().getLevel());
            System.out.println("change to: " + this.currentUser.getRole().getRoleType());
            this.flushPage();
            System.out.println(this.access.getButtons());
        });

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        this.operationPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.operationPane.setLayout(new BoxLayout(operationPane, BoxLayout.X_AXIS));

        this.setTitle("RBACEasy");
        this.setLayout (new BorderLayout ());
        this.add(BorderLayout.NORTH, contentPane);
        this.add(BorderLayout.SOUTH, operationPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        contentPane.add(visitorButton);
        contentPane.add(contributorButton);
        contentPane.add(bossButton);

        this.flushPage();
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void flushPage() {
        List<JButton> openButtons = this.access.getButtons();
        this.operationPane.removeAll();
        for (JButton button : openButtons) {
            this.operationPane.add(button);
            SwingUtilities.updateComponentTreeUI(this.operationPane);
        }
    }

}
