package assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class Admin extends Staff{
    private int n = 0;
    private DefaultTableModel model;
    
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
    
    public boolean modifyPass(JTable t, String row, String pass) {
        if (check(t, row)) {
            setUpass(pass);
            Utils.editFile("users.txt", this, User.class);
            model.setValueAt(pass.replaceAll(".", "*"), n - 1, 2);
            return true;
        } return false; // row is out of range or invalid data type = invalid row number
    }
    
    public void modifyStatus(boolean isCustomer) {
        if (!isCustomer) {
            if (getUstatus().equals("deactived")) setUstatus("pending"); 
            else setUstatus("deactived");         
        } else {
            if (getUstatus().equals("blocked")) setUstatus("pending");
            else setUstatus("blocked");
        }
        Utils.editFile("users.txt", this, User.class);
        model.setValueAt(getUstatus(), n - 1, 6);
    }
    
    public void modifyStatus() { 
        setUstatus("deleted");
        Utils.editFile("users.txt", this, User.class);
        
        model.removeRow(n - 1);
        reCountRow();

    }
    
    public boolean check(JTable t, String row) {
        try {
            this.n = Integer.parseInt(row);
            this.model = (DefaultTableModel) t.getModel();
            
            if (n <= model.getRowCount()) {
                String id = model.getValueAt(n - 1, 1).toString();

                User m = Utils.IDtoObject(id, "users.txt", User.class);

                if (m == null) return false; // row is out of range

                setUid(id);
                return true;
            }
            return false;

        } catch (NumberFormatException e) {
            return false; // Invalid data type
        }
    }
    
    public <T> void search(JTable t, String s) {
        ((DefaultTableModel) t.getModel()).setRowCount(0);
        ArrayList<User> objects = FileOperations.read("users.txt", User.class);
        
        for (User obj : objects) {
            User user = (User) obj;
            if (user.getUname().contains(s) && !user.getUstatus().equals("deleted"))
                Utils.addTableRow(t, User.class, user);
        }
    }
    
    public void viewBooking(JTable t) {
        ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);
        this.model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        Object[] tableRow = new Object[8];
        int i = 0;

        for (Booking bs : bookings) {
            tableRow[0] = i++;
            tableRow[1] = bs.getBookingID();
            tableRow[2] = bs.getHallID();
            tableRow[3] = bs.getCustomer().getUid();
            tableRow[4] = bs.getBookingDate();
            tableRow[5] = Booking.timeSlotConversion(bs.getTimeSlots()[0]);
            tableRow[6] = Booking.timeSlotConversion(bs.getTimeSlots()[1]);
            tableRow[7] = bs.getBookingStatus();
            model.addRow(tableRow);
        }
    }
    
    public void viewBooking(JTable t, boolean past) {
        ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);
        this.model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        Object[] tableRow = new Object[8];
        int i = 1;
        
        for (Booking bs : bookings) {
            if (past) {
                if (bs.getBookingDate().isBefore(LocalDate.now())) {
                    tableRow[0] = i++;
                    tableRow[1] = bs.getBookingID();
                    tableRow[2] = bs.getHallID();
                    tableRow[3] = bs.getCustomer().getUid();
                    tableRow[4] = bs.getBookingDate();
                    tableRow[5] = Booking.timeSlotConversion(bs.getTimeSlots()[0]);
                    tableRow[6] = Booking.timeSlotConversion(bs.getTimeSlots()[1]);
                    tableRow[7] = bs.getBookingStatus();
                    model.addRow(tableRow);
                }
            } else {
                // For upcoming bookings (today and future)
                if (bs.getBookingDate().isEqual(LocalDate.now()) || bs.getBookingDate().isAfter(LocalDate.now())) {
                    tableRow[0] = i++;
                    tableRow[1] = bs.getBookingID();
                    tableRow[2] = bs.getHallID();
                    tableRow[3] = bs.getCustomer().getUid();
                    tableRow[4] = bs.getBookingDate();
                    tableRow[5] = Booking.timeSlotConversion(bs.getTimeSlots()[0]);
                    tableRow[6] = Booking.timeSlotConversion(bs.getTimeSlots()[1]);
                    tableRow[7] = bs.getBookingStatus();
                    model.addRow(tableRow);
                }
            } 
        }
    }   
    
    public void removeCurrentAdmin(JTable t, String currentAdmin){
        this.model = (DefaultTableModel) t.getModel();
        
        for (int i = 0; i <= model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).toString().equals(currentAdmin)) {
                model.removeRow(i);
                break;
            }
        }
        reCountRow();
    }
    
    private void reCountRow() {
        for (int i = 0; i < model.getRowCount(); i++) 
            model.setValueAt(i + 1, i, 0);
    }
}