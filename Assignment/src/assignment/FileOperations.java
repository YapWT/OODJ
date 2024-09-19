package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unchecked")
public class FileOperations {
  public static <T> ArrayList<T> read(String filename) {
    ArrayList<T> result = new ArrayList<>();

    try (BufferedReader rd = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = rd.readLine()) != null) {
        ArrayList<String> data = new ArrayList<>(Arrays.asList(line.split(",")));
        if (filename.contains("users")) {
          result.add(
              (T)
                  new User(
                      data.get(0),
                      data.get(1),
                      data.get(2),
                      data.get(3),
                      data.get(4),
                      data.get(5)));
        } else if (filename.contains("halls")) {
          String[] timeSlots = null;
          result.add(
              (T)
                  new Hall(
                      Integer.parseInt(data.get(0)),
                      data.get(1),
                      Integer.parseInt(data.get(2)),
                      Integer.parseInt(data.get(3)),
                      timeSlots));
        } else if (filename.contains("payments")) {
          result.add(
              (T)
                  new Payment(
                      data.get(0), data.get(1), Integer.parseInt(data.get(2)), data.get(3)));
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + filename);
    } catch (IOException e) {
      System.out.println("Error when reading " + filename + ".\n " + e);
    }
    return result;
  }

  public static <T> void write(String filename, T data) {
    try (BufferedWriter w = new BufferedWriter(new FileWriter(filename, true))) {
      w.write(data.toString() + "\n");
    } catch (IOException e) {
      System.out.println("Error when writting to users.txt. \n" + e);
    }
  }

  public static <T> void write(String filename, ArrayList<T> data) {
    try (BufferedWriter w = new BufferedWriter(new FileWriter(filename, false))) {
      for (T datapoint : data) {
        w.write(datapoint.toString() + "\n");
      }
    } catch (IOException e) {
      System.out.println("Error when writting to users.txt.\n " + e);
    }
  }
}
