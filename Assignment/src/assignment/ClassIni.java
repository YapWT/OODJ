package assignment;

import java.io.*;

public class ClassIni {
    public String Ini() {
        try (BufferedReader rd = new BufferedReader(new FileReader("users.txt"))) {
            return null;
        } catch (FileNotFoundException e) {
            try (BufferedWriter w = new BufferedWriter(new FileWriter("users.txt"))) {
                UserMangement id = new UserMangement();
                
                String ID = id.generateID("A");
                w.write(String.format("%s,123,admin,A", ID));
                
                return (String.format("ID: %s\nPasswors: 123", ID));
                
            } catch (IOException e2){
                System.out.println("Error when adding a new user. ");
                return null;
            }
        }
        catch (IOException e) {
            System.out.println("Error Found in reader file");
            return null;
        }
    }
}
