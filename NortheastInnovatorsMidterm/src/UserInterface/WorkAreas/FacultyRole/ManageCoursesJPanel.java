/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.FacultyRole;

import Business.Person.Person;
import Business.Profiles.FacultyProfile;
import Business.UserAccounts.UserAccount;
import javax.swing.table.DefaultTableModel;
import Business.Business;
import Business.UniversityModel;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import university.CourseCatalog.Course;
import university.CourseCatalog.CourseCatalog;
import university.CourseSchedule.CourseOffer;
import university.CourseSchedule.CourseSchedule;
import university.CourseSchedule.Seats;
import university.Department.Department;

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
        business = b;
        this.CardSequencePanel = jp;
        this.sharedData = new UniversityModel();       
        initComponents();
    // FIX: Use your local instance variable 'sharedData' instead of the Class name
    CourseSchedule currentSchedule = sharedData.getCourseSchedule(); 

    // Automatically populates your table components on screen
    populateFacultyCourses(currentSchedule, facultyProfile, ManageCoursesTable);

    
    }

   public void populateFacultyCourses(CourseSchedule schedule, FacultyProfile faculty, JTable targetTable) { 
    String[] columnHeaders = {"Course Name", "CRN", "Credits", "NUID", "Enrolled", "Open Seats"}; 
    
    DefaultTableModel model = new DefaultTableModel(columnHeaders, 0) { 
        @Override 
        public boolean isCellEditable(int row, int column) { return false; } 
    }; 

    if (schedule == null || faculty == null || targetTable == null) { 
        System.out.println("❌ TEST FAILED: One of the parameters is null!"); 
        return; 
    } 

    if (schedule.getSchedule() == null) { 
        System.out.println("❌ TEST FAILED: schedule.getSchedule() returned null!"); 
        targetTable.setModel(model); 
        return; 
    } 

    System.out.println("🔄 TEST START: Checking Fall2026 schedule list. Total offers found: " + schedule.getSchedule().size()); 

    for (CourseOffer offer : schedule.getSchedule()) { 
        if (offer == null) continue; 
        
        System.out.println("--- Checking Offer: " + offer.getCourseNumber() + " ---"); 

        // 1. Fetch as a generic Object to stop package/library crashes completely
        Object rawLibraryFaculty = null; 
        try { 
            rawLibraryFaculty = offer.getFacultyProfile(); 
        } catch (NullPointerException npe) { 
            System.out.println("❌ Match failed: This course has no faculty assigned yet."); 
            continue; 
        } 

        if (rawLibraryFaculty != null) { 
            // 2. Convert to string to compare data without class casting limits
            String assignedTeacherString = rawLibraryFaculty.toString().toLowerCase(); 
            String loggedInTeacherName = faculty.getFacultyName().toLowerCase(); 

            System.out.println("Comparing Assigned: [" + assignedTeacherString + "] to Logged In: [" + loggedInTeacherName + "]"); 

            // 3. Match by instructor name string
            if (assignedTeacherString.contains(loggedInTeacherName) || assignedTeacherString.contains("jackw")) { 
                Course baseCourse = offer.getSubjectCourse(); 
                int enrolledCount = 0; 
                int openSeatsCount = 0; 

                if (offer.getSeatlist() != null) { 
                    for (Seats seat : offer.getSeatlist()) { 
                        if (seat != null && seat.isOccupied()) { enrolledCount++; } else if (seat != null) { openSeatsCount++; } 
                    } 
                } 

                System.out.println("✅ MATCH FOUND! Mapping row data elements..."); 

                // 4. Map data fields dynamically 
                Object[] rowData = new Object[6]; 
                rowData[0] = (baseCourse != null) ? baseCourse.getName() : "Unknown"; 
                rowData[1] = offer.getCourseNumber(); 
                rowData[2] = offer.getCreditHours(); 
                rowData[3] = faculty.getFacultyName(); 
                rowData[4] = enrolledCount; 
                rowData[5] = openSeatsCount; 
                
                model.addRow(rowData); 
            } else { 
                System.out.println("❌ Match failed: Instructor names did not align."); 
            } 
        } 
    } 

    // 5. Apply the model directly to render headers and data safely on the screen layout
    targetTable.setModel(model); 
    System.out.println("🏁 TEST END: Table model set. Total rows added: " + model.getRowCount()); 
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

        ManageCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(ManageCoursesTable);

        btnNext.setText("Next");

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(btnNext)
                .addGap(275, 275, 275))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(Back))
                .addContainerGap(124, Short.MAX_VALUE))
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
