package preparacioj;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertarDatosEmpleados {
    public static void main(String[] args) {
        // Datos a insertar
        String[] apellidos = {"García", "Martínez", "López", "Pérez", "Sánchez"};
        int[] departamentos = {1, 2, 1, 3, 2};
        double[] salarios = {2000.50, 2500.75, 1800.30, 3000.00, 2200.45};

        // Ruta del archivo
        String basePath = "C:\\Users\\Martín\\IdeaProjects\\AdtUnidad1\\src\\preparacioj\\NUEVODIR";
        File fichero = new File(basePath, "Empleados.dat");

        // Escritura en el archivo aleatorio
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            for (int i = 0; i < apellidos.length; i++) {
                int id = i + 1; // Identificador único para cada empleado

                // Escribir identificador (4 bytes)
                raf.writeInt(id);

                // Escribir apellido (10 caracteres = 20 bytes)
                String apellido = String.format("%-10s", apellidos[i]); // Asegurar que tiene 10 caracteres
                raf.writeChars(apellido);

                // Escribir departamento (4 bytes)
                raf.writeInt(departamentos[i]);

                // Escribir salario (8 bytes)
                raf.writeDouble(salarios[i]);
            }
            System.out.println("Datos de empleados escritos correctamente en el archivo: " + fichero.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}



/* El ejemplo siguiente inserta datos de empleados en un fichero aleatorio. Los datos a insertar:
apellido, departamento y salario, se obtienen de varios arrays que se llenan en el programa, los
datos se van introduciendo de forma secuencial por lo que no va a ser necesario usar el método
seek(). Por cada empleado también se insertará un identificador (mayor que 0) que coincidirá con el
índice +1 con el que se recorren los arrays. La longitud del registro de cada empleado es la misma
        (36 bytes) y los tipos que se insertan y su tamaño en bytes es el siguiente:
        • Se inserta en primer lugar un entero, que es el identificador, ocupa 4 bytes.
• A continuación una cadena de 10 caracteres, es el apellido. Como Java utiliza caracteres
UNICODE, cada carácter de una cadena de caracteres ocupa 16 bits (2 bytes), por tanto, el
apellido ocupa 20 bytes.
• Un tipo entero que es el departamento, ocupa 4 bytes.
• Un tipo Double que es el salario, ocupa 8 bytes.
        (Tamaño de otros tipos: short (2 bytes), byte (1 byte), long (8 bytes), boolean (1bit), float (4 bytes),
etc.)
El fichero se abre en modo "rw" para lectura y escritura. */
