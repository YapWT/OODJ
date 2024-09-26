package assignment;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class uiManager extends javax.swing.JFrame {
    private String ID;
    private Booking booking = new Booking();
    private Issue issue = new Issue();
    private Manager manager = new Manager();

    public uiManager() {
        initComponents();
    }
    
    public uiManager(String ID) {
        initComponents();
        this.ID = ID;
        Utils.viewTable(salesTbl, "bookings.txt", Booking.class);
        Utils.viewTable(issueTbl, "issues.txt", Issue.class);
        manager.showScheduler(assignCbo);
        weekCbo.setEnabled(false);
        monthCbo.setEnabled(false);
        yearCbo.setEnabled(false);
        manager.showTotalEarnings(earningsLbl);
        manager.showTotalIssueInProgress(issuesLbl);
        manager.showTotalIssuePendingResponse(responseLbl);
        String managerName = (Utils.IDtoObject(ID, "users.txt", User.class)).getUname();
        jLabel1.setText(managerName);
        
        // update profile
        // updateProfile
        Panel_updateProfile PNL_profile = new Panel_updateProfile(ID, new User());
        jPanel8.setLayout(new BorderLayout());
        jPanel8.add(PNL_profile, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        earningsLbl = new javax.swing.JLabel();
        issuesLbl = new javax.swing.JLabel();
        responseLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesTbl = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        filterWeekBtn = new javax.swing.JButton();
        filterMonthBtn = new javax.swing.JButton();
        filterYearBtn = new javax.swing.JButton();
        weekCbo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        monthCbo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        yearCbo = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        issueTbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        assignCbo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 153));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("WELCOME,");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("TOTAL EARNINGS : ");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("ISSUE IN PROGRESS :");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("PENDING ISSUE RESPONSE :");

        earningsLbl.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        earningsLbl.setForeground(new java.awt.Color(0, 0, 0));
        earningsLbl.setText("jLabel6");

        issuesLbl.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        issuesLbl.setForeground(new java.awt.Color(0, 0, 0));
        issuesLbl.setText("jLabel16");

        responseLbl.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        responseLbl.setForeground(new java.awt.Color(0, 0, 0));
        responseLbl.setText("jLabel17");

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Name Name Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(260, 260, 260)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(earningsLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(issuesLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(responseLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(118, 118, 118))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(earningsLbl)
                        .addGap(18, 18, 18)
                        .addComponent(issuesLbl)
                        .addGap(18, 18, 18)
                        .addComponent(responseLbl))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addContainerGap(319, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("HOME", jPanel2);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("SALES DASHBOARD");

        salesTbl.setBackground(new java.awt.Color(204, 204, 204));
        salesTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salesTbl.setForeground(new java.awt.Color(0, 0, 0));
        salesTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Sales"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salesTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(salesTbl);

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("FILTER BY :");

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("VIEW");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("WEEK :");

        filterWeekBtn.setBackground(new java.awt.Color(102, 102, 102));
        filterWeekBtn.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        filterWeekBtn.setForeground(new java.awt.Color(255, 255, 255));
        filterWeekBtn.setText("WEEK");
        filterWeekBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterWeekBtnActionPerformed(evt);
            }
        });

        filterMonthBtn.setBackground(new java.awt.Color(102, 102, 102));
        filterMonthBtn.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        filterMonthBtn.setForeground(new java.awt.Color(255, 255, 255));
        filterMonthBtn.setText("MONTH");
        filterMonthBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterMonthBtnActionPerformed(evt);
            }
        });

        filterYearBtn.setBackground(new java.awt.Color(102, 102, 102));
        filterYearBtn.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        filterYearBtn.setForeground(new java.awt.Color(255, 255, 255));
        filterYearBtn.setText("YEAR");
        filterYearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterYearBtnActionPerformed(evt);
            }
        });

        weekCbo.setBackground(new java.awt.Color(102, 102, 102));
        weekCbo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        weekCbo.setForeground(new java.awt.Color(255, 255, 255));
        weekCbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Week 01", "Week 02", "Week 03", "Week 04", "Week 05", "Week 06", "Week 07", "Week 08", "Week 09", "Week 10", "Week 11", "Week 12", "Week 13", "Week 14", "Week 15", "Week 16", "Week 17", "Week 18", "Week 19", "Week 20", "Week 21", "Week 22", "Week 23", "Week 24", "Week 25", "Week 26", "Week 27", "Week 28", "Week 29", "Week 30", "Week 31", "Week 32", "Week 33", "Week 34", "Week 35", "Week 36", "Week 37", "Week 38", "Week 39", "Week 40", "Week 41", "Week 42", "Week 43", "Week 44", "Week 45", "Week 46", "Week 47", "Week 48", "Week 49", "Week 50", "Week 51", "Week 52", "Week 53" }));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("MONTH : ");

        monthCbo.setBackground(new java.awt.Color(102, 102, 102));
        monthCbo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        monthCbo.setForeground(new java.awt.Color(255, 255, 255));
        monthCbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("YEAR :");

        yearCbo.setBackground(new java.awt.Color(102, 102, 102));
        yearCbo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        yearCbo.setForeground(new java.awt.Color(255, 255, 255));
        yearCbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(jButton2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(filterWeekBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(filterMonthBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(filterYearBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(weekCbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(jLabel13)
                                    .addGap(18, 18, 18)
                                    .addComponent(monthCbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(39, 39, 39)
                                    .addComponent(jLabel14)
                                    .addGap(18, 18, 18)
                                    .addComponent(yearCbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {filterMonthBtn, filterWeekBtn, filterYearBtn});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(filterWeekBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterMonthBtn)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addComponent(weekCbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(monthCbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(yearCbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterYearBtn)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(25, 25, 25))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {filterMonthBtn, filterWeekBtn, filterYearBtn});

        jTabbedPane1.addTab("SALES DASHBOARD", jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("ISSUES MANAGEMENT");

        issueTbl.setBackground(new java.awt.Color(204, 204, 204));
        issueTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        issueTbl.setForeground(new java.awt.Color(0, 0, 0));
        issueTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Booking", "Description", "Response", "Status", "Assigned Staff"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        issueTbl.setColumnSelectionAllowed(true);
        issueTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(issueTbl);
        issueTbl.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ASSIGN SCHEDULER :");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("STATUS :");

        jComboBox4.setBackground(new java.awt.Color(102, 102, 102));
        jComboBox4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "In Progress", "Done", "Closed", "Cancelled" }));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("RESPONSE :");

        jTextField2.setBackground(new java.awt.Color(102, 102, 102));
        jTextField2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        assignCbo.setBackground(new java.awt.Color(102, 102, 102));
        assignCbo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        assignCbo.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(97, 97, 97)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(assignCbo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(104, 104, 104)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jTextField2)))
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jButton1)))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {assignCbo, jComboBox4});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(153, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assignCbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(55, 55, 55))))
        );

        jTabbedPane1.addTab("MAINTENANCE OPERATION", jPanel5);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 813, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("EDIT ACCOUNT", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterMonthBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterMonthBtnActionPerformed
        booking.getBookingFilter("month");
        weekCbo.setEnabled(false);
        monthCbo.setEnabled(true);
        yearCbo.setEnabled(true);
    }//GEN-LAST:event_filterMonthBtnActionPerformed

    private void filterWeekBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterWeekBtnActionPerformed
        booking.getBookingFilter("week");
        weekCbo.setEnabled(true);
        monthCbo.setEnabled(false);
        yearCbo.setEnabled(true);
    }//GEN-LAST:event_filterWeekBtnActionPerformed

    private void filterYearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterYearBtnActionPerformed
        booking.getBookingFilter("year");
        weekCbo.setEnabled(false);
        monthCbo.setEnabled(false);
        yearCbo.setEnabled(true);
    }//GEN-LAST:event_filterYearBtnActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);
        String selectedWeek = weekCbo.getSelectedItem().toString();
        String selectedYear = yearCbo.getSelectedItem().toString();

        // Initialize filter values
        Integer week = null;
        Integer month = null;
        Integer year = Integer.parseInt(selectedYear);
        
        if (weekCbo.isEnabled()) {
            String weekString = selectedWeek.replaceAll("\\D+", ""); // Extract week number
            week = Integer.parseInt(weekString);
        } else if (monthCbo.isEnabled()) {
            month = monthCbo.getSelectedIndex() + 1; // Get month number
        }

        // Create a filtered list based on the selected filters
        ArrayList<Booking> filteredBookings = new ArrayList<>();

        for (Booking booking : bookings) {
            // Check if booking matches selected filters
            if (booking.matchesFilters(booking, week, month, year)) {
                filteredBookings.add(booking);
            }
        }

        // Update the table with filtered data
        booking.updateSalesTable(filteredBookings, salesTbl);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int selectedRow = issueTbl.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select an issue from the table.");
            return;
        }
        String issueID = issueTbl.getValueAt(selectedRow, 0).toString();

        String newStatus = jComboBox4.getSelectedItem().toString();
        String newAssignedStaff = assignCbo.getSelectedItem().toString();
        String newResponse = jTextField2.getText();

        // chnage 3 thing
        issue.setIssueID(issueID);
        issue.setStatus(newStatus);
        issue.setAssignedStaff(newAssignedStaff);
        issue.setResponse(newResponse);
        Utils.editFile("issues.txt", issue, Issue.class);

        issueTbl.setValueAt(newStatus, selectedRow, 4);
        issueTbl.setValueAt(newAssignedStaff, selectedRow, 5);
        issueTbl.setValueAt(newResponse, selectedRow, 3);
        // update home's total issue in pending
        manager.showTotalIssueInProgress(issuesLbl);
        manager.showTotalIssuePendingResponse(responseLbl);
        
        jComboBox4.setSelectedIndex(0);
        assignCbo.setSelectedIndex(0);
        jTextField2.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(uiManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uiManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uiManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uiManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uiManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> assignCbo;
    private javax.swing.JLabel earningsLbl;
    private javax.swing.JButton filterMonthBtn;
    private javax.swing.JButton filterWeekBtn;
    private javax.swing.JButton filterYearBtn;
    private javax.swing.JTable issueTbl;
    private javax.swing.JLabel issuesLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox<String> monthCbo;
    private javax.swing.JLabel responseLbl;
    private javax.swing.JTable salesTbl;
    private javax.swing.JComboBox<String> weekCbo;
    private javax.swing.JComboBox<String> yearCbo;
    // End of variables declaration//GEN-END:variables
}
