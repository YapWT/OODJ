package assignment;

import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class uiCustomer extends javax.swing.JFrame {
  Customer customer;
  Schedule schedule = new Schedule();

  String[] timeSlotComboStrings =
      new String[] {
        "8:00am", "9:00am", "10:00am", "11:00am", "12:00pm", "1:00pm", "2:00pm", "3:00pm", "4:00pm",
        "5:00pm", "6:00pm"
      };

  public uiCustomer() {
    initComponents();
  }

  public uiCustomer(User customer) {
    this.customer = (Customer) customer;
    System.out.println(customer.toString());
    initComponents();

    datePicker.setDateToToday();
    for (String slot : timeSlotComboStrings) {
      startSlot.addItem(slot);
      endSlot.addItem(slot);
    }

    ArrayList<Hall> halls = FileOperations.read("halls.txt", Hall.class);
    for (Hall hall : halls) {
        if(!hall.getHallStatus().equals("Inactive")) {
            hallComboBox.addItem(hall.getHallID());
        }
    }

    datePicker.addDateChangeListener(
        new DateChangeListener() {
          public void dateChanged(DateChangeEvent event) {
            datePicker.setDate(event.getNewDate());
            schedule.setScheduleDate(datePicker.getDate());
            if (Schedule.checkIfScheduleExists(datePicker.getDate(), hallComboBox.getSelectedItem().toString())) {
                schedule = Schedule.scheduleObjectify(datePicker.getDate(), hallComboBox.getSelectedItem().toString());
            } else {
                schedule.setScheduleDate(datePicker.getDate());
                schedule.setHallID(hallComboBox.getSelectedItem().toString());
                String[] scheduleSlots = new String[10];
                Arrays.fill(scheduleSlots, "available");

                schedule.setTimeSlot(scheduleSlots);
                FileOperations.write("schedules.txt", schedule);
            }
            Schedule.displaySchedule(scheduleTable, schedule);
          }
        });
    
    Booking.displayBookingsTable(filterBookingTable, "All", customer.getUid());
    Booking.displayBookingsTable(cancelBookingsTable, "All", customer.getUid());
    ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);
    for(Booking booking : bookings){
        if(booking.getCustomer().getUid().equals(customer.getUid()) && !booking.getBookingStatus().equals("cancelled")){
            cancelBookingCombo.addItem(booking.getBookingID());
        }
        if(booking.getCustomer().getUid().equals(customer.getUid()) && !booking.getBookingStatus().equals("cancelled") && !booking.getIssue().isEmpty()){
            raiseIssueCombo.addItem(booking.getBookingID());
        }
    }
    Customer.displayIssueTable(issueTable, customer.getUid());
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        hallComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scheduleTable = new javax.swing.JTable();
        hallTypeLBL = new javax.swing.JLabel();
        capacityLBL = new javax.swing.JLabel();
        RatePerHourLBL = new javax.swing.JLabel();
        datePicker = new com.github.lgooddatepicker.components.DatePicker();
        jLabel6 = new javax.swing.JLabel();
        startSlot = new javax.swing.JComboBox<>();
        endSlot = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bookHallBtn = new javax.swing.JButton();
        bookStatus = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        filterBookingTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        filterAllBtn = new javax.swing.JButton();
        filterPastBtn = new javax.swing.JButton();
        filterUpcomingBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cancelBookingsTable = new javax.swing.JTable();
        cancelBookingCombo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cancelBookingBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        issueTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        raiseIssueCombo = new javax.swing.JComboBox<>();
        issueDesc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        submitIssueBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Customer Menu");

        jButton5.setText("Logout");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTabbedPane1.setToolTipText("Book New Hall");

        hallComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hallComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Select Hall:");

        jLabel3.setText("Capacity:");

        jLabel4.setText("Hall Type:");

        jLabel5.setText("Rate Per Hour:");

        scheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Availability"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scheduleTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(scheduleTable);
        if (scheduleTable.getColumnModel().getColumnCount() > 0) {
            scheduleTable.getColumnModel().getColumn(0).setResizable(false);
            scheduleTable.getColumnModel().getColumn(1).setResizable(false);
        }

        datePicker.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                datePickerFocusGained(evt);
            }
        });

        jLabel6.setText("Select Date:");

        startSlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSlotActionPerformed(evt);
            }
        });

        jLabel7.setText("Select time slot:");

        jLabel8.setText("to");

        bookHallBtn.setText("Book Hall");
        bookHallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookHallBtnActionPerformed(evt);
            }
        });

        bookStatus.setMaximumSize(new java.awt.Dimension(100, 30));
        bookStatus.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hallTypeLBL))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(capacityLBL))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hallComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(RatePerHourLBL))
                                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(startSlot, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(endSlot, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(19, 19, 19))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(bookHallBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bookStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hallComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(hallTypeLBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(capacityLBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(RatePerHourLBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(bookHallBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
        );

        jTabbedPane1.addTab("Book New Hall", jPanel1);

        filterBookingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookingID", "HallID", "Start Time", "End Time", "Total Price", "Booking Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(filterBookingTable);
        if (filterBookingTable.getColumnModel().getColumnCount() > 0) {
            filterBookingTable.getColumnModel().getColumn(0).setResizable(false);
            filterBookingTable.getColumnModel().getColumn(1).setResizable(false);
            filterBookingTable.getColumnModel().getColumn(2).setResizable(false);
            filterBookingTable.getColumnModel().getColumn(3).setResizable(false);
            filterBookingTable.getColumnModel().getColumn(4).setResizable(false);
            filterBookingTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel9.setText("Filter reservations by:");

        filterAllBtn.setText("All");
        filterAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterAllBtnActionPerformed(evt);
            }
        });

        filterPastBtn.setText("Past");
        filterPastBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterPastBtnActionPerformed(evt);
            }
        });

        filterUpcomingBtn.setText("Upcoming");
        filterUpcomingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterUpcomingBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterAllBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterPastBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterUpcomingBtn)
                .addGap(81, 81, 81))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(filterAllBtn)
                    .addComponent(filterPastBtn)
                    .addComponent(filterUpcomingBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("View Bookings", jPanel2);

        cancelBookingsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookingID", "HallID", "Start Time", "End Time", "Total Price", "Booking Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cancelBookingsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(cancelBookingsTable);
        if (cancelBookingsTable.getColumnModel().getColumnCount() > 0) {
            cancelBookingsTable.getColumnModel().getColumn(0).setResizable(false);
            cancelBookingsTable.getColumnModel().getColumn(1).setResizable(false);
            cancelBookingsTable.getColumnModel().getColumn(2).setResizable(false);
            cancelBookingsTable.getColumnModel().getColumn(3).setResizable(false);
            cancelBookingsTable.getColumnModel().getColumn(4).setResizable(false);
            cancelBookingsTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel10.setText("Select Booking:");

        cancelBookingBtn.setText("Cancel Booking");
        cancelBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBookingBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBookingCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(cancelBookingBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelBookingCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelBookingBtn)
                .addGap(0, 72, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cancel Bookings", jPanel3);

        issueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookingID", "Booking Date", "Issue Desc.", "Isssue Response", "Issue Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        issueTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(issueTable);

        jLabel11.setText("Select bookingID that you would like to raise an issue:");

        jLabel12.setText("Issue Description:");

        submitIssueBtn.setText("Submit");
        submitIssueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitIssueBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(issueDesc)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(raiseIssueCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(submitIssueBtn)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(raiseIssueCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(issueDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitIssueBtn)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Raise Issue", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterAllBtnActionPerformed
       Booking.displayBookingsTable(filterBookingTable, "All", customer.getUid());
    }//GEN-LAST:event_filterAllBtnActionPerformed

    private void filterPastBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterPastBtnActionPerformed
        Booking.displayBookingsTable(filterBookingTable, "Past", customer.getUid());
    }//GEN-LAST:event_filterPastBtnActionPerformed

    private void filterUpcomingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterUpcomingBtnActionPerformed
        Booking.displayBookingsTable(filterBookingTable, "Up Coming", customer.getUid());
    }//GEN-LAST:event_filterUpcomingBtnActionPerformed

    private void cancelBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBookingBtnActionPerformed
        Booking.cancelBooking(cancelBookingCombo.getSelectedItem().toString(), customer.getUid());
        Booking.displayBookingsTable(cancelBookingsTable, "All", customer.getUid());
        cancelBookingCombo.removeAllItems();
        ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);
        for(Booking booking : bookings){
            if(booking.getCustomer().getUid().equals(customer.getUid()) && !booking.getBookingStatus().equals("cancelled")){
                cancelBookingCombo.addItem(booking.getBookingID());
            }
            if(booking.getCustomer().getUid().equals(customer.getUid()) && !booking.getBookingStatus().equals("cancelled") && booking.getIssue().isEmpty()){
                raiseIssueCombo.addItem(booking.getBookingID());
            }
        }
    }//GEN-LAST:event_cancelBookingBtnActionPerformed

    private void submitIssueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitIssueBtnActionPerformed
        customer.createIssue(raiseIssueCombo.getSelectedItem().toString(), issueDesc.getText());
        Customer.displayIssueTable(issueTable, customer.getUid());
        issueDesc.setText("");
        raiseIssueCombo.removeAllItems();
        ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);
        for(Booking booking : bookings){
            if(booking.getCustomer().getUid().equals(customer.getUid()) && !booking.getBookingStatus().equals("cancelled") && booking.getIssue().isEmpty()){
                raiseIssueCombo.addItem(booking.getBookingID());
            }
        }
    }//GEN-LAST:event_submitIssueBtnActionPerformed

  private void datePickerFocusGained(
      java.awt.event.FocusEvent evt) { // GEN-FIRST:event_datePickerFocusGained
    datePicker.setDateToToday();
  } // GEN-LAST:event_datePickerFocusGained

  private void bookHallBtnActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_bookHallBtnActionPerformed
    if (startSlot.getSelectedIndex() >= endSlot.getSelectedIndex()) {
      bookStatus.setText("Start time must be before end time!");
    } else {
      int[] bookingSlot = new int[] {startSlot.getSelectedIndex() + 1, endSlot.getSelectedIndex() + 1};
      try {
          if(datePicker.getDate().isBefore(LocalDate.now())){
              JOptionPane.showMessageDialog(null, "You can't book a hall that is in the past!");
          } else {
            customer.bookHalls(
          hallComboBox.getSelectedItem().toString(), bookingSlot, datePicker.getDate());
            JOptionPane.showMessageDialog(null, "Hall booked");
            bookStatus.setText(" ");
          }
      } catch (IllegalArgumentException e) {
          bookStatus.setText("You included unavailable timeslots");
      }

      
      schedule = Schedule.scheduleObjectify(datePicker.getDate(), hallComboBox.getSelectedItem().toString());
      Schedule.displaySchedule(scheduleTable, schedule);
      Booking.displayBookingsTable(filterBookingTable, "All", customer.getUid());
      Booking.displayBookingsTable(cancelBookingsTable, "All", customer.getUid());
      Customer.displayIssueTable(issueTable, customer.getUid());
      ArrayList<Booking> bookings = FileOperations.read("bookings.txt", Booking.class);
      for(Booking booking : bookings){
          if(booking.getCustomer().getUid().equals(customer.getUid()) && !booking.getBookingStatus().equals("cancelled")){
              cancelBookingCombo.addItem(booking.getBookingID());
          }
          if(booking.getCustomer().getUid().equals(customer.getUid()) && !booking.getBookingStatus().equals("cancelled") && booking.getIssue().isEmpty()){      
              raiseIssueCombo.addItem(booking.getBookingID());
          }
      }
    }
  } // GEN-LAST:event_bookHallBtnActionPerformed

  private void startSlotActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_startSlotActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_startSlotActionPerformed

  private void jButton5ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton5ActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_jButton5ActionPerformed

  private void hallComboBoxActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_hallComboBoxActionPerformed
    // TODO add your handling code here:
    String selectedHall = hallComboBox.getSelectedItem().toString();
    Hall hall = Utils.IDtoObject(selectedHall, "halls.txt", Hall.class);

    hallTypeLBL.setText(hall.getHallType());
    capacityLBL.setText(Integer.toString(hall.getCapacity()));
    RatePerHourLBL.setText(Integer.toString(hall.getRatePerHour()));

    if (Schedule.checkIfScheduleExists(datePicker.getDate(), selectedHall)) {
      schedule = Schedule.scheduleObjectify(datePicker.getDate(), selectedHall);
    } else {
      schedule.setScheduleDate(datePicker.getDate());
      schedule.setHallID(selectedHall);
      String[] scheduleSlots = new String[10];
      Arrays.fill(scheduleSlots, "available");

      schedule.setTimeSlot(scheduleSlots);
      FileOperations.write("schedules.txt", schedule);
    }
    Schedule.displaySchedule(scheduleTable, schedule);
  } // GEN-LAST:event_hallComboBoxActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(uiCustomer.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(uiCustomer.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(uiCustomer.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(uiCustomer.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new uiCustomer().setVisible(true);
          }
        });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RatePerHourLBL;
    private javax.swing.JButton bookHallBtn;
    private javax.swing.JLabel bookStatus;
    private javax.swing.JButton cancelBookingBtn;
    private javax.swing.JComboBox<String> cancelBookingCombo;
    private javax.swing.JTable cancelBookingsTable;
    private javax.swing.JLabel capacityLBL;
    private com.github.lgooddatepicker.components.DatePicker datePicker;
    private javax.swing.JComboBox<String> endSlot;
    private javax.swing.JButton filterAllBtn;
    private javax.swing.JTable filterBookingTable;
    private javax.swing.JButton filterPastBtn;
    private javax.swing.JButton filterUpcomingBtn;
    private javax.swing.JComboBox<String> hallComboBox;
    private javax.swing.JLabel hallTypeLBL;
    private javax.swing.JTextField issueDesc;
    private javax.swing.JTable issueTable;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> raiseIssueCombo;
    private javax.swing.JTable scheduleTable;
    private javax.swing.JComboBox<String> startSlot;
    private javax.swing.JButton submitIssueBtn;
    // End of variables declaration//GEN-END:variables
}
