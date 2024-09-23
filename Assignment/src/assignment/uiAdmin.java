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
                System.out.println(name + "." + type);
                
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
                jLabel6.setText("Cancel Add User");
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
        BTN_add = new javax.swing.JButton();
        BTN_add1 = new javax.swing.JButton();
        BTN_add2 = new javax.swing.JButton();
        BTN_fadmin = new javax.swing.JButton();
        BTN_factive = new javax.swing.JButton();
        BTN_cancelf = new javax.swing.JButton();
        BTN_fpending = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        BTN_fcustomer = new javax.swing.JButton();
        BTN_fmanager = new javax.swing.JButton();
        BTN_fscheduler = new javax.swing.JButton();
        BTN_fdeactived = new javax.swing.JButton();
        BTN_fblock = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        BTN_add.setText("Add User");
        BTN_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_addActionPerformed(evt);
            }
        });

        BTN_add1.setText("Modify Name");
        BTN_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_add1ActionPerformed(evt);
            }
        });

        BTN_add2.setText("Modify Status");
        BTN_add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_add2ActionPerformed(evt);
            }
        });

        BTN_fadmin.setText("Admin");
        BTN_fadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fadminActionPerformed(evt);
            }
        });

        BTN_factive.setText("active");
        BTN_factive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_factiveActionPerformed(evt);
            }
        });

        BTN_cancelf.setText("Cancel Filter");
        BTN_cancelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_cancelfActionPerformed(evt);
            }
        });

        BTN_fpending.setText("pending");
        BTN_fpending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fpendingActionPerformed(evt);
            }
        });

        jLabel6.setText("jLabel3");

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

        BTN_fcustomer.setText("Customer");
        BTN_fcustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fcustomerActionPerformed(evt);
            }
        });

        BTN_fmanager.setText("Manager");
        BTN_fmanager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fmanagerActionPerformed(evt);
            }
        });

        BTN_fscheduler.setText("Scheduler");
        BTN_fscheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fschedulerActionPerformed(evt);
            }
        });

        BTN_fdeactived.setText("deactived");
        BTN_fdeactived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fdeactivedActionPerformed(evt);
            }
        });

        BTN_fblock.setText("blocked");
        BTN_fblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_fblockActionPerformed(evt);
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
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(BTN_add)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(BTN_add1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BTN_add2))))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(BTN_fadmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_fcustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_fmanager)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_fscheduler)
                        .addGap(73, 73, 73)
                        .addComponent(BTN_cancelf))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(BTN_factive)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_fpending)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_fdeactived)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_fblock)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_add)
                    .addComponent(BTN_add1)
                    .addComponent(BTN_add2))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_factive)
                    .addComponent(BTN_fpending)
                    .addComponent(BTN_fdeactived)
                    .addComponent(BTN_fblock))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_cancelf)
                    .addComponent(BTN_fadmin)
                    .addComponent(BTN_fcustomer)
                    .addComponent(BTN_fmanager)
                    .addComponent(BTN_fscheduler))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("User Management", jPanel7);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Update Profile", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel2)
                .addGap(0, 317, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_addActionPerformed

    }//GEN-LAST:event_BTN_addActionPerformed

    private void BTN_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_add1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_add1ActionPerformed

    private void BTN_add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_add2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_add2ActionPerformed

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
    private javax.swing.JButton BTN_add1;
    private javax.swing.JButton BTN_add2;
    private javax.swing.JButton BTN_cancelf;
    private javax.swing.JButton BTN_factive;
    private javax.swing.JButton BTN_fadmin;
    private javax.swing.JButton BTN_fblock;
    private javax.swing.JButton BTN_fcustomer;
    private javax.swing.JButton BTN_fdeactived;
    private javax.swing.JButton BTN_fmanager;
    private javax.swing.JButton BTN_fpending;
    private javax.swing.JButton BTN_fscheduler;
    private javax.swing.ButtonGroup BTN_groupAdd;
    private javax.swing.JTable TBL_view;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
