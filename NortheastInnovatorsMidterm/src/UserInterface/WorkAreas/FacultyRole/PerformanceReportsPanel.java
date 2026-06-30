/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.FacultyRole;

import Business.Business;
import Business.Profiles.FacultyProfile;
import Business.Profiles.StudentProfile;
import Business.UniversityModel;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author mmoly
 */
public class PerformanceReportsPanel extends javax.swing.JPanel {
JPanel CardSequencePanel;
      Business business;
          private UniversityModel sharedData;
          FacultyProfile facultyProfile;
    /**
     * Creates new form PerformanceReportsPanel
     */
    public PerformanceReportsPanel(Business b,UniversityModel sharedData,FacultyProfile fpp, JPanel jp)  {
        this.facultyProfile= fpp;
        business = b;
        this.CardSequencePanel = jp;
        this.sharedData = new UniversityModel();       
        initComponents();
        
        populatePerformanceReportTable(business, PerformanceReports,txtGPA,txtStanding);
    }
public void populatePerformanceReportTable(Business business, JTable targetTable, javax.swing.JTextField txtGPAOutput, javax.swing.JTextField txtStandingOutput) { 
    String[] columnHeaders = {"Student Name", "Course Code", "Current Grade", "Semester"}; 
    
    DefaultTableModel model = new DefaultTableModel(columnHeaders, 0) { 
        @Override 
        public boolean isCellEditable(int row, int column) { 
            return column == 2; // Only the Grade column remains editable
        } 
    }; 

    if (business == null || targetTable == null) return; 
    
    java.util.ArrayList<StudentProfile> allStudents = business.getStudentDirectory().getList(); 
    
    for (StudentProfile student : allStudents) { 
        if (student == null) continue; 
        
        int assignmentCount = student.getSubmittedAssignments().size(); 
        String currentStudentName = student.getPerson().getPersonId();
        
        model.addRow(new Object[]{currentStudentName, "INFO 5100",  "A", "Spring 2026"}); 
        model.addRow(new Object[]{currentStudentName, "INFO 6205",  "A-", "Spring 2026"}); 
        model.addRow(new Object[]{currentStudentName, "INFO 6105",  "B+", "Fall 2025"}); 
        model.addRow(new Object[]{currentStudentName, "DAMG 6210",  "A", "Fall 2025"}); 
    } 
    
    targetTable.setModel(model); 

    // Baseline display settings
    if (txtGPAOutput != null) { txtGPAOutput.setText("3.68"); txtGPAOutput.setEditable(false); }
    if (txtStandingOutput != null) {
        txtStandingOutput.setText("Good");
        txtStandingOutput.setEditable(false);
        txtStandingOutput.setForeground(new java.awt.Color(46, 125, 50));
    }

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

        Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PerformanceReports = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtGPA = new javax.swing.JTextField();
        txtStanding = new javax.swing.JTextField();
        currentGPA = new javax.swing.JLabel();
        AcademicStanding = new javax.swing.JLabel();
        calculate = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 255, 204));

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        PerformanceReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        PerformanceReports.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(PerformanceReports);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Student Performance Reports");

        currentGPA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        currentGPA.setText("Current GPA");

        AcademicStanding.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AcademicStanding.setText("Academic Standing");

        calculate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        calculate.setText("Calculate GPA and Standing");
        calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(204, 255, 204));
        jTextField1.setText("To updates a grade, select the value in Current Grade Column and update. Use button to recalculate.  ");
        jTextField1.setBorder(null);
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
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Back)
                        .addGap(97, 97, 97)
                        .addComponent(calculate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AcademicStanding)
                            .addComponent(currentGPA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGPA, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStanding, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(158, 158, 158))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(currentGPA)
                            .addComponent(txtGPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AcademicStanding)
                            .addComponent(txtStanding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Back)
                            .addComponent(calculate))
                        .addGap(40, 40, 40))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        CardSequencePanel.remove(this);
        ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_BackActionPerformed

    private void calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateActionPerformed
      // 1. Force the table to stop active cell editing so the typed values are committed
    if (PerformanceReports.isEditing()) {
        PerformanceReports.getCellEditor().stopCellEditing();
    }

    DefaultTableModel model = (DefaultTableModel) PerformanceReports.getModel();
    if (model.getRowCount() == 0) return;

    // 2. Identify the target student name from the first row of data
    String targetStudent = model.getValueAt(0, 0).toString();
    
    double totalPoints = 0;
    int courseCount = 0;

    // 3. Scan the grid manually to tally grade metrics
    for (int i = 0; i < model.getRowCount(); i++) {
        String studentInRow = model.getValueAt(i, 0).toString();
        
        if (studentInRow.equals(targetStudent)) {
            String grade = model.getValueAt(i, 3).toString().trim().toUpperCase();
            
            double points = 0.0;
            switch (grade) {
                case "A":  points = 4.0; break;
                case "A-": points = 3.7; break;
                case "B+": points = 3.3; break;
                case "B":  points = 3.0; break;
                case "B-": points = 2.7; break;
                case "C+": points = 2.3; break;
                case "C":  points = 2.0; break;
                case "C-": points = 1.7; break;
                case "D":  points = 1.0; break;
                case "F":  points = 0.0; break;
                default:   points = 4.0; break;
            }
            totalPoints += points;
            courseCount++;
        }
    }

    // 4. Compute calculations
    double newGpa = (courseCount > 0) ? (totalPoints / courseCount) : 0.0;
    txtGPA.setText(String.format("%.2f", newGpa));

    // 5. Update the Academic Standing display styling definitions
    if (newGpa > 3.0) {
        txtStanding.setText("Good Standing");
        txtStanding.setForeground(new java.awt.Color(46, 125, 50)); // Green
    } 
    else if (newGpa == 3.0) {
        txtStanding.setText("Average Standing");
        txtStanding.setForeground(new java.awt.Color(218, 125, 0));  // Orange
    } 
    else if (newGpa <= 2.0) {
        txtStanding.setText("Poor Standing");
        txtStanding.setForeground(new java.awt.Color(198, 40, 40)); // Red
    } 
    else {
        txtStanding.setText("Below Average");
        txtStanding.setForeground(new java.awt.Color(218, 125, 0));
    }

    }//GEN-LAST:event_calculateActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AcademicStanding;
    private javax.swing.JButton Back;
    private javax.swing.JTable PerformanceReports;
    private javax.swing.JButton calculate;
    private javax.swing.JLabel currentGPA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtGPA;
    private javax.swing.JTextField txtStanding;
    // End of variables declaration//GEN-END:variables
}
