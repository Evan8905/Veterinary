package Presentation;

import javax.swing.JOptionPane;
import Data.Client;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author eefre
 */
public class ClientScreen extends javax.swing.JFrame {

    /**
     * Creates new form Client
     */
    public ClientScreen() {
        initComponents();
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
        jLabel3 = new javax.swing.JLabel();
        txtClientName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
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

        jLabel1.setText("Version 1.1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, -1, -1));

        jLabel2.setText("Power by UTN Student");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 134, -1));

        jLabel3.setText("Datos de contacto del cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));
        getContentPane().add(txtClientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 220, -1));
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 220, -1));
        getContentPane().add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 220, -1));

        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 60, -1));

        jLabel5.setText("Dirección");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        jLabel6.setText("Teléfono");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        jLabel7.setText("Identificación");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 220, -1));

        btnCreate.setText("Crear");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        btnRead.setText("Consultar");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });
        getContentPane().add(btnRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, -1, -1));

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, -1, -1));

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

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        getForm();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        readAclient();
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateAclient();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteAclient();
    }//GEN-LAST:event_btnDeleteActionPerformed

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

    public void getForm() {
        int id = Integer.parseInt(txtID.getText());
        String name = txtClientName.getText();
        String address = txtAddress.getText();
        String pNumber = txtPhoneNumber.getText();

        Client.createNewClient(id, name, address, pNumber);
        CleanUpForm();
        Object[] options = {"Sí", "No"};

        // Display the option dialog
        int choice = JOptionPane.showOptionDialog(null, "¿Desea Registrar una mascota?", "Registro de mascota",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Handle user's choice
        if (choice == JOptionPane.YES_OPTION) {
            PetScreen screen = new PetScreen();
            screen.setLocationRelativeTo(null);
            screen.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Puedes completar el registro despues!");
        }
    }

    public void CleanUpForm() {
        txtID.setText("");
        txtClientName.setText("");
        txtAddress.setText("");
        txtPhoneNumber.setText("");
    }

    public void readAclient() {
        int id = Integer.parseInt(txtID.getText());
        String[] clientData = Client.readClient(id);
        if (clientData != null) {
            String name = clientData[0];
            String address = clientData[1];
            String phone = clientData[2];

            txtClientName.setText(name);
            txtAddress.setText(address);
            txtPhoneNumber.setText(phone);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateAclient() {
        int id = Integer.parseInt(txtID.getText());
        String name = txtClientName.getText();
        String address = txtAddress.getText();
        String pNumber = txtPhoneNumber.getText();

        //New Client
        Client client = new Client(id, name, address, pNumber);

        // Update the client
        boolean success = client.updateClient();

        if (success) {
            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            CleanUpForm();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteAclient() {
        int id = Integer.parseInt(txtID.getText());
        Client.deleteClient(id);
        CleanUpForm();
    }

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
            java.util.logging.Logger.getLogger(ClientScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpdate;
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
