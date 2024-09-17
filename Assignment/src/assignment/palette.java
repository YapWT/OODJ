package assignment;

import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class palette {
    public String getValue(ButtonGroup group) { return null; }
    public void set(boolean b){}
    public void deleteAll() {}
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

class ComponentAction extends palette {
    ArrayList<JComponent> object;

//    new ComponentAction(new ArrayList<>(Arrays.asList(TXT_name))).deleteAll();
    public ComponentAction (ArrayList<JComponent> object) {
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
    
    @Override
    public boolean emptyPassword() {
        for (JComponent ob : object) {
            if (((JPasswordField) ob).getPassword().length == 0) 
                return true; 
        }
        return false; 
    }
}

class table extends palette {
    private JTable t;
    private Object[] tableRow = new Object[3];
    private User user;
    private DefaultTableModel model;
    
    public table(User user, JTable t, String Uid){
        this.t = t;
        this.user = user;
        model = (DefaultTableModel) t.getModel();
        user.setUid(Uid);
    }
    
    public void addRow(){
        tableRow[0] = user.getUid();
        tableRow[1] = user.getUname();
        tableRow[2] = user.getUcontact();

        model.addRow(tableRow);        
    }
    
    public void refreshTable(int c, int column, int row){
        String x = null;
        switch (c){
            case 0: x = user.getUid(); break;
            case 1: x = user.getUpass(); break;
            case 2: x = user.getUname(); break;
            case 3: x = user.getUtype(); break;
            case 4: x = user.getUcontact(); break;
            case 5: x = user.getUstatus(); break;
        }

        model.setValueAt(x, row, column);
    }
}

class label extends palette {
    private JLabel l;
    
    public label(JLabel l){
        this.l = l;
    }
    
    public void setVisibleAndText(String message){
        l.setVisible(true);
        l.setText(message);
    }
}