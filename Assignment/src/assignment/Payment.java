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

  public String getPaymentID() {
    return paymentID;
  }

  public void setPaymentID(String paymentID) {
    this.paymentID = paymentID;
  }

  public String getCustomerID() {
    return customerID;
  }

  public void setCustomerID(String customerID) {
    this.customerID = customerID;
  }

  public int getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(int paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public String getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  @Override
  public String toString() {
    return String.format(
        "%s|%s|%d|%s", this.paymentID, this.customerID, this.paymentAmount, this.paymentStatus);
  }
}
