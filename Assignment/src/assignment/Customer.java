package assignment;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Customer extends User {
  public Customer() {}

  public Customer(String id, String pass, String name, String type, String contact, String status) {
    this.setUid(id);
    this.setUpass(pass);
    this.setUname(name);
    this.setUtype(type);
    this.setUcontact(contact);
    this.setUstatus(status);
  }

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
    ArrayList<Hall> halls = FileOperations.read("halls.txt", Hall.class);
    // this is retarded

    return null;
  }

  public void bookHalls(String hallID, int[] timeSlots, LocalDate date) {
    if (timeSlots.length > 2) {
      throw new IllegalArgumentException("Timeslots only accept an array of length 2");
    }

    ArrayList<Hall> halls = FileOperations.read("halls.txt", Hall.class);
    int amount = 0;

    for (Hall hall : halls) {
      if (hall.getHallID().equals(hallID)) {
        amount = hall.getRatePerHour() * (timeSlots[1] - timeSlots[0]);
        break;
      } else {
        throw new IllegalArgumentException("Invalid hall number");
      }
    }

    Schedule schedule = null;
    String[] timeSlot = null;

    if (Schedule.checkIfScheduleExists(date, hallID)) {
      schedule = Schedule.scheduleObjectify(date, hallID);
      timeSlot = schedule.getTimeSlot();
      for (int i = timeSlots[0] - 1; i < timeSlots[1] - 1; i++) {
        if (timeSlot[i].equals("booked")) {
          throw new IllegalArgumentException("Invalid choice, conflicted timeSlot");
        }
      }
      for (int i = timeSlots[0] - 1; i < timeSlots[1] - 1; i++) {
        timeSlot[i] = "booked";
      }
      schedule.setTimeSlot(timeSlot);

    } else {
      schedule.setScheduleDate(date);
      schedule.setHallID(hallID);
      String[] scheduleSlots = new String[10];
      Arrays.fill(scheduleSlots, "available");
    }

    Booking booking =
        new Booking(Utils.generateID("B"), hallID, this, timeSlots, amount, "success", date);
    FileOperations.write("bookings.txt", booking);

    Schedule.overwriteOldSchedule(schedule);
  }

  public void viewBookings() {}

  public void cancelBookings() {}

  public void createIssue() {}
}
