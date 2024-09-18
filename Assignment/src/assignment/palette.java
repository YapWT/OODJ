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

class ComponentAction extends palette {
    ArrayList<JComponent> object;

//    new ComponentAction(new ArrayList<>(Arrays.asList(TXT_name))).deleteAll();
    public ComponentAction (ArrayList<JComponent> object) {
        this.object = object;
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
    
    
    public void addRow(int numColumn, ArrayList<String> x){
        for (int i = 0; i < numColumn; i++)
                tableRow[i] = x.get(i);

        model.addRow(tableRow);   
        System.out.println(tableRow);
    }
    
    public void refreshTable(String x, int column, int row){
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