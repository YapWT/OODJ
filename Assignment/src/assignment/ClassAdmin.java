package assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ClassAdmin {
    protected void writeFile(String filename, String data){
        try (BufferedWriter w = new BufferedWriter(new FileWriter(filename, true))) {    
            w.write(data);
        } catch (IOException e2){
            System.out.println("Error when adding a new user. ");
        }
    }
}

class UserMangement extends ClassAdmin{
    private String Uid;
    private String Upass;
    private String Uname;
    private String Utype;
    private String Ustatus; // active, blocked, deactived, pending
    
    private ConcurrentHashMap<String, AtomicInteger> count = new ConcurrentHashMap<>();

    // S - scheduler, C - customer, A - admin, M - manager
    public String generateID(String type) {
       
        count.putIfAbsent(type, new AtomicInteger(0));
        int i = count.get(type).incrementAndGet();
        
        return String.format("%s%d%03d", type, 160, i);
    }
    
    public void addUser(String name, String type) {
        this.Uid = generateID(type);
        this.Upass = "123";
        this.Uname = name;
        this.Utype = type;
        this.Ustatus = "pending";
        writeFile("users.txt", String.format("%s,%s,%s,%s,%s", Uid, Upass, Uname, Utype, Ustatus));
    }
    
    @Override
    protected void writeFile(String filename, String data){
        try (BufferedWriter w = new BufferedWriter(new FileWriter(filename, true))) {
            w.write("\n" + data);
        } catch (IOException e2){
            System.out.println("Error when adding a new user. ");
        }
    }
    
    
    
}
