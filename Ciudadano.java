// Relación de DEPENDENCIA: el ciudadano necesita una elección para votar,
// pero no pertenece ni se almacena dentro de ella.

public class Ciudadano {
    private String nombre;
    private String cedula;
    private boolean yaVoto;

    // Constructor con todos los datos
    public Ciudadano(String nombreObjeto, String cedulaObjeto, boolean yaVotoObjeto) {
        nombre = nombreObjeto;
        cedula = cedulaObjeto;
        yaVoto = yaVotoObjeto;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public boolean getYaVoto() {
        return yaVoto;
    }

    // Setters
    public void setNombre(String nombreNuevo) {
        nombre = nombreNuevo;
    }

    public void setCedula(String cedulaNueva) {
        cedula = cedulaNueva;
    }

    public void setYaVoto(boolean yaVotoNuevo) {
        yaVoto = yaVotoNuevo;
    }

    // Muestra los datos del ciudadano en una sola línea
    @Override
    public String toString() {
        return "Ciudadano: " + nombre +
                ", Cédula: " + cedula +
                ", Ya votó: " + yaVoto;
    }

    // Compara dos ciudadanos para ver si son iguales
    public boolean equals(Ciudadano ciudadanoComparar) {
        return nombre.equals(ciudadanoComparar.nombre) &&
                cedula.equals(ciudadanoComparar.cedula) &&
                yaVoto == ciudadanoComparar.yaVoto;
    }
}