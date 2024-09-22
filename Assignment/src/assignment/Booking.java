package assignment;

public class Booking {
  private String bookingID;
  private String hallID;
  private Customer customer;
  private int[] timeSlots;
  private int totalPrice;
  private String bookingStatus;
  private Payment payment;

  public Booking() {}

  public Booking(
      String bookingID,
      String hallID,
      String customerID,
      int[] timeSlots,
      int totalPrice,
      String bookingStatus,
      String paymentID) {

    this.bookingID = bookingID;
    this.hallID = hallID;
    this.timeSlots = timeSlots;
    this.totalPrice = totalPrice;
    this.bookingStatus = bookingStatus;

    this.customer = Utils.IDtoObject(customerID, "users.txt", Customer.class);
    this.payment = Utils.IDtoObject(paymentID, "payments.txt", Payment.class);
  }

  public Booking(
      String bookingID,
      String hallID,
      Customer customer,
      int[] timeSlots,
      int totalPrice,
      String bookingStatus,
      Payment payment) {

    this.bookingID = bookingID;
    this.hallID = hallID;
    this.timeSlots = timeSlots;
    this.totalPrice = totalPrice;
    this.bookingStatus = bookingStatus;
    this.customer = customer;
    this.payment = payment;
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

  public Payment getPayment() {
    return payment;
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

  public void setPayment(Payment payment) {
    this.payment = payment;
  }
}
