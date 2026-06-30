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
import university.CourseSchedule.CourseSchedule;

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
    // 8 columns defined here
    String[] columnHeaders = {"Semester", "Course Name", "CRN", "Credits", "Teacher", "Enrolled", "Open Seats", "Schedule"}; 
    
    DefaultTableModel model = new DefaultTableModel(columnHeaders, 0) { 
        @Override 
        public boolean isCellEditable(int row, int column) { 
        return column == 5; 
        }
    }; 

        int totalCount = 10;
        int enrolledCount = 0; 
        int openSeatsCount = totalCount - enrolledCount; 
       
        Object[] rowData = new Object[8]; 
        rowData[0] = "Fall 2026"; // Semester
        rowData[1] = "App Eng";       
        rowData[2] = "INFO5100"; // CRN
        rowData[3] = 4; 
        rowData[4] = faculty.getPerson().getPersonId(); // Teacher 
        rowData[5] = enrolledCount; // Enrolled Students 
        rowData[6] = openSeatsCount; // Open Seats 
        rowData[7] = "Tuesday and Thursday 12:00PM - 1:30PM"; // Schedule 

        // Add dynamic row
        model.addRow(rowData); 
    

    // FIX 3: Cleaned up curly quotes, stray semicolons, and commas in manual rows
    model.addRow(new Object[]{"Fall 2026", "Data Science Fundamentals", "INFO7300", 4, faculty.getPerson().getPersonId(), 8,2, "Saturdays 1:00PM - 4:00PM"}); 
    model.addRow(new Object[]{"Spring 2026", "Web Development", "INFO6205", 4, faculty.getPerson().getPersonId(), 5, 5, "Mondays and Wednesdays 2:00PM - 3:30PM"}); 
    model.addRow(new Object[]{"Fall 2025", "Database Systems", "DAMG6210", 4, faculty.getPerson().getPersonId(), 2, 8, "Fridays 9:00AM - 12:00PM"}); 

    // Apply the data model to the visual table layout UI component
    targetTable.setModel(model);
     // 2. Add the mathematical listener to recalculate open seats on user edits
    model.addTableModelListener(new javax.swing.event.TableModelListener() {
        @Override
        public void tableChanged(javax.swing.event.TableModelEvent e) {
            if (e.getType() == javax.swing.event.TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                // Track changes made strictly inside Column 5 (Enrolled Students)
                if (column == 5) {
                    try {
                        // Extract the newly typed numeric enrollment value
                        int updatedEnrolled = Integer.parseInt(model.getValueAt(row, 5).toString().trim());
                        
                        // Define your maximum course seat limits per room (e.g., 10 seats max capacity)
                        int maxCapacity = 10; 
                        
                        // Core Equation: Open Seats = Max Capacity - Enrolled
                        int recalculatedOpenSeats = maxCapacity - updatedEnrolled;

                        // Ensure open seats don't display negative values if overridden
                        if (recalculatedOpenSeats < 0) {
                            recalculatedOpenSeats = 0;
                        }

                        // Temporarily decouple listener to avoid cyclical infinite loop triggers
                        model.removeTableModelListener(this);
                        
                        // Push the calculated value directly into Column 6 (Open Seats)
                        model.setValueAt(recalculatedOpenSeats, row, 6);
                        
                        // Re-couple the listener event monitoring system
                        model.addTableModelListener(this);
                        
                    } catch (NumberFormatException nfe) {
                        // Catch typo block errors and pop up a warning window
                        javax.swing.JOptionPane.showMessageDialog(targetTable, 
                            "Please enter a valid whole number for enrollment.", 
                            "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    });
    
    
    // Auto-fit lengths
    targetTable.getTableHeader().setResizingColumn(null);
    resizeTableColumns(targetTable);
}


    

public void resizeTableColumns(JTable table) {
    javax.swing.SwingUtilities.invokeLater(() -> {
        // Enforce off-resize to let columns push out past panel borders naturally
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            
            // FIX 1: Hardcode 150px as the absolute starting minimum width
            int preferredWidth = 150; 
            int maxWidth = tableColumn.getMaxWidth();
            
            // Measure Header Length
            Object headerValue = tableColumn.getHeaderValue();
            if (headerValue != null) {
                java.awt.Component headerComp = table.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(table, headerValue, false, false, 0, column);
                preferredWidth = Math.max(preferredWidth, headerComp.getPreferredSize().width + 30);
            }
            
            // Measure Row Text Lengths
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                java.awt.Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width + 30; // 30px padding
                preferredWidth = Math.max(preferredWidth, width);
            }
            
            // Enforce maximum boundaries if explicitly constrained
            if (preferredWidth >= maxWidth) {
                preferredWidth = maxWidth;
            }
            
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
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 255, 204));
        setMinimumSize(new java.awt.Dimension(801, 447));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(801, 447));

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

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage Assigned Courses ");

        jTextField1.setText("To updated the open seats in the course selected Enrolled Students and updates value. ");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                            .addComponent(jTextField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(Back)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Back)
                .addGap(84, 84, 84))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
    CardSequencePanel.remove(this);
        ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTable ManageCoursesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables






}
