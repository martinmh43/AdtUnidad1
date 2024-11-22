package preparacioj;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InsertarDatosFichero {
    public static void main(String[] args) {
        // Datos a insertar
        String[] nombres = {"Ana", "Luis", "María", "Carlos"};
        int[] edades = {25, 30, 22, 35};

        // Ruta del archivo
        String basePath = "C:\\Users\\Martín\\IdeaProjects\\AdtUnidad1\\src\\preparacioj\\NUEVODIR";
        File file = new File(basePath, "FichData.dat");

        // Escritura de datos en el archivo
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < nombres.length; i++) {
                dos.writeUTF(nombres[i]); // Escribir el nombre
                dos.writeInt(edades[i]); // Escribir la edad
            }
            System.out.println("Datos escritos correctamente en el archivo: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
