package assignment;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;

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
  
  public void showTotalEarnings(JLabel lbl) {
      ArrayList<Booking> bookings = FileOperations.read("Bookings.txt", Booking.class);
      Integer sales = 0;
      
      for (Booking b : bookings) {
          sales += b.getTotalPrice();
      }
      
      lbl.setText("RM" + sales.toString());
  }
  
  public void showTotalIssueInProgress(JLabel lbl) {
      ArrayList<Issue> issues = FileOperations.read("issues.txt", Issue.class);
      Integer total = 0;
      
      for (Issue i : issues) {
          if (i.getStatus().equals("In Progress")) {
              total++;
          }
      }
      
      lbl.setText(total.toString());

  }
  
  
}
