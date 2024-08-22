package assignment;

import java.io.*;

public class ClassIni {
    public String Ini() {
        try (BufferedReader rd = new BufferedReader(new FileReader("users.txt"))) {
            return null;
        } catch (FileNotFoundException e) {
            new zWriteFile().write("users.txt", "A160001,123,admin,A,pending", false);
            return "A160001,123,admin,A,pending";
        } catch (IOException e) {
            System.out.println("Error Found in reader file");
            return null;
        }
    }
}
