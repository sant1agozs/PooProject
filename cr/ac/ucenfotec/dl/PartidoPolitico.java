package cr.ac.ucenfotec.dl;

/**
 * Representa un partido político dentro de la elección.
 */
public class PartidoPolitico {

    private String nombre;
    private String siglas;

    public PartidoPolitico(String nombreObjeto, String siglasObjeto) {
        this.nombre = nombreObjeto;
        this.siglas = siglasObjeto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setNombre(String nombreNuevo) {
        this.nombre = nombreNuevo;
    }

    public void setSiglas(String siglasNuevas) {
        this.siglas = siglasNuevas;
    }

    @Override
    public String toString() {
        return "Partido: " + nombre + " (" + siglas + ")";
    }

    public boolean equals(PartidoPolitico partidoComparar) {
        if (partidoComparar == null) {
            return false;
        }
        return this.nombre.equals(partidoComparar.nombre)
                && this.siglas.equals(partidoComparar.siglas);
    }
}