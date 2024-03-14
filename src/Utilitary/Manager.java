package Utilitary;

import Data.User;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author eefre
 */
public class Manager {

    private static int recordCounter = 0;
    private static int appointmentCounter = 0;

    public static boolean validateAuser(String userName, String password, String userStatus) {
        String fileName = "Users.txt";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String userN = parts[1].trim(); // trim() remove white space before and after
                String pwd = parts[2].trim();
                String status = parts[4].trim();

                if (userName.equals(userN) && password.equals(pwd) && password.equals(pwd) && userStatus.equals(status)) {
                    JOptionPane.showMessageDialog(null, "Hola, " + userN, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

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

    public static String generateAppointmentID() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Appointment.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].substring(3)); // Extract numerical part of record ID
                if (id > appointmentCounter) {
                    appointmentCounter = id;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        appointmentCounter++; // Increment counter
        return "REG" + String.format("%04d", appointmentCounter);
    }

    public static java.util.List<String[]> getReport(String petSelected) {
        String[] fileNames = {"Appointment.txt", "Records.txt"};
        java.util.List<String[]> reportList = new java.util.ArrayList<>();

        for (String fileName : fileNames) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String petId = parts[1];
                    if (petId.equals(petSelected)) {
                        reportList.add(parts);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return reportList;
    }

//    public static void getRanking() {
//        String fileName = "Appointment.txt";
//        Map<String, Integer> petCounts = new HashMap<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                String petId = parts[1];
//                petCounts.put(petId, petCounts.getOrDefault(petId, 0) + 1);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Imprimir el ranking de mascotas
//        System.out.println("Ranking de Mascotas:");
//        for (Map.Entry<String, Integer> entry : petCounts.entrySet()) {
//            System.out.println("Mascota: " + entry.getKey() + ", Consultas: " + entry.getValue());
//        }
//    }
    public static void getRanking() {
        String fileName = "Appointment.txt";
        Map<String, Integer> petCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String petId = parts[1];
                petCounts.put(petId, petCounts.getOrDefault(petId, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Construir el mensaje para el JOptionPane
        StringBuilder message = new StringBuilder("Ranking de las 3 Mascotas Más Consultadas:\n");
        int count = 0;
        for (Map.Entry<String, Integer> entry : petCounts.entrySet()) {
            message.append("Mascota: ").append(entry.getKey()).append(", Consultas: ").append(entry.getValue()).append("\n");
            count++;
            if (count >= 3) {
                break; // Salir del bucle después de los tres primeros resultados
            }
        }

        // Mostrar el mensaje en un JOptionPane
        JOptionPane.showMessageDialog(null, message.toString(), "Ranking de Mascotas", JOptionPane.INFORMATION_MESSAGE);
    }

}
