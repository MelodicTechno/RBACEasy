package src.page;

import src.role.RoleDict;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ChooseRole extends JComboBox<RoleDict> {
    private static final RoleDict[] choices = {RoleDict.Visitor, RoleDict.Contributor, RoleDict.Boss};

    public ChooseRole() {
        super(choices);
    }

}
