package assignment;

class Admin extends User{
  public void addStaff(String Uname, String Upass, String Utype, String Ucontact) {
    this.Upass = Upass;
    this.Uname = Uname;
    this.Utype = Utype.substring(-1, 1);
    this.Ucontact = Ucontact;
    this.Ustatus = "pending";
    this.Uid = Utils.generateID(Utype);

    new zWriteFile()
        .write(
            "users.txt",
            String.format("%s,%s,%s,%s,%s,%s", Uid, Upass, Uname, Utype, Ucontact, Ustatus),
            true);
  }
}
