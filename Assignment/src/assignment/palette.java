package assignment;

import javax.swing.*;
import java.util.*;

public class palette extends User {
    public String getValue(ButtonGroup group) { return null; }
    public void set(boolean b){}
    public void deleteAll() {}
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

class ComponentAction extends palette {
    ArrayList<JComponent> object;

    public ComponentAction(ArrayList<JComponent> object) {
        this.object = object;
    }
    
    
    @Override
    public void set(boolean b) {
        for (JComponent ob : object) {
            ob.setEnabled(b);
        }
    }
    
    @Override
    public void deleteAll() {
        for (JComponent ob : object) {
            if (ob instanceof JTextField)
                ((JTextField) ob).setText("");
            else if (ob instanceof JPasswordField)
                ((JPasswordField) ob).setText("");
            else
                System.out.println("Error on deleteAll()");
        }
    }
}