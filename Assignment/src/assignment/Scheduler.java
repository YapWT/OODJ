package assignment;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Scheduler extends Staff {
  public Scheduler() {}
  private String data;
  private String hallID;

  public void addHall(String hallType) {
      switch(hallType){
          case "Auditorium":
          {
            hallID = Utils.generateID("H");
            Auditorium audi = new Auditorium();
            audi.setHallID(hallID);
            audi.setHallStatus("Active");
            data = audi.getHallID()+", "+audi.getHallType()+", "+audi.getHallStatus();;
          }
          case "Banquet Hall":
          {
            hallID = Utils.generateID("H");
            Banquet banquet = new Banquet();
            banquet.setHallID(hallID);
            banquet.setHallStatus("Active");
            data = banquet.getHallID()+", "+banquet.getHallType()+", "+banquet.getHallStatus();
          }
          case "Meeting Room":
          {
            hallID = Utils.generateID("H");
            MeetingRoom meetingRoom = new MeetingRoom();
            meetingRoom.setHallID(hallID);
            meetingRoom.setHallStatus("Active");
            data = meetingRoom.getHallID()+", "+meetingRoom.getHallType()+", "+meetingRoom.getHallStatus();
          }
        }
        FileOperations.write("halls.txt", data);      
  }
    
  public void editHall() {}

  public void deleteHall() {}

  public void setHallAvailability() {}

  public void setMaintenanceSchedule() {}
}
