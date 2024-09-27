package assignment;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Manager extends Staff {
  
  public void showScheduler(JComboBox cb) {
      ArrayList<User> object = FileOperations.read("users.txt", User.class);
      for (User obj : object) {
          if (obj.getUtype().equals("S") && obj.getUstatus().equals("active")){
              cb.addItem(obj.getUid()); // get scheduler id that is active
          }
      }
  }
  
  public void showTotalEarnings(JLabel lbl) {
      ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);
      Integer sales = 0;
      
      for (Booking b : bookings) {
          if (b.getBookingStatus().equals("success"))
            sales += b.getTotalPrice();
      }
      
      lbl.setText("RM" + sales.toString());
  }
  
  public void showTotalIssueInProgress(JLabel lbl) {
      ArrayList<Issue> issues = FileOperations.read("issues.txt", Issue.class);
      Integer total = 0;
      
      for (Issue i : issues) {
          if (i.getStatus().equalsIgnoreCase("In Progress")) {
              total++;
          }
      }
      
      lbl.setText(total.toString());

  }
  
  public void showTotalIssuePending(JLabel lbl) {
      ArrayList<Issue> issues = FileOperations.read("issues.txt", Issue.class);
      Integer total = 0;

      for (Issue i : issues) {
          if (i.getStatus().equalsIgnoreCase("Pending") || i.getStatus().isEmpty()) {
              total++;
          }
      }

      lbl.setText(total.toString());

  }
  
  public void showTotalIssuePendingResponse(JLabel lbl) {
      ArrayList<Issue> issues = FileOperations.read("issues.txt", Issue.class);
      Integer total = 0;

      for (Issue i : issues) {
          String response = i.getResponse().trim(); // Trim whitespace to avoid inconsistencies

          if (response.isEmpty() || response.equals("null")) { // Check both empty and "null"
              if (!i.getStatus().equalsIgnoreCase("Cancelled")) {
                  total++;
              }
          }
      }

      lbl.setText(total.toString());

  }
  
  
}
