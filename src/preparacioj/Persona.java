package preparacioj;

import java.io.Serializable;

public class Persona implements Serializable {
    private static final long serialVersionUID = 1L; // Versión para garantizar compatibilidad
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}
