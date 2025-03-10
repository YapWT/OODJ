package assignment;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
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
    ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);

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

  public boolean matchesFilters(Booking booking, Integer week, Integer month, Integer year) {
    LocalDate bookingDate = booking.getBookingDate(); // Assuming you have a getter for bookingDate

    // Check year
    System.out.print(bookingDate.getYear());
    System.out.print(year);
    if (year != null && bookingDate.getYear() != year) {
      return false;
    }

    // Check month (only if month is specified)
    if (month != null && bookingDate.getMonthValue() != month) {
      return false;
    }

    // Check week (only if week is specified)
    if (week != null && bookingDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR) != week) {
      return false;
    }

    return true;
  }

  public void updateSalesTable(List<Booking> filteredBookings, JTable t) {
    DefaultTableModel tableModel = (DefaultTableModel) t.getModel();
    tableModel.setRowCount(0); // Assuming you are using a DefaultTableModel

    for (Booking booking : filteredBookings) {
      // Assuming the table model has two columns (date, sales)
      Object[] row = {
        booking.getBookingDate(), booking.getTotalPrice()
      }; // Add your specific details
      tableModel.addRow(row);
    }
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
    LocalDate today = LocalDate.now();

    Object[] tableRow = new Object[6];

    if (bookings != null) {
      for (Booking booking : bookings) {
        if (customerID.equals(booking.getCustomer().getUid())
            && !booking.getBookingStatus().equals("cancelled")) {
          if (filter.equals("All")) {
            tableRow[0] = booking.getBookingID();
            tableRow[1] = booking.getHallID();
            tableRow[2] = timeSlotConversion(booking.getTimeSlots()[0]);
            tableRow[3] = timeSlotConversion(booking.getTimeSlots()[1]);
            tableRow[4] = booking.getTotalPrice();
            tableRow[5] = booking.getBookingDate();
            model.addRow(tableRow);
          } else if (filter.equals("Past")) {
            if (booking.getBookingDate().isBefore(today)) {
              tableRow[0] = booking.getBookingID();
              tableRow[1] = booking.getHallID();
              tableRow[2] = timeSlotConversion(booking.getTimeSlots()[0]);
              tableRow[3] = timeSlotConversion(booking.getTimeSlots()[1]);
              tableRow[4] = booking.getTotalPrice();
              tableRow[5] = booking.getBookingDate();
              model.addRow(tableRow);
            }
          } else if (filter.equals("Up Coming")) {
            if (booking.getBookingDate().isEqual(today)
                || booking.getBookingDate().isAfter(today)) {
              tableRow[0] = booking.getBookingID();
              tableRow[1] = booking.getHallID();
              tableRow[2] = timeSlotConversion(booking.getTimeSlots()[0]);
              tableRow[3] = timeSlotConversion(booking.getTimeSlots()[1]);
              tableRow[4] = booking.getTotalPrice();
              tableRow[5] = booking.getBookingDate();
              model.addRow(tableRow);
            }
          }
        }
      }
    }
  }

  public static void cancelBooking(String bookingID, String customerID) {
    ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);
    ArrayList<Schedule> schedules = FileOperations.read("schedules.txt", Schedule.class);

    for (Booking booking : bookings) {
      if (booking.getBookingID().equals(bookingID)
          && booking.getCustomer().getUid().equals(customerID)) {
        booking.setBookingStatus("cancelled");

        for (Schedule schedule : schedules) {
          if (booking.getHallID().equals(schedule.getHallID())
              && booking.getBookingDate().isEqual(schedule.getScheduleDate())) {
            String[] timeSlot = schedule.getTimeSlot();
            for (int i = booking.getTimeSlots()[0]; i < booking.getTimeSlots()[1]; i++) {
              timeSlot[i - 1] = "available";
            }
          }
        }
      }
    }

    FileOperations.write("bookings.txt", bookings);
    FileOperations.write("schedules.txt", schedules);
  }
}
