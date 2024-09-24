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
                    if (defaultPending && (classA.getUtype().equals(RoleSelected) || RoleSelected == null))
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
                        jLabel6.setText("Password Change!");
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TBL_view = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
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
        BTN_cancelf = new javax.swing.JButton();
        BTN_cancelf2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TBL_view1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        BTN_cancelf1.setText("Cancel Filter");
        BTN_cancelf1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_cancelf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_cancelf1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        jLabel6.setText("jLabel6");
        jLabel6.setToolTipText("");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BTN_deactive.setText("Deactive/Reactivate Staff");
        BTN_deactive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_deactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_deactiveActionPerformed(evt);
            }
        });

        BTN_deleteC.setText("Delete Customer");
        BTN_deleteC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_deleteC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_deleteCActionPerformed(evt);
            }
        });

        BTN_modifyPass.setText("Modify Password");
        BTN_modifyPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_modifyPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_modifyPassActionPerformed(evt);
            }
        });

        BTN_add.setText("Add User");
        BTN_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_addActionPerformed(evt);
            }
        });

        BTN_blockC.setText("Block/Unblock Customer");
        BTN_blockC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_blockC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_blockCActionPerformed(evt);
            }
        });

        jLabel7.setText("Filter User by Status: ");

        BTN_factive.setText("Active");
        BTN_factive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_factive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_factiveActionPerformed(evt);
            }
        });

        jLabel8.setText("Filter User by User Type: ");

        BTN_fadmin.setText("Admin");
        BTN_fadmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fadminActionPerformed(evt);
            }
        });

        jLabel9.setText("Search User by User Name:  ");

        BTN_fcustomer.setText("Customer");
        BTN_fcustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fcustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fcustomerActionPerformed(evt);
            }
        });

        BTN_fmanager.setText("Manager");
        BTN_fmanager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fmanager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fmanagerActionPerformed(evt);
            }
        });

        BTN_fscheduler.setText("Scheduler");
        BTN_fscheduler.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fscheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fschedulerActionPerformed(evt);
            }
        });

        BTN_fblock.setText("Blocked");
        BTN_fblock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fblock.setPreferredSize(new java.awt.Dimension(78, 25));
        BTN_fblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fblockActionPerformed(evt);
            }
        });

        BTN_fdeactived.setText("Deactived");
        BTN_fdeactived.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fdeactived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fdeactivedActionPerformed(evt);
            }
        });

        BTN_fpending.setText("Pending");
        BTN_fpending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_fpending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fpendingActionPerformed(evt);
            }
        });

        BTN_cancelf.setText("Cancel Filter");
        BTN_cancelf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_cancelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_cancelfActionPerformed(evt);
            }
        });

        BTN_cancelf2.setText("Go");
        BTN_cancelf2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_cancelf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_cancelf2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTN_cancelf2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(BTN_factive)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(BTN_fpending)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(BTN_fdeactived)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(BTN_fblock, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(BTN_fadmin)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(BTN_fcustomer)
                                                    .addGap(6, 6, 6)
                                                    .addComponent(BTN_fmanager)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(BTN_fscheduler)))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(BTN_blockC)
                                                    .addGap(47, 47, 47)
                                                    .addComponent(BTN_deactive))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(BTN_add)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(BTN_modifyPass)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(BTN_deleteC))))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(BTN_cancelf)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BTN_add, BTN_modifyPass});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BTN_blockC, BTN_deactive});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BTN_factive, BTN_fadmin, BTN_fblock, BTN_fcustomer, BTN_fdeactived, BTN_fmanager, BTN_fpending, BTN_fscheduler});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_add)
                    .addComponent(BTN_modifyPass)
                    .addComponent(BTN_deleteC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_blockC)
                    .addComponent(BTN_deactive))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_factive)
                    .addComponent(BTN_fblock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_fdeactived)
                    .addComponent(BTN_fpending))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(BTN_cancelf2))
                .addGap(18, 18, 18)
                .addComponent(BTN_cancelf))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("User Management", jPanel7);

        TBL_view1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "no", "User ID", "Password", "User Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_view1.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(TBL_view1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Booking Status", jPanel3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Update Profile", jPanel5);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Admin Page");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("jTabbedPane1");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_addActionPerformed

    }//GEN-LAST:event_BTN_addActionPerformed

    private void BTN_modifyPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_modifyPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_modifyPassActionPerformed

    private void BTN_fadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fadminActionPerformed
        RoleSelected = 'A';
        Utils.viewTable(TBL_view, "users.txt", User.class, 3, "A");
        classA.removeCurrentAdmin(TBL_view, Uid);
    }//GEN-LAST:event_BTN_fadminActionPerformed

    private void BTN_factiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_factiveActionPerformed
        defaultPending = false;
        Utils.viewTable(TBL_view, "users.txt", User.class, 5, "active");
        classA.removeCurrentAdmin(TBL_view, Uid);
    }//GEN-LAST:event_BTN_factiveActionPerformed

    private void BTN_cancelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_cancelfActionPerformed
        defaultPending = true;
        RoleSelected = null;
        Utils.viewTable(TBL_view, "users.txt", User.class);
    }//GEN-LAST:event_BTN_cancelfActionPerformed

    private void BTN_fpendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fpendingActionPerformed
        defaultPending = true;
        Utils.viewTable(TBL_view, "users.txt", User.class, 5, "pending");
    }//GEN-LAST:event_BTN_fpendingActionPerformed

    private void BTN_fcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fcustomerActionPerformed
        RoleSelected = 'C';
        Utils.viewTable(TBL_view, "users.txt", User.class, 3, "C");
    }//GEN-LAST:event_BTN_fcustomerActionPerformed

    private void BTN_fmanagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fmanagerActionPerformed
        RoleSelected = 'M';
        Utils.viewTable(TBL_view, "users.txt", User.class, 3, "M");
    }//GEN-LAST:event_BTN_fmanagerActionPerformed

    private void BTN_fschedulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fschedulerActionPerformed
        RoleSelected = 'S';
        Utils.viewTable(TBL_view, "users.txt", User.class, 3, "S");
    }//GEN-LAST:event_BTN_fschedulerActionPerformed

    private void BTN_fdeactivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fdeactivedActionPerformed
        defaultPending = false;
        Utils.viewTable(TBL_view, "users.txt", User.class, 5, "deactived");
    }//GEN-LAST:event_BTN_fdeactivedActionPerformed

    private void BTN_fblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fblockActionPerformed
        defaultPending = false;
        Utils.viewTable(TBL_view, "users.txt", User.class, 5, "blocked");
    }//GEN-LAST:event_BTN_fblockActionPerformed

    private void BTN_blockCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_blockCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_blockCActionPerformed

    private void BTN_deactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_deactiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_deactiveActionPerformed

    private void BTN_deleteCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_deleteCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_deleteCActionPerformed

    private void BTN_cancelf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_cancelf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_cancelf1ActionPerformed

    private void BTN_cancelf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_cancelf2ActionPerformed
        defaultPending = true;
        RoleSelected = null;
        if (jTextField1 != null)
            classA.search(TBL_view, jTextField1.getText());
    }//GEN-LAST:event_BTN_cancelf2ActionPerformed

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
    private javax.swing.JButton BTN_cancelf2;
    private javax.swing.JButton BTN_deactive;
    private javax.swing.JButton BTN_deleteC;
    private javax.swing.JButton BTN_factive;
    private javax.swing.JButton BTN_fadmin;
    private javax.swing.JButton BTN_fblock;
    private javax.swing.JButton BTN_fcustomer;
    private javax.swing.JButton BTN_fdeactived;
    private javax.swing.JButton BTN_fmanager;
    private javax.swing.JButton BTN_fpending;
    private javax.swing.JButton BTN_fscheduler;
    private javax.swing.ButtonGroup BTN_groupAdd;
    private javax.swing.JButton BTN_modifyPass;
    private javax.swing.JTable TBL_view;
    private javax.swing.JTable TBL_view1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
