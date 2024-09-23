package assignment;

import java.time.LocalDate;

public class Schedule {
  private String scheduleID;
  private LocalDate scheduleDate;
  private String hallID;
  private int[] timeSlot;

  public Schedule() {}

  public Schedule(String scheduleID, LocalDate date, String hallID, int[] timeSlot) {
    this.scheduleID = scheduleID;
    this.scheduleDate = date;
    this.hallID = hallID;
    this.timeSlot = timeSlot;
  }

  public String getScheduleID() {
    return scheduleID;
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

  public void setScheduleID(String scheduleID) {
    this.scheduleID = scheduleID;
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
        "%s,%s,%s,%d,%d",
        this.scheduleID,
        this.scheduleDate.toString(),
        this.hallID,
        this.timeSlot[0],
        this.timeSlot[1]);
  }
}
