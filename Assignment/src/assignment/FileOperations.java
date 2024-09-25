package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unchecked")
public class FileOperations {
  public static <T> ArrayList<T> read(String filename, Class<T> runtimeClass) {
    ArrayList<T> result = new ArrayList<>();

    try (BufferedReader rd = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = rd.readLine()) != null) {
        ArrayList<String> data = new ArrayList<>(Arrays.asList(line.split("\\|")));
        String id = data.get(0);

        if (runtimeClass == User.class) {
          result.add(
              (T)
                  new User(
                      data.get(0),
                      data.get(1),
                      data.get(2),
                      data.get(3),
                      data.get(4),
                      data.get(5)));

        } else if (User.class.isAssignableFrom(runtimeClass)) {
          if (id.startsWith("C")) {
            result.add(
                runtimeClass.cast(
                    new Customer(
                        data.get(0),
                        data.get(1),
                        data.get(2),
                        data.get(3),
                        data.get(4),
                        data.get(5))));
          }
        } else if (runtimeClass == Hall.class) {
          result.add((T) new Hall(data.get(0), data.get(1), data.get(2)));
        } else if (runtimeClass == Booking.class) {
          int[] timeSlots =
              new int[] {Integer.parseInt(data.get(3)), Integer.parseInt(data.get(4))};
          result.add(
              (T)
                  new Booking(
                      data.get(0),
                      data.get(1),
                      data.get(2),
                      timeSlots,
                      Integer.parseInt(data.get(5)),
                      data.get(6),
                      LocalDate.parse(data.get(7)),
                      data.get(8)));
        } else if (runtimeClass == Schedule.class) {
          String[] timeSlots =
              new String[] {
                data.get(2),
                data.get(3),
                data.get(4),
                data.get(5),
                data.get(6),
                data.get(7),
                data.get(8),
                data.get(9),
                data.get(10),
                data.get(11)
              };
          result.add((T) new Schedule(LocalDate.parse(data.get(0)), data.get(1), timeSlots));
        } else if (runtimeClass == Issue.class) {
              String issueID = data.size() > 0 ? data.get(0) : "";
              String bookingID = data.size() > 1 ? data.get(1) : "";
              String description = data.size() > 2 ? data.get(2) : "";  
              String response = data.size() > 3 ? data.get(3) : "";     
              String status = data.size() > 4 ? data.get(4) : "";       
              String assignedStaff = data.size() > 5 ? data.get(5) : "";

              if (runtimeClass == Issue.class) {
                  result.add((T) new Issue(issueID, bookingID, description, response, status, assignedStaff));
              }
        }
      }
      
    } catch (FileNotFoundException e) {
      if (filename.contains("schedules")) {
        result.add((T) new Schedule());
        return result;
      }
    } catch (IOException e) {
      System.out.println("Error when reading " + filename + ".\n " + e);
    }
    return result;
  }

  public static <T> void write(String filename, T data) {
    try (BufferedWriter w = new BufferedWriter(new FileWriter(filename, true))) {
      w.write(data.toString() + "\n");
    } catch (IOException e) {
      System.out.println("Error when writting to " + filename + "\n" + e);
    }
  }

  public static <T> void write(String filename, ArrayList<T> data) {
    try (BufferedWriter w = new BufferedWriter(new FileWriter(filename, false))) {
      for (T datapoint : data) {
        w.write(datapoint.toString() + "\n");
      }
    } catch (IOException e) {
      System.out.println("Error when writting to " + filename + "\n" + e);
    }
  }
}
