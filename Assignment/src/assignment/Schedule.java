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
