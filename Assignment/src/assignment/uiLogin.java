package assignment;

public class uiLogin extends javax.swing.JFrame {    
    ClassLogin cl;
    
    public uiLogin() {
        initComponents();
        LBL_message.setVisible(false);
        cl = new ClassLogin();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TXT_id = new javax.swing.JTextField();
        TXT_pass = new javax.swing.JPasswordField();
        BTN_exit = new javax.swing.JButton();
        BTN_login = new javax.swing.JButton();
        BTN_register = new javax.swing.JButton();
        LBL_message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setText("Title");

        jLabel2.setText("User ID");

        jLabel3.setText("Password");

        BTN_exit.setText("Exit");
        BTN_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_exitActionPerformed(evt);
            }
        });

        BTN_login.setText("Login");
        BTN_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_loginActionPerformed(evt);
            }
        });

        BTN_register.setText("Register");
        BTN_register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_registerActionPerformed(evt);
            }
        });

        LBL_message.setText("Message Area");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXT_id, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTN_exit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_register)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_login))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LBL_message, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(84, 84, 84))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXT_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_exit)
                    .addComponent(BTN_login)
                    .addComponent(BTN_register))
                .addGap(31, 31, 31)
                .addComponent(LBL_message)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BTN_exitActionPerformed

    private void BTN_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_loginActionPerformed

        cl.setUid(TXT_id.getText());
        cl.setUpass(TXT_pass.getText());
        
        String check = cl.checkUser();
        String type = cl.getUtype(); 
        // S - scheduler, C - customer, A - admin, M - manager
        
        if (check.equals("Login") | check.equals("pending")) {
            this.dispose();
            switch (type) {
                case "A":
                    new uiAdmin(cl.getUid()).setVisible(true);
                    break;
                case "C":
                    new uiCustomer(cl.getUid()).setVisible(true);
                    break;
                case "M":
                    new uiManager(cl.getUid()).setVisible(true);
                    break;
                case "S":
                    new uiScheduler(cl.getUid()).setVisible(true);
                    break;
                default:
                    break;
                }
        } else {
            LBL_message.setVisible(true);
            if (check.equals("Failed"))
                LBL_message.setText("Invalid User ID or Password. Please Try Again. ");
            else if (check.equals("block"))
                LBL_message.setText("Your account is blocked. ");
            else
                LBL_message.setText("Your account has been deactivated. ");
        }
    }//GEN-LAST:event_BTN_loginActionPerformed

    private void BTN_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_registerActionPerformed
        // customer register
    }//GEN-LAST:event_BTN_registerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uiLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_exit;
    private javax.swing.JButton BTN_login;
    private javax.swing.JButton BTN_register;
    private javax.swing.JLabel LBL_message;
    private javax.swing.JTextField TXT_id;
    private javax.swing.JPasswordField TXT_pass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
