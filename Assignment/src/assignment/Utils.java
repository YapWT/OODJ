  package assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Utils {
  public static String generateID(String type) {
    ArrayList<?> data = null;
    List<String> typeOfData = new ArrayList<>();

    if (type.equals("C") || type.equals("A") || type.equals("S") || type.equals("M")) {
      data = FileOperations.read("users.txt");
      for (Object obj : data) {
        User user = (User) obj;
        if (user.getUtype().equals(type)) {
          typeOfData.add(user.getUid());
        }
      }
    } else if (type.equals("P")) {
      data = FileOperations.read("payments.txt");
      for (Object obj : data) {
        Payment payment = (Payment) obj;
        typeOfData.add(payment.getPaymentID());
      }
    } else if (type.equals("H")) {
      data = FileOperations.read("halls.txt");
      for (Object obj : data) {
        Hall hall = (Hall) obj;
        typeOfData.add(hall.getHallID());
      }
    } else if (type.equals("B")) {
      data = FileOperations.read("bookings.txt");
      for (Object obj : data) {
        Booking booking = (Booking) obj;
        typeOfData.add(booking.getBookingID());
      }
    }

    int count = typeOfData.size();

    return String.format("%s%08d", type, count + 1);
  }

  public static <T> T IDtoObject(String id, String filename, Class<T> runtimeClass) {
    ArrayList<T> objects = FileOperations.read(filename);
    ArrayList<Character> userTypes = new ArrayList<>(Arrays.asList('A', 'S', 'C', 'M'));

    char IDtype = id.charAt(0);

    if (runtimeClass == User.class && userTypes.contains(IDtype)) {
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
    } else if (runtimeClass == Hall.class && IDtype == 'H') {
      for (T obj : objects) {
        Hall hall = (Hall) obj;
        if (hall.getHallID().equals(id)) {
          return obj;
        }
      }
    }
    return null;
  }

  // edit file
  // need to set before calling

  public static <T> void editFile(String filename, T data, Class<T> runtimeClass) {
    ArrayList<T> obj = FileOperations.read(filename);

    if (runtimeClass == User.class) {
        User u = (User) data; 
        for (int i = 0; i < obj.size(); i++) {
            User user = (User) obj.get(i);
            if (user.getUid().equals(u.getUid())){
                obj.set(i, (T) u);
                break;
            }
        }
    }
    // edit with rewrite all data
    FileOperations.write(filename, obj);
  }

  public static boolean checkContact(String contact) {
    if (contact.matches("01\\d{8}") || contact.matches("01\\d{9}")) return true;
    return false;
  }

  public static boolean emptyPassword(ArrayList<JComponent> object) {
    for (JComponent ob : object) {
      if (((JPasswordField) ob).getPassword().length == 0) return true;
    }
    return false;
  }

  // table without any filter
  public static <T> void viewTable(JTable t, String filename, Class<T> runtimeClass) {
    DefaultTableModel model = (DefaultTableModel) t.getModel();
    model.setRowCount(0);
    ArrayList<T> object = FileOperations.read(filename);
    Object[] tableRow = new Object[7];

    int i = 1;

    if (object != null) {
      if (runtimeClass == User.class) {
        for (T row : object) {
          User a = (User) row;

          if (!a.getUstatus().equals("deleted")) {
            tableRow[0] = i++;
            tableRow[1] = a.getUid();
            tableRow[2] = a.getUpass().replaceAll(".", "*");
            tableRow[3] = a.getUname();
            tableRow[4] = a.getUtype();
            tableRow[5] = a.getUcontact();
            tableRow[6] = a.getUstatus();

            model.addRow(tableRow);
          }
        }
      } else if (runtimeClass == Hall.class) {
        for (T row : object) {
          Hall a = (Hall) row;
          tableRow[0] = a.getHallID();
          String hallType = a.getHallType();
          String Type = null;
          switch (hallType) {
            case "auditorium":
              {
                Type = "Auditorium";
                break;
              }
            case "banquet":
              {
                Type = "Banquet Hall";
                break;
              }
            case "meeting":
              {
                Type = "Meeting Room";
                break;
              }
          }
          tableRow[1] = Type;
          tableRow[2] = a.getHallStatus();

          model.addRow(tableRow);
        }
      }
    }
  }

  // filter table
  public static <T> void viewTable(
      JTable t, String filename, Class<T> runtimeClass, int column, String filter) {
    DefaultTableModel model = (DefaultTableModel) t.getModel();
    model.setRowCount(0);
    ArrayList<T> object = FileOperations.read(filename);
    Object[] tableRow = new Object[7];

    int i = 1;

    if (object != null) {
      if (runtimeClass == User.class) {
        if (column != 0) {
          for (T row : object) {
            User a = (User) row;
            String f = null;

            switch (column) {
              case 3:
                f = a.getUtype();
                break;
              case 5:
                f = a.getUstatus();
                break;
            }

            if (!a.getUstatus().equals("deleted") && f.equals(filter)) {
              tableRow[0] = i++;
              tableRow[1] = a.getUid();
              tableRow[2] = a.getUpass().replaceAll(".", "*");
              tableRow[3] = a.getUname();
              tableRow[4] = a.getUtype();
              tableRow[5] = a.getUcontact();
              tableRow[6] = a.getUstatus();

              model.addRow(tableRow);
            }
          }
        } else {
          User a = IDtoObject(filter, "users.txt", User.class);

          tableRow[0] = a.getUid();
          tableRow[1] = a.getUname();
          tableRow[2] = a.getUcontact();

          model.addRow(tableRow);
        }
      }
    }
  }

  public static <T> void addTableRow(JTable t, Class<T> runtimeClass, T data) {
    DefaultTableModel model = (DefaultTableModel) t.getModel();
    Object[] tableRow = new Object[7];

    if (runtimeClass == User.class) {
      User user = (User) data;
      tableRow[0] = model.getRowCount() + 1;
      tableRow[1] = user.getUid();
      tableRow[2] = user.getUpass();
      tableRow[3] = user.getUname();
      tableRow[4] = user.getUtype();
      tableRow[5] = user.getUcontact();
      tableRow[6] = user.getUstatus();

      model.addRow(tableRow);
    }
  }
  
}
