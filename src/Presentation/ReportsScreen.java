package Presentation;

import Utilitary.Manager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eefre
 */
public class ReportsScreen extends javax.swing.JFrame {

    /**
     * Creates new form ReporstScreen
     */
    private ArrayList<String> petList = new ArrayList<>();

    private DefaultTableModel dtReports;
    private Object[] o = new Object[5];

    public ReportsScreen() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setPets();
        dtReports = (DefaultTableModel) tableReports.getModel();
    }

    private void setPets() {
        String fileName = "Pets.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String displayText = id + " - " + name; // this is how the info is displayed in the combo box.
                    petList.add(displayText);
                }
            }
            // The model is created.
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(petList.toArray(new String[0]));
            // The model is set to the "cmbPets"
            cmbPetId.setModel(model);
            System.out.println("Pets loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de Pets", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getReportBySelection() {
        String petSelected = (String) cmbPetId.getSelectedItem();
        List<String[]> reportList = Manager.getReport(petSelected);

        if (!reportList.isEmpty()) {
            for (String[] reportData : reportList) {
                Object[] rowData = new Object[7]; 

                SimpleDateFormat formatoOriginal = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                SimpleDateFormat formatoNuevo = new SimpleDateFormat("EEE MMM dd yyyy");
                try {
                    Date fecha = formatoOriginal.parse(reportData[2]);
                    String nuevaFecha = formatoNuevo.format(fecha);
                    rowData[2] = nuevaFecha;
                } catch (ParseException e) {
                    e.printStackTrace();
                    rowData[2] = reportData[2];
                }
                rowData[0] = reportData[0];
                rowData[1] = reportData[1];
                rowData[3] = reportData[6];

                dtReports.addRow(rowData);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún reporte para la mascota seleccionada.");
        }
    }

    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) dtReports;
        model.setRowCount(0); // Elimina todas las filas de la tabla
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbPetId = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReports = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnReport = new javax.swing.JButton();
        btnRanking = new javax.swing.JButton();
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
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setFont(new java.awt.Font("Yu Gothic Medium", 3, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(0, 153, 204));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pawprint (1).png"))); // NOI18N
        lblLogo.setText("PetCare");
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 110, 40));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Reportes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        cmbPetId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPetIdActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPetId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 340, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Seleccione una mascota");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        tableReports.setForeground(new java.awt.Color(0, 102, 102));
        tableReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Registro", "Id - Nombre", "Fecha", "Motivo", "Diagnóstico", "Medicamentos"
            }
        ));
        jScrollPane1.setViewportView(tableReports);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 690, 250));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Recurrencia");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Version 1.1");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Power by UTN Student");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 134, -1));

        btnReport.setText("Mostrar Reporte");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        getContentPane().add(btnReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 150, -1));

        btnRanking.setText("Mostrar");
        btnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingActionPerformed(evt);
            }
        });
        getContentPane().add(btnRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, -1, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/General.png"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -30, -1, 530));

        jMenuBar1.setForeground(new java.awt.Color(0, 102, 102));

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
        itemReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReportsActionPerformed(evt);
            }
        });
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

    private void cmbPetIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPetIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPetIdActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        clearTable();
        
        getReportBySelection();

    }//GEN-LAST:event_btnReportActionPerformed

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

    private void itemReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReportsActionPerformed
        ReportsScreen Prc = new ReportsScreen();
        Prc.setLocationRelativeTo(null);
        Prc.setVisible(true);
    }//GEN-LAST:event_itemReportsActionPerformed

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

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingActionPerformed
        Manager.getRanking();
    }//GEN-LAST:event_btnRankingActionPerformed

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
            java.util.logging.Logger.getLogger(ReportsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportsScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btnRanking;
    private javax.swing.JButton btnReport;
    private javax.swing.JComboBox<String> cmbPetId;
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTable tableReports;
    // End of variables declaration//GEN-END:variables
}
