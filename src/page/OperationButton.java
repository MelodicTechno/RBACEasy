package src.page;

import src.level.Level;
import src.operation.OperationEnum;

import javax.swing.*;

public class OperationButton extends JButton {

    private Level level;

    public OperationButton(Level level) {
        this.level = level;
        super.setText("Operation");
    }

    private OperationButton() {

    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

}
