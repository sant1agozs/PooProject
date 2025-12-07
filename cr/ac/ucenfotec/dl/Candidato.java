package cr.ac.ucenfotec.dl;

import java.util.Objects;

public class Candidato {
    private int id;
    private String nombre;
    private PartidoPolitico partido;
    private int votos;

    public Candidato(int id, String nombre, PartidoPolitico partido, int votos) {
        this.id = id;
        this.nombre = nombre;
        this.partido = partido;
        this.votos = votos;
    }

    public Candidato(String nombre, PartidoPolitico partido, int votos) {
        this(0, nombre, partido, votos);
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }

    public PartidoPolitico getPartido() { return partido; }

    public int getVotos() { return votos; }

    public void setVotos(int votos) { this.votos = votos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidato)) return false;
        Candidato that = (Candidato) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}