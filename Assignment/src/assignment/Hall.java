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
}
