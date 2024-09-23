package assignment;

import java.time.LocalDate;

public class Schedule {
  private LocalDate scheduleDate;
  private String hallID;
  private int[] timeSlot;

  public Schedule() {}

  public Schedule(LocalDate date, String hallID, int[] timeSlot) {
    this.scheduleDate = date;
    this.hallID = hallID;
    this.timeSlot = timeSlot;
  }

  public LocalDate getScheduleDate() {
    return scheduleDate;
  }

  public String getHallID() {
    return hallID;
  }

  public int[] getTimeSlot() {
    return timeSlot;
  }

  public void setScheduleDate(LocalDate scheduleDate) {
    this.scheduleDate = scheduleDate;
  }

  public void setHallID(String hallID) {
    this.hallID = hallID;
  }

  public void setTimeSlot(int[] timeSlot) {
    this.timeSlot = timeSlot;
  }

  @Override
  public String toString() {
    return String.format(
        "%s,%s,%d,%d",
        this.scheduleDate.toString(), this.hallID, this.timeSlot[0], this.timeSlot[1]);
  }
}
