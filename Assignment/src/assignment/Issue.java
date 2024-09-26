/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

public class Issue {

  private String issueID;
  private String booking;
  private String description;
  private String response;
  private String status;
  private String assignedStaff;

  public Issue() {
    this.issueID = "null";
  }

  public Issue(
      String issueID,
      String booking,
      String description,
      String response,
      String status,
      String assignedStaff) {
    this.issueID = issueID;
    this.booking = booking;
    this.description = description;
    this.response = response;
    this.status = status;
    this.assignedStaff = assignedStaff;
  }

    public void setIssueID(String issueID) {
        this.issueID = issueID;
        Issue data = Utils.IDtoObject(issueID, "issues.txt", Issue.class);

        if (!(data == null)) {
            this.booking = data.getBooking();
            this.description = data.getDescription();
            this.response = data.getResponse();
            this.status = data.getStatus();
            this.assignedStaff = data.getAssignedStaff();
        }
    }

    public String getAssignedStaff() {
        return assignedStaff;
    }

  public void setAssignedStaff(String assignedStaff) {
    this.assignedStaff = assignedStaff;
  }

  public String getIssueID() {
    if (issueID == null || issueID.equals("null")) {
      return "null";
    }
    return issueID;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public String getBooking() {
    return booking;
  }

  public void setBooking(String booking) {
    this.booking = booking;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return String.format(
        "%s|%s|%s|%s|%s|%s", issueID, booking, description, response, status, assignedStaff);
  }
}
