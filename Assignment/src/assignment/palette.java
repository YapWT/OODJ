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


class table extends palette {
    private JTable t;
    private Object[] tableRow = new Object[7];
    private DefaultTableModel model;
    
    public table(JTable t){
        this.t = t;
        model = (DefaultTableModel) t.getModel();
    }
    
    public <T> void addRow(String filename, Class<T> runtimeClass, String id){
        ArrayList<T> object = FileOperations.read(filename);
        int i = 1;

        if (object != null) {
            if (runtimeClass == User.class && id == null) {
                for (T row : object) {
                    User a = (User) row;

                    tableRow[0] = i++;
                    tableRow[1] = a.getUid();
                    tableRow[2] = a.getUpass();
                    tableRow[3] = a.getUname();
                    tableRow[4] = a.getUtype();
                    tableRow[5] = a.getUcontact();
                    tableRow[6] = a.getUstatus();
                    
                    model.addRow(tableRow);
                }
            } else if (runtimeClass == User.class && id != null){
                User a = Utils.IDtoObject(id, "users.txt", User.class);

                tableRow[0] = a.getUid();
                tableRow[1] = a.getUname();
                tableRow[2] = a.getUcontact();

                model.addRow(tableRow);
                
            }
        }
    }
    
    public void refreshTable(String x, int column, int row){
        model.setValueAt(x, row, column);
    }
}

