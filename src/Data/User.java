package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author eefre
 */
public class User {

    private String fullName;
    private String userName;
    private String password;
    private boolean type;
    private boolean status;

    public User(String fullName, String userName, String password, boolean type, boolean status) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static void CreateNewUser(String fullName, String userName, String password, boolean typeSelected, boolean statusSelected) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt", true))) {
            writer.write(fullName + "," + userName + "," + password + "," + typeSelected + "," + statusSelected);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Datos de Usuario guardados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datos NO Guardados", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String[] readUsers(String User) {
        String fileName = "Users.txt";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String userName = parts[1].trim(); // trim() remove white space
                if (userName.equals(User)) {
                    String[] userData = new String[5];
                    userData[0] = parts[0];
                    userData[1] = parts[1];
                    userData[2] = parts[2];
                    userData[3] = parts[3];
                    userData[4] = parts[4];
                    return userData;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateUsers() {
        String fileName = "Users.txt";
        String tempFileName = "Users_temp.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String userN = parts[1].trim();

                if (userN.equals(userName)) {
                    //if the pet ID is found, the information is gonna be updated.
                    writer.write(fullName + "," + userName + "," + password + "," + type + "," + status);
                    writer.newLine();
                } else {
                    // otherwise the information remain the same or rewrite.
                    writer.write(line);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // it replace the temp file to the original
        File originalFile = new File(fileName);
        File tempFile = new File(tempFileName);

        // it verify if the temp file is properly captured
        if (!tempFile.exists() || !tempFile.isFile()) {
            System.out.println("Error: El archivo temporal no se creó correctamente.");
            return false;
        }
        // Delete the original file before of rename the temp file.

        if (!originalFile.delete()) {
            System.out.println("Error al eliminar el archivo original.");
            return false;
        }
        // Rename the temp file to the original

        if (!tempFile.renameTo(originalFile)) {
            System.out.println("Error al renombrar el archivo temporal.");
            return false;
        }

        return true;
    }

    public static void deleteUser(String userName) {
        String fileName = "Users.txt";
        String tempFileName = "Users_temp.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String userN = parts[1].trim();

                if (!(userN.equals(userName))) {

                    writer.write(line);
                    writer.newLine();
                } else {
                    found = true; // found and user deleted it.
                }
            }

            // Display messages accordinly.
            if (found) {
                JOptionPane.showMessageDialog(null, "Registro de usuario Eliminado", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException e) {
            e.printStackTrace();
            // retrieve a massage in case of any issue.
            return;
        }
        //Rename the temp file to the original
        File originalFile = new File(fileName);
        File tempFile = new File(tempFileName);

        //verify if the temp file was created before rename it.
        if (!tempFile.exists() || !tempFile.isFile()) {
            System.out.println("Error: El archivo temporal no se creó correctamente.");
            return;
        }
        // Detele the original file before renaming the temp file.
        if (!originalFile.delete()) {
            System.out.println("Error al eliminar el archivo original.");
            return;
        }

        // rename the temp file to the original.
        if (!tempFile.renameTo(originalFile)) {
            System.out.println("Error al renombrar el archivo temporal.");
            return;
        }
    }

}
