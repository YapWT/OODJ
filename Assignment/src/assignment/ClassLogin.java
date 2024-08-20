package assignment;

import java.io.*;

public class ClassLogin {
    private String Uid;
    private String Upass;
    private String Uname;
    private String Utype;
    private String Ustatus; // active, blocked, deleted

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
                    if (data[4].equals("active")){
                        this.Utype = data[3];
                        this.Uname = data[2];
                        return "Login";
                    } else if (data[4].equals("blocked"))
                        return "block";
                    else
                        return "delete";
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


}
