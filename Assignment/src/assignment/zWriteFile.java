package assignment;

import java.io.*;
import java.util.*;

interface writeFile {
    void write(String filename, String data, boolean append);
    void write(String filename, ArrayList<ArrayList<Object>> data, boolean append);
}

public class zWriteFile implements writeFile{
    
    @Override
    public void write(String filename, String data, boolean append){
        try (BufferedWriter w = new BufferedWriter(new FileWriter(filename, append))) {
            w.write(data);
        } catch (IOException e2){
            System.out.println("Error when writing a file. ");
        }
    }
    
    @Override
    public void write(String filename, ArrayList<ArrayList<Object>> data, boolean append){
        try (BufferedWriter w = new BufferedWriter(new FileWriter(filename, append))) {
            for (ArrayList<Object> row : data) {
                w.write(toString(row));
                w.newLine();
            }
                
                
        } catch (IOException e2){
            System.out.println("Error when writing a file. ");
        }
    }

    
    private String toString(ArrayList<Object> row) {
        StringBuilder line = new StringBuilder();

        for (Object obj : row){
            if (line.length() > 0)
                line.append(",");
            line.append(obj.toString());
        }
        line.append("\n");
        return line.toString();
    }
}
