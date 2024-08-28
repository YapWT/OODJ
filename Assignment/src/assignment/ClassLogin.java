package assignment;

import java.util.*;

public class ClassLogin {
    private String Uid;
    private String Upass;
    private String Uname;
    private String Utype;
    private String Ustatus; // active, blocked, deactived, pending

    public ClassLogin(String Uid, String Upass) {
        this.Uid = Uid;
        this.Upass = Upass;
    }
    
    public String checkUser() {
        ArrayList<ArrayList<Object>> data = new zReadFile("users.txt", 0, Uid).getAllData();

        if (!data.isEmpty()) {
            if (data.get(0).get(0).equals(Uid) && data.get(0).get(1).equals(Upass)){
                this.Utype = data.get(0).get(3).toString();
                this.Uname = data.get(0).get(2).toString();
                this.Ustatus = data.get(0).get(4).toString();

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
                row.set(4, "active");
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
