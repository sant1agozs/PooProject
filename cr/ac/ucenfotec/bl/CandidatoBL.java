package cr.ac.ucenfotec.bl;

import cr.ac.ucenfotec.dl.Candidato;
import cr.ac.ucenfotec.dl.PartidoPolitico;

/**
 * Lógica de negocio para candidatos.
 * En esta versión funciona como soporte (validaciones simples).
 */
public class CandidatoBL {

    public Candidato crearCandidato(String nombre, PartidoPolitico partido) {
        return new Candidato(nombre, partido, 0);
    }

    public boolean validarNombre(String nombre) {
        return nombre != null && !nombre.isEmpty() && nombre.length() >= 3;
    }
}