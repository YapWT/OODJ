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
        List<List<String>> data = new zReadFile("users.txt", 0, Uid).getAllData();
            
        if (data != null) {
            if (data.get(0).get(0).equals(Uid) && data.get(0).get(1).equals(Upass)){
                this.Utype = data.get(0).get(3);
                this.Uname = data.get(0).get(2);
                this.Ustatus = data.get(0).get(4);

                if (Ustatus.equals("active"))
                    return "Login";
                else if (Ustatus.equals("blocked"))
                    return "block";
                else if (Ustatus.equals("pending")) {
                    changeStatus();
                    return "pending";
                } else
                    return "deactivate";
            }
        }
        return "Failed";
    }
    
    public void changeStatus(){
        List<List<String>> data = new zReadFile("users.txt").getAllData();
        for (List<String> row : data) {
            if (row.get(0).equals(Uid)) {
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
