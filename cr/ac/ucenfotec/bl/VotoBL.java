package cr.ac.ucenfotec.bl;

import cr.ac.ucenfotec.dl.*;

/**
 * Lógica para validación y creación de votos.
 */
public class VotoBL {

    public Voto crearVoto(Ciudadano ciudadano, Candidato candidato) {
        return new Voto(ciudadano, candidato);
    }

    public boolean ciudadanoPuedeVotar(Ciudadano c) {
        return !c.getYaVoto();
    }
}