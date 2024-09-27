package assignment;

import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Utils {
  public static String generateID(String type) {
    ArrayList<?> data = null;
    List<String> typeOfData = new ArrayList<>();

    if (type.equals("C") || type.equals("A") || type.equals("S") || type.equals("M")) {
      data = FileOperations.read("users.txt", User.class);
      for (Object obj : data) {
        User user = (User) obj;
        if (user.getUtype().equals(type)) {
          typeOfData.add(user.getUid());
        }
      }
    } else if (type.equals("H")) {
      data = FileOperations.read("halls.txt", Hall.class);
      for (Object obj : data) {
        Hall hall = (Hall) obj;
        typeOfData.add(hall.getHallID());
      }
    } else if (type.equals("B")) {
      data = FileOperations.read("bookings.txt", Booking.class);
      for (Object obj : data) {
        Booking booking = (Booking) obj;
        typeOfData.add(booking.getBookingID());
      }

    } else if (type.equals("I")) {
      data = FileOperations.read("issues.txt", Issue.class);
      for (Object obj : data) {
        Issue issue = (Issue) obj;
        typeOfData.add(issue.getIssueID());
      }
    }

    int count = typeOfData.size();

    return String.format("%s%08d", type, count + 1);
  }

  public static <T> T IDtoObject(String id, String filename, Class<T> runtimeClass) {
    ArrayList<T> objects = FileOperations.read(filename, runtimeClass);
    char IDtype = id.charAt(0);

    if (runtimeClass == Hall.class && IDtype == 'H') {
      for (T obj : objects) {
        Hall hall = (Hall) obj;
        if (hall.getHallID().equals(id)) {
          return obj;
        }
      }
    } else if (runtimeClass == Booking.class && IDtype == 'B') {
      for (T obj : objects) {
        Booking booking = (Booking) obj;
        if (booking.getBookingID().equals(id)) {
          return obj;
        }
      }
    } else if (runtimeClass == Customer.class && IDtype == 'C') {
      for (T obj : objects) {
        Customer customer = (Customer) obj;
        if (customer.getUid().equals(id)) {
          return obj;
        }
      }
    } else if (runtimeClass == User.class) {
      for (T obj : objects) {
        User user = (User) obj;
        if (user.getUid().equals(id)) {
          return obj;
        }
      }
    } else if (runtimeClass == Issue.class) {
      for (T obj : objects) {
        Issue issuee = (Issue) obj;
        if (issuee.getIssueID().equals(id)) {
          return obj;
        }
      }
    }
    return null;
  }

  // need to set before calling
  /*
    setUpass(newPass);
    Utils.editFile("users.txt", this, User.class);
  */
  public static <T> void editFile(String filename, T data, Class<T> runtimeClass) {
    ArrayList<T> obj = FileOperations.read(filename, runtimeClass);

    if (runtimeClass == User.class) {
      User u = (User) data;
      for (int i = 0; i < obj.size(); i++) {
        User user = (User) obj.get(i);
        if (user.getUid().equals(u.getUid())) {
          obj.set(i, (T) u);
          break;
        }
      }
    } else if (runtimeClass == Issue.class) {
      Issue issue = (Issue) data;
      for (int i = 0; i < obj.size(); i++) {
        Issue issues = (Issue) obj.get(i);
        if (issues.getIssueID().equals(issue.getIssueID())) {
          obj.set(i, (T) issue);
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

  // table without any filter
  public static <T> void viewTable(JTable t, String filename, Class<T> runtimeClass) {
    DefaultTableModel model = (DefaultTableModel) t.getModel();
    model.setRowCount(0);
    ArrayList<T> object = FileOperations.read(filename, runtimeClass);
    Object[] tableRow = new Object[7];

    int i = 1;

    if (object != null) {
      if (runtimeClass == User.class) {
        for (T row : object) {
          User a = (User) row;

          if (!a.getUstatus().equals("deleted")) {
            tableRow[0] = i++;
            tableRow[1] = a.getUid();
            tableRow[2] = a.getUname();
            tableRow[3] = a.getUtype();
            tableRow[4] = a.getUcontact();
            tableRow[5] = a.getUstatus();

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
      } else if (runtimeClass == Booking.class) {
        for (T row : object) {
          Booking b = (Booking) row;
          if ((b.getBookingStatus()).toLowerCase().equals("success")) {
            tableRow[0] = b.getBookingDate();
            tableRow[1] = "RM" + b.getTotalPrice();
            model.addRow(tableRow);
          }
        }
      } else if (runtimeClass == Issue.class) {
        for (T row : object) {
          Issue issue = (Issue) row;
          tableRow[0] = issue.getIssueID();
          tableRow[1] = issue.getBooking();
          tableRow[2] = issue.getDescription();
          tableRow[3] = issue.getResponse();
          tableRow[4] = issue.getStatus();
          tableRow[5] = issue.getAssignedStaff();
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
    ArrayList<T> object = FileOperations.read(filename, runtimeClass);
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
              tableRow[2] = a.getUname();
              tableRow[3] = a.getUtype();
              tableRow[4] = a.getUcontact();
              tableRow[5] = a.getUstatus();

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

  // for filter hall only
  public static <T> void viewTable(JTable t, String hallType, String hallStatus) {
    DefaultTableModel model = (DefaultTableModel) t.getModel();
    model.setRowCount(0);
    ArrayList<Hall> halls = FileOperations.read("halls.txt", Hall.class);
    Object[] tableRow = new Object[3];
    for (Hall hall : halls) {
      if (hall.getHallType().equals(hallType) && hall.getHallStatus().equals(hallStatus)) {
        tableRow[0] = hall.getHallID();
        String type = null;
        switch (hallType) {
          case "auditorium":
            {
              type = "Auditorium";
              break;
            }
          case "banquet":
            {
              type = "Banquet Hall";
              break;
            }
          case "meeting":
            {
              type = "Meeting Room";
              break;
            }
        }
        tableRow[1] = type;
        tableRow[2] = hallStatus;

        model.addRow(tableRow);
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
      tableRow[2] = user.getUname();
      tableRow[3] = user.getUtype();
      tableRow[4] = user.getUcontact();
      tableRow[5] = user.getUstatus();

      model.addRow(tableRow);
    }
  }
}
