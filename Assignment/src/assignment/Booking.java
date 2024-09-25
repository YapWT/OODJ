package assignment;

import java.time.LocalDate;
import java.util.Locale;
import java.time.temporal.WeekFields;
import java.util.ArrayList;

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
      String bookingStatus) {

    this.bookingID = bookingID;
    this.hallID = hallID;
    this.customer = customer;
    this.timeSlots = timeSlots;
    this.totalPrice = totalPrice;
    this.bookingStatus = bookingStatus;
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
    this.issue = Utils.IDtoObject(issueID, "issues.txt", Issue.class);
  }

  public Booking(
      String bookingID,
      String hallID,
      Customer customer,
      int[] timeSlots,
      int totalPrice,
      String bookingStatus,
      Issue issue) {

    this.bookingID = bookingID;
    this.hallID = hallID;
    this.timeSlots = timeSlots;
    this.totalPrice = totalPrice;
    this.bookingStatus = bookingStatus;
    this.customer = customer;
    this.issue = issue;
  }

    public LocalDate getBookingDate() {
        return bookingDate;
    }
    
    public ArrayList<Booking> getBookingFilter(String filter) {
    ArrayList<Integer> f = new ArrayList<>();
    ArrayList<Booking> bookings = FileOperations.read("Bookings.txt", Booking.class);
    
   
        
    for (Booking b : bookings) {
        LocalDate Date = b.getBookingDate();  // Directly access bookingDate
        
        if (filter.equals("month")) {
            f.add(Date.getMonthValue());  // Extract the month directly
        } else if (filter.equals("year")) {
            f.add(Date.getYear());  // Extract the year directly
        } else if (filter.equals("week")) {
            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            int weekNumber = Date.get(weekFields.weekOfYear());  // Extract the week number
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
}

