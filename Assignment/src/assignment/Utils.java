package assignment;

import java.util.*;

public class Utils {
  public static String generateID(String type) {
    ArrayList<User> users = FileOperations.read("users.txt");
    List<String> typeOfUser = new ArrayList<>();

    for (User user : users) {
      typeOfUser.add(user.getUtype());
    }

    int count = Collections.frequency(typeOfUser, type);

    return String.format("%s%08d", type, count + 1);
  }

  public static zUserToString idGetRow(String Uid) {
    ArrayList<ArrayList<Object>> data = new zReadFile("users.txt", 0, Uid).getAllData();
    if (data.isEmpty()) return null;

    return new zUserToString(data);
  }

  // edit one column of a row
  public static void editFile(String filename, String comparation, int column, String edition) {
    ArrayList<ArrayList<Object>> data = new zReadFile(filename).getAllData();

    for (ArrayList<Object> row : data) {
      if (row.get(0).toString().equals(comparation)) {
        row.set(column, edition);
        break;
      }
    }
    // edit with rewrite all data
    new zWriteFile().write(filename, data, false);
  }

  public static boolean checkContact(String contact) {
    if (contact.matches("01\\d{8}") || contact.matches("01\\d{9}")) return true;
    return false;
  }
}
