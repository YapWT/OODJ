package assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Schedule {
  private LocalDate scheduleDate;
  private String hallID;
  private String[] timeSlot;

  public Schedule() {}

  public Schedule(LocalDate date, String hallID) {
    this.scheduleDate = date;
    this.hallID = hallID;
  }

  public Schedule(LocalDate date, String hallID, String[] timeSlot) {
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

  public String[] getTimeSlot() {
    return timeSlot;
  }

  public void setScheduleDate(LocalDate scheduleDate) {
    this.scheduleDate = scheduleDate;
  }

  public void setHallID(String hallID) {
    this.hallID = hallID;
  }

  public void setTimeSlot(String[] timeSlot) {
    this.timeSlot = timeSlot;
  }

  @Override
  public String toString() {
    return String.format(
        "%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s",
        this.scheduleDate.toString(),
        this.hallID,
        this.timeSlot[0],
        this.timeSlot[1],
        this.timeSlot[2],
        this.timeSlot[3],
        this.timeSlot[4],
        this.timeSlot[5],
        this.timeSlot[6],
        this.timeSlot[7],
        this.timeSlot[8],
        this.timeSlot[9]);
  }

  public static boolean checkIfScheduleExists(LocalDate scheduleDate, String hallID) {
    ArrayList<Schedule> schedules = FileOperations.read("schedules.txt");
    for (Schedule schedule : schedules) {
      if (schedule.getScheduleDate() == scheduleDate && schedule.getHallID() == hallID) {
        return true;
      }
    }
    return false;
  }

  public static Schedule scheduleObjectify(LocalDate scheduleDate, String hallID) {
    ArrayList<Schedule> schedules = FileOperations.read("schedules.txt");
    for (Schedule schedule : schedules) {
      if (schedule.getScheduleDate() == scheduleDate && schedule.getHallID() == hallID) {
        return schedule;
      }
    }
    return null;
  }

  public static void displaySchedule(JTable t) {
    DefaultTableModel model = (DefaultTableModel) t.getModel();
    model.setRowCount(0);
  }
}
