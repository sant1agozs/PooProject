package cr.ac.ucenfotec.dl;

/**
 * Representa a un ciudadano habilitado para votar.
 */
public class Ciudadano extends Persona {

    private String cedula;
    private boolean yaVoto;

    public Ciudadano(String nombreObjeto, String cedulaObjeto, boolean yaVotoObjeto) {
        super(nombreObjeto);
        this.cedula = cedulaObjeto;
        this.yaVoto = yaVotoObjeto;
    }

    public String getCedula() {
        return cedula;
    }

    public boolean getYaVoto() {
        return yaVoto;
    }

    public void setCedula(String cedulaNueva) {
        this.cedula = cedulaNueva;
    }

    public void setYaVoto(boolean yaVotoNuevo) {
        this.yaVoto = yaVotoNuevo;
    }

    @Override
    public String toString() {
        return "Ciudadano: " + nombre +
                ", Cédula: " + cedula +
                ", Ya votó: " + yaVoto;
    }

    public boolean equals(Ciudadano ciudadanoComparar) {
        if (ciudadanoComparar == null) {
            return false;
        }
        return this.nombre.equals(ciudadanoComparar.nombre)
                && this.cedula.equals(ciudadanoComparar.cedula)
                && this.yaVoto == ciudadanoComparar.yaVoto;
    }
}