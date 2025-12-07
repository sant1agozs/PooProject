package cr.ac.ucenfotec.bl;

import cr.ac.ucenfotec.dl.PartidoPolitico;

/**
 * Soporte para creación y validación de partidos políticos.
 */
public class PartidoPoliticoBL {

    public PartidoPolitico crearPartido(String nombre, String siglas) {
        return new PartidoPolitico(nombre, siglas);
    }

    public boolean validarSiglas(String siglas) {
        return siglas != null && siglas.length() <= 5;
    }
}