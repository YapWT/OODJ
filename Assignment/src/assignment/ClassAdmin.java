package assignment;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class ClassAdmin {

    public String getSelectedButton(ButtonGroup group){
        for (var buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}

class UserMangement extends ClassAdmin{
    private String Uid;
    private String Upass;
    private String Uname;
    private String Utype;
    private String Ustatus; // active, blocked, deactived, pending

    public String getUid() {
        return Uid;
    }

    public String getUpass() {
        return Upass;
    }

    public String getUname() {
        return Uname;
    }

    public String getUtype() {
        return Utype;
    }

    public String getUstatus() {
        return Ustatus;
    }
    
    // S - scheduler, C - customer, A - admin, M - manager

    public void addUser(String name, String type) {
        this.Uid = new IDGenerator(type.substring(0, 1)).GetID();
        this.Upass = "123";
        this.Uname = name;
        this.Utype = type.substring(0, 1);
        this.Ustatus = "pending";
        
        new zWriteFile().write("users.txt", String.format("%s,%s,%s,%s,%s", Uid, Upass, Uname, Utype, Ustatus), true);
    }

}

class IDGenerator extends UserMangement {
    private String type;
    private int count;
    
    protected IDGenerator(String type){
        this.type = type;
        count = loadCounter("users.txt", type);
    }
    
    private int loadCounter(String filename, String t){
        List<String> type = new zReadFile("users.txt").getSplit3();
        return Collections.frequency(type, t);
    }
    
    public String GetID(){      
        return String.format("%s%d%03d", type, 160, count + 1);
    }
}
