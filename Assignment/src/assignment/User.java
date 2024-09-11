package assignment;

import java.util.*;

public class User {
    private String Uid;
    private String Uname;
    private String Upass;
    private String Utype;
    private String Ustatus; // active, blocked, deactived, pending
    private String Ucontact;
    private zUserToString userToString;

    public String login() {
        ArrayList<ArrayList<Object>> data = new zReadFile("users.txt", 0, Uid).getAllData();
        userToString = new zUserToString(data);

        if (!data.isEmpty()) {
            if (userToString.getSplit(0).equals(Uid) && userToString.getSplit(1).equals(Upass)){
                this.Utype = userToString.getSplit(3);
                this.Ustatus = userToString.getSplit(5);

                switch (Ustatus) {
                    case "active":
                        return "Login";
                    case "blocked":
                        return "block";
                    case "pending":
                        changeStatus();
                        return "pending";
                    default:
                        return "deactivate";
                }
            }
        }
        return "Failed";    
    }
    
    private void changeStatus(){
        ArrayList<ArrayList<Object>> data = new zReadFile("users.txt").getAllData();
        
        for (ArrayList<Object> row : data) {
            if (row.get(0).toString().equals(Uid)) {
                row.set(5, "active");
                break;
            }
        }
        new zWriteFile().write("users.txt", data, false);
    }

    public void logout() {}

    public void updateProfile() {}
    
    
    
    
    
    public String getUid() {
        return Uid;
    }

    public void setUid(String Uid) {
        this.Uid = Uid;
    }

    public String getUpass() {
        return Upass;
    }

    public void setUpass(String Upass) {
        this.Upass = Upass;
    }

    public String getUtype() {
        return Utype;
    }

    public void setUtype(String Utype) {
        this.Utype = Utype;
    }

    public String getUstatus() {
        return Ustatus;
    }

    public void setUstatus(String Ustatus) {
        this.Ustatus = Ustatus;
    }
    
}
