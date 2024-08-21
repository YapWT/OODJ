package assignment;

import java.io.*;

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

    public String checkUser(){
        try (BufferedReader rd = new BufferedReader(new FileReader("users.txt"))){
            String line;
            while ((line = rd.readLine()) != null) {
                String[] data = line.split(",");
                
                if (data[0].equals(Uid) && data[1].equals(Upass)){
                    this.Utype = data[3];
                    this.Uname = data[2];
                    this.Ustatus = data[4];
                    
                    if (Ustatus.equals("active"))
                        return "Login";
                    else if (Ustatus.equals("blocked"))
                        return "block";
                    else if (Ustatus.equals("pending"))
                        return "pending";
                    else
                        return "deactivate";
                }
            }
        } catch (IOException e){
            return "Error reading the file in login";
        }
        return "Failed";
    }

    public String getUtype() {
        return Utype;
    }    

    public String getUid() {
        return Uid;
    }
}
