package assignment;

public class Booking {
  private String bookingID;
  private int hallID;
  private Customer customer;
  private int[] timeSlots;
  private int totalPrice;
  private String bookingStatus;
  private Payment payment;

  public Booking() {}

  public Booking(
      String bookingID,
      int hallID,
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
}
