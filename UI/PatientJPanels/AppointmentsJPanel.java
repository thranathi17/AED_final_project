/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.PatientJPanels;

import Business.Business;
import Doctor.Doctor;
import Hospital.Appointment;
import Hospital.Hospital;
import Insurance.InsuranceEnrollment;
import Patient.Patient;
import UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MC
 */
public class AppointmentsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AppointmentsJPanel
     */
    public Business business;
    public UserAccount userAccount;
    DefaultTableModel aptsTableModel;
    
    public AppointmentsJPanel() {
        initComponents();
    }
    
    public AppointmentsJPanel(Business business, UserAccount userAccount) {
        initComponents();
        this.business = business;
        this.userAccount = userAccount;
        this.aptsTableModel = (DefaultTableModel) ptnAptsTable.getModel();
        
        displayAppointments();
        populateDropdowns();
    }
    
    public void populateDropdowns()
    {
        for(Hospital h : this.business.getHospitals().getHospitals())
        {
            selectHospCBox.addItem(h.getHospitalName());
            for (Doctor d : h.getDoctors().getDoctorsList())
            {
                selDocCBox.addItem(d.getId() + ';' + d.getFirstName() + ' ' + d.getLastName());
            }
        }
    }
    
    public void displayAppointments()
    {
        ArrayList<Appointment> aps = this.business.getAppointments().getAppointments();
        if(aps.size() >= 0) {
            aptsTableModel.setRowCount(0);
            for(Appointment a: aps) {
                if (a.getPatient().getId().equals(userAccount.getPersonId()))
                {
                    Object row[] = new Object[7];
                    row[0] = a.getAppointmentId();
                    row[1] = a.getHospital().getHospitalName();
                    row[2] = a.getDoctor().getId() + ';' + a.getDoctor().getFirstName() + ' ' + a.getDoctor().getLastName();
                    row[3] = a.getAppointmentDate();
                    row[4] = a.getAppointmentHour();
                    row[5] = a.getStatus();
                    row[6] = a.getCost();
                    aptsTableModel.addRow(row);
                }
            }
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        selectHospCBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        selDocCBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        selAptDate = new com.toedter.calendar.JCalendar();
        jLabel4 = new javax.swing.JLabel();
        selectTimeCBox = new javax.swing.JComboBox<>();
        requestAptBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ptnAptsTable = new javax.swing.JTable();
        cancelAptBtn = new javax.swing.JButton();

        jLabel1.setText("Select a Hospital");

        jLabel2.setText("Select a Doctor");

        jLabel3.setText("Choose a Date");

        jLabel4.setText("Select a time slot");

        selectTimeCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8 AM", "9 AM", "10 AM", "11 AM", "1 PM", "2 PM", "3 PM", "4 PM" }));

        requestAptBtn.setText("Request Appointment");
        requestAptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestAptBtnActionPerformed(evt);
            }
        });

        ptnAptsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Apt Id", "Hospital Name", "Doctor Name", "Date", "Time", "Status", "Cost"
            }
        ));
        jScrollPane1.setViewportView(ptnAptsTable);

        cancelAptBtn.setText("Cancel Appointment");
        cancelAptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAptBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selAptDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selDocCBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectHospCBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectTimeCBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(requestAptBtn)))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelAptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(selectHospCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(selDocCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(selAptDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(selectTimeCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addComponent(requestAptBtn)))
                .addGap(27, 27, 27)
                .addComponent(cancelAptBtn)
                .addContainerGap(356, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestAptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestAptBtnActionPerformed
        String hospitalName = selectHospCBox.getSelectedItem().toString();
        String doctorId = selDocCBox.getSelectedItem().toString().split(";")[0];
        
        Hospital hospital = this.business.getHospitals().findHospitalByName(hospitalName);
        Doctor doctor = hospital.getDoctors().findDoctor(doctorId);
        
        Patient currentPatient = this.business.getPatients().findPatient(userAccount.getPersonId());
        
        Date selectedDate = selAptDate.getDate();
        String selectedTime = selectTimeCBox.getSelectedItem().toString();
        
        this.business.getAppointments().addAppointment(hospital, currentPatient, doctor, selectedDate, selectedTime);
        
        displayAppointments();
    }//GEN-LAST:event_requestAptBtnActionPerformed

    private void cancelAptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAptBtnActionPerformed
        int selectedRowIndex = ptnAptsTable.getSelectedRow();
        String aptId = ptnAptsTable.getValueAt(selectedRowIndex, 1).toString();
        Appointment apt = this.business.getAppointments().findAppointment(aptId);
        apt.setStatus("Cancelled");
        
        displayAppointments();
    }//GEN-LAST:event_cancelAptBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelAptBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ptnAptsTable;
    private javax.swing.JButton requestAptBtn;
    private com.toedter.calendar.JCalendar selAptDate;
    private javax.swing.JComboBox<String> selDocCBox;
    private javax.swing.JComboBox<String> selectHospCBox;
    private javax.swing.JComboBox<String> selectTimeCBox;
    // End of variables declaration//GEN-END:variables
}
