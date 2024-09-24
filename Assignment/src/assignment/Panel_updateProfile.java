package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Panel_updateProfile extends javax.swing.JPanel {
    private User updateProfile;

    public Panel_updateProfile() {
        initComponents();
    }
    
    public Panel_updateProfile(String Uid, User updateProfile) {
        initComponents();

        jLabel8.setHorizontalAlignment(JLabel.CENTER);
        
        this.updateProfile = updateProfile;

        // update profile
        updateProfile.setUid(Uid);
        BTN_delete.setEnabled(false);
        jLabel8.setVisible(false);
        Utils.viewTable(TBL_profile, "users.txt", User.class, 0, updateProfile.getUid());

        if (updateProfile.getUtype().equals("C")) BTN_delete.setEnabled(true);
        
        // change contact
        BTN_c.addActionListener(e -> {
            jLabel8.setVisible(false);
            JTextField contact = new JTextField();
            
            int option = JOptionPane.showConfirmDialog(null, new Object[]{"Enter Contact: ", contact}, "Change Contact", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
            if (option == JOptionPane.OK_OPTION) {
                
                if (updateProfile.updateC(contact.getText())) {
                    ((DefaultTableModel) TBL_profile.getModel()).setValueAt(updateProfile.getUcontact(), 0, 2);
                    jLabel8.setVisible(true);
                    jLabel8.setText("Contact Number Change!.");
                } else {
                    jLabel8.setVisible(true);
                    jLabel8.setText("Incorrect Contact Number or Empty Input Found. ");
                }                
            } else {
                jLabel8.setVisible(true);
                jLabel8.setText("Contact change was canceled.");
            }
            
        });
        
        //change name
        BTN_name.addActionListener(e -> {
            jLabel8.setVisible(false);
            JTextField name = new JTextField();
            
            int option = JOptionPane.showConfirmDialog(null, new Object[]{"Enter New Name: ", name}, "Change Name", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
            if (option == JOptionPane.OK_OPTION) {
                if (updateProfile.updateName(name.getText())) {
                    ((DefaultTableModel) TBL_profile.getModel()).setValueAt(updateProfile.getUname(), 0, 1);
                    jLabel8.setVisible(true);
                    jLabel8.setText("Name Updated! "); 
                } else {
                    jLabel8.setVisible(true);
                    jLabel8.setText("Empty Input Found"); 
                }
            } else {
                    jLabel8.setVisible(true);
                    jLabel8.setText("Name change was canceled."); 
            }
        });
        
        // change password
        BTN_pass.addActionListener(e -> {
            jLabel8.setVisible(false);
            
            JPasswordField oldP = new JPasswordField();
            JPasswordField newP = new JPasswordField();
            
            Object[] p = {
                "Enter Old Password: ", oldP, 
                "Enter New Password: ", newP
            };
            
            int option = JOptionPane.showConfirmDialog(null, p, "Change Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
            if (option == JOptionPane.OK_OPTION) {
               
                if (oldP.getPassword().length == 0 || newP.getPassword().length == 0) {
                    jLabel8.setVisible(true);
                    jLabel8.setText("Empty Input Found");
                }
                else {
                    switch (updateProfile.updatePass(new String(oldP.getPassword()), new String(newP.getPassword()))){
                        case "Same":
                            jLabel8.setVisible(true);
                            jLabel8.setText("Please provide a different password from old password. "); 
                            break;
                        case "Incorrect":
                            jLabel8.setVisible(true);
                            jLabel8.setText("Old Password is Incorrect! "); 
                            break;
                        case "Done":
                            jLabel8.setVisible(true);
                            jLabel8.setText("Password Change Succesfully!"); 
                            break;
                    }
                }
            } else {
                jLabel8.setVisible(true);
                jLabel8.setText("Password change was canceled.");
            }
        });
    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTN_name = new javax.swing.JButton();
        BTN_c = new javax.swing.JButton();
        BTN_pass = new javax.swing.JButton();
        BTN_delete = new javax.swing.JButton();
        BTN_logout = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TBL_profile = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        BTN_name.setText("Change User Name");
        BTN_name.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_nameActionPerformed(evt);
            }
        });

        BTN_c.setText("Change Contact");
        BTN_c.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_cActionPerformed(evt);
            }
        });

        BTN_pass.setText("Change Password");
        BTN_pass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_passActionPerformed(evt);
            }
        });

        BTN_delete.setText("Delete Account");
        BTN_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_deleteActionPerformed(evt);
            }
        });

        BTN_logout.setText("Log Out");
        BTN_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_logoutActionPerformed(evt);
            }
        });

        TBL_profile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "User Name", "Contact"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_profile.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TBL_profile);

        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(BTN_pass)
                            .addComponent(BTN_delete)
                            .addComponent(BTN_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTN_name, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTN_c)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BTN_c, BTN_delete, BTN_logout, BTN_name, BTN_pass});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(BTN_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_c)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_pass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_logout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_delete)
                .addGap(35, 35, 35)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_nameActionPerformed

    private void BTN_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_cActionPerformed

    private void BTN_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_passActionPerformed

    private void BTN_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_deleteActionPerformed
        int result = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to delete your account?",
            "Delete Account Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (result == JOptionPane.YES_OPTION) {
            updateProfile.setUstatus("deleted");
            Utils.editFile("users.txt", this.updateProfile, User.class);
            jLabel8.setText("Account deleted.");
            updateProfile.logout(this);
        } else
        jLabel8.setText("Account deletion canceled.");
    }//GEN-LAST:event_BTN_deleteActionPerformed

    private void BTN_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_logoutActionPerformed
        updateProfile.logout(this);
    }//GEN-LAST:event_BTN_logoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_c;
    private javax.swing.JButton BTN_delete;
    private javax.swing.JButton BTN_logout;
    private javax.swing.JButton BTN_name;
    private javax.swing.JButton BTN_pass;
    private javax.swing.JTable TBL_profile;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
