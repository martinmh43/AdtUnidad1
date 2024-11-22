package preparacioj;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class VisualizarDatosFichero {
    public static void main(String[] args) {
        // Ruta del archivo
        String basePath = "C:\\Users\\Martín\\IdeaProjects\\AdtUnidad1\\src\\preparacioj\\NUEVODIR";
        File file = new File(basePath, "FichData.dat");

        // Comprobar si el archivo existe
        if (!file.exists()) {
            System.out.println("El archivo no existe: " + file.getAbsolutePath());
            return;
        }

        // Leer y mostrar los datos del archivo
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            System.out.println("Contenido del archivo:");
            while (dis.available() > 0) {
                String nombre = dis.readUTF(); // Leer el nombre
                int edad = dis.readInt();     // Leer la edad
                System.out.printf("Nombre: \"%s\", Edad: \"%d\"%n", nombre, edad);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
