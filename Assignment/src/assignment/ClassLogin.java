package assignment;

import java.util.*;

public class ClassLogin {
    private String Uid;
    private String Upass;
    private String Utype;
    private String Ustatus; // active, blocked, deactived, pending
    private zUserToString userToString;

    public void setUid(String Uid) {
        this.Uid = Uid;
    }

    public void setUpass(String Upass) {
        this.Upass = Upass;
    }

    public String checkUser() {
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
    
    public void changeStatus(){
        ArrayList<ArrayList<Object>> data = new zReadFile("users.txt").getAllData();
        
        for (ArrayList<Object> row : data) {
            if (row.get(0).toString().equals(Uid)) {
                row.set(5, "active");
                break;
            }
        }
        new zWriteFile().write("users.txt", data, false);
    }
    
    public String getUtype() {
        return Utype;
    }    

    public String getUid() {
        return Uid;
    }
}
