/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.StudentRole;

import Business.Business;
import Business.Profiles.StudentAccount;
import Business.Profiles.StudentProfile;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * Student panel for reviewing transcript information and academic history.
 *
 * @author Nicholas Woodward
 */
public class StudentTranscriptJPanel extends javax.swing.JPanel {

    // ATTRIBUTES
    private Business business;
    private StudentProfile student;
    private JPanel CardSequencePanel;
    private final StudentAccount studentAccount;

    // CONSTRUCTOR
    /**
     * Creates a new StudentTranscriptJPanel for an authenticated student.
     *
     * @param b business object
     * @param sa authenticated student account
     * @param sp student profile
     * @param csp parent CardLayout panel
     */
    public StudentTranscriptJPanel(Business b, StudentAccount sa, StudentProfile sp, JPanel csp) {
        business = b;
        student = sp;
        CardSequencePanel = csp;
        studentAccount = sa;

        if (Business.Authorize(sa, "Student")) {
            initComponents();
            setBackground(new java.awt.Color(240, 248, 255));
            populateTranscriptTable();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTranscript = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnViewAcademicHistory = new javax.swing.JButton();

        lblTitle.setText("Transcript");

        tblTranscript.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTranscript);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnViewAcademicHistory.setText("View Academic History");
        btnViewAcademicHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAcademicHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack)
                    .addComponent(btnViewAcademicHistory, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewAcademicHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewAcademicHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAcademicHistoryActionPerformed
    viewAcademicHistory();
    }//GEN-LAST:event_btnViewAcademicHistoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewAcademicHistory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblTranscript;
    // End of variables declaration//GEN-END:variables
    /**
     * Populates the transcript table with the student's academic history.
     */
    private void populateTranscriptTable() {
        DefaultTableModel model = (DefaultTableModel) tblTranscript.getModel();

        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[]{"Course", "Credits", "Grade", "Term"});

        model.addRow(new Object[]{"INFO5100", "4", "A", "Spring 2026"});
        model.addRow(new Object[]{"INFO6205", "4", "A-", "Spring 2026"});
        model.addRow(new Object[]{"INFO6105", "4", "B+", "Fall 2025"});
        model.addRow(new Object[]{"DAMG6210", "4", "A", "Fall 2025"});
    }

    /**
     * Displays a summary of the student's completed credits, GPA, and academic standing.
     */
    private void viewAcademicHistory() {
        JOptionPane.showMessageDialog(this,
                "Academic History Summary\n\n"
                + "Completed Credits: 16\n"
                + "Current GPA: 3.78\n"
                + "Academic Standing: Good Standing",
                "Academic History",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Returns the user to the Student Work Area panel.
     */
    private void goBack() {
        CardSequencePanel.remove(this);
        ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }
}
