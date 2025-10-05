// Relación de AGREGACIÓN: el candidato pertenece a un partido,
// pero puede existir aunque el partido no esté registrado.

public class Candidato {
    private String nombre;
    private PartidoPolitico partido;
    private int votos;

    // Constructor con todos los datos
    public Candidato(String nombreObjeto, PartidoPolitico partidoObjeto, int votosObjeto) {
        nombre = nombreObjeto;
        partido = partidoObjeto;
        votos = votosObjeto;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public PartidoPolitico getPartido() {
        return partido;
    }

    public int getVotos() {
        return votos;
    }

    // Setters
    public void setNombre(String nombreNuevo) {
        nombre = nombreNuevo;
    }

    public void setPartido(PartidoPolitico partidoNuevo) {
        partido = partidoNuevo;
    }

    public void setVotos(int votosNuevos) {
        votos = votosNuevos;
    }

    // Muestra los datos del candidato en una sola línea
    @Override
    public String toString() {
        return "Candidato: " + nombre +
                ", Partido: " + partido.getNombre() + " (" + partido.getSiglas() + ")" +
                ", Votos: " + votos;
    }

    // Compara dos candidatos para ver si son iguales
    public boolean equals(Candidato candidatoComparar) {
        return nombre.equals(candidatoComparar.nombre) &&
                partido.equals(candidatoComparar.partido) &&
                votos == candidatoComparar.votos;
    }
}