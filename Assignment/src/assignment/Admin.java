package assignment;

class Admin{
    private String Uid;
    private String Upass;
    private String Uname;
    private String Utype;
    private String Ucontact;
    private String Ustatus; // active, blocked, deactived, pending

    // S - scheduler, C - customer, A - admin, M - manager

    public void addStaff(String name, String type) {
        this.Upass = "123";
        this.Uname = name;
        this.Utype = type.substring(0, 1);
        this.Ucontact = "";
        this.Ustatus = "pending";
        this.Uid = new Utils().generateID(Utype);
        
//        new zWriteFile().write("users.txt", String.format("\n%s,%s,%s,%s,%s,%s", Uid, Upass, Uname, type, Ucontact, Ustatus), true);
        System.out.print(String.format("\n%s,%s,%s,%s,%s,%s", Uid, Upass, Uname, type, Ucontact, Ustatus));
    } 
    

    public String getUid() {
        return Uid;
    }

    public String getUpass() {
        return Upass;
    }

    public String getUname() {
        return Uname;
    }

    public String getUtype() {
        return Utype;
    }

    public String getUcontact() {
        return Ucontact;
    }


    public String getUstatus() {
        return Ustatus;
    }
}
