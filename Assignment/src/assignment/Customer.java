package assignment;

import java.util.ArrayList;

public class Customer extends User {
  public Customer() {}

  public void register(String name, String password, String contact) {
    this.setUid(Utils.generateID("C"));
    this.setUpass(password);
    this.setUname(name);
    this.setUtype("C");
    this.setUcontact(contact);
    this.setUstatus("pending");

    System.out.println(
        String.format(
            "\n%s,%s,%s,%s,%s,%s",
            this.getUid(),
            this.getUpass(),
            this.getUname(),
            this.getUtype(),
            this.getUcontact(),
            this.getUstatus()));

    FileOperations.write("users.txt", this);
  }

  public ArrayList<Hall> viewAvailableHalls() {
    ArrayList<Hall> halls = FileOperations.read("halls.txt");
    // this is retarded

    return null;
  }

  public void bookHalls(int hallID, int[] timeSlots) {
    if (timeSlots.length > 2) {
      throw new IllegalArgumentException("Timeslots only accept an array of length 2");
    }

    ArrayList<Hall> halls = FileOperations.read("halls.txt");
    int amount = 0;

    for (Hall hall : halls) {
      if (hall.getHallID() == hallID) {
        for (int i = timeSlots[0]; i < timeSlots[1]; i++) {
          hall.setTimeSlot(i, "booked");
        }

        amount = hall.getRatePerHour() * (timeSlots[1] - timeSlots[0]);
        break;
      } else {
        throw new IllegalArgumentException("Invalid hall number");
      }
    }
    FileOperations.write("halls.txt", halls);

    Payment payment = new Payment(Utils.generateID("payment"), this.getUid(), amount, "success");
    FileOperations.write("payments.txt", payment);

    Booking booking =
        new Booking(
            Utils.generateID("booking"), hallID, this, timeSlots, amount, "success", payment);
    FileOperations.write("bookings.txt", booking);
  }

  public void viewBookings() {}

  public void cancelBookings() {}

  public void createIssue() {}
}
