package assignment;

public class Scheduler extends Staff {
  public Scheduler() {}

  private String data;
  private String hallID;

  public String addHall(int hallType) {
    data = null;
    hallID = Utils.generateID("H");
    System.out.println(hallType);
    switch (hallType) {
      case 0:
        {
          Auditorium audi = new Auditorium();
          audi.setHallID(hallID);
          audi.setHallStatus("Active");
          data = audi.getHallID() + "," + audi.getHallType() + "," + audi.getHallStatus();
          break;
        }
      case 1:
        {
          Banquet banquet = new Banquet();
          banquet.setHallID(hallID);
          banquet.setHallStatus("Active");
          data = banquet.getHallID() + "," + banquet.getHallType() + "," + banquet.getHallStatus();
          break;
        }
      case 2:
        {
          MeetingRoom meetingRoom = new MeetingRoom();
          meetingRoom.setHallID(hallID);
          meetingRoom.setHallStatus("Active");
          data =
              meetingRoom.getHallID()
                  + ","
                  + meetingRoom.getHallType()
                  + ","
                  + meetingRoom.getHallStatus();
        }
        break;
    }
    FileOperations.write("halls.txt", data);
    return ("Hall Added");
  }

  public void editHall() {}

  public void deleteHall() {}

  public void setHallAvailability() {}

  public void setMaintenanceSchedule() {}
}
