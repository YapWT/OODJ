package assignment;

import java.awt.BorderLayout;

public class uiScheduler extends javax.swing.JFrame {
    Scheduler currentScheduler = new Scheduler();
    private String ID;
    public uiScheduler() {
        initComponents();
    }
    
    public uiScheduler(String ID) {
        initComponents();
        this.ID = ID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        viewHall = new javax.swing.JButton();
        SchedulerPanel = new javax.swing.JPanel();
        scheduleHall = new javax.swing.JButton();
        editHall = new javax.swing.JButton();
        addHall = new javax.swing.JButton();
        btnUpdateProfile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Scheduler Panel");

        viewHall.setBackground(new java.awt.Color(255, 255, 255));
        viewHall.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        viewHall.setForeground(new java.awt.Color(0, 0, 0));
        viewHall.setText("View Hall");
        viewHall.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        viewHall.setBorderPainted(false);
        viewHall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewHallActionPerformed(evt);
            }
        });

        SchedulerPanel.setBackground(new java.awt.Color(255, 255, 255));
        SchedulerPanel.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout SchedulerPanelLayout = new javax.swing.GroupLayout(SchedulerPanel);
        SchedulerPanel.setLayout(SchedulerPanelLayout);
        SchedulerPanelLayout.setHorizontalGroup(
            SchedulerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );
        SchedulerPanelLayout.setVerticalGroup(
            SchedulerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        scheduleHall.setBackground(new java.awt.Color(255, 255, 255));
        scheduleHall.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        scheduleHall.setForeground(new java.awt.Color(0, 0, 0));
        scheduleHall.setText("Hall Schedule");
        scheduleHall.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scheduleHall.setBorderPainted(false);
        scheduleHall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleHallActionPerformed(evt);
            }
        });

        editHall.setBackground(new java.awt.Color(255, 255, 255));
        editHall.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        editHall.setForeground(new java.awt.Color(0, 0, 0));
        editHall.setText("Edit Hall");
        editHall.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        editHall.setBorderPainted(false);
        editHall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editHallActionPerformed(evt);
            }
        });

        addHall.setBackground(new java.awt.Color(255, 255, 255));
        addHall.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        addHall.setForeground(new java.awt.Color(0, 0, 0));
        addHall.setText("Add Hall");
        addHall.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addHall.setBorderPainted(false);
        addHall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHallActionPerformed(evt);
            }
        });

        btnUpdateProfile.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdateProfile.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnUpdateProfile.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdateProfile.setText("My Profile");
        btnUpdateProfile.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnUpdateProfile.setBorderPainted(false);
        btnUpdateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewHall, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(scheduleHall, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editHall, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addHall, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                            .addComponent(btnUpdateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(SchedulerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(viewHall, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addHall, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editHall, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scheduleHall, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(SchedulerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addHallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHallActionPerformed
        SchedulerPanel.removeAll();
        SchedulerPanel.repaint();
        SchedulerPanel.add(new uiAddHall(currentScheduler).getPanel());// TODO add your handling code here:
    }//GEN-LAST:event_addHallActionPerformed

    private void editHallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editHallActionPerformed
        SchedulerPanel.removeAll();
        SchedulerPanel.repaint();
        SchedulerPanel.add(new uiEditHall(currentScheduler).getPanel());
    }//GEN-LAST:event_editHallActionPerformed

    private void viewHallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewHallActionPerformed
        SchedulerPanel.removeAll();
        SchedulerPanel.repaint();
        SchedulerPanel.add(new uiViewHall(currentScheduler).getPanel());
        
    }//GEN-LAST:event_viewHallActionPerformed

    private void scheduleHallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleHallActionPerformed
        SchedulerPanel.removeAll();
        SchedulerPanel.repaint();
        SchedulerPanel.add(new uiScheduleHall().getPanel());
    }//GEN-LAST:event_scheduleHallActionPerformed

    private void btnUpdateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProfileActionPerformed
        SchedulerPanel.removeAll();
        Panel_updateProfile myprofile = new Panel_updateProfile(ID, new User());
        SchedulerPanel.setLayout(new BorderLayout());
        SchedulerPanel.add(myprofile, BorderLayout.CENTER);
        SchedulerPanel.revalidate();

    }//GEN-LAST:event_btnUpdateProfileActionPerformed

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
            java.util.logging.Logger.getLogger(uiScheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uiScheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uiScheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uiScheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uiScheduler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SchedulerPanel;
    private javax.swing.JButton addHall;
    private javax.swing.JButton btnUpdateProfile;
    private javax.swing.JButton editHall;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton scheduleHall;
    private javax.swing.JButton viewHall;
    // End of variables declaration//GEN-END:variables
}
