package assignment;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class uiAdmin extends javax.swing.JFrame {

    public uiAdmin() {
        initComponents();
    }
    
    public uiAdmin(String Uid, Admin classA) {
        initComponents();
        
        // user management
        jLabel6.setVisible(false);
        
        Utils.viewTable(TBL_view, "users.txt", User.class);
        
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
        

        // hall
//        this.classH = new Hall();
        
        // updateProfile
        Panel_updateProfile PNL_profile = new Panel_updateProfile(Uid, new User());
            jPanel5.setLayout(new BorderLayout());
            jPanel5.add(PNL_profile, BorderLayout.CENTER);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTN_groupAdd = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TBL_view = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        BTN_factive = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        BTN_cancelf = new javax.swing.JButton();
        BTN_fpending = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        BTN_fcustomer = new javax.swing.JButton();
        BTN_blockC = new javax.swing.JButton();
        BTN_fmanager = new javax.swing.JButton();
        BTN_deactive = new javax.swing.JButton();
        BTN_fscheduler = new javax.swing.JButton();
        BTN_add = new javax.swing.JButton();
        BTN_modifyPass = new javax.swing.JButton();
        BTN_deleteC = new javax.swing.JButton();
        BTN_fdeactived = new javax.swing.JButton();
        BTN_fblock = new javax.swing.JButton();
        BTN_fadmin = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Admin Page");

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

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6)
        );

        BTN_factive.setText("Active");
        BTN_factive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_factiveActionPerformed(evt);
            }
        });

        jLabel7.setText("Filter User by Status: ");

        BTN_cancelf.setText("Cancel Filter");
        BTN_cancelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_cancelfActionPerformed(evt);
            }
        });

        BTN_fpending.setText("Pending");
        BTN_fpending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fpendingActionPerformed(evt);
            }
        });

        jLabel8.setText("Filter User by User Type: ");

        BTN_fcustomer.setText("Customer");
        BTN_fcustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fcustomerActionPerformed(evt);
            }
        });

        BTN_blockC.setText("Block/Unblock Customer");
        BTN_blockC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_blockCActionPerformed(evt);
            }
        });

        BTN_fmanager.setText("Manager");
        BTN_fmanager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fmanagerActionPerformed(evt);
            }
        });

        BTN_deactive.setText("Deactive/Reactivate Staff");
        BTN_deactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_deactiveActionPerformed(evt);
            }
        });

        BTN_fscheduler.setText("Scheduler");
        BTN_fscheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fschedulerActionPerformed(evt);
            }
        });

        BTN_add.setText("Add User");
        BTN_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_addActionPerformed(evt);
            }
        });

        BTN_modifyPass.setText("Modify Password");
        BTN_modifyPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_modifyPassActionPerformed(evt);
            }
        });

        BTN_deleteC.setText("Delete Customer");
        BTN_deleteC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_deleteCActionPerformed(evt);
            }
        });

        BTN_fdeactived.setText("Deactived");
        BTN_fdeactived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fdeactivedActionPerformed(evt);
            }
        });

        BTN_fblock.setText("Blocked");
        BTN_fblock.setPreferredSize(new java.awt.Dimension(78, 25));
        BTN_fblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fblockActionPerformed(evt);
            }
        });

        BTN_fadmin.setText("Admin");
        BTN_fadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fadminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(BTN_fadmin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTN_fcustomer)
                                .addGap(6, 6, 6)
                                .addComponent(BTN_fmanager)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTN_fscheduler))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(BTN_blockC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BTN_deactive))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(BTN_add)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTN_modifyPass)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BTN_deleteC))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(BTN_factive)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTN_fpending)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTN_fdeactived)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTN_fblock, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(BTN_cancelf)
                                .addGap(144, 144, 144))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BTN_add, BTN_modifyPass});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BTN_blockC, BTN_deactive});

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BTN_factive, BTN_fadmin, BTN_fblock, BTN_fcustomer, BTN_fdeactived, BTN_fmanager, BTN_fpending, BTN_fscheduler});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_add)
                    .addComponent(BTN_modifyPass)
                    .addComponent(BTN_deleteC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_blockC)
                    .addComponent(BTN_deactive))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_factive)
                    .addComponent(BTN_fblock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_fdeactived)
                    .addComponent(BTN_fpending))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_fadmin)
                    .addComponent(BTN_fcustomer)
                    .addComponent(BTN_fmanager)
                    .addComponent(BTN_fscheduler))
                .addGap(18, 18, 18)
                .addComponent(BTN_cancelf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("User Management", jPanel7);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Update Profile", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_addActionPerformed

    }//GEN-LAST:event_BTN_addActionPerformed

    private void BTN_modifyPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_modifyPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_modifyPassActionPerformed

    private void BTN_fadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fadminActionPerformed
        Utils.viewTable(TBL_view, "users.txt", User.class, 3, "A");
    }//GEN-LAST:event_BTN_fadminActionPerformed

    private void BTN_factiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_factiveActionPerformed
        Utils.viewTable(TBL_view, "users.txt", User.class, 5, "active");
    }//GEN-LAST:event_BTN_factiveActionPerformed

    private void BTN_cancelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_cancelfActionPerformed
        Utils.viewTable(TBL_view, "users.txt", User.class);
    }//GEN-LAST:event_BTN_cancelfActionPerformed

    private void BTN_fpendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fpendingActionPerformed
        Utils.viewTable(TBL_view, "users.txt", User.class, 5, "pending");
    }//GEN-LAST:event_BTN_fpendingActionPerformed

    private void BTN_fcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fcustomerActionPerformed
        Utils.viewTable(TBL_view, "users.txt", User.class, 3, "C");
    }//GEN-LAST:event_BTN_fcustomerActionPerformed

    private void BTN_fmanagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fmanagerActionPerformed
        Utils.viewTable(TBL_view, "users.txt", User.class, 3, "M");
    }//GEN-LAST:event_BTN_fmanagerActionPerformed

    private void BTN_fschedulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fschedulerActionPerformed
        Utils.viewTable(TBL_view, "users.txt", User.class, 3, "S");
    }//GEN-LAST:event_BTN_fschedulerActionPerformed

    private void BTN_fdeactivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fdeactivedActionPerformed
        Utils.viewTable(TBL_view, "users.txt", User.class, 5, "deactived");
    }//GEN-LAST:event_BTN_fdeactivedActionPerformed

    private void BTN_fblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_fblockActionPerformed
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
