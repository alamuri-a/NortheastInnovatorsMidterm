/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.FacultyRole;

import Business.Profiles.FacultyProfile;
import javax.swing.table.DefaultTableModel;
import Business.Business;
import Business.Profiles.StudentAccount;
import Business.Profiles.StudentProfile;
import Business.UniversityModel;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author meredith molyneux
 */
public class ManageStudentProfileJPanel extends javax.swing.JPanel {

       JPanel CardSequencePanel;
        Business business;
          private UniversityModel sharedData;
           FacultyProfile facultyProfile;
           StudentAccount studentAccount;
        //final UserAccount user;
    /**
     * Creates new form ManageStudents
     */
    public ManageStudentProfileJPanel(Business b,UniversityModel sharedData,FacultyProfile fpp, JPanel jp) {
        this.facultyProfile= fpp;
        business = b;
        this.CardSequencePanel = jp;
        this.sharedData = new UniversityModel();       
        initComponents();
        
         
        populateStudentRosterTable(business,ManageStudentTable);
    
    }
  public void populateStudentRosterTable(Business business, JTable targetTable) {
    String[] columnHeaders = {"Semester","Student Name", "Course Name", "Prerequisites Met?","Enrollment Status", "Override Status"};
    DefaultTableModel model = new DefaultTableModel(columnHeaders, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
         return column ==4 ; 
    }
    };
    if ( business == null || targetTable == null) return;

    // 1. Get all student profiles in the business system
  
    ArrayList<StudentProfile> allStudents = business.getStudentDirectory().getList();

    // 2. Loop and generate row details using a mix of profile features and static text
    for (StudentProfile student : allStudents) {
        if (student == null) continue;

        Object[] rowData = new Object[6];
        rowData[0] ="Spring 2026";
        rowData[1] = student.getPerson().getPersonId();        // Dynamic Student Name
        rowData[2] =  "INFO5100 App Eng";                         // Hardcoded Course Name
        rowData[3] = "✅ Prerequisites Met";                     // Hardcoded Pre Req
        rowData[4] = "Completed";                                // Initial Status
        rowData[5] = "None Required";                          // Initial Status
        model.addRow(rowData);
      
        Object[] extraRow1 = new Object[6];
        extraRow1[0] ="Spring 2026";
        extraRow1[1] = student.getPerson().getPersonId(); 
        extraRow1[2] = "INFOR6205 Web Development";                     
        extraRow1[3] = "✅ Prerequisites Met"; 
        extraRow1[4] = "Completed";                                
        extraRow1[5] = "None Required";                          
     
        model.addRow(extraRow1);

        // Manual Row 2
        Object[] extraRow2 = new Object[6];
        extraRow2[0] ="Fall 2026";
        extraRow2[1] = student.getPerson().getPersonId();
        extraRow2[2] = "DAMG6210 Database Management Systems";
        extraRow2[3] = "❌ Missing Reqs"; 
        extraRow2[4] = "Not Enrolled";
        extraRow2[5] = "Overrided Required!";                          
        model.addRow(extraRow2);
    
    targetTable.setModel(model);
    // Create a dropdown menu editor for Column 4 (Override Status)
        javax.swing.JComboBox<String> overrideBox = new javax.swing.JComboBox<>(new String[]{"None Required","Overrided Required", "Approved", "Denied"});
        javax.swing.table.TableColumn overrideColumn = targetTable.getColumnModel().getColumn(4);
        overrideColumn.setCellEditor(new javax.swing.DefaultCellEditor(overrideBox));
    
        // 2. Add the dynamic cell listener to handle changes on the fly
    model.addTableModelListener(new javax.swing.event.TableModelListener() {
        @Override
        public void tableChanged(javax.swing.event.TableModelEvent e) {
            // Check if a single cell was updated
            if (e.getType() == javax.swing.event.TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                // If the user changed the "Override Status" (Column 4)
                if (column == 4) {
                    String overrideValue = model.getValueAt(row, 4).toString().trim();
                    
                    // Temporarily remove listener to avoid infinite loop when updating another cell in the same row
                    model.removeTableModelListener(this);

                    if (overrideValue.equalsIgnoreCase("Approved") || overrideValue.equalsIgnoreCase("Yes")) {
                        // Change Enrollment Status to Enrolled if override is approved
                        model.setValueAt("Enrolled", row, 3);
                    } else {
                        // Revert back if it's denied or pending
                        model.setValueAt("Not Enrolled", row, 3);
                    }

                    // Re-attach the cell tracking listener
                    model.addTableModelListener(this);
                }
            }
        }
    });
        
// Create a custom cell renderer to dynamically inject colors based on row values
        javax.swing.table.DefaultTableCellRenderer statusColorRenderer = new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                // Let Java prepare the basic default label component state first
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value != null) {
                    String text = value.toString().trim();

                    // Apply targeted styling rules based on text string matches
                    if (text.equalsIgnoreCase("Enrolled") || text.equalsIgnoreCase("Approved") || text.equalsIgnoreCase("Yes")) {
                        c.setForeground(new java.awt.Color(46, 125, 50)); // Deep Forest Green
                        c.setFont(c.getFont().deriveFont(java.awt.Font.BOLD));
                    } else if (text.contains("Not Enrolled") || text.contains("Missing") || text.equalsIgnoreCase("Denied")) {
                        c.setForeground(new java.awt.Color(198, 40, 40)); // Crimson Red
                        c.setFont(c.getFont().deriveFont(java.awt.Font.BOLD));
                    } else if (text.equalsIgnoreCase("Overide ")) {
                        c.setForeground(new java.awt.Color(218, 125, 0)); // Amber / Warning Orange
                        c.setFont(c.getFont().deriveFont(java.awt.Font.BOLD));
                    } else {
                        // Reset to default standard text color if selected row has alternate properties
                        c.setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
                        c.setFont(c.getFont().deriveFont(java.awt.Font.PLAIN));
                    }
                }
                return c;
            }
        };

        // Apply this color renderer engine directly to columns 2, 3, and 4
        targetTable.getColumnModel().getColumn(2).setCellRenderer(statusColorRenderer); // Prerequisites
        targetTable.getColumnModel().getColumn(3).setCellRenderer(statusColorRenderer); // Enrollment Status
        targetTable.getColumnModel().getColumn(4).setCellRenderer(statusColorRenderer); // Override Status
    
        resizeTableColumns(targetTable); // Triggers your layout auto-fitting engine
    }}
  
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ManageStudentTable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 255, 204));

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage Enrolled Students");

        jScrollPane2.setHorizontalScrollBar(null);

        ManageStudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ManageStudentTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(ManageStudentTable);

        jTextField1.setBackground(new java.awt.Color(204, 255, 204));
        jTextField1.setText("To complete an Overided, Select the Override Status Column and choose and action ");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Back)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addComponent(Back)
                .addGap(153, 153, 153))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
    CardSequencePanel.remove(this);
        ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_BackActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTable ManageStudentTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
