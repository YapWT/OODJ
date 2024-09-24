package assignment;

import java.io.*;
import java.util.*;
import javax.swing.*;

interface initialize {
  abstract String checkFile();
}

interface login_logout {
  String login();

  void logout(JPanel p);
}

interface profile {
  boolean updateName(String Uname);

  String updatePass(String Upass, String newPass);

  boolean updateC(String Ucontact);
}

public class User implements initialize, login_logout, profile {
  private String Uid;
  private String Upass;
  private String Uname;
  private String Utype;
  private String Ucontact;
  private String Ustatus; // active, blocked, deactived, pending, deleted

  public User() {}

public User(String id, String pass, String name, String type, String contact, String status) {
    this.Uid = id;
    this.Upass = pass;
    this.Uname = name;
    this.Utype = type;
    this.Ucontact = contact;
    this.Ustatus = status;
  }
  
  public String checkFile() {
    try (BufferedReader rd = new BufferedReader(new FileReader("users.txt"))) {
      return null;
    } catch (FileNotFoundException e) {
      this.Upass = "123";
      this.Uname = "First Admin";
      this.Utype = "A";
      this.Ucontact = "";
      this.Ustatus = "pending";
      this.Uid = Utils.generateID("A");

      FileOperations.write("users.txt", this);

      return String.format("ID: %s\nPassword: %s", Uid, Upass);

    } catch (IOException e) {
      System.out.println("Error Found in reader file");
      return null;
    }
  }

    public String login() {
        User data = Utils.IDtoObject(Uid, "users.txt", User.class);

        if (data != null) {
            if (data.getUid().equals(Uid) && data.getUpass().equals(Upass)) {
              this.Utype = data.getUtype();
              this.Ustatus = data.getUstatus();

              switch (Ustatus) {
                case "active":
                    return "Login";
                case "blocked":
                    return "block";
                case "pending":
                    setUstatus("active");
                    Utils.editFile("users.txt", this, User.class);
                    return "pending";
                case "deleted":
                    return "Failed";
                default:
                    return "deactivate";
                }
            }
        }
        return "Failed";
      }
    

  public void logout(JPanel p) {
    ((JFrame) SwingUtilities.getWindowAncestor(p)).dispose();
    new uiLogin().setVisible(true);
  }

  public boolean updateName(String Uname) {
    if (Uname.isEmpty() | Uname == null) return false;

        System.out.println(Uname);
        this.Uname = Uname;
        setUname(Uname);
        System.out.println(this);
        Utils.editFile("users.txt", this, User.class);
        System.out.println(this.Uname);
        return true;
    }

    public String updatePass(String Upass, String newPass) {
        if (!Upass.equals(this.Upass)) return "Incorrect";
        else if (Upass.equals(newPass)) return "Same";
        else {
            setUpass(newPass);
            Utils.editFile("users.txt", this, User.class);
        }

    this.Upass = newPass;
    return "Done";
  }

  public boolean updateC(String Ucontact) {
    if (Ucontact == null | Ucontact.isEmpty()) return false;

         if (Utils.checkContact(Ucontact)) {
             setUcontact(Ucontact);
             Utils.editFile("users.txt", this, User.class);
         }
         else return false;

    this.Ucontact = Ucontact;
    return true;
  }

  public String getUid() {
    return Uid;
  }

  public String getUname() {
    return Uname;
  }

  public String getUpass() {
    return Upass;
  }

  public String getUtype() {
    return Utype;
  }

  public String getUstatus() {
    return Ustatus;
  }

  public String getUcontact() {
    return Ucontact;
  }

  public void setUid(String Uid) {
    this.Uid = Uid;
    User data = Utils.IDtoObject(Uid, "users.txt", User.class);

    if (!(data == null)) {
      this.Upass = data.getUpass();
      this.Uname = data.getUname();
      this.Utype = data.getUtype();
      this.Ustatus = data.getUstatus();
      this.Ucontact = data.getUcontact();
    }
  }

  public void setUname(String Uname) {
    this.Uname = Uname;
  }

  public void setUpass(String Upass) {
    this.Upass = Upass;
  }

  public void setUtype(String Utype) {
    this.Utype = Utype;
  }

  public void setUstatus(String Ustatus) {
    this.Ustatus = Ustatus;
  }

  public void setUcontact(String Ucontact) {
    this.Ucontact = Ucontact;
  }

  public String toString() {
    return String.format(
        "%s|%s|%s|%s|%s|%s",
        this.Uid, this.Upass, this.Uname, this.Utype, this.Ucontact, this.Ustatus);
  }
}
