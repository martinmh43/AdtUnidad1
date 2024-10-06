import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio4 {

    private static final int TAMANIO_ID = 4;
    private static final int TAMANIO_APELLIDO = 20;
    private static final int TAMANIO_DEPARTAMENTO = 4;
    private static final int TAMANIO_SALARIO = 8;
    private static final int TAMANIO_REGISTRO = TAMANIO_ID + TAMANIO_APELLIDO + TAMANIO_DEPARTAMENTO + TAMANIO_SALARIO;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("ERROR: Son necesarios al menos 2 parámetros.");
            return;
        }

        String operacion = args[0];
        int id = Integer.parseInt(args[1]);

        switch (operacion) {
            case "modificar":
                if (args.length != 3) {
                    System.out.println("ERROR: Son necesarios 3 parámetros para modificar.");
                    return;
                }
                double importe = Double.parseDouble(args[2]);
                modificarSalario(id, importe);
                break;

            case "borrar":
                borrarEmpleado(id);
                break;

            case "mostrarBorrados":
                mostrarEmpleadosBorrados();
                break;

            default:
                System.out.println("ERROR: Operación no válida.");
        }
    }

    private static void modificarSalario(int id, double importe) {
        try (RandomAccessFile archivo = new RandomAccessFile("empleados.dat", "rw")) {
            long posicion = (id - 1) * TAMANIO_REGISTRO;

            if (posicion >= archivo.length()) {
                System.out.println("ERROR: El empleado con ID " + id + " no existe.");
                return;
            }

            archivo.seek(posicion);
            int idEmpleado = archivo.readInt();

            if (idEmpleado == 0) {
                System.out.println("ERROR: El empleado con ID " + id + " no existe.");
                return;
            }

            byte[] apellidoBytes = new byte[TAMANIO_APELLIDO];
            archivo.readFully(apellidoBytes);
            String apellido = new String(apellidoBytes).trim();

            archivo.skipBytes(TAMANIO_DEPARTAMENTO);
            double salarioAntiguo = archivo.readDouble();

            double nuevoSalario = salarioAntiguo + importe;
            archivo.seek(posicion + TAMANIO_ID + TAMANIO_APELLIDO + TAMANIO_DEPARTAMENTO);
            archivo.writeDouble(nuevoSalario);

            System.out.println("Empleado: " + apellido);
            System.out.println("Salario antiguo: " + salarioAntiguo);
            System.out.println("Nuevo salario: " + nuevoSalario);

        } catch (IOException e) {
            System.out.println("ERROR al modificar el salario.");
        }
    }

    private static void borrarEmpleado(int id) {
        try (RandomAccessFile archivo = new RandomAccessFile("empleados.dat", "rw")) {
            long posicion = (id - 1) * TAMANIO_REGISTRO;

            if (posicion >= archivo.length()) {
                System.out.println("ERROR: El empleado con ID " + id + " no existe.");
                return;
            }

            archivo.seek(posicion);
            int idEmpleado = archivo.readInt();

            if (idEmpleado == 0) {
                System.out.println("ERROR: El empleado con ID " + id + " no existe.");
                return;
            }

            archivo.seek(posicion);
            archivo.writeInt(-1);
            archivo.writeBytes(String.format("%-" + TAMANIO_APELLIDO + "s", idEmpleado));
            archivo.writeInt(0);
            archivo.writeDouble(0);

            System.out.println("Empleado con ID " + id + " ha sido marcado como borrado.");

        } catch (IOException e) {
            System.out.println("ERROR al borrar el empleado.");
        }
    }

    private static void mostrarEmpleadosBorrados() {
        try (RandomAccessFile archivo = new RandomAccessFile("empleados.dat", "r")) {
            long numRegistros = archivo.length() / TAMANIO_REGISTRO;

            for (int i = 0; i < numRegistros; i++) {
                archivo.seek(i * TAMANIO_REGISTRO);
                int idEmpleado = archivo.readInt();

                if (idEmpleado == -1) {
                    byte[] apellidoBytes = new byte[TAMANIO_APELLIDO];
                    archivo.readFully(apellidoBytes);
                    String apellido = new String(apellidoBytes).trim();

                    System.out.println("Empleado borrado: " + apellido);
                }
            }

        } catch (IOException e) {
            System.out.println("ERROR al mostrar empleados borrados.");
        }
    }
}
