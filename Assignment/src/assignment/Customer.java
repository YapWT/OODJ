package assignment;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Customer extends User {
  public Customer() {}

  public void register(String name, String password, String contact) {
    this.setUid(Utils.generateID("C"));
    this.setUpass(password);
    this.setUname(name);
    this.setUtype("C");
    this.setUcontact(contact);
    this.setUstatus("active");

    FileOperations.write("users.txt", this);
  }

  public ArrayList<Hall> viewAvailableHalls() throws IOException {
    ArrayList<Hall> halls = FileOperations.read("halls.txt");
    // this is retarded

    return null;
  }

  public void bookHalls(String hallID, int[] timeSlots, LocalDate date) throws IOException {
    if (timeSlots.length > 2) {
      throw new IllegalArgumentException("Timeslots only accept an array of length 2");
    }

    ArrayList<Hall> halls = FileOperations.read("halls.txt");
    int amount = 0;

    for (Hall hall : halls) {
      if (hall.getHallID() == hallID) {
        for (int i = timeSlots[0]; i < timeSlots[1]; i++) {}

        amount = hall.getRatePerHour() * (timeSlots[1] - timeSlots[0]);
        break;
      } else {
        throw new IllegalArgumentException("Invalid hall number");
      }
    }

    Payment payment = new Payment(Utils.generateID("payment"), this.getUid(), amount, "success");
    FileOperations.write("payments.txt", payment);

    Booking booking =
        new Booking(
            Utils.generateID("booking"), hallID, this, timeSlots, amount, "success", payment);
    FileOperations.write("bookings.txt", booking);

    Schedule schedule = new Schedule(date, hallID, timeSlots);
    FileOperations.write("schedules.txt", schedule);
  }

  public void viewBookings() {}

  public void cancelBookings() {}

  public void createIssue() {}
}
