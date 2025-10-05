class Voto {
    private Ciudadano votante;
    private Candidato candidato;

    public Voto(Ciudadano votante, Candidato candidato) {
        this.votante = votante;
        this.candidato = candidato;
    }

    public Candidato getCandidato() { return candidato; }
}