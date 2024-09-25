package assignment;

import java.util.ArrayList;
import javax.swing.JComboBox;

public class Manager extends Staff {
  public Manager() {}

  public void viewSalesDashboard() {}

  public void respondToIssue() {}

  public void assignTask() {}

  public void updateIssueStatus() {}
  
  
  public void showScheduler(JComboBox cb) {
      ArrayList<User> object = FileOperations.read("users.txt", User.class);
      for (User obj : object) {
          if (obj.getUtype().equals("S")){
              cb.addItem(obj.getUid()); // get scheduler id
          }
      }
  }
}
