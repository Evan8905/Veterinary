package Presentation;

import Data.Client;
import Data.Pet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author eefre
 */
public class PetScreen extends javax.swing.JFrame {

    /**
     * Creates new form PetScreen
     */
    private ArrayList<String> clientsList = new ArrayList<>();

    public PetScreen() {
        initComponents();
        setClients();
    }

    private void setClients() {
        String fileName = "Clients.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String displayText = id + " - " + name; // this is how the info is displayed in the combo box.
                    clientsList.add(displayText);
                }
            }
            // The model is created.
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(clientsList.toArray(new String[0]));
            // The model is set to the "cmbClients"
            cmbClients.setModel(model);
            System.out.println("Clients loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de clientes", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getFormInfo() {

        int id = Integer.parseInt(txtID.getText());
        String name = txtPetName.getText();
        String breed = txtbreed.getText();
        String age = txtPetAge.getText();
        String weight = txtPetWeight.getText();
        String medC = txtPetMCondition.getText();
        String selectedClient = (String) cmbClients.getSelectedItem();

        Pet.CreateNewPet(id, name, breed, age, weight, medC, selectedClient);
        CleanUpForm();
    }

    private void readApet() {

        int id = Integer.parseInt(txtID.getText());
        String[] petData = Pet.readPet(id);
        if (petData != null) {
            String name = petData[0];
            String breed = petData[1];
            String age = petData[2];
            String weight = petData[3];
            String mConditions = petData[4];
            String owner = petData[5];

            txtPetName.setText(name);
            txtbreed.setText(breed);
            txtPetAge.setText(age);
            txtPetWeight.setText(weight);
            txtPetMCondition.setText(mConditions);
            cmbClients.setSelectedItem(owner);

        } else {
            JOptionPane.showMessageDialog(null, "Mascota no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void updateApet() {
        int id = Integer.parseInt(txtID.getText());
        String name = txtPetName.getText();
        String breed = txtbreed.getText();
        String age = txtPetAge.getText();
        String weight = txtPetWeight.getText();
        String medC = txtPetMCondition.getText();
        String selectedClient = (String) cmbClients.getSelectedItem();

        //New Pet
        Pet pet = new Pet(id, name, breed, age, weight, medC, selectedClient);

        // Update the Pets file
        boolean success = pet.updatePets();

        if (success) {
            JOptionPane.showMessageDialog(null, "Registro de mascota actualizado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            CleanUpForm();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos de mascota", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteApet() {
        int id = Integer.parseInt(txtID.getText());
        Pet.deletePet(id);
        CleanUpForm();
    }

    public void CleanUpForm() {
        txtID.setText("");
        txtPetName.setText("");
        txtbreed.setText("");
        txtPetAge.setText("");
        txtPetWeight.setText("");
        txtPetMCondition.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtPetName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtbreed = new javax.swing.JTextField();
        txtPetAge = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPetWeight = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPetMCondition = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbClients = new javax.swing.JComboBox<>();
        BG = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemAppointments = new javax.swing.JMenuItem();
        itemMedicalRecords = new javax.swing.JMenuItem();
        itemReports = new javax.swing.JMenuItem();
        item_logout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemUser = new javax.swing.JMenuItem();
        itemClient = new javax.swing.JMenuItem();
        itemPet = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Gestionar Mascotas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        btnCreate.setText("Crear");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, -1, -1));

        btnRead.setText("Consultar");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });
        getContentPane().add(btnRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, -1, -1));

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, -1, -1));

        jLabel1.setText("Version 1.1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, -1, -1));

        jLabel2.setText("Power by UTN Student");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, 134, -1));

        jLabel7.setText("Identificación");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 220, -1));
        getContentPane().add(txtPetName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 220, -1));

        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 60, -1));

        jLabel5.setText("Raza");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));
        getContentPane().add(txtbreed, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 220, -1));
        getContentPane().add(txtPetAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 220, -1));

        jLabel6.setText("Edad");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        jLabel8.setText("Peso");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));
        getContentPane().add(txtPetWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 220, -1));

        jLabel9.setText("Condición Médica");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));
        getContentPane().add(txtPetMCondition, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 220, 40));

        jLabel10.setText("Dueño");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        cmbClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClientsActionPerformed(evt);
            }
        });
        getContentPane().add(cmbClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 220, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/General.png"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 540));

        jMenu1.setText("Menú");

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
        getFormInfo();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        readApet();
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateApet();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteApet();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cmbClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClientsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClientsActionPerformed

    private void itemAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAppointmentsActionPerformed
        AppointmentScreen Prc = new AppointmentScreen();
        Prc.setLocationRelativeTo(null);
        Prc.setVisible(true);
    }//GEN-LAST:event_itemAppointmentsActionPerformed

    private void itemMedicalRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMedicalRecordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemMedicalRecordsActionPerformed

    private void item_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_logoutActionPerformed
        JOptionPane.showMessageDialog(null, "Saliendo del Sistema...");
        System.exit(0);
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
            java.util.logging.Logger.getLogger(PetScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PetScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PetScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PetScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PetScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbClients;
    private javax.swing.JMenuItem itemAppointments;
    private javax.swing.JMenuItem itemClient;
    private javax.swing.JMenuItem itemMedicalRecords;
    private javax.swing.JMenuItem itemPet;
    private javax.swing.JMenuItem itemReports;
    private javax.swing.JMenuItem itemUser;
    private javax.swing.JMenuItem item_logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPetAge;
    private javax.swing.JTextField txtPetMCondition;
    private javax.swing.JTextField txtPetName;
    private javax.swing.JTextField txtPetWeight;
    private javax.swing.JTextField txtbreed;
    // End of variables declaration//GEN-END:variables
}
