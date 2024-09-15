package assignment;

import java.io.*;
import java.util.*;

interface readFile {
    ArrayList<ArrayList<Object>> getAllData();
    List<String> getSplit0();
    List<String> getSplit1();
    List<String> getSplit2();
    List<String> getSplit3();
    List<String> getSplit4();
    List<String> getSplit5();
}

public class zReadFile extends Utils implements readFile {
    private ArrayList<ArrayList<Object>> allData = new ArrayList<>(); // [[], []
    private List<String> split0 = new ArrayList<>(); // []
    private List<String> split1 = new ArrayList<>();
    private List<String> split2 = new ArrayList<>();
    private List<String> split3 = new ArrayList<>();
    private List<String> split4 = new ArrayList<>();
    private List<String> split5 = new ArrayList<>();
    
    public zReadFile(String filename){
        try (BufferedReader rd = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = rd.readLine()) != null) {
                allData.add(new ArrayList<> (Arrays.asList(line.split(","))));
                split0.add(line.split(",")[0]);
                split1.add(line.split(",")[1]);
                split2.add(line.split(",")[2]);
                split3.add(line.split(",")[3]);
                split4.add(line.split(",")[4]);
                split5.add(line.split(",")[5]);
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
                    allData.add(new ArrayList<> (Arrays.asList(line.split(","))));
            }
        } catch (IOException e2){
            System.out.println("Error when reading a file. ");
        }
    }

    @Override
    public ArrayList<ArrayList<Object>> getAllData() {
        return allData;
    }
    
    @Override
    public List<String> getSplit0() {
        return split0;
    }

    @Override
    public List<String> getSplit1() {
        return split1;
    }

    @Override
    public List<String> getSplit2() {
        return split2;
    }

    @Override
    public List<String> getSplit3() {
        return split3;
    }

    @Override
    public List<String> getSplit4() {
        return split4;
    }
    
    @Override
    public List<String> getSplit5() {
        return split5;
    }
}