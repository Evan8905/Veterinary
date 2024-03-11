package Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author eefre
 */
public class Appointment {

    private String pet;
    private Date date;
    private String time;
    private String service;
    private String doctor;

    public Appointment(String pet, Date date, String time, String service, String doctor) {
        this.pet = pet;
        this.date = date;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public static void CreateNewAppointment(String pet, Date date, String time, String service, String doctor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Appointment.txt", true))) {
            writer.write(pet + "," + date + "," + time + "," + service + "," + doctor);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Datos de cita guardados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datos NO Guardados", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
