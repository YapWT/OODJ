package assignment;

class Admin extends Staff{
    public Admin() {}
    
    public void addStaff(String Uname, String Upass, String Utype, String Ucontact) {
        this.setUpass(Upass);
        this.setUname(Uname);
        this.setUtype(Utype.substring(0, 1));
        this.setUcontact(Ucontact);
        this.setUstatus("pending");
        this.setUid(Utils.generateID(getUtype()));

        FileOperations.write("users.txt", this);
  }
}
