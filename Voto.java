// Relación de COMPOSICIÓN: el voto depende totalmente del votante y del candidato.
// Si la elección se elimina, estos votos dejan de existir.

public class Voto {
    private Ciudadano votante;
    private Candidato candidato;

    // Constructor con todos los datos
    public Voto(Ciudadano votanteObjeto, Candidato candidatoObjeto) {
        votante = votanteObjeto;
        candidato = candidatoObjeto;
    }

    // Getters
    public Ciudadano getVotante() {
        return votante;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    // Setters
    public void setVotante(Ciudadano votanteNuevo) {
        votante = votanteNuevo;
    }

    public void setCandidato(Candidato candidatoNuevo) {
        candidato = candidatoNuevo;
    }

    // Muestra los datos del voto en una sola línea
    @Override
    public String toString() {
        return "Votante: " + votante.getNombre() +
                " → Candidato: " + candidato.getNombre();
    }

    // Compara dos votos para ver si son iguales
    public boolean equals(Voto votoComparar) {
        return votante.equals(votoComparar.votante) &&
                candidato.equals(votoComparar.candidato);
    }
}