package cr.ac.ucenfotec.bl;

import cr.ac.ucenfotec.dl.Ciudadano;

/**
 * Lógica asociada a ciudadanos.
 */
public class CiudadanoBL {

    public Ciudadano crearCiudadano(String nombre, String cedula) {
        return new Ciudadano(nombre, cedula, false);
    }

    public boolean validarCedula(String cedula) {
        return cedula != null && cedula.contains("-");
    }
}