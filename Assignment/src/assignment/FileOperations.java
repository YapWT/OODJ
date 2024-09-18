package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileOperations {
  private static ArrayList<User> users = new ArrayList<>();

  public static ArrayList<User> readUsers() {
    try (BufferedReader rd = new BufferedReader(new FileReader("users.txt"))) {
      String line;
      while ((line = rd.readLine()) != null) {
        ArrayList<String> data = new ArrayList<>(Arrays.asList(line.split(",")));
        users.add(
            new User(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5)));
      }
    } catch (FileNotFoundException e) {

    } catch (IOException e2) {
      System.out.println("Error when reading a file. ");
    }
    return users;
  }

  public static void writeUsers(User user) {
    try (BufferedWriter w = new BufferedWriter(new FileWriter("users.txt", true))) {
      w.write(user.toString() + "\n");
    } catch (IOException e2) {
      System.out.println("Error when writing a file. ");
    }
  }

  public static void writeUsers(ArrayList<User> users) {
    try (BufferedWriter w = new BufferedWriter(new FileWriter("users.txt", false))) {
      for (User user : users) {
        w.write(user.toString() + "\n");
      }
    } catch (IOException e) {
      System.out.println("Error when writing a file. ");
    }
  }
}
