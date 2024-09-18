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
