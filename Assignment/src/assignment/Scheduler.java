package assignment;


public class Scheduler extends Staff {
  public Scheduler() {}
  private String data;
  private String hallID;
  
  public void addHall(String hallType) {
      Utils utils = new Utils();
      FileOperations files = new FileOperations();
      switch(hallType){
          case "Auditorium":
          {
            hallID = utils.generateID("H");
            Auditorium audi = new Auditorium();
            audi.setHallID(hallID);
            audi.setHallStatus("Active");
            data = audi.getHallID()+", "+audi.getHallType()+", "+audi.getHallStatus();;
          }
          case "Banquet Hall":
          {
            hallID = utils.generateID("H");
            Banquet banquet = new Banquet();
            banquet.setHallID(hallID);
            banquet.setHallStatus("Active");
            data = banquet.getHallID()+", "+banquet.getHallType()+", "+banquet.getHallStatus();
          }
          case "Meeting Room":
          {
            hallID = utils.generateID("H");
            MeetingRoom meetingRoom = new MeetingRoom();
            meetingRoom.setHallID(hallID);
            meetingRoom.setHallStatus("Active");
            data = meetingRoom.getHallID()+", "+meetingRoom.getHallType()+", "+meetingRoom.getHallStatus();
          }
        }
        files.write("halls.txt", data);      
  }

  public void editHall() {}

  public void deleteHall() {}

  public void setHallAvailability() {}

  public void setMaintenanceSchedule() {}
}
