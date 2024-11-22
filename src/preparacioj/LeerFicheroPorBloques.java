package preparacioj;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroPorBloques {
    public static void main(String[] args) {
        // Ruta del archivo dentro de NUEVODIR
        String basePath = "C:\\Users\\Martín\\IdeaProjects\\AdtUnidad1\\src\\preparacioj\\NUEVODIR";
        File fileToRead = new File(basePath, "leerFichero.txt");

        // Comprobar si el archivo existe
        if (!fileToRead.exists()) {
            System.out.println("El archivo no existe: " + fileToRead.getAbsolutePath());
            return;
        }

        // Leer el archivo en bloques de 30 caracteres
        try (FileReader reader = new FileReader(fileToRead)) {
            char[] buffer = new char[30]; // Bloque de 30 caracteres
            int charsRead;
            while ((charsRead = reader.read(buffer)) != -1) {
                // Convertir el bloque leído en cadena y mostrarlo
                String block = new String(buffer, 0, charsRead);
                System.out.print(block);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
