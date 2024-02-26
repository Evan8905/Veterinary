package Data;

import java.io.BufferedWriter;
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
            writer.write(id + "," + name + "," + breed + "," + age+ "," + weight + "," +medC+ "," +selectedClient);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Datos de Mascota guardados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datos NO Guardados", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
