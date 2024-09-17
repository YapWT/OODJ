package assignment;

import java.io.*;
import java.util.*;
import javax.swing.*;

interface initialize {
    abstract String checkFile();
}

interface login_logout {
    String login();
    void logout(JPanel p);
}

interface profile {
    boolean updateName(String Uname);
    String updatePass(String Upass, String newPass);
    boolean updateC(String Ucontact);
}

public class User implements initialize, login_logout, profile{
    private String Uid;
    private String Upass;
    private String Uname;
    private String Utype;
    private String Ucontact;
    private String Ustatus; // active, blocked, deactived, pending

    public User() {}
    
    public String checkFile() {
        try (BufferedReader rd = new BufferedReader(new FileReader("users.txt"))) {
            return null;
        } catch (FileNotFoundException e) {
            addUser("First Admin", "123", "A", "");
            return String.format("ID: %s\nPassword: %s", Uid, Upass);
        } catch (IOException e) {
            System.out.println("Error Found in reader file");
            return null;
        }
    }
    
    public void addUser(String Uname, String Upass, String Utype, String Ucontact) {
        this.Upass = Upass;
        this.Uname = Uname;
        this.Utype = Utype.substring(0, 1);
        this.Ucontact = Ucontact;
        this.Ustatus = "pending";
        this.Uid = new Utils().generateID(Utype);
        
        new zWriteFile().write("users.txt", String.format("%s,%s,%s,%s,%s,%s", Uid, Upass, Uname, Utype, Ucontact, Ustatus), true);
    } 
    
    public String login() {
        zUserToString data = Utils.idGetRow(Uid);
        
        if (data != null) {
            if (data.getSplit(0).equals(Uid) && data.getSplit(1).equals(Upass)){
                this.Utype = data.getSplit(3);
                this.Ustatus = data.getSplit(5);

                switch (Ustatus) {
                    case "active": return "Login";
                    case "blocked": return "block";
                    case "pending": Utils.editFile("users.txt", Uid, 5, "active"); return "pending";
                    case "deleted" : return "Failed";
                    default: return "deactivate";
                }
            }
        }
        return "Failed";    
    }

    public void logout(JPanel p) {
        ((JFrame) SwingUtilities.getWindowAncestor(p)).dispose();
        new uiLogin().setVisible(true);
        
    }

    public boolean updateName(String Uname) {
        if (Uname.isEmpty() | Uname == null)
            return false;
        
        this.Uname = Uname;
        Utils.editFile("users.txt", Uid, 2, Uname);
        return true;
    }

    public String updatePass(String Upass, String newPass) {
        if (!Upass.equals(this.Upass)) 
            return "Incorrect";
        else if (Upass.equals(newPass)) 
            return "Same";
        else
            Utils.editFile("users.txt", Uid, 1, newPass);
        
        this.Upass = newPass;
        return "Done";
            
    }

    public boolean updateC(String Ucontact) {      
        if (Ucontact == null | Ucontact.isEmpty())
            return false;
        
        if (Utils.checkContact(Ucontact))
            Utils.editFile("users.txt", Uid, 4, Ucontact);
        else 
            return false;
        
        this.Ucontact = Ucontact;
        return true;
    }

    public String getUid() {
        return Uid;
    }

    public String getUname() {
        return Uname;
    }

    public String getUpass() {
        return Upass;
    }

    public String getUtype() {
        return Utype;
    }
    
    public String getUstatus() {
        return Ustatus;
    }

    public String getUcontact() {
        return Ucontact;
    }

    public void setUid(String Uid) {
        this.Uid = Uid;

        zUserToString data = Utils.idGetRow(Uid);
        if (!(data == null)){
            this.Upass = data.getSplit(1);
            this.Uname = data.getSplit(2);
            this.Utype = data.getSplit(3);
            this.Ustatus = data.getSplit(5);
            this.Ucontact = data.getSplit(4);
        }
    }

    public void setUname(String Uname) {
        this.Uname = Uname;
    }

    public void setUpass(String Upass) {
        this.Upass = Upass;
    }

    public void setUtype(String Utype) {
        this.Utype = Utype;
    }

    public void setUstatus(String Ustatus) {
        this.Ustatus = Ustatus;
    }

    public void setUcontact(String Ucontact) {
        this.Ucontact = Ucontact;
    }
}
