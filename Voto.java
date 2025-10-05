// Relación de COMPOSICIÓN: el voto depende totalmente del votante y del candidato.
// Si la elección se elimina, estos votos dejan de existir.

class Voto {
    private Ciudadano votante;
    private Candidato candidato;

    public Voto(Ciudadano votante, Candidato candidato) {
        this.votante = votante;
        this.candidato = candidato;
    }

    public Candidato getCandidato() { return candidato; }
}