package cr.ac.ucenfotec.dl;

/**
 * Representa un voto emitido por un ciudadano hacia un candidato.
 */
public class Voto {

    private Ciudadano votante;
    private Candidato candidato;

    public Voto(Ciudadano votanteObjeto, Candidato candidatoObjeto) {
        this.votante = votanteObjeto;
        this.candidato = candidatoObjeto;
    }

    public Ciudadano getVotante() {
        return votante;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setVotante(Ciudadano votanteNuevo) {
        this.votante = votanteNuevo;
    }

    public void setCandidato(Candidato candidatoNuevo) {
        this.candidato = candidatoNuevo;
    }

    @Override
    public String toString() {
        return "Votante: " + votante.getNombre() +
                " → Candidato: " + candidato.getNombre();
    }

    public boolean equals(Voto votoComparar) {
        if (votoComparar == null) {
            return false;
        }
        return this.votante.equals(votoComparar.votante)
                && this.candidato.equals(votoComparar.candidato);
    }
}