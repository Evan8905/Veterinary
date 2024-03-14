package Presentation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eefre
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
        lblLogo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnApointment = new javax.swing.JButton();
        btnRecords = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
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
        setPreferredSize(new java.awt.Dimension(825, 515));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setFont(new java.awt.Font("Yu Gothic Medium", 3, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(0, 153, 204));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pawprint (1).png"))); // NOI18N
        lblLogo.setText("PetCare");
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 110, 40));

        lblLogo1.setFont(new java.awt.Font("Yu Gothic Medium", 3, 18)); // NOI18N
        lblLogo1.setForeground(new java.awt.Color(0, 153, 153));
        lblLogo1.setText("El cuidado de tu mascota es nuestra prioridad");
        getContentPane().add(lblLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 450, 40));

        jLabel1.setText("Version 1.1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, -1, -1));

        jLabel2.setText("Power by UTN Student");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 134, -1));

        btnApointment.setBackground(new java.awt.Color(102, 102, 102));
        btnApointment.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnApointment.setForeground(new java.awt.Color(0, 153, 153));
        btnApointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/appointmenticon.png"))); // NOI18N
        btnApointment.setText("Citas");
        btnApointment.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(51, 255, 255)));
        btnApointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApointmentActionPerformed(evt);
            }
        });
        getContentPane().add(btnApointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 130, 90));

        btnRecords.setBackground(new java.awt.Color(102, 102, 102));
        btnRecords.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnRecords.setForeground(new java.awt.Color(0, 153, 153));
        btnRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HistoricalIcon.png"))); // NOI18N
        btnRecords.setText("Historial");
        btnRecords.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(51, 255, 255)));
        btnRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordsActionPerformed(evt);
            }
        });
        getContentPane().add(btnRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 130, 90));

        btnReports.setBackground(new java.awt.Color(102, 102, 102));
        btnReports.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnReports.setForeground(new java.awt.Color(0, 153, 153));
        btnReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reportIcon.png"))); // NOI18N
        btnReports.setText("Reportes");
        btnReports.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(51, 255, 255)));
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });
        getContentPane().add(btnReports, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 130, 90));

        BG.setBackground(new java.awt.Color(102, 102, 102));
        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/General.png"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 540));

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

    private void btnApointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApointmentActionPerformed
        AppointmentScreen Prc = new AppointmentScreen();
        Prc.setLocationRelativeTo(null);
        Prc.setVisible(true);
    }//GEN-LAST:event_btnApointmentActionPerformed

    private void btnRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordsActionPerformed
        RecordScreen Prc = new RecordScreen();
        Prc.setLocationRelativeTo(null);
        Prc.setVisible(true);
    }//GEN-LAST:event_btnRecordsActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        ReportsScreen Prc = new ReportsScreen();
        Prc.setLocationRelativeTo(null);
        Prc.setVisible(true);
    }//GEN-LAST:event_btnReportsActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btnApointment;
    private javax.swing.JButton btnRecords;
    private javax.swing.JButton btnReports;
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogo1;
    // End of variables declaration//GEN-END:variables
}
