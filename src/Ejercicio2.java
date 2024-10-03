import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("HAY QUE INTRODUCIR UN ARGUMENTO....");
            return;
        }

        String nombreFichero = args[0];
        try (FileReader fr = new FileReader(nombreFichero)) {
            int caracter;
            while ((caracter = fr.read()) != -1) {
                System.out.print((char) caracter);
            }

        } catch (FileNotFoundException e) {
            System.out.println("NO EXISTE EL FICHERO....");
        } catch (IOException e) {
            System.out.println("ERROR AL LEER EL FICHERO....");
        }
    }
}
