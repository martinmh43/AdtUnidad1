package preparacioj;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerPersonasDeArchivo {
    public static void main(String[] args) {
        // Ruta del archivo
        String basePath = "C:\\Users\\Martín\\IdeaProjects\\AdtUnidad1\\src\\preparacioj\\NUEVODIR";
        File fichero = new File(basePath, "FichPersona.dat");

        // Comprobar si el archivo existe
        if (!fichero.exists()) {
            System.out.println("El archivo no existe: " + fichero.getAbsolutePath());
            return;
        }

        // Leer los objetos del archivo
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(fichero))) {
            int contador = 1; // Contador para numerar las salidas
            while (true) {
                Persona persona = (Persona) objIn.readObject(); // Leer objeto del archivo
                System.out.printf("%d=>Nombre: \"%s\", Edad: \"%d\"%n", contador, persona.getNombre(), persona.getEdad());
                contador++;
            }
        } catch (EOFException e) {
            // Fin del archivo
            System.out.println("Lectura finalizada. Se alcanzó el final del archivo.");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
