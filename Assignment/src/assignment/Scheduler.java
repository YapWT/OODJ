package assignment;


public class Scheduler extends Staff {
  public Scheduler() {}
  private String data;
  private String hallID;
  
  public void addHall(int hallType) {
      Utils utils = new Utils();
      FileOperations files = new FileOperations();
      if(hallType==0)
      {
          hallID = utils.generateID("H");
          Auditorium audi = new Auditorium();
          audi.setHallID(hallID);
          audi.setHallStatus("Active");
          data = audi.getHallID()+", "+audi.getHallType()+", "+audi.getCapacity()+", "+audi.getRatePerHour()+", "+audi.getHallStatus();
          files.write("halls.txt", data);
      }
  }

  public void editHall() {}

  public void deleteHall() {}

  public void setHallAvailability() {}

  public void setMaintenanceSchedule() {}
}
