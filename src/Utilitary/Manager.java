package Utilitary;

import Data.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author eefre
 */
public class Manager {

    public static boolean validateAuser(String userName, String password) {
        String fileName = "Users.txt";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String userN = parts[1].trim(); // trim() remove white space before and after
                String pwd = parts[2].trim();

                if (userName.equals(userN) && password.equals(pwd)) {
                    JOptionPane.showMessageDialog(null, "Hola, " + userN, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static int recordCounter = 0;

    public static String generateRecordID() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Records.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].substring(3)); // Extract numerical part of record ID
                if (id > recordCounter) {
                    recordCounter = id;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        recordCounter++; // Increment counter
        return "REG" + String.format("%04d", recordCounter);
    }
}
