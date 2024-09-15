package assignment;

import java.io.*;
import java.util.*;

interface initialize {
    abstract String checkFile();
}

interface login_logout {
    String login();
    void logout();
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
            new zWriteFile().write("users.txt", "A160001,123,admin,A,,pending", false);
            return "ID: A160001\nPassword: 123";
        } catch (IOException e) {
            System.out.println("Error Found in reader file");
            return null;
        }
    }
    
    public String login() {
        this.Uid = Uid;
        this.Upass = Upass;
        
        zUserToString data = Utils.idGetRow(Uid);
        
        if (data != null) {
            if (data.getSplit(0).equals(Uid) && data.getSplit(1).equals(Upass)){
                this.Utype = data.getSplit(3);
                this.Ustatus = data.getSplit(5);

                switch (Ustatus) {
                    case "active": return "Login";
                    case "blocked": return "block";
                    case "pending": return "pending";
                    default: return "deactivate";
                }
            }
        }
        return "Failed";    
    }

    public void logout() {
        
    }

    public boolean updateName(String Uname) {
        if (Uname.isEmpty() | Uname == null)
            return false;
        
        this.Uname = Uname;
        zUserToString data = Utils.idGetRow(Uid);
        Utils.editFile("users.txt", Uid, 2, Uname);
        return true;
    }

    public String updatePass(String Upass, String newPass) {
        if (Upass.equals(this.Upass)) {
            zUserToString data = Utils.idGetRow(Uid);
            Utils.editFile("users.txt", Uid, 1, newPass);
        } else if (Upass.equals(newPass)) {
            return "Same";
        } else
            return "Incorrect";
        
        this.Upass = newPass;
        return "Done";
            
    }

    public boolean updateC(String Ucontact) {
        zUserToString data = Utils.idGetRow(Uid);
        
        if (Ucontact == null | Ucontact.isEmpty())
            return false;
        
        if (Utils.checkContact(Ucontact))
            Utils.editFile("users.txt", Uid, 4, Ucontact);
        else 
            return false;
        
        this.Ucontact = Ucontact;
        return true;
    }

    public void setUidAndGetAllData(String Uid){
        this.Uid = Uid;
        
        zUserToString data = Utils.idGetRow(Uid);
        this.Upass = data.getSplit(1);
        this.Uname = data.getSplit(2);
        this.Utype = data.getSplit(3);
        this.Ustatus = data.getSplit(5);
        this.Ucontact = data.getSplit(4);
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
