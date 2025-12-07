package cr.ac.ucenfotec.dl;

/**
 * Clase base abstracta para representar una persona.
 * Sirve como padre de Ciudadano y Candidato.
 */
public abstract class Persona {

    protected String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreNuevo) {
        this.nombre = nombreNuevo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre;
    }
}