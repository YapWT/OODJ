package assignment;

import javax.swing.*;

public class yGetRadioButtonValue {
    public String getSelectedButton(ButtonGroup group) {
        for (var buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}
