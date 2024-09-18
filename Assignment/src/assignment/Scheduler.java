package assignment;


public class Scheduler extends Staff {
  public Scheduler() {}

  public void addHall(String hallType) {
      classHall newHall = new classHall();
      newHall.hallType = hallType;
  }

  public void editHall() {}

  public void deleteHall() {}

  public void setHallAvailability() {}

  public void setMaintenanceSchedule() {}
}
