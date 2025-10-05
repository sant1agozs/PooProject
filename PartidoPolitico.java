// Relación de AGREGACIÓN: la clase es usada por Candidato,
// pero ambos pueden existir de forma independiente.

public class PartidoPolitico {
    private String nombre;
    private String siglas;

    // Constructor con todos los datos
    public PartidoPolitico(String nombreObjeto, String siglasObjeto) {
        nombre = nombreObjeto;
        siglas = siglasObjeto;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    // Setters
    public void setNombre(String nombreNuevo) {
        nombre = nombreNuevo;
    }

    public void setSiglas(String siglasNuevas) {
        siglas = siglasNuevas;
    }

    // Muestra los datos del partido en una sola línea
    @Override
    public String toString() {
        return "Partido: " + nombre + " (" + siglas + ")";
    }

    // Compara dos partidos políticos para ver si son iguales
    public boolean equals(PartidoPolitico partidoComparar) {
        return nombre.equals(partidoComparar.nombre) &&
                siglas.equals(partidoComparar.siglas);
    }
}