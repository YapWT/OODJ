package assignment;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class Admin extends Staff{
    public Admin() {}
    
    public void addStaff(String Uname, String Upass, String Utype, String Ucontact) {
        this.setUpass(Upass);
        this.setUname(Uname);
        this.setUtype(Utype.substring(0, 1));
        this.setUcontact(Ucontact);
        this.setUstatus("pending");
        this.setUid(Utils.generateID(getUtype()));

        FileOperations.write("users.txt", this);
    }
    
    public boolean modifyPass(JTable t, String row, String pass) {
        if (checkInt(row)) {
            int n = Integer.parseInt(row);
            User m = Utils.IDtoObject(rowToGetUid(t, n), "users.txt", User.class);
            
            if (m == null) return false;
            
            m.setUpass(pass);
            Utils.editFile("users.txt", m.getUid(), 1, pass, User.class);
            t.setValueAt(pass.replaceAll(".", "*"), n - 1, 2);
            return true;
        } return false;
    }
    
    private boolean checkInt(String i) {
        try {
            Integer.parseInt(i);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private String rowToGetUid(JTable t, int row){
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        return model.getValueAt(row - 1, 1).toString();
    }
}
