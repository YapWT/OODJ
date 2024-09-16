package assignment;

class Admin extends User{
    public void addStaff(String Uname, String Upass, String Utype, String Ucontact) {
        super.addUser(Uname, Upass, Utype, Ucontact);
    }
}
