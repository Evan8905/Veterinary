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
public class Record {

    private String refId;
    private String petId;
    private String diagnostic;
    private String treatment;
    private String mStudies;
    private String prescription;
    private String vaccines;

    public Record(String refId, String petId, String diagnostic, String treatment, String mStudies, String prescription, String vaccines) {
        this.refId = refId;
        this.petId = petId;
        this.diagnostic = diagnostic;
        this.treatment = treatment;
        this.mStudies = mStudies;
        this.prescription = prescription;
        this.vaccines = vaccines;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getmStudies() {
        return mStudies;
    }

    public void setmStudies(String mStudies) {
        this.mStudies = mStudies;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getVaccines() {
        return vaccines;
    }

    public void setVaccines(String vaccines) {
        this.vaccines = vaccines;
    }

    public static void CreateNewRecord(String refId, String petId, String diagnostic, String treatment, String mStudies, String prescription, String vaccines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Records.txt", true))) {
            writer.write(refId + "," + petId + "," + diagnostic + "," + treatment + "," + mStudies + "," + prescription + "," + vaccines);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Registro " + refId + " guardado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datos NO Guardados", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String[] readRecord(String refId) {
        String fileName = "Records.txt";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String petId = parts[0];
                if (petId.equals(refId)) {
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

    public boolean updateRecord() {
        String fileName = "Records.txt";
        String tempFileName = "Records_temp.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String recId = parts[0];

                if (recId.equals(refId)) {
                    //if the ref ID is found, the information is gonna be updated.
                    writer.write(refId + "," + petId + "," + diagnostic + "," + treatment + "," + mStudies + "," + prescription + "," + vaccines);
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
    
    public static void deleteRecord(String refId) {
        String fileName = "Records.txt";
        String tempFileName = "Records_temp.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {

            String line;
            boolean found = false; 
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String recId = parts[0];

                if (!recId.equals(refId)) {
                    
                    writer.write(line);
                    writer.newLine();
                } else {
                    found = true; // found and record deleted.
                }
            }

            // Display messages accordinly.
            if (found) {
                JOptionPane.showMessageDialog(null, "Registro " + refId + " Eliminado", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Registro no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
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
