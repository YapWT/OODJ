package assignment;

import java.util.*;
import javax.swing.*;

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
            typeOfData.add(hall.getHallID());
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
    ArrayList<Character> userTypes = new ArrayList<>(Arrays.asList('A', 'S', 'C', 'M'));

    char IDtype = id.charAt(0);

    if (runtimeClass == User.class && userTypes.contains(IDtype)) {
      for (T obj : objects) {
        User user = (User) obj;
        if (user.getUid().equals(id)) return obj;
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

  // edit one column of a row
  public static <T> void editFile(
      String filename, String id, int column, String newData, Class<T> runtimeClass) {
    ArrayList<T> obj = FileOperations.read(filename);

    if (runtimeClass == User.class) {
      for (T row : obj) {
        User user = (User) row;
        if (user.getUid().equals(id)) {
          setColumnValue(column, newData, row);
          break;
        }
      }
    }
    // edit with rewrite all data
    FileOperations.write(filename, obj);
  }

  private static <T> void setColumnValue(int column, String value, T row) {
    // id is not avalable to make modify
    if (row instanceof User) {
      // type is not avaible to edit
      User user = (User) row;
      switch (column) {
        case 1:
          user.setUpass(value);
          break;
        case 2:
          user.setUname(value);
          break;
        case 4:
          user.setUcontact(value);
          break;
        case 5:
          user.setUstatus(value);
          break;
      }
    }
  }

  public static boolean checkContact(String contact) {
    if (contact.matches("01\\d{8}") || contact.matches("01\\d{9}")) return true;
    return false;
  }
  
  public static boolean emptyPassword(ArrayList<JComponent> object) {
        for (JComponent ob : object) {
            if (((JPasswordField) ob).getPassword().length == 0) 
                return true; 
        }
        return false; 
    }

}

