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
public class Pet {

    private int id;
    private String petName;
    private String breed;
    private String age;
    private String weight;
    private String medicalConditions;
    private String owner;

    public Pet(int id, String petName, String breed, String age, String weight, String medicalConditions, String owner) {
        this.id = id;
        this.petName = petName;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
        this.medicalConditions = medicalConditions;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public static void CreateNewPet(int id, String name, String breed, String age, String weight, String medC, String selectedClient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Pets.txt", true))) {
            writer.write(id + "," + name + "," + breed + "," + age + "," + weight + "," + medC + "," + selectedClient);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Datos de Mascota guardados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datos NO Guardados", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static String[] readPet(int id) {
        String fileName = "Pets.txt";
        String line; // This is important, "line" will read line by line in the Pets file.

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int petId = Integer.parseInt(parts[0]);
                if (petId == id) {
                    String[] petData = new String[6];
                    petData[0] = parts[1];
                    petData[1] = parts[2];
                    petData[2] = parts[3];
                    petData[3] = parts[4];
                    petData[4] = parts[5];
                    petData[5] = parts[6];
                    return petData;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // It retrieves null if any value is found.
    }

    public boolean updatePets() {
        String fileName = "Pets.txt";
        String tempFileName = "Pets_temp.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int petId = Integer.parseInt(parts[0].trim());

                if (petId == id) {
                    //if the pet ID is found, the information is gonna be updated.
                    writer.write(id + "," + petName + "," + breed + "," + age + "," + weight + "," + medicalConditions + "," + owner);
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
    
    public static void deletePet(int id) {
        String fileName = "Pets.txt";
        String tempFileName = "Pets_temp.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {

            String line;
            boolean found = false; 
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int petId = Integer.parseInt(parts[0].trim());

                if (petId != id) {
                    
                    writer.write(line);
                    writer.newLine();
                } else {
                    found = true; // found and pet deleted it.
                }
            }

            // Display messages accordinly.
            if (found) {
                JOptionPane.showMessageDialog(null, "Registro de mascota Eliminado", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Mascota no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
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
