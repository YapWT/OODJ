package assignment;

import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class palette {
    public String getValue(ButtonGroup group) { return null; }
    public boolean emptyPassword() {return true; }
}

class RadioBtnSettings extends palette {
    @Override
    public String getValue(ButtonGroup group) {
        for (var buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected())
                return button.getText();
        }
        return null;
    }
 }


