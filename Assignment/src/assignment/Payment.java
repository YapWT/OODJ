package assignment;

public class Payment {
  private String paymentID;
  private String customerID;
  private int paymentAmount;
  private String paymentStatus;

  public Payment() {}

  public Payment(String id, String cusID, int amount, String status) {
    this.paymentID = id;
    this.customerID = cusID;
    this.paymentAmount = amount;
    this.paymentStatus = status;
  }

  public String toString() {
    return String.format(
        "%s,%s,%d,%s", this.paymentID, this.customerID, this.paymentAmount, this.paymentStatus);
  }

  public void updateStatus(String status) {
    this.paymentStatus = status;
  }
}
