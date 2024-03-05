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
                String userN = parts[1].trim(); // trim() remove white space
                String pwd = parts[2].trim();
                
                if (userName.equals(userN) && password.equals(pwd)) {
                    JOptionPane.showMessageDialog(null, "Hola," + userN, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        return false;
    }
}

