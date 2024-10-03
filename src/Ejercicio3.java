import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio3 {

    private static final int TAMANIO_ID = 4;
    private static final int TAMANIO_APELLIDO = 20;
    private static final int TAMANIO_DEPARTAMENTO = 4;
    private static final int TAMANIO_SALARIO = 8;
    private static final int TAMANIO_REGISTRO = TAMANIO_ID + TAMANIO_APELLIDO + TAMANIO_DEPARTAMENTO + TAMANIO_SALARIO;

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("ERROR son necesarios 4 parametros");
            return;
        }

        try {
            int id = Integer.parseInt(args[0]);
            String apellido = args[1];
            int departamento = Integer.parseInt(args[2]);
            double salario = Double.parseDouble(args[3]);

            insertaEmpleado(id, apellido, departamento, salario);

        } catch (NumberFormatException e) {
            if (e.getMessage().contains(args[0])) {
                System.out.println("ERROR tipo de argumento ID incorrecto");
            } else if (e.getMessage().contains(args[2])) {
                System.out.println("ERROR tipo de argumento DEP incorrecto");
            } else if (e.getMessage().contains(args[3])) {
                System.out.println("ERROR tipo de argumento SALARIO incorrecto");
            }
        }
    }

    private static void insertaEmpleado(int id, String apellido, int departamento, double salario) {
        try (RandomAccessFile archivo = new RandomAccessFile("empleados.dat", "rw")) {

            long posicion = (id - 1) * TAMANIO_REGISTRO;

            if (posicion >= archivo.length()) {
                archivo.setLength(posicion + TAMANIO_REGISTRO);
            }
            archivo.seek(posicion);
            int idEmpleado = archivo.readInt();

            if (idEmpleado != 0) {
                System.out.println("Error, el registro ya existe");
                return;
            }
            archivo.seek(posicion);
            archivo.writeInt(id);
            archivo.writeBytes(String.format("%-" + TAMANIO_APELLIDO + "s", apellido));
            archivo.writeInt(departamento);
            archivo.writeDouble(salario);

            System.out.println("Registro insertado correctamente");

        } catch (IOException e) {
            System.out.println("ERROR al escribir en el fichero.");
        }
    }
}
