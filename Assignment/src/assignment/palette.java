package assignment;

import javax.swing.*;

public abstract class palette {
    abstract String getValue(ButtonGroup group);
}

class getSelectedButton extends palette {
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
