/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment;
import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author zhusheng
 */
public class uiAddHall extends javax.swing.JFrame {
    private Scheduler scheduler;
    /**
     * Creates new form uiAddHall
     */
    public uiAddHall(){
        
    }
    public uiAddHall(Scheduler scheduler) {
        initComponents();
        setContentPane(addHall);
        this.scheduler = scheduler;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addHall = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hallSelector = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        lblHallFare = new javax.swing.JLabel();
        lblHallSeating = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addHall.setBackground(new java.awt.Color(255, 255, 255));
        addHall.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addHall.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Hall Type");

        hallSelector.setBackground(new java.awt.Color(255, 255, 255));
        hallSelector.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        hallSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auditorium", "Banquet Hall", "Meeting Room" }));
        hallSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hallSelectorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Add Hall");

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 0, 0));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblHallFare.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        lblHallFare.setForeground(new java.awt.Color(0, 0, 0));

        lblHallSeating.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        lblHallSeating.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout addHallLayout = new javax.swing.GroupLayout(addHall);
        addHall.setLayout(addHallLayout);
        addHallLayout.setHorizontalGroup(
            addHallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addHallLayout.createSequentialGroup()
                .addGroup(addHallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblHallSeating, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHallFare, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addHallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addHallLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(addHallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(addHallLayout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hallSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(addHallLayout.createSequentialGroup()
                            .addGap(166, 166, 166)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        addHallLayout.setVerticalGroup(
            addHallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addHallLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addHallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hallSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(lblHallFare, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHallSeating, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addHall, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addHall, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        scheduler.addHall(hallSelector.getSelectedItem().toString());
    }//GEN-LAST:event_btnAddActionPerformed

    private void hallSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hallSelectorActionPerformed
        if("Auditorium".equals(hallSelector.getSelectedItem().toString())){
            lblHallFare.setText("Rate per Hour: RM " + new Auditorium().getRatePerHour());
            lblHallSeating.setText("Number of seating: " + new Auditorium().getCapacity());
        }
        else if("Banquet Hall".equals(hallSelector.getSelectedItem().toString())){
            lblHallFare.setText("Rate per Hour: RM " + new Banquet().getRatePerHour());
            lblHallSeating.setText("Number of seating: " + new Banquet().getCapacity());
        }
        else if("Meeting Room".equals(hallSelector.getSelectedItem().toString())){
            lblHallFare.setText("Rate per Hour: RM " + new MeetingRoom().getRatePerHour());
            lblHallSeating.setText("Number of seating: " + new MeetingRoom().getCapacity());
        }
    }//GEN-LAST:event_hallSelectorActionPerformed

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
            java.util.logging.Logger.getLogger(uiAddHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uiAddHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uiAddHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uiAddHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uiAddHall().setVisible(true);
            }
        });
    }
    public JPanel getPanel(){
        return addHall;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addHall;
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> hallSelector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblHallFare;
    private javax.swing.JLabel lblHallSeating;
    // End of variables declaration//GEN-END:variables
}
