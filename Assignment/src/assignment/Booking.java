package assignment;

public class Booking {
  private String bookingID;
  private String hallID;
  private Customer customer;
  private int[] timeSlots;
  private int totalPrice;
  private String bookingStatus;
  private Issue issue;

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
      String issueID) {

    this.bookingID = bookingID;
    this.hallID = hallID;
    this.timeSlots = timeSlots;
    this.totalPrice = totalPrice;
    this.bookingStatus = bookingStatus;

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
        "%s|%s|%s|%d|%d|%d|%s|%s",
        bookingID,
        hallID,
        customer.getUid(),
        timeSlots[0],
        timeSlots[1],
        totalPrice,
        bookingStatus,
        issue.getIssueID());
  }
}
