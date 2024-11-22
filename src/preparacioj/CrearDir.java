package preparacioj;

import java.io.File;
import java.io.IOException;

public class CrearDir {
    public static void main(String[] args) {
        // Ruta base
        String basePath = "C:\\Users\\Martín\\IdeaProjects\\AdtUnidad1\\src\\preparacioj";

        // Crear el directorio NUEVODIR
        File newDir = new File(basePath + File.separator + "NUEVODIR");
        if (!newDir.exists()) {
            if (newDir.mkdir()) {
                System.out.println("Directorio creado: " + newDir.getAbsolutePath());
            } else {
                System.out.println("No se pudo crear el directorio.");
                return;
            }
        }

        // Crear dos ficheros vacíos en NUEVODIR
        File file1 = new File(newDir, "fichero1.txt");
        File file2 = new File(newDir, "fichero2.txt");
        try {
            if (file1.createNewFile()) {
                System.out.println("Archivo creado: " + file1.getName());
            } else {
                System.out.println("El archivo " + file1.getName() + " ya existe.");
            }
            if (file2.createNewFile()) {
                System.out.println("Archivo creado: " + file2.getName());
            } else {
                System.out.println("El archivo " + file2.getName() + " ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear los archivos: " + e.getMessage());
        }

        // Renombrar uno de los archivos
        File renamedFile = new File(newDir, "renombrado.txt");
        if (file1.renameTo(renamedFile)) {
            System.out.println("Archivo renombrado a: " + renamedFile.getName());
        } else {
            System.out.println("No se pudo renombrar el archivo.");
        }
    }
}
