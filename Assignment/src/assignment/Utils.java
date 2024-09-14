package assignment;

import java.util.Collections;
import java.util.List;

public class Utils {
  public String generateID(String type) {
    List<String> typeOfUser = new zReadFile("users.txt").getSplit3();

    int count = Collections.frequency(typeOfUser, type);

    return String.format("%s%d", type, count+1);
  }
}
