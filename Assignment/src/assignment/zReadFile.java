package assignment;

import java.io.*;
import java.util.*;

public class zReadFile {
    private List<List<String>> allData = new ArrayList<>(); // [[], []
    private List<String> split0 = new ArrayList<>(); // []
    private List<String> split1 = new ArrayList<>();
    private List<String> split2 = new ArrayList<>();
    private List<String> split3 = new ArrayList<>();
    private List<String> split4 = new ArrayList<>();
    
    public zReadFile(String filename){
        try (BufferedReader rd = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = rd.readLine()) != null) {
                allData.add(Arrays.asList(line.split(",")));
                split0.add(line.split(",")[0]);
                split1.add(line.split(",")[1]);
                split2.add(line.split(",")[2]);
                split3.add(line.split(",")[3]);
                split4.add(line.split(",")[4]);
            }
        } catch (IOException e2){
            System.out.println("Error when reading a file. ");
        }
    }
    
    public zReadFile(String filename, int splitNumber, String search){
        try (BufferedReader rd = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = rd.readLine()) != null) {
                if (line.split(",")[splitNumber].equals(search))
                    allData.add(Arrays.asList(line.split(",")));
            }
        } catch (IOException e2){
            System.out.println("Error when reading a file. ");
        }
    }

    public List<List<String>> getAllData() {
        return allData;
    }
    
    public List<String> getSplit0() {
        return split0;
    }

    public List<String> getSplit1() {
        return split1;
    }

    public List<String> getSplit2() {
        return split2;
    }

    public List<String> getSplit3() {
        return split3;
    }

    public List<String> getSplit4() {
        return split4;
    }

}
