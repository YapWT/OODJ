package assignment;

public class Hall {
  private String hallID;
  private String hallType;
  private int capacity;
  private int ratePerHour;
  private String hallStatus;

  public Hall() {}

  public Hall(String id, String type, String hallStatus) {
    this.hallID = id;
    this.hallType = type;
    this.hallStatus = hallStatus;

    switch (type) {
      case "banquet":
        this.capacity = 300;
        this.ratePerHour = 100;
        break;
      case "auditorium":
        this.capacity = 1000;
        this.ratePerHour = 300;
        break;
      case "meeting":
        this.capacity = 30;
        this.ratePerHour = 50;
        break;
    }
  }

  public String getHallStatus() {
    return hallStatus;
  }

  public void setHallStatus(String hallStatus) {
    this.hallStatus = hallStatus;
  }

  public String getHallID() {
    return hallID;
  }

  public String getHallType() {
    return hallType;
  }

  public int getCapacity() {
    return capacity;
  }

  public int getRatePerHour() {
    return ratePerHour;
  }

  public void setHallID(String hallID) {
    this.hallID = hallID;
  }

  public void setHallType(String hallType) {
    this.hallType = hallType;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public void setRatePerHour(int ratePerHour) {
    this.ratePerHour = ratePerHour;
  }
}

class Auditorium extends Hall {

  public Auditorium() {
    super();
    setHallType("auditorium");
    setCapacity(1000);
    setRatePerHour(300);
  }
}

class Banquet extends Hall {

  public Banquet() {
    super();
    setHallType("banquet");
    setCapacity(300);
    setRatePerHour(100);
  }
}

class MeetingRoom extends Hall {

  public MeetingRoom() {
    super();
    setHallType("meeting");
    setCapacity(30);
    setRatePerHour(50);
  }
}
