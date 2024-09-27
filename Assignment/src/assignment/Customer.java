package assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Customer extends User {
  public Customer() {}

  public Customer(String id, String pass, String name, String type, String contact, String status) {
    this.setUid(id);
    this.setUpass(pass);
    this.setUname(name);
    this.setUtype(type);
    this.setUcontact(contact);
    this.setUstatus(status);
  }

  public void register(String name, String password, String contact) {
    this.setUid(Utils.generateID("C"));
    this.setUpass(password);
    this.setUname(name);
    this.setUtype("C");
    this.setUcontact(contact);
    this.setUstatus("active");

    FileOperations.write("users.txt", this);
  }

  public int bookHalls(String hallID, int[] timeSlots, LocalDate date) {
    if (timeSlots.length > 2) {
      throw new IllegalArgumentException("Timeslots only accept an array of length 2");
    }

    ArrayList<Hall> halls = FileOperations.read("halls.txt", Hall.class);
    int amount = 0;

    for (Hall hall : halls) {
      if (hall.getHallID().equals(hallID)) {
        amount = hall.getRatePerHour() * (timeSlots[1] - timeSlots[0]);
        break;
      }
    }

    Schedule schedule = null;
    String[] timeSlot = null;

    if (Schedule.checkIfScheduleExists(date, hallID)) {
      schedule = Schedule.scheduleObjectify(date, hallID);
      timeSlot = schedule.getTimeSlot();
      for (int i = timeSlots[0] - 1; i < timeSlots[1] - 1; i++) {
        if (timeSlot[i].equals("booked") || timeSlot[i].equals("maintenance")) {
          throw new IllegalArgumentException("Invalid choice, you chose invalid timeSlot");
        }
      }
      for (int i = timeSlots[0] - 1; i < timeSlots[1] - 1; i++) {
        timeSlot[i] = "booked";
      }
      schedule.setTimeSlot(timeSlot);

    } else {
      schedule.setScheduleDate(date);
      schedule.setHallID(hallID);
      String[] scheduleSlots = new String[10];
      Arrays.fill(scheduleSlots, "available");
    }

    Booking booking =
        new Booking(Utils.generateID("B"), hallID, this, timeSlots, amount, "success", date);
    FileOperations.write("bookings.txt", booking);

    Schedule.overwriteOldSchedule(schedule);

    return amount;
  }

  public static void displayIssueTable(JTable T, String customerID) {
    DefaultTableModel model = (DefaultTableModel) T.getModel();
    model.setRowCount(0);
    ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);

    Object[] tableRow = new Object[5];

    for (Booking booking : bookings) {
      if (booking.getCustomer().getUid().equals(customerID)
          && !booking.getBookingStatus().equals("cancelled")) {
        tableRow[0] = booking.getBookingID();
        tableRow[1] = booking.getBookingDate();
        if (booking.getIssue().isEmpty()) {
          tableRow[2] = "null";
          tableRow[3] = "null";
          tableRow[4] = "null";
        } else {
          tableRow[2] = booking.getIssue().getDescription();
          tableRow[3] = booking.getIssue().getResponse();
          tableRow[4] = booking.getIssue().getStatus();
        }

        model.addRow(tableRow);
      }
    }
  }

  public void createIssue(String bookingID, String description) {
    String issueID = Utils.generateID("I");

    Issue issue = new Issue(issueID, bookingID, description);

    FileOperations.write("issues.txt", issue);

    ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);
    for (Booking booking : bookings) {
      if (booking.getBookingID().equals(bookingID)) {
        booking.setIssue(Utils.IDtoObject(issueID, "issues.txt", Issue.class));
        break;
      }
    }

    FileOperations.write("bookings.txt", bookings);
  }
}
