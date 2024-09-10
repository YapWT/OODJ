package assignment;

import java.util.*;

public class zUserToString {
   
    private ArrayList<String> splits = new ArrayList<>();
    
    public zUserToString(ArrayList<ArrayList<Object>> data) {
        for (int i = 0; i < data.size(); i++){
            for (int j = 0; j < 6; j++) 
                splits.add(data.get(i).get(j).toString());
        }
    }

    public String getSplit(int i){
        return splits.get(i);
    }
}
