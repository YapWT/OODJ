package assignment;

import java.io.IOException;

public class Scheduler extends Staff {
  public Scheduler() {}

  private String data;
  private String hallID;
  private String HallStatus;
  private String HallType;

  public String addHall(int hallType) {
    data = null;
    hallID = Utils.generateID("H");
    HallStatus = "Active";
    switch (hallType) {
      case 0:
        {
          Auditorium audi = new Auditorium();
          audi.setHallID(hallID);
          audi.setHallStatus(HallStatus);
          data = audi.getHallID() + "|" + audi.getHallType() + "|" + audi.getHallStatus();
          break;
        }
      case 1:
        {
          Banquet banquet = new Banquet();
          banquet.setHallID(hallID);
          banquet.setHallStatus(HallStatus);
          data = banquet.getHallID() + "|" + banquet.getHallType() + "|" + banquet.getHallStatus();
          break;
        }
      case 2:
        {
          MeetingRoom meetingRoom = new MeetingRoom();
          meetingRoom.setHallID(hallID);
          meetingRoom.setHallStatus(HallStatus);
          data =
              meetingRoom.getHallID()
                  + "|"
                  + meetingRoom.getHallType()
                  + "|"
                  + meetingRoom.getHallStatus();
        }
        break;
    }
    FileOperations.write("halls.txt", data);
    return ("Hall Added");
  }

  public void editHall(String HallID, int hallType, int hallStatus) throws IOException {
    HallType = null;
    switch (hallType) {
      case 0:
        {
          HallType = "auditorium";
          break;
        }
      case 1:
        {
          HallType = "banquet";
          break;
        }
      case 2:
        {
          HallType = "meeting";
          break;
        }
    }
    switch (hallStatus) {
      case 0:
        {
          HallStatus = "Active";
          break;
        }
      case 1:
        {
          HallStatus = "Inactive";
          break;
        }
    }
    data = HallID + "|" + HallType + "|" + HallStatus;
    FileOperations.overwrite("halls.txt", HallID, data);
  }
}
