package assignment;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class uiAdmin extends javax.swing.JFrame {
    private Admin classA;
    private String Uid;
    private boolean defaultPending = true;
    private Character RoleSelected = null;

    public uiAdmin() {
        initComponents();
    }
    
    public uiAdmin(String Uid, Admin classA) {
        initComponents();
        
        // user management
        this.classA = classA;
        this.Uid = Uid;
        jLabel6.setVisible(false);
        jLabel6.setHorizontalAlignment(JLabel.CENTER);
        
        Utils.viewTable(TBL_view, "users.txt", User.class);
        classA.removeCurrentAdmin(TBL_view, Uid);
        
        // add user
        BTN_add.addActionListener(e -> {
            jLabel6.setVisible(false);
            
            Panel_addUser PNL_add = new Panel_addUser();
            
            int option = JOptionPane.showConfirmDialog(null, PNL_add, "AddUser", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
            if (option == JOptionPane.OK_OPTION) {
                String name = PNL_add.getName();
                String type = PNL_add.getType();     
                if (type != null && name != null && !name.isEmpty()){
                    classA.addStaff(name, "123", type, "");
                    if (defaultPending || (classA.getUtype().equals(RoleSelected) || RoleSelected == null))
                        Utils.addTableRow(TBL_view, User.class, classA);
                    jLabel6.setVisible(true);
                    jLabel6.setText(name + " Added!");
                } else {
                    jLabel6.setVisible(true);
                    jLabel6.setText("There Empty Input Found. ");
                }
            } else {
                jLabel6.setVisible(true);
                jLabel6.setText("Cancel Add User Action. ");
            }
        
        });
        
        BTN_modifyPass.addActionListener (e -> {
            jLabel6.setVisible(false);
            
            JTextField row = new JTextField();
            JPasswordField pass = new JPasswordField();
            
            Object[] p = {
                "Row: ", row,
                "Enter New Password: ", pass
            };
            
            int option = JOptionPane.showConfirmDialog(null, p, "Change User's Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
            if (option == JOptionPane.OK_OPTION) {
                if (!(row.getText().isEmpty() || pass.getPassword().length == 0)) {
                    if (classA.modifyPass(TBL_view, row.getText(), new String(pass.getPassword()))) {
                        jLabel6.setVisible(true);
                        jLabel6.setText(classA.getUname() + "'s Password Change!");
                    } else {
                        jLabel6.setVisible(true);
                        jLabel6.setText("Invalid Row Number. ");
                    }
                } else {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Empty Input Found. ");
                }
            } else {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Cancel Modify User's Password Action. ");
            }
        });
        
        BTN_deactive.addActionListener (e -> {
            jLabel6.setVisible(false);
            
            JTextField row = new JTextField();
            
            int option = JOptionPane.showConfirmDialog(null, new Object[] {"Row: ", row}, "Active or Deactive Staff", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
            if (option == JOptionPane.OK_OPTION) {
                if (!(row.getText().isEmpty())) {
                    if (classA.check(TBL_view, row.getText())) {
                        if (classA.getUtype().equals("C")) {
                            jLabel6.setVisible(true);
                            jLabel6.setText("Customer are not allowed to deactive or reactive. ");
                        } else {
                            classA.modifyStatus(false);
                            jLabel6.setVisible(true);
                            if (classA.getUstatus().equals("deactived")) jLabel6.setText("Sucessfully Deactive " + classA.getUname());
                            else jLabel6.setText("Sucessfully Reactive " + classA.getUname());
                        }
                    } else {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Invalid Row Number. ");    
                    }
                } else {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Empty input found. ");                    
                }
            } else {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Cancel Modify User's Password Action. ");
            }
        });
        
        BTN_deleteC.addActionListener (e -> {
            jLabel6.setVisible(false);
            
            JTextField row = new JTextField();
            
            int option = JOptionPane.showConfirmDialog(null, new Object[] {"Row: ", row}, "Delete Customer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
            if (option == JOptionPane.OK_OPTION) {
                if (!(row.getText().isEmpty())) {
                    if (classA.check(TBL_view, row.getText())) {
                        if (!classA.getUtype().equals("C")) {
                            jLabel6.setVisible(true);
                            jLabel6.setText("Only allow to delete Customer. ");
                        } else {
                            classA.modifyStatus();
                            jLabel6.setVisible(true);
                            jLabel6.setText("Sucessfully Delete " + classA.getUname());
                        }
                    } else {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Invalid Row Number. ");    
                    }
                } else {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Empty input found. ");                    
                }
            } else {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Cancel Delete Customer Action. ");
            }
        });
        
        BTN_blockC.addActionListener (e -> {
            jLabel6.setVisible(false);
            
            JTextField row = new JTextField();
            
            int option = JOptionPane.showConfirmDialog(null, new Object[] {"Row: ", row}, "Block or Unblock Customer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
            if (option == JOptionPane.OK_OPTION) {
                if (!(row.getText().isEmpty())) {
                    if (classA.check(TBL_view, row.getText())) {
                        if (!classA.getUtype().equals("C")) {
                            jLabel6.setVisible(true);
                            jLabel6.setText("Only allow to block or unblock Customer. ");
                        } else {
                            classA.modifyStatus(true);
                            jLabel6.setVisible(true);
                            if (classA.getUstatus().equals("blocked")) jLabel6.setText("Sucessfully Block " + classA.getUname());
                            else jLabel6.setText("Sucessfully Unblock " + classA.getUname());
                        }
                    } else {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Invalid Row Number. ");    
                    }
                } else {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Empty input found. ");                    
                }
            } else {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Cancel Blocks or Unblock Customer Action. ");
            }
        });
        

        // view booking
        new Admin().viewBooking(TBL_booking);
        // updateProfile
        Panel_updateProfile PNL_profile = new Panel_updateProfile(Uid, new User());
            jPanel5.setLayout(new BorderLayout());
            jPanel5.add(PNL_profile, BorderLayout.CENTER);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTN_groupAdd = new javax.swing.ButtonGroup();
        BTN_cancelf1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TBL_view = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        BTN_deactive = new javax.swing.JButton();
        BTN_deleteC = new javax.swing.JButton();
        BTN_modifyPass = new javax.swing.JButton();
        BTN_add = new javax.swing.JButton();
        BTN_blockC = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        BTN_factive = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        BTN_fadmin = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        BTN_fcustomer = new javax.swing.JButton();
        BTN_fmanager = new javax.swing.JButton();
        BTN_fscheduler = new javax.swing.JButton();
        BTN_fblock = new javax.swing.JButton();
        BTN_fdeactived = new javax.swing.JButton();
        BTN_fpending = new javax.swing.JButton();
        BTN_search = new javax.swing.JButton();
        BTN_cancelf = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        BTN_fpast = new javax.swing.JButton();
        BTN_fupcoming = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TBL_booking = new javax.swing.JTable();
        BTN_fcancelB = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        BTN_cancelf1.setText("Cancel Filter");
        BTN_cancelf1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_cancelf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_cancelf1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 153));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        TBL_view.setBackground(new java.awt.Color(204, 204, 204));
        TBL_view.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TBL_view.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        TBL_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "no", "User ID", "Password", "User Name", "User Type", "Contact", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_view.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(TBL_view);
        if (TBL_view.getColumnModel().getColumnCount() > 0) {
            TBL_view.getColumnModel().getColumn(4).setHeaderValue("User Type");
            TBL_view.getColumnModel().getColumn(5).setHeaderValue("Contact");
            TBL_view.getColumnModel().getColumn(6).setHeaderValue("Status");
        }

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        BTN_deactive.setBackground(new java.awt.Color(102, 102, 102));
        BTN_deactive.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_deactive.setForeground(new java.awt.Color(255, 255, 255));
        BTN_deactive.setText("Deactive/Reactivate Staff");
        BTN_deactive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_deactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_deactiveActionPerformed(evt);
            }
        });

        BTN_deleteC.setBackground(new java.awt.Color(102, 102, 102));
        BTN_deleteC.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_deleteC.setForeground(new java.awt.Color(255, 255, 255));
        BTN_deleteC.setText("Delete Customer");
        BTN_deleteC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_deleteC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_deleteCActionPerformed(evt);
            }
        });

        BTN_modifyPass.setBackground(new java.awt.Color(102, 102, 102));
        BTN_modifyPass.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_modifyPass.setForeground(new java.awt.Color(255, 255, 255));
        BTN_modifyPass.setText("Modify Password");
        BTN_modifyPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_modifyPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_modifyPassActionPerformed(evt);
            }
        });

        BTN_add.setBackground(new java.awt.Color(102, 102, 102));
        BTN_add.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_add.setForeground(new java.awt.Color(255, 255, 255));
        BTN_add.setText("Add User");
        BTN_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_addActionPerformed(evt);
            }
        });

        BTN_blockC.setBackground(new java.awt.Color(102, 102, 102));
        BTN_blockC.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_blockC.setForeground(new java.awt.Color(255, 255, 255));
        BTN_blockC.setText("Block/Unblock Customer");
        BTN_blockC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_blockC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_blockCActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel7.setText("Filter User by Status: ");

        BTN_factive.setBackground(new java.awt.Color(102, 102, 102));
        BTN_factive.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_factive.setForeground(new java.awt.Color(255, 255, 255));
        BTN_factive.setText("Active");
        BTN_factive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_factive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_factiveActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel8.setText("Filter User by User Type: ");

        BTN_fadmin.setBackground(new java.awt.Color(102, 102, 102));
        BTN_fadmin.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_fadmin.setForeground(new java.awt.Color(255, 255, 255));
        BTN_fadmin.setText("Admin");
        BTN_fadmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fadminActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel9.setText("Search User by User Name:  ");

        jTextField1.setBackground(new java.awt.Color(102, 102, 102));
        jTextField1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));

        BTN_fcustomer.setBackground(new java.awt.Color(102, 102, 102));
        BTN_fcustomer.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_fcustomer.setForeground(new java.awt.Color(255, 255, 255));
        BTN_fcustomer.setText("Customer");
        BTN_fcustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fcustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fcustomerActionPerformed(evt);
            }
        });

        BTN_fmanager.setBackground(new java.awt.Color(102, 102, 102));
        BTN_fmanager.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_fmanager.setForeground(new java.awt.Color(255, 255, 255));
        BTN_fmanager.setText("Manager");
        BTN_fmanager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fmanager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fmanagerActionPerformed(evt);
            }
        });

        BTN_fscheduler.setBackground(new java.awt.Color(102, 102, 102));
        BTN_fscheduler.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_fscheduler.setForeground(new java.awt.Color(255, 255, 255));
        BTN_fscheduler.setText("Scheduler");
        BTN_fscheduler.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fscheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fschedulerActionPerformed(evt);
            }
        });

        BTN_fblock.setBackground(new java.awt.Color(102, 102, 102));
        BTN_fblock.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_fblock.setForeground(new java.awt.Color(255, 255, 255));
        BTN_fblock.setText("Blocked");
        BTN_fblock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fblock.setPreferredSize(new java.awt.Dimension(78, 25));
        BTN_fblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fblockActionPerformed(evt);
            }
        });

        BTN_fdeactived.setBackground(new java.awt.Color(102, 102, 102));
        BTN_fdeactived.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_fdeactived.setForeground(new java.awt.Color(255, 255, 255));
        BTN_fdeactived.setText("Deactived");
        BTN_fdeactived.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fdeactived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fdeactivedActionPerformed(evt);
            }
        });

        BTN_fpending.setBackground(new java.awt.Color(102, 102, 102));
        BTN_fpending.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_fpending.setForeground(new java.awt.Color(255, 255, 255));
        BTN_fpending.setText("Pending");
        BTN_fpending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fpending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fpendingActionPerformed(evt);
            }
        });

        BTN_search.setBackground(new java.awt.Color(102, 102, 102));
        BTN_search.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_search.setForeground(new java.awt.Color(255, 255, 255));
        BTN_search.setText("SEARCH");
        BTN_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_searchActionPerformed(evt);
            }
        });

        BTN_cancelf.setBackground(new java.awt.Color(102, 102, 102));
        BTN_cancelf.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_cancelf.setForeground(new java.awt.Color(255, 255, 255));
        BTN_cancelf.setText("Cancel Filter");
        BTN_cancelf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_cancelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_cancelfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(BTN_blockC, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(BTN_deactive, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(BTN_add, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_modifyPass, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTN_deleteC))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BTN_fadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BTN_factive, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BTN_fdeactived, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BTN_fmanager))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BTN_fscheduler, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BTN_fblock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_search)))
                .addGap(6, 6, 6))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BTN_fpending, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTN_fcustomer, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(BTN_cancelf)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BTN_factive, BTN_fadmin, BTN_fblock, BTN_fcustomer, BTN_fdeactived, BTN_fmanager, BTN_fpending, BTN_fscheduler});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BTN_blockC, BTN_deactive});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BTN_add, BTN_deleteC});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BTN_modifyPass)
                    .addComponent(BTN_add)
                    .addComponent(BTN_deleteC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_blockC)
                    .addComponent(BTN_deactive))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_factive)
                    .addComponent(BTN_fblock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_fdeactived)
                    .addComponent(BTN_fpending))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_fadmin)
                    .addComponent(BTN_fcustomer)
                    .addComponent(BTN_fmanager)
                    .addComponent(BTN_fscheduler))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(BTN_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTN_cancelf)
                .addGap(5, 5, 5))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BTN_factive, BTN_fadmin, BTN_fblock, BTN_fcustomer, BTN_fdeactived, BTN_fmanager, BTN_fpending, BTN_fscheduler});

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane5)))
                .addGap(38, 38, 38))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("User Management", jPanel7);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel10.setText("Filtering Bookings Based on Status:");

        BTN_fpast.setBackground(new java.awt.Color(102, 102, 102));
        BTN_fpast.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_fpast.setForeground(new java.awt.Color(255, 255, 255));
        BTN_fpast.setText("Past Booking");
        BTN_fpast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fpast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fpastActionPerformed(evt);
            }
        });

        BTN_fupcoming.setBackground(new java.awt.Color(102, 102, 102));
        BTN_fupcoming.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_fupcoming.setForeground(new java.awt.Color(255, 255, 255));
        BTN_fupcoming.setText("Upcoming Booking");
        BTN_fupcoming.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fupcoming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fupcomingActionPerformed(evt);
            }
        });

        TBL_booking.setBackground(new java.awt.Color(204, 204, 204));
        TBL_booking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TBL_booking.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        TBL_booking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "no", "Booking ID", "Hall ID", "Customer ID", "Booking Date", "Start Time", "End Time", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_booking.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(TBL_booking);

        BTN_fcancelB.setBackground(new java.awt.Color(102, 102, 102));
        BTN_fcancelB.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        BTN_fcancelB.setForeground(new java.awt.Color(255, 255, 255));
        BTN_fcancelB.setText("Cancel Filter");
        BTN_fcancelB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fcancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fcancelBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane7))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(BTN_fpast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_fupcoming)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_fcancelB)
                .addGap(74, 74, 74))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BTN_fcancelB, BTN_fpast, BTN_fupcoming});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_fupcoming)
                    .addComponent(BTN_fpast)
                    .addComponent(BTN_fcancelB))
                .addContainerGap(234, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Booking Status", jPanel3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Update Profile", jPanel5);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel2.setText("Admin Page");

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.setToolTipText("");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("jTabbedPane1");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_cancelf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_cancelf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_cancelf1ActionPerformed

    private void BTN_fpastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fpastActionPerformed
        new Admin().viewBooking(TBL_booking, true);
    }//GEN-LAST:event_BTN_fpastActionPerformed

    private void BTN_fupcomingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fupcomingActionPerformed
        new Admin().viewBooking(TBL_booking, false);
    }//GEN-LAST:event_BTN_fupcomingActionPerformed

    private void BTN_fcancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fcancelBActionPerformed
        new Admin().viewBooking(TBL_booking);
    }//GEN-LAST:event_BTN_fcancelBActionPerformed

    private void BTN_cancelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_cancelfActionPerformed
        jTextField1.setText("");
        jLabel6.setVisible(false);
        defaultPending = true;
        RoleSelected = null;
        Utils.viewTable(TBL_view, "users.txt", User.class);
        classA.removeCurrentAdmin(TBL_view, Uid);
    }//GEN-LAST:event_BTN_cancelfActionPerformed

    private void BTN_fpendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fpendingActionPerformed
        jTextField1.setText("");
        jLabel6.setVisible(false);
        defaultPending = true;
        Utils.viewTable(TBL_view, "users.txt", User.class, 5, "pending");
    }//GEN-LAST:event_BTN_fpendingActionPerformed

    private void BTN_fdeactivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fdeactivedActionPerformed
        jTextField1.setText("");
        jLabel6.setVisible(false);
        defaultPending = false;
        Utils.viewTable(TBL_view, "users.txt", User.class, 5, "deactived");
    }//GEN-LAST:event_BTN_fdeactivedActionPerformed

    private void BTN_fblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fblockActionPerformed
        jTextField1.setText("");
        jLabel6.setVisible(false);
        defaultPending = false;
        Utils.viewTable(TBL_view, "users.txt", User.class, 5, "blocked");
    }//GEN-LAST:event_BTN_fblockActionPerformed

    private void BTN_fschedulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fschedulerActionPerformed
        jTextField1.setText("");
        jLabel6.setVisible(false);
        RoleSelected = 'S';
        Utils.viewTable(TBL_view, "users.txt", User.class, 3, "S");
    }//GEN-LAST:event_BTN_fschedulerActionPerformed

    private void BTN_fmanagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fmanagerActionPerformed
        jTextField1.setText("");
        jLabel6.setVisible(false);
        RoleSelected = 'M';
        Utils.viewTable(TBL_view, "users.txt", User.class, 3, "M");
    }//GEN-LAST:event_BTN_fmanagerActionPerformed

    private void BTN_fcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fcustomerActionPerformed
        jTextField1.setText("");
        jLabel6.setVisible(false);
        RoleSelected = 'C';
        Utils.viewTable(TBL_view, "users.txt", User.class, 3, "C");
    }//GEN-LAST:event_BTN_fcustomerActionPerformed

    private void BTN_fadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fadminActionPerformed
        jTextField1.setText("");
        jLabel6.setVisible(false);
        RoleSelected = 'A';
        Utils.viewTable(TBL_view, "users.txt", User.class, 3, "A");
        classA.removeCurrentAdmin(TBL_view, Uid);
    }//GEN-LAST:event_BTN_fadminActionPerformed

    private void BTN_factiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_factiveActionPerformed
        jTextField1.setText("");
        jLabel6.setVisible(false);
        defaultPending = false;
        Utils.viewTable(TBL_view, "users.txt", User.class, 5, "active");
        classA.removeCurrentAdmin(TBL_view, Uid);
    }//GEN-LAST:event_BTN_factiveActionPerformed

    private void BTN_blockCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_blockCActionPerformed
        jTextField1.setText("");
    }//GEN-LAST:event_BTN_blockCActionPerformed

    private void BTN_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_addActionPerformed
        jTextField1.setText("");
    }//GEN-LAST:event_BTN_addActionPerformed

    private void BTN_modifyPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_modifyPassActionPerformed
        jTextField1.setText("");
    }//GEN-LAST:event_BTN_modifyPassActionPerformed

    private void BTN_deleteCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_deleteCActionPerformed
        jTextField1.setText("");
    }//GEN-LAST:event_BTN_deleteCActionPerformed

    private void BTN_deactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_deactiveActionPerformed
        jTextField1.setText("");
    }//GEN-LAST:event_BTN_deactiveActionPerformed

    private void BTN_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_searchActionPerformed
        jLabel6.setVisible(false);
        defaultPending = true;
        RoleSelected = null;
        if (jTextField1 != null)
        classA.search(TBL_view, jTextField1.getText());
    }//GEN-LAST:event_BTN_searchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(uiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uiAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_add;
    private javax.swing.JButton BTN_blockC;
    private javax.swing.JButton BTN_cancelf;
    private javax.swing.JButton BTN_cancelf1;
    private javax.swing.JButton BTN_deactive;
    private javax.swing.JButton BTN_deleteC;
    private javax.swing.JButton BTN_factive;
    private javax.swing.JButton BTN_fadmin;
    private javax.swing.JButton BTN_fblock;
    private javax.swing.JButton BTN_fcancelB;
    private javax.swing.JButton BTN_fcustomer;
    private javax.swing.JButton BTN_fdeactived;
    private javax.swing.JButton BTN_fmanager;
    private javax.swing.JButton BTN_fpast;
    private javax.swing.JButton BTN_fpending;
    private javax.swing.JButton BTN_fscheduler;
    private javax.swing.JButton BTN_fupcoming;
    private javax.swing.ButtonGroup BTN_groupAdd;
    private javax.swing.JButton BTN_modifyPass;
    private javax.swing.JButton BTN_search;
    private javax.swing.JTable TBL_booking;
    private javax.swing.JTable TBL_view;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
