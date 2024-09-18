package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileOperations {
  private static ArrayList<User> users;

  public static ArrayList<User> readUsers() {
    try (BufferedReader rd = new BufferedReader(new FileReader("users.txt"))) {
      String line;
      while ((line = rd.readLine()) != null) {
        ArrayList<String> data = new ArrayList<>(Arrays.asList(line.split(",")));
        users.add(
            new User(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5)));
      }
      return users;
    } catch (FileNotFoundException e) {

    } catch (IOException e2) {
      System.out.println("Error when reading a file. ");
    }
  }
}
