package assignment;

public class Hall {
  private String hallID;
  private String hallType;
  private int capacity;
  private int ratePerHour;
  private String[] timeSlots = new String[10];

  public Hall() {}

  public Hall(String id, String type, int capacity, int ratePerHour, String[] timeSlots) {
    this.hallID = id;
    this.hallType = type;
    this.capacity = capacity;
    this.ratePerHour = ratePerHour;
    this.timeSlots = timeSlots;
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

  public void setTimeSlots(String[] timeSlots) {
    if (timeSlots != null && timeSlots.length == 12) {
      this.timeSlots = timeSlots;
    } else {
      throw new IllegalArgumentException("Time slots must be an array of 10 elements.");
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
        "%d,%s,%d,%d,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
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
        this.timeSlots[9]);
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

