import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class Ejercicio1 {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("HAY QUE INTRODUCIR UN ARGUMENTO....");
        } else {
            Path directorio = Paths.get(args[0]);
            if (Files.exists(directorio) && Files.isDirectory(directorio)) {
                try (Stream<Path> stream = Files.list(directorio)) {
                    System.out.println("Archivos en el directorio " + directorio.toString() + ":");
                    stream.forEach(System.out::println);
                } catch (IOException e) {
                    System.out.println("Error al leer el directorio: " + e.getMessage());
                }
            } else {
                System.out.println("DIRECTORIO INEXISTENTE");
            }
        }
    }
}
