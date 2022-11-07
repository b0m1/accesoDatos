import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String dni;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni= dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad <= 0) {
            this.edad = 1;
        } else {
            this.edad = edad;
        }

    }

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona() {
        this.nombre = "";
        this.dni = "";
        this.edad = 0;
    }
}
