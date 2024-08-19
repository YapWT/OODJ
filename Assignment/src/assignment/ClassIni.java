package assignment;

import java.io.*;

public class ClassIni {
    public void Ini() {
        try {
            BufferedReader rd = new BufferedReader(new FileReader("users.txt"));
        } catch (FileNotFoundException e) {
            try {
                BufferedWriter w = new BufferedWriter(new FileWriter("users.txt"));
                UserMangement id = new UserMangement();
                w.write("");
            } catch (IOException e){
                System.out.println("Error when adding a new user. ");               
            }
        }
        catch (IOException e) {
            System.out.println("Error Found in reader file");
        }
    }
    

}
