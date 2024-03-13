package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author eefre
 */
public class Appointment {

    private String pet;
    private Date date;
    private String hour;
    private String minutes;
    private String timeSystem;
    private String service;
    private String doctor;

    public Appointment(String pet, Date date, String hour, String minutes, String timeSystem, String service, String doctor) {
        this.pet = pet;
        this.date = date;
        this.hour = hour;
        this.minutes = minutes;
        this.timeSystem = timeSystem;
        this.service = service;
        this.doctor = doctor;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getTimeSystem() {
        return timeSystem;
    }

    public void setTimeSystem(String timeSystem) {
        this.timeSystem = timeSystem;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public static void CreateNewAppointment(String pet, Date date, String hour, String minutes, String timeSystem, String service, String doctor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Appointment.txt", true))) {
            writer.write(pet + "," + date + "," + hour + "," + minutes + "," + timeSystem + "," + service + "," + doctor);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Datos de cita guardados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datos NO Guardados", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static String[] readPet(String id) {
        String fileName = "Appointment.txt";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String petId = parts[0];
                if (petId.equals(id)) {
                    String[] data = new String[7];
                    for (int i = 0; i < parts.length; i++) {
                        data[i] = parts[i];
                    }
                    return data;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateAppointment() {
        String fileName = "Appointment.txt";
        String tempFileName = "Appointment_temp.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String petId = parts[0];

                if (petId.equals(pet)) {
                    //if the pet ID is found, the information is gonna be updated.
                    writer.write(pet + "," + date + "," + hour + "," + minutes + "," + timeSystem + "," + service + "," + doctor);
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
    
    public static void deleteAppointment(String id) {
        String fileName = "Appointment.txt";
        String tempFileName = "Appointment_temp.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {

            String line;
            boolean found = false; 
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String petId = parts[0];

                if (!petId.equals(id)) {
                    
                    writer.write(line);
                    writer.newLine();
                } else {
                    found = true; // found and pet deleted it.
                }
            }

            // Display messages accordinly.
            if (found) {
                JOptionPane.showMessageDialog(null, "Registro de cita Eliminado", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cita no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
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
