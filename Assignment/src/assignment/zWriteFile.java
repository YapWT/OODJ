package assignment;

import java.io.*;
import java.util.*;

interface writeFile {
    void write(String filename, String data, boolean append);
    void write(String filename, ArrayList<ArrayList<Object>> data, boolean append);
}

public class zWriteFile extends Utils implements writeFile{
    
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
            for (ArrayList<Object> row : data)
                w.write(toString(row));
                
                
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


class zUserToString extends zWriteFile {

    private ArrayList<String> splits = new ArrayList<>();

    public zUserToString(ArrayList<ArrayList<Object>> data) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < 6; j++) {
                splits.add(data.get(i).get(j).toString());
            }
        }
    }

    public String getSplit(int i) {
        return splits.get(i);
    }
}

