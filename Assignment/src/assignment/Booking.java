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
      String paymentID) {}
}
