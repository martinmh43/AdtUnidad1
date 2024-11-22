package preparacioj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirEnArchivo {
    public static void main(String[] args) {
        // Ruta del archivo
        String basePath = "C:\\Users\\Martín\\IdeaProjects\\AdtUnidad1\\src\\preparacioj\\NUEVODIR";
        File file = new File(basePath, "leerFichero.txt");

        // Datos para escribir
        char[] charArray = {'H', 'o', 'l', 'a', ' ', 'm', 'u', 'n', 'd', 'o', '!', '\n'};
        String singleString = "Esta es una línea adicional.\n";
        String[] stringArray = {"Línea uno del array.\n", "Línea dos del array.\n", "Línea tres del array.\n"};

        try (FileWriter writer = new FileWriter(file, true)) { // `true` para añadir contenido
            // Escribir el array de caracteres
            writer.write(charArray);
            System.out.println("Array de caracteres escrito en el archivo.");

            // Escribir una cadena (String)
            writer.write(singleString);
            System.out.println("Cadena escrita en el archivo.");

            // Escribir el contenido de un array de String
            for (String line : stringArray) {
                writer.write(line);
            }
            System.out.println("Array de cadenas escrito en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
