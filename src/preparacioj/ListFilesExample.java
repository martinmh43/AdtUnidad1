import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListFilesExample {
    public static void main(String[] args) {
        // Ruta del directorio
        String path = "C:\\Users\\Martín\\IdeaProjects\\AdtUnidad1\\src\\preparacioj";

        // Crear objeto File
        File directory = new File(path);

        // Obtener el listado de directorios y archivos
        List<String> filesAndDirs = listFilesAndDirectories(directory);

        // Imprimir el resultado
        filesAndDirs.forEach(System.out::println);
    }

    public static List<String> listFilesAndDirectories(File dir) {
        List<String> resultList = new ArrayList<>();
        if (dir.exists() && dir.isDirectory()) {
            // Obtener listado de archivos y directorios
            String[] content = dir.list();
            if (content != null) {
                for (String name : content) {
                    resultList.add(name);
                }
            }
        } else {
            System.out.println("La ruta no existe o no es un directorio.");
        }
        return resultList;
    }
}
