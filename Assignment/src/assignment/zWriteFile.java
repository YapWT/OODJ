package assignment;

import java.io.*;
import java.util.List;

public class zWriteFile {
    public void write(String filename, String data, boolean append){
        try (BufferedWriter w = new BufferedWriter(new FileWriter(filename, append))) {
            w.write(data);
        } catch (IOException e2){
            System.out.println("Error when writing a file. ");
        }
    }
    
    public void write(String filename, List<List<String>> data, boolean append){
        try (BufferedWriter w = new BufferedWriter(new FileWriter(filename, append))) {
            for (List<String> row: data) {
                w.write(String.join(",", row));
                w.newLine();
            }
        } catch (IOException e2){
            System.out.println("Error when writing a file. ");
        }
    }
}
