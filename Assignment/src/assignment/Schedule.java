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
    ArrayList<Schedule> schedules = FileOperations.read("schedules.txt", Schedule.class);
    if (schedules != null && !schedules.isEmpty() && !schedules.get(0).isEmpty()) {
      System.out.println("Schedule is null");
      System.out.println(schedules.size());
      for (Schedule schedule : schedules) {
        if (schedule.getScheduleDate().toString().equals(scheduleDate.toString())
            && schedule.getHallID().equals(hallID)) {
          return true;
        }
      }
    }
    return false;
  }

  public static Schedule scheduleObjectify(LocalDate scheduleDate, String hallID) {
    ArrayList<Schedule> schedules = FileOperations.read("schedules.txt", Schedule.class);
    for (Schedule schedule : schedules) {
      if (schedule.getScheduleDate().toString().equals(scheduleDate.toString())
          && schedule.getHallID().equals(hallID)) {
        return schedule;
      }
    }
    return null;
  }

  public static void displaySchedule(JTable t, Schedule schedule) {
    DefaultTableModel model = (DefaultTableModel) t.getModel();
    String[] timeSlotList =
        new String[] {
          "8:00am-9:00am",
          "9:00am-10:00am",
          "10:00am-11:00am",
          "11:00am-12:00pm",
          "12:00pm-1:00pm",
          "1:00pm-2:00pm",
          "2:00pm-3:00pm",
          "3:00pm-4:00pm",
          "4:00pm-5:00pm",
          "5:00pm-6:00pm"
        };
    model.setRowCount(0);

    Object[] tableRow = new Object[2];

    if (schedule != null) {
      for (int i = 0; i < 10; i++) {
        tableRow[0] = timeSlotList[i];
        tableRow[1] = schedule.getTimeSlot()[i];

        model.addRow(tableRow);
      }
    }
  }

  public static void overwriteOldSchedule(Schedule newSchedule) {
    String targetDate = newSchedule.getScheduleDate().toString();
    String targetHallID = newSchedule.getHallID();

    ArrayList<Schedule> schedules = FileOperations.read("schedules.txt", Schedule.class);

    for (Schedule schedule : schedules) {
      if (targetDate.equals(schedule.getScheduleDate().toString())
          && targetHallID.equals(schedule.getHallID())) {
        schedule.setTimeSlot(newSchedule.getTimeSlot());
      }
    }

    FileOperations.write("schedules.txt", schedules);
  }

  public boolean isEmpty() {
    return hallID == null;
  }
}
