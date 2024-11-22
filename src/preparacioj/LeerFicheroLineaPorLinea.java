package preparacioj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroLineaPorLinea {
    public static void main(String[] args) {
        // Ruta del archivo
        String basePath = "C:\\Users\\Martín\\IdeaProjects\\AdtUnidad1\\src\\preparacioj\\NUEVODIR";
        File file = new File(basePath, "LeerFichero.txt");

        // Comprobar si el archivo existe
        if (!file.exists()) {
            System.out.println("El archivo no existe: " + file.getAbsolutePath());
            return;
        }

        // Leer el archivo línea por línea
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Mostrar cada línea por pantalla
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
