package assignment;

public class Hall {
  private int hallID;
  private String hallType;
  private int capacity;
  private int ratePerHour;
  private String[] timeSlots = new String[12];

  public Hall() {}

  public Hall(int id, String type, int capacity, int ratePerHour, String[] timeSlots) {
    this.hallID = id;
    this.hallType = type;
    this.capacity = capacity;
    this.ratePerHour = ratePerHour;
    this.timeSlots = timeSlots;
  }

  public int getHallID() {
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

  public String[] getTimeSlots() {
    return timeSlots;
  }

  public String getTimeSlot(int index) {
    if (index >= 0 && index < timeSlots.length) {
      return timeSlots[index];
    } else {
      throw new IllegalArgumentException("Index out of bounds");
    }
  }

  public void setHallID(int hallID) {
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

  public void setTimeSlots(String[] timeSlots) {
    if (timeSlots != null && timeSlots.length == 12) {
      this.timeSlots = timeSlots;
    } else {
      throw new IllegalArgumentException("Time slots must be an array of 12 elements.");
    }
  }

  public void setTimeSlot(int index, String timeSlot) {
    if (index >= 0 && index < timeSlots.length) {
      this.timeSlots[index] = timeSlot;
    } else {
      throw new IllegalArgumentException("Index out of bounds");
    }
  }

  public String toString() {
    return String.format(
        "%d,%s,%d,%d,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
        this.hallID,
        this.hallType,
        this.capacity,
        this.ratePerHour,
        this.timeSlots[0],
        this.timeSlots[1],
        this.timeSlots[2],
        this.timeSlots[3],
        this.timeSlots[4],
        this.timeSlots[5],
        this.timeSlots[6],
        this.timeSlots[7],
        this.timeSlots[8],
        this.timeSlots[9],
        this.timeSlots[10],
        this.timeSlots[11]);
  } 
}

class Auditorium extends Hall{

    public Auditorium() {
    }

    public Auditorium(int id, String type, int capacity, int ratePerHour, String[] timeSlots) {
        super(id, type, capacity, ratePerHour, timeSlots);
        type = "auditorium";
        capacity = 1000;
        ratePerHour = 300;
    }
    
}

class Banquet extends Hall{

    public Banquet() {
    }

    public Banquet(int id, String type, int capacity, int ratePerHour, String[] timeSlots) {
        super(id, type, capacity, ratePerHour, timeSlots);
        type="banquet";
        capacity = 300;
        ratePerHour = 100;
    }
    
    
}

class MeetingRoom extends Hall{

    public MeetingRoom() {
    }

    public MeetingRoom(int id, String type, int capacity, int ratePerHour, String[] timeSlots) {
        super(id, type, capacity, ratePerHour, timeSlots);
        type = "meeting";
        capacity = 30;
        ratePerHour = 50;
    }
    
}
