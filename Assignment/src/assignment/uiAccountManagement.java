package assignment;

import javax.swing.*;
import java.util.*;

public class uiAccountManagement extends javax.swing.JFrame {
    private User user;
    private String buttonPress;
    
    public uiAccountManagement() {
        initComponents();
        setContentPane(PNL_accManagement);

        new ComponentAction(new ArrayList<>(Arrays.asList(TXT_name, TXT_c, TXT_old, TXT_new))).set(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        PNL_accManagement = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TXT_c = new javax.swing.JTextField();
        TXT_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TXT_old = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TXT_new = new javax.swing.JPasswordField();
        BTN_change = new javax.swing.JButton();
        BTN_pass = new javax.swing.JButton();
        BTN_c = new javax.swing.JButton();
        BTN_name = new javax.swing.JButton();
        BTN_logout = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Change User Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Change Contact");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Select the changes you want to make: ");

        jLabel4.setText("Old Password: ");

        jLabel5.setText("New Password: ");

        BTN_change.setText("Change");
        BTN_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_changeActionPerformed(evt);
            }
        });

        BTN_pass.setText("Change Password");
        BTN_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_passActionPerformed(evt);
            }
        });

        BTN_c.setText("Change Contact");
        BTN_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_cActionPerformed(evt);
            }
        });

        BTN_name.setText("Change User Name");
        BTN_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_nameActionPerformed(evt);
            }
        });

        BTN_logout.setText("Log Out");
        BTN_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_logoutActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Change Password");

        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout PNL_accManagementLayout = new javax.swing.GroupLayout(PNL_accManagement);
        PNL_accManagement.setLayout(PNL_accManagementLayout);
        PNL_accManagementLayout.setHorizontalGroup(
            PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNL_accManagementLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(BTN_logout)
                .addGap(27, 27, 27)
                .addComponent(BTN_change)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PNL_accManagementLayout.createSequentialGroup()
                .addGroup(PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PNL_accManagementLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PNL_accManagementLayout.createSequentialGroup()
                                .addComponent(BTN_name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTN_c)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTN_pass))
                            .addGroup(PNL_accManagementLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PNL_accManagementLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PNL_accManagementLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PNL_accManagementLayout.createSequentialGroup()
                                .addGroup(PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TXT_name, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                        .addComponent(TXT_c)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PNL_accManagementLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TXT_old, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXT_new, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                            .addGroup(PNL_accManagementLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        PNL_accManagementLayout.setVerticalGroup(
            PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNL_accManagementLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_pass)
                    .addComponent(BTN_c)
                    .addComponent(BTN_name))
                .addGap(18, 18, 18)
                .addGroup(PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PNL_accManagementLayout.createSequentialGroup()
                        .addComponent(TXT_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PNL_accManagementLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_old, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PNL_accManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_change)
                    .addComponent(BTN_logout))
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PNL_accManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PNL_accManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_passActionPerformed
        new ComponentAction(new ArrayList<>(Arrays.asList(TXT_old, TXT_new))).set(true);
        new ComponentAction(new ArrayList<>(Arrays.asList(TXT_name, TXT_c))).set(false);
        buttonPress = "p";
        
    }//GEN-LAST:event_BTN_passActionPerformed

    private void BTN_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_cActionPerformed
        new ComponentAction(new ArrayList<>(Arrays.asList(TXT_c))).set(true);
        new ComponentAction(new ArrayList<>(Arrays.asList(TXT_name, TXT_old, TXT_new))).set(false);
        buttonPress = "c";
    }//GEN-LAST:event_BTN_cActionPerformed

    private void BTN_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_nameActionPerformed
        new ComponentAction(new ArrayList<>(Arrays.asList(TXT_name))).set(true);
        new ComponentAction(new ArrayList<>(Arrays.asList(TXT_c, TXT_old, TXT_new))).set(false);
        buttonPress = "n";
    }//GEN-LAST:event_BTN_nameActionPerformed

    private void BTN_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_changeActionPerformed
        boolean flag = false;

        switch (buttonPress) {
            case "p": 
                if (new ComponentAction(new ArrayList<>(Arrays.asList(TXT_old, TXT_new))).emptyPassword())
                    jLabel8.setText("Empty Input Found");
                else {                
                    switch (user.updatePass(TXT_old.getText(), TXT_new.getText())) {
                        case "Same":
                            jLabel8.setText("Please provide a different new password from old password. ");
                            break;
                        case "Incorrect":
                            jLabel8.setText("Old Password is Incorrect! ");
                            break;
                        case "Done":
                            jLabel8.setText("Password Change Succesfully!");
                            new ComponentAction(new ArrayList<>(Arrays.asList(TXT_name))).deleteAll();
                            flag = true;
                            break;
                        default:
                            jLabel8.setText("Empty Input Found. ");
                    } 
                } break;

            case "c": 
                if (!user.updateC(TXT_c.getText()))
                    jLabel8.setText("Incorrect Contact Number or Empty Input Found. ");
                else {
                    TXT_c.setText("");
                    flag = true;
                    jLabel8.setText("Contact Number Changed!");
                }
                break;

            case "n": 
                if (!user.updateName(TXT_name.getText()))
                    jLabel8.setText("Empty Input Found. ");
                else {
                    TXT_name.setText("");
                    flag = true;
                    jLabel8.setText("Name Changed!");
                }
                break;
        }
        
        if (flag)
            jTextArea1.setText(String.format("User ID: %s \nUser Name: %s \nContact: %s", user.getUid(), user.getUname(), user.getUcontact()));
    }//GEN-LAST:event_BTN_changeActionPerformed

    private void BTN_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_logoutActionPerformed
        user.logout();
    }//GEN-LAST:event_BTN_logoutActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(uiAccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uiAccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uiAccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uiAccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uiAccountManagement().setVisible(true);
            }
        });
    }
    
    public JPanel getPNL_accManagement(User user, String Uid) {
        this.user = user;
        user.setUid(Uid);
        jTextArea1.setText(String.format("User ID: %s \nUser Name: %s \nContact: %s", user.getUid(), user.getUname(), user.getUcontact()));
        return PNL_accManagement;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_c;
    private javax.swing.JButton BTN_change;
    private javax.swing.JButton BTN_logout;
    private javax.swing.JButton BTN_name;
    private javax.swing.JButton BTN_pass;
    private javax.swing.JPanel PNL_accManagement;
    private javax.swing.JTextField TXT_c;
    private javax.swing.JTextField TXT_name;
    private javax.swing.JPasswordField TXT_new;
    private javax.swing.JPasswordField TXT_old;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
