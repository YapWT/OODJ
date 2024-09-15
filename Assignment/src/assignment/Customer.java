package assignment;

public class Customer extends User {
  public Customer() {}

  public void register(String name, String password, String contact) {
    this.setUid(Utils.generateID("C"));
    this.setUpass(password);
    this.setUname(name);
    this.setUtype("C");
    this.setUcontact(contact);
    this.setUstatus("pending");
    
    System.out.println(String.format("\n%s,%s,%s,%s,%s,%s", 
                    this.getUid(), 
                    this.getUpass(), 
                    this.getUname(), 
                    this.getUtype(), 
                    this.getUcontact(), 
                    this.getUstatus()));
    
    new zWriteFile()
        .write(
            "users.txt",
            String.format("%s,%s,%s,%s,%s,%s", 
                    this.getUid(), 
                    this.getUpass(), 
                    this.getUname(), 
                    this.getUtype(), 
                    this.getUcontact(), 
                    this.getUstatus()),
            true);
  }

  public void viewAvailableHalls() {}

  public void bookHalls() {}

  public void viewBookings() {}

  public void cancelBookings() {}

  public void createIssue() {}
}
