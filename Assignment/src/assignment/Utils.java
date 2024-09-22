package assignment;

import java.util.*;

public class Utils {
  public static String generateID(String type) {
    ArrayList<?> data = null;
    List<String> typeOfData = new ArrayList<>();

    switch (type) {
      case "C":
      case "A":
      case "S":
      case "M":
        {
          data = FileOperations.read("users.txt");
          for (Object obj : data) {
            User user = (User) obj;
            typeOfData.add(user.getUid());
          }
          break;
        }
      case "P":
        {
          data = FileOperations.read("payments.txt");
          for (Object obj : data) {
            Payment payment = (Payment) obj;
            typeOfData.add(payment.getPaymentID());
          }
          break;
        }
      case "H":
        {
          data = FileOperations.read("halls.txt");
          for (Object obj : data) {
            Hall hall = (Hall) obj;
            typeOfData.add(Integer.toString(hall.getHallID()));
          }
          break;
        }
      case "B":
        {
          data = FileOperations.read("bookings.txt");
          break;
        }
    }

    int count = Collections.frequency(typeOfData, type);

    return String.format("%s%08d", type, count + 1);
  }

  public static <T> T IDtoObject(String id, String filename, Class<T> runtimeClass) {
    ArrayList<T> objects = FileOperations.read(filename);
    char IDtype = id.charAt(0);
    if (runtimeClass == Customer.class && IDtype == 'C') {
      for (T obj : objects) {
        User user = (User) obj;
        if (user.getUid().equals(id)) {
          return obj;
        }
      }
    } else if (runtimeClass == Payment.class && IDtype == 'P') {
      for (T obj : objects) {
        Payment payment = (Payment) obj;
        if (payment.getPaymentID().equals(id)) {
          return obj;
        }
      }
    }
    return null;
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
