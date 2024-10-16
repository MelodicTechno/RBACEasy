package src.page;

import src.level.Level;
import src.role.Visitor;
import src.user.User;

import javax.swing.*;

public class UserButton extends JButton {

    private User user;
    private final String imagePath;

    public UserButton() {
        this.user = new Visitor("user");
        this.imagePath = "/images/visitor.png";
        super.setIcon(new ImageIcon(this.imagePath));
    }

    public UserButton(User user) {
        this.user = user;
        if (this.user.getRole().getLevel() == Level.low) {
            this.imagePath = "/images/visitor.png";
        }
        else if (this.user.getRole().getLevel() == Level.middle) {
            this.imagePath = "/images/developer.png";
        }
        else {
            this.imagePath = "/images/boss.png";
        }
        super.setIcon(new ImageIcon(this.imagePath));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
