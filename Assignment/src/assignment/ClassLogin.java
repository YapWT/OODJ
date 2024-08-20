package assignment;

import java.io.*;
import javax.swing.JOptionPane;


public class ClassLogin {
    private String Uid;
    private String Upass;
    private String Uname;
    private String Utype;

    public ClassLogin(String Uid, String Upass) {
        this.Uid = Uid;
        this.Upass = Upass;
    }
    
    public boolean checkUser(){
        
        try (BufferedReader rd = new BufferedReader(new FileReader("users.txt"))){
            String line;
            while ((line = rd.readLine()) != null){
                String[] data = line.split(",");
                if (data[0].equals(Uid) && data[1].equals(Upass)){
                    this.Utype = data[3];
                    this.Uname = data[2];
                    return true;
                }
                    
            } 
        } catch (IOException e){
            System.out.println("Error reading the file in login");
            return false;
        }
        return false;
    }

    public String getUtype() {
        return Utype;
    }
    
    
}
