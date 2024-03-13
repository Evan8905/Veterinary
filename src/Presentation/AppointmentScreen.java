package Presentation;

import Data.Appointment;
import Data.Pet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author eefre
 */
public class AppointmentScreen extends javax.swing.JFrame {

    /**
     * Creates new form AppointmentScreen
     */
    private ArrayList<String> petList = new ArrayList<>();
    private ArrayList<String> doctorList = new ArrayList<>();

    public AppointmentScreen() {
        initComponents();
        setPets();
        setDoctor();
    }

    // this method allow me to set pets to the combo box "cmbPets"
    private void setPets() {
        String fileName = "Pets.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String displayText = id + ", " + name; // this is how the info is displayed in the combo box.
                    petList.add(id);
                }
            }
            // The model is created.
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(petList.toArray(new String[0]));
            // The model is set to the "cmbPets"
            cmbPets.setModel(model);
            System.out.println("Pets loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de Pets", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setDoctor() {
        String fileName = "Users.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String displayText = id + " - " + name; // this is how the info is displayed in the combo box.
                    doctorList.add(displayText);
                }
            }
            // The model is created.
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(doctorList.toArray(new String[0]));
            // The model is set to the "cmbDoctor"
            cmbDoctor.setModel(model);
            System.out.println("Doctor loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de Users", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getFormInfo() {

        String petSelected = (String) cmbPets.getSelectedItem();
        Date date = dateChooser.getDate();
        String hourSelected = (String) cmbHour.getSelectedItem();
        String minuteSelected = (String) cmbMinutes.getSelectedItem();
        String timeSystem = (String) cmbAmPm.getSelectedItem();

        //String time = hourSelected + ":" + minuteSelected + ":" + timeSystem;
        String service = (String) cmbServices.getSelectedItem();
        String doctor = (String) cmbDoctor.getSelectedItem();

        Appointment.CreateNewAppointment(petSelected, date, hourSelected, minuteSelected, timeSystem, service, doctor);

        //CleanUpForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbPets = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cmbAmPm = new javax.swing.JComboBox<>();
        cmbHour = new javax.swing.JComboBox<>();
        cmbMinutes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbServices = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbDoctor = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMascota = new javax.swing.JTable();
        txtSearchField = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemHome = new javax.swing.JMenuItem();
        itemAppointments = new javax.swing.JMenuItem();
        itemMedicalRecords = new javax.swing.JMenuItem();
        itemReports = new javax.swing.JMenuItem();
        item_logout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemUser = new javax.swing.JMenuItem();
        itemClient = new javax.swing.JMenuItem();
        itemPet = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(815, 545));
        setMinimumSize(new java.awt.Dimension(815, 545));
        setPreferredSize(new java.awt.Dimension(815, 545));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Gestionar Cita");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Seleccione un paciente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        getContentPane().add(cmbPets, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 200, -1));

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Seleccione una fecha");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));
        getContentPane().add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 200, -1));

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Hora de la cita");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        cmbAmPm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        getContentPane().add(cmbAmPm, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 60, -1));

        cmbHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        getContentPane().add(cmbHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 50, -1));

        cmbMinutes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "10", "20", "30", "40", "50" }));
        getContentPane().add(cmbMinutes, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 50, -1));

        jLabel5.setText("Version 1.1");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, -1, -1));

        jLabel6.setText("Power by UTN Student");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 134, -1));

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Procedimiento Clinico");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        cmbServices.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consulta Médica", "Vacunación", "Cirugía", "Corte de pelo", "Esterilización", "Otros Procedimientos" }));
        getContentPane().add(cmbServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 200, -1));

        jLabel8.setBackground(new java.awt.Color(0, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Médico a cargo");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        getContentPane().add(cmbDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 200, -1));

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        btnDelete.setText("Eliminar");
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        tableMascota.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tableMascota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Procedimiento", "Fecha", "Médico"
            }
        ));
        jScrollPane1.setViewportView(tableMascota);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 380, 200));
        getContentPane().add(txtSearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 270, -1));

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, -1, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Buscar Mascota por ID");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        lblLogo.setFont(new java.awt.Font("Yu Gothic Medium", 3, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(0, 153, 204));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pawprint (1).png"))); // NOI18N
        lblLogo.setText("PetCare");
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 110, 40));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/General.png"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 550));

        jMenu1.setText("Menú");

        itemHome.setText("Inicio");
        itemHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHomeActionPerformed(evt);
            }
        });
        jMenu1.add(itemHome);

        itemAppointments.setText("Citas");
        itemAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAppointmentsActionPerformed(evt);
            }
        });
        jMenu1.add(itemAppointments);

        itemMedicalRecords.setText("Historial");
        itemMedicalRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMedicalRecordsActionPerformed(evt);
            }
        });
        jMenu1.add(itemMedicalRecords);

        itemReports.setText("Reportes");
        jMenu1.add(itemReports);

        item_logout.setText("Salir");
        item_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_logoutActionPerformed(evt);
            }
        });
        jMenu1.add(item_logout);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Registro|Gestión");

        itemUser.setText("Usuario");
        itemUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUserActionPerformed(evt);
            }
        });
        jMenu2.add(itemUser);

        itemClient.setText("Cliente");
        itemClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClientActionPerformed(evt);
            }
        });
        jMenu2.add(itemClient);

        itemPet.setText("Mascota");
        itemPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPetActionPerformed(evt);
            }
        });
        jMenu2.add(itemPet);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        getFormInfo();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        readApet();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateAnAppointment();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void itemHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHomeActionPerformed
        Main Prc = new Main();
        Prc.setLocationRelativeTo(null);
        Prc.setVisible(true);
    }//GEN-LAST:event_itemHomeActionPerformed

    private void itemAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAppointmentsActionPerformed
        AppointmentScreen Prc = new AppointmentScreen();
        Prc.setLocationRelativeTo(null);
        Prc.setVisible(true);
    }//GEN-LAST:event_itemAppointmentsActionPerformed

    private void itemMedicalRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMedicalRecordsActionPerformed
        RecordScreen Prc = new RecordScreen();
        Prc.setLocationRelativeTo(null);
        Prc.setVisible(true);
    }//GEN-LAST:event_itemMedicalRecordsActionPerformed

    private void item_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_logoutActionPerformed
        JOptionPane.showMessageDialog(null, "Cerrando Sesión...");
        Login Prc = new Login();
        Prc.setLocationRelativeTo(null);
        Prc.setVisible(true);
    }//GEN-LAST:event_item_logoutActionPerformed

    private void itemUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUserActionPerformed
        UserScreen open = new UserScreen();
        open.setLocationRelativeTo(null);
        open.setVisible(true);
    }//GEN-LAST:event_itemUserActionPerformed

    private void itemClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClientActionPerformed
        ClientScreen open = new ClientScreen();
        open.setLocationRelativeTo(null);
        open.setVisible(true);
    }//GEN-LAST:event_itemClientActionPerformed

    private void itemPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPetActionPerformed
        PetScreen open = new PetScreen();
        open.setLocationRelativeTo(null);
        open.setVisible(true);
    }//GEN-LAST:event_itemPetActionPerformed

    private void readApet() {
        String id = txtSearchField.getText();
        String[] petData = Appointment.readPet(id);
        if (petData != null) {
            String petName = petData[0];
            String dateString = petData[1];
            String hour = petData[2];
            String minutes = petData[3];
            String timeSystem = petData[4];
            String service = petData[5];
            String doctor = petData[6];

            cmbPets.setSelectedItem(petName);

            // object date
            Date date = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
                date = dateFormat.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (date != null) {
                // Set the JDateChooser
                dateChooser.setDate(date);
            } else {
                JOptionPane.showMessageDialog(null, "Error al convertir la fecha", "Error", JOptionPane.ERROR_MESSAGE);
            }

            cmbHour.setSelectedItem(hour);
            cmbMinutes.setSelectedItem(minutes);
            cmbAmPm.setSelectedItem(timeSystem);
            cmbServices.setSelectedItem(service);
            cmbDoctor.setSelectedItem(doctor);
        } else {
            JOptionPane.showMessageDialog(null, "Mascota no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateAnAppointment() {
        String petSelected = (String) cmbPets.getSelectedItem();
        Date date = dateChooser.getDate();
        String hourSelected = (String) cmbHour.getSelectedItem();
        String minuteSelected = (String) cmbMinutes.getSelectedItem();
        String timeSystem = (String) cmbAmPm.getSelectedItem();

        //String time = hourSelected + ":" + minuteSelected + ":" + timeSystem;
        String service = (String) cmbServices.getSelectedItem();
        String doctor = (String) cmbDoctor.getSelectedItem();

        //New Appointment
        Appointment appointment = new Appointment(petSelected, date, hourSelected, minuteSelected, timeSystem, service, doctor);

        // Update the appointment file
        boolean success = appointment.updateAppointment();

        if (success) {
            JOptionPane.showMessageDialog(null, "Registro de cita actualizado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            //CleanUpForm();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos de mascota", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteAnAppointment() {
        String id = (String) cmbPets.getSelectedItem();
        Appointment.deleteAppointment(id);
        //CleanUpForm();
    }
//    public void CleanUpForm() {
//        txtID.setText("");
//        txtPetName.setText("");
//        txtbreed.setText("");
//        txtPetAge.setText("");
//        txtPetWeight.setText("");
//        txtPetMCondition.setText("");
//    }

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
            java.util.logging.Logger.getLogger(AppointmentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbAmPm;
    private javax.swing.JComboBox<String> cmbDoctor;
    private javax.swing.JComboBox<String> cmbHour;
    private javax.swing.JComboBox<String> cmbMinutes;
    private javax.swing.JComboBox<String> cmbPets;
    private javax.swing.JComboBox<String> cmbServices;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JMenuItem itemAppointments;
    private javax.swing.JMenuItem itemClient;
    private javax.swing.JMenuItem itemHome;
    private javax.swing.JMenuItem itemMedicalRecords;
    private javax.swing.JMenuItem itemPet;
    private javax.swing.JMenuItem itemReports;
    private javax.swing.JMenuItem itemUser;
    private javax.swing.JMenuItem item_logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTable tableMascota;
    private javax.swing.JTextField txtSearchField;
    // End of variables declaration//GEN-END:variables
}
