package assignment;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ClassAdmin {
    public class UserMangement extends ClassAdmin{
        private String Uid;
        private String Upass;
        private String Uname;
        private String Utype;
        
        public UserMangement() {}

        public UserMangement(String Uid, String Upass, String Uname, String Utype) {
            this.Uid = Uid;
            this.Upass = Upass;
            this.Uname = Uname;
            this.Utype = Utype;
        }
        
        // S - scheduler, C - customer, A - admin, M - manager
        public String generateID(String Type){
            AtomicInteger count = new AtomicInteger(0);

            int i = count.incrementAndGet();
            
            return String.format("%s%d%03d", Type, 160, i);
        }
        
        public String addUser(){
            
            return "Added!";
        }
    }
}
