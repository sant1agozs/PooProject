// Relación de AGREGACIÓN: el candidato pertenece a un partido,
// pero puede existir aunque el partido no esté registrado.

class Candidato {
    private String nombre;
    private PartidoPolitico partido;
    private int votos;

    public Candidato(String nombre, PartidoPolitico partido) {
        this.nombre = nombre;
        this.partido = partido;
        this.votos = 0;
    }

    public String getNombre() { return nombre; }
    public PartidoPolitico getPartido() { return partido; }
    public int getVotos() { return votos; }

    public void agregarVoto() {
        votos++;
    }

    @Override
    public String toString() {
        return nombre + " - " + partido + " | Votos: " + votos;
    }
}