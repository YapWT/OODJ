package assignment;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Schedule {
  private LocalDate scheduleDate;
  private String hallID;
  private int[] timeSlot;

  public Schedule() {}

  public Schedule(LocalDate date, String hallID) {
    this.scheduleDate = date;
    this.hallID = hallID;
  }

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
        "%s|%s|%d|%d",
        this.scheduleDate.toString(), this.hallID, this.timeSlot[0], this.timeSlot[1]);
  }

  public Schedule checkIfScheduleExists(LocalDate scheduleDate, String hallID) {
      ArrayList<Schedule> schedules = FileOperations.read("schedules.txt");
      for (Schedule schedule : schedules) {
        if (schedule.getScheduleDate() == scheduleDate && schedule.getHallID() == hallID) {
          return schedule;
        }
      }
    return null;
  }
}
