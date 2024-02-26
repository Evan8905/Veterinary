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
public class Client {

    private int id;
    private String name;
    private String address;
    private String pNumber;

    public Client(int id, String name, String address, String pNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pNumber = pNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public static void createNewClient(int id, String name, String address, String pNumber) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Clients.txt", true))) {
            writer.write(id + "," + name + "," + address + "," + pNumber);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Datos de Cliente guardados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datos NO Guardados", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String[] readClient(int id) {
        String fileName = "Clients.txt";
        String line; // This is important, "line" will read line by line in the Clients file.

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int clientId = Integer.parseInt(parts[0]);
                if (clientId == id) {
                    String[] clientData = new String[3];
                    clientData[0] = parts[1]; // Send Name
                    clientData[1] = parts[2]; // Send Addess
                    clientData[2] = parts[3]; // Send phone number
                    return clientData;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // It retrieves null if any value is found.
    }

    public boolean updateClient() {
        String fileName = "Clients.txt";
        String tempFileName = "Clients_temp.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int clientId = Integer.parseInt(parts[0].trim());

                if (clientId == id) {
                    //if the client ID is found, the information is gonna be updated.
                    writer.write(id + "," + name + "," + address + "," + pNumber);
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

        return true; // Si la operación fue exitosa, se devuelve true
    }

    public static void deleteClient(int id) {
        String fileName = "Clients.txt";
        String tempFileName = "Clients_temp.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {

            String line;
            boolean found = false; 
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int clientId = Integer.parseInt(parts[0].trim());

                if (clientId != id) {
                    
                    writer.write(line);
                    writer.newLine();
                } else {
                    found = true; // found and client deleted it.
                }
            }

            // Display messages accordinly.
            if (found) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Si hay algún error, imprimir el stack trace y salir del método
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
