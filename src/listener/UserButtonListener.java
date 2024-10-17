package src.listener;

import src.level.Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserButtonListener implements ActionListener {

    private Level level;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");
    }
}
