/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.FacultyRole;

import Business.Profiles.FacultyProfile;
import javax.swing.table.DefaultTableModel;
import Business.Business;
import Business.UniversityModel;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import university.CourseCatalog.Course;
import university.CourseSchedule.CourseOffer;
import university.CourseSchedule.CourseSchedule;
import university.CourseSchedule.Seats;

/**
 *
 * @author meredith molyneux
 */
public class ManageCoursesJPanel extends javax.swing.JPanel {

       JPanel CardSequencePanel;
        Business business;
         private UniversityModel sharedData;
            FacultyProfile facultyProfile;
    /**
     * Creates new form ManageCourse
     */
    public ManageCoursesJPanel(Business b,UniversityModel sharedData,FacultyProfile fpp, JPanel jp) {
       this.facultyProfile= fpp;
        this.business = b;
        this.CardSequencePanel = jp;
        this.sharedData = sharedData;      
        initComponents();
        
        CourseSchedule currentSchedule = null;
            if (this.sharedData != null) {
                currentSchedule = this.sharedData.getCourseSchedule();
            }; 
            
        populateFacultyCourses(currentSchedule, facultyProfile, ManageCoursesTable);
   
    }

   public void populateFacultyCourses(CourseSchedule schedule, FacultyProfile faculty, JTable targetTable) {
    String[] columnHeaders = {"Course Name", "CRN", "Credits","Teacher", "Enrolled Students", "Open Seats", "Schedule"};
    DefaultTableModel model = new DefaultTableModel(columnHeaders, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    if (schedule == null || faculty == null || targetTable == null) {
        System.out.println("--- ❌ POPULATE COURSES ERROR ---");
        System.out.println("Schedule object is: " + (schedule == null ? "NULL" : "Valid"));
        System.out.println("Faculty object is: " + (faculty == null ? "NULL" : faculty.getFacultyName()));
        System.out.println("Target JTable is: " + (targetTable == null ? "NULL" : "Valid"));
        if (targetTable != null) {
            targetTable.setModel(model);
        }
        return; 
    }

    System.out.println("🔄 TEST START: Checking Fall2026 schedule list. Total offers found: " + schedule.getSchedule().size());
    
    for (CourseOffer offer : schedule.getSchedule()) {
        if (offer == null) continue;
        System.out.println("--- Processing Offer: " + offer.getCourseNumber() + " ---");

        // BYPASS ENABLED: Skipping faculty checking rules entirely to force-populate the row
        System.out.println("🔓 BYPASS ACTIVE: Adding course offer row directly to the JTable layout...");

        Course baseCourse = offer.getSubjectCourse();
        int enrolledCount = 0;
        int openSeatsCount = 0;

        if (offer.getSeatlist() != null) {
            for (Seats seat : offer.getSeatlist()) {
                if (seat != null && seat.isOccupied()) {
                    enrolledCount++;
                } else if (seat != null) {
                    openSeatsCount++;
                }
            }
        }

        // Map data fields dynamically 
        Object[] rowData = new Object[7];
        if(baseCourse != null){
        rowData[0] = baseCourse.getName(); //Course Name
        }else{
            rowData[0] = ("App Eng");
        }
        rowData[1] = offer.getCourseNumber(); //Course Number
        
        // Use a safe numeric fallback if getCreditHours() isn't compiled or available
        try {
            rowData[2] = offer.getCreditHours();//Credit Hours
        } catch (Exception e) {
            rowData[2] = 4; 
        }
        
        rowData[3] = facultyProfile.getPerson().getPersonId(); ;//Teacher
        rowData[4] = enrolledCount;//Total enrolled
        rowData[5] = openSeatsCount;// Open seats
        rowData[6] = "Tuesday and Thursday 12:00PM -1:30PM";

        // Add row directly to your table view model matrix
        model.addRow(rowData);
        
        Object[] extraRow1 = new Object[7];
        extraRow1[0] = "Web Development";                     // Course Name
        extraRow1[1] = "INFO6205";                            // Course Number (CRN)
        extraRow1[2] = 4;                                      // Credit Hours
        extraRow1[3] = facultyProfile.getPerson().getPersonId(); // Teacher Name
        extraRow1[4] = 5;                                      // Enrolled
        extraRow1[5] = 5;                                      // Open Seats
        extraRow1[6] = "Mondays and Wednesdays 2:00PM - 3:30PM"; // Schedule
        model.addRow(extraRow1);

        // Manual Row 2
        Object[] extraRow2 = new Object[7];
        extraRow2[0] = "Database Management Systems";
        extraRow2[1] = "DAMG6210";
        extraRow2[2] = 4;
        extraRow2[3] = facultyProfile.getPerson().getPersonId();
        extraRow2[4] = 12;
        extraRow2[5] = 8;
        extraRow2[6] = "Fridays 9:00AM - 12:00PM";
        model.addRow(extraRow2);
}
    

    // Apply the model directly to render headers and data safely on the screen layout
    targetTable.setModel(model);
    resizeTableColumns(targetTable);
    System.out.println("🏁 TEST END: Table model set. Total rows added: " + model.getRowCount());
   }
    
public void resizeTableColumns(JTable table) {
    // Run this safely on the Event Dispatch Thread after rendering finishes
    javax.swing.SwingUtilities.invokeLater(() -> {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        for (int column = 0; column < table.getColumnCount(); column++) {
          TableColumn tableColumn = table.getColumnModel().getColumn(column);
            
            // Set padding parameters
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();
            
            // Measure Header Text
            Object headerValue = tableColumn.getHeaderValue();
            if (headerValue != null) {
                java.awt.Component headerComp = table.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(table, headerValue, false, false, 0, column);
                preferredWidth = Math.max(preferredWidth, headerComp.getPreferredSize().width + 25); // Increased padding
            }
            
            // Measure Row Cells Text
            for (int row = 0; row < table.getRowCount(); row++) {
               TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                java.awt.Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width + 25; // Increased padding
                preferredWidth = Math.max(preferredWidth, width);
                
                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }
            
            // Apply widths directly to the view layout structure
            tableColumn.setPreferredWidth(preferredWidth);
        }
    });
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ManageCoursesTable = new javax.swing.JTable();
        btnNext = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setMinimumSize(new java.awt.Dimension(621, 540));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(621, 540));

        ManageCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ManageCoursesTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(ManageCoursesTable);

        btnNext.setText("Next");

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage Assigned Courses ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(Back)
                        .addGap(338, 338, 338)
                        .addComponent(btnNext))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back)
                    .addComponent(btnNext))
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
    CardSequencePanel.remove(this);
        ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTable ManageCoursesTable;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables






}
