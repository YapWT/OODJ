package assignment;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

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

  public void bookHalls(String hallID, int[] timeSlots, LocalDate date) {
    if (timeSlots.length > 2) {
      throw new IllegalArgumentException("Timeslots only accept an array of length 2");
    }

    ArrayList<Hall> halls = FileOperations.read("halls.txt");
    int amount = 0;

    for (Hall hall : halls) {
      if (hall.getHallID().equals(hallID)) {
        for (int i = timeSlots[0]; i < timeSlots[1]; i++) {}

        amount = hall.getRatePerHour() * (timeSlots[1] - timeSlots[0]);
        break;
      } else {
        throw new IllegalArgumentException("Invalid hall number");
      }
    }

    Booking booking =
        new Booking(Utils.generateID("booking"), hallID, this, timeSlots, amount, "success");
    FileOperations.write("bookings.txt", booking);

    String[] scheduleSlots = new String[10];
    Arrays.fill(scheduleSlots, "available");

    for (int i = timeSlots[0]; i < timeSlots[1]; i++) {
      scheduleSlots[i] = "booked";
    }

    Schedule schedule = new Schedule(date, hallID, scheduleSlots);
    FileOperations.write("schedules.txt", schedule);
  }

  public void viewBookings() {}

  public void cancelBookings() {}

  public void createIssue() {}
}
