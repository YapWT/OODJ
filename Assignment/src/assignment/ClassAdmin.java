package assignment;

import java.util.*;

interface ClassAdmin {
    String getUid();
    String getUpass();
    String getUname();
    String getUtype();
    String getUcontact();
    String getUstatus();
    
    void addUser(String name, String type);
}

class UserMangement implements ClassAdmin{
    private String Uid;
    private String Upass;
    private String Uname;
    private String Utype;
    private String Ucontact;
    private String Ustatus; // active, blocked, deactived, pending

    @Override
    public String getUid() {
        return Uid;
    }

    @Override
    public String getUpass() {
        return Upass;
    }

    @Override
    public String getUname() {
        return Uname;
    }

    @Override
    public String getUtype() {
        return Utype;
    }

    @Override
    public String getUcontact() {
        return Ucontact;
    }

    @Override
    public String getUstatus() {
        return Ustatus;
    }
    
    // S - scheduler, C - customer, A - admin, M - manager
    @Override
    public void addUser(String name, String type) {
        this.Uid = new IDGenerator(type.substring(0, 1)).GetID();
        this.Upass = "123";
        this.Uname = name;
        this.Utype = type.substring(0, 1);
        this.Ucontact = "";
        this.Ustatus = "pending";
        
        new zWriteFile().write("users.txt", String.format("\n%s,%s,%s,%s,%s,%s", Uid, Upass, Uname, Utype, Ucontact, Ustatus), true);
    }

}

class IDGenerator extends UserMangement {
    private String type;
    private int count;
    
    protected IDGenerator(String type){
        this.type = type;
        count = loadCounter("users.txt", type);
    }
    
    private int loadCounter(String filename, String t){
        List<String> type = new zReadFile("users.txt").getSplit3();
        return Collections.frequency(type, t);
    }
    
    public String GetID(){      
        return String.format("%s%d%03d", type, 160, count + 1);
    }
}
