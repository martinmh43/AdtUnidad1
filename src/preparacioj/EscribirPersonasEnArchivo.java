package preparacioj;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirPersonasEnArchivo {
    public static void main(String[] args) {
        // Ruta del archivo
        String basePath = "C:\\Users\\Martín\\IdeaProjects\\AdtUnidad1\\src\\preparacioj\\NUEVODIR";
        File fichero = new File(basePath, "FichPersona.dat");

        // Crear objetos Persona
        Persona[] personas = {
                new Persona("Ana", 25),
                new Persona("Luis", 30),
                new Persona("María", 22),
                new Persona("Carlos", 35)
        };

        // Escribir los objetos en el archivo
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(fichero))) {
            for (Persona persona : personas) {
                objOut.writeObject(persona); // Escribir objeto en el archivo
            }
            System.out.println("Objetos escritos correctamente en el archivo: " + fichero.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
