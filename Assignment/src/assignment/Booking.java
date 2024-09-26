package assignment;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Booking {
  private String bookingID;
  private String hallID;
  private Customer customer;
  private int[] timeSlots;
  private int totalPrice;
  private String bookingStatus;
  private Issue issue;
  private LocalDate bookingDate;

  public Booking() {}

  public Booking(
      String bookingID,
      String hallID,
      Customer customer,
      int[] timeSlots,
      int totalPrice,
      String bookingStatus,
      LocalDate bookingDate) {

    this.bookingID = bookingID;
    this.hallID = hallID;
    this.customer = customer;
    this.timeSlots = timeSlots;
    this.totalPrice = totalPrice;
    this.bookingStatus = bookingStatus;
    this.bookingDate = bookingDate;
    this.issue = new Issue() {};
  }

  public Booking(
      String bookingID,
      String hallID,
      String customerID,
      int[] timeSlots,
      int totalPrice,
      String bookingStatus,
      LocalDate bookingDate,
      String issueID) {

    this.bookingID = bookingID;
    this.hallID = hallID;
    this.timeSlots = timeSlots;
    this.totalPrice = totalPrice;
    this.bookingStatus = bookingStatus;
    this.bookingDate = bookingDate;

    this.customer = Utils.IDtoObject(customerID, "users.txt", Customer.class);
    if (issueID.equals("null")) {
      this.issue = new Issue() {};
    } else {
      this.issue = Utils.IDtoObject(issueID, "issues.txt", Issue.class);
    }
  }

  public Booking(
      String bookingID,
      String hallID,
      Customer customer,
      int[] timeSlots,
      int totalPrice,
      String bookingStatus,
      LocalDate bookingDate,
      Issue issue) {

    this.bookingID = bookingID;
    this.hallID = hallID;
    this.timeSlots = timeSlots;
    this.totalPrice = totalPrice;
    this.bookingStatus = bookingStatus;
    this.customer = customer;
    this.bookingDate = bookingDate;
    this.issue = issue;
  }

  public LocalDate getBookingDate() {
    return bookingDate;
  }

  public ArrayList<Booking> getBookingFilter(String filter) {
    ArrayList<Integer> f = new ArrayList<>();
    ArrayList<Booking> bookings = FileOperations.read("Bookings.txt", Booking.class);

    for (Booking b : bookings) {
      LocalDate Date = b.getBookingDate(); // Directly access bookingDate

      if (filter.equals("month")) {
        f.add(Date.getMonthValue()); // Extract the month directly
      } else if (filter.equals("year")) {
        f.add(Date.getYear()); // Extract the year directly
      } else if (filter.equals("week")) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = Date.get(weekFields.weekOfYear()); // Extract the week number
        f.add(weekNumber);
      }
    }
    return bookings;
  }

  public void setBookingDate(LocalDate bookingDate) {
    this.bookingDate = bookingDate;
  }

  public String getBookingID() {
    return bookingID;
  }

  public String getHallID() {
    return hallID;
  }

  public Customer getCustomer() {
    return customer;
  }

  public int[] getTimeSlots() {
    return timeSlots;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public String getBookingStatus() {
    return bookingStatus;
  }

  public Issue getIssue() {
    return issue;
  }

  public void setBookingID(String bookingID) {
    this.bookingID = bookingID;
  }

  public void setHallID(String hallID) {
    this.hallID = hallID;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public void setTimeSlots(int[] timeSlots) {
    this.timeSlots = timeSlots;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public void setBookingStatus(String bookingStatus) {
    this.bookingStatus = bookingStatus;
  }

  public void setIssue(Issue issue) {
    this.issue = issue;
  }

  public String toString() {
    return String.format(
        "%s|%s|%s|%d|%d|%d|%s|%s|%s",
        bookingID,
        hallID,
        customer.getUid(),
        timeSlots[0],
        timeSlots[1],
        totalPrice,
        bookingStatus,
        bookingDate.toString(),
        issue.getIssueID());
  }

  public static String timeSlotConversion(int time) {
    String[] timeSlotComboStrings =
        new String[] {
          "8:00am", "9:00am", "10:00am", "11:00am", "12:00pm", "1:00pm", "2:00pm", "3:00pm",
          "4:00pm", "5:00pm", "6:00pm"
        };

    return timeSlotComboStrings[time - 1];
  }

  public static void displayBookingsTable(JTable T, String filter, String customerID) {
    DefaultTableModel model = (DefaultTableModel) T.getModel();
    model.setRowCount(0);

    ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);

    Object[] tableRow = new Object[6];

    if (bookings != null) {
      for (Booking booking : bookings) {
        if (customerID.equals(booking.getCustomer().getUid())
            && !booking.getBookingStatus().equals("cancelled")) {
          switch (filter) {
            case "All":
              {
                tableRow[0] = booking.getBookingID();
                tableRow[1] = booking.getHallID();
                tableRow[2] = timeSlotConversion(booking.getTimeSlots()[0]);
                tableRow[3] = timeSlotConversion(booking.getTimeSlots()[1]);
                tableRow[4] = booking.getTotalPrice();
                tableRow[5] = booking.getBookingDate();
                model.addRow(tableRow);
                break;
              }
            case "Past":
              {
                if (booking.getBookingDate().isBefore(LocalDate.now())) {
                  tableRow[0] = booking.getBookingID();
                  tableRow[1] = booking.getHallID();
                  tableRow[2] = timeSlotConversion(booking.getTimeSlots()[0]);
                  tableRow[3] = timeSlotConversion(booking.getTimeSlots()[1]);
                  tableRow[4] = booking.getTotalPrice();
                  tableRow[5] = booking.getBookingDate();
                  model.addRow(tableRow);
                  break;
                }
              }
            case "Up Coming":
              {
                if (booking.getBookingDate().isEqual(LocalDate.now())
                    || booking.getBookingDate().isAfter(LocalDate.now())) {
                  tableRow[0] = booking.getBookingID();
                  tableRow[1] = booking.getHallID();
                  tableRow[2] = timeSlotConversion(booking.getTimeSlots()[0]);
                  tableRow[3] = timeSlotConversion(booking.getTimeSlots()[1]);
                  tableRow[4] = booking.getTotalPrice();
                  tableRow[5] = booking.getBookingDate();
                  model.addRow(tableRow);
                  break;
                }
              }
          }
        }
      }
    }
  }

  public static void cancelBooking(String boookingID, String customerID) {
    ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);

    for (Booking booking : bookings) {
      if (booking.getBookingID().equals(boookingID)
          && booking.getCustomer().getUid().equals(customerID)) {
        booking.setBookingStatus("cancelled");
      }
    }

    FileOperations.write("bookings.txt", bookings);
  }
}
