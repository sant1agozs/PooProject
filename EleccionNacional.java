import java.util.ArrayList;

public class EleccionNacional {
    private String nombre;
    private ArrayList<Candidato> candidatos;
    private ArrayList<Voto> votos;

    // Constructor con todos los datos
    public EleccionNacional(String nombreObjeto) {
        nombre = nombreObjeto;
        candidatos = new ArrayList<>();
        votos = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    public ArrayList<Voto> getVotos() {
        return votos;
    }

    // Setters
    public void setNombre(String nombreNuevo) {
        nombre = nombreNuevo;
    }

    public void setCandidatos(ArrayList<Candidato> candidatosNuevos) {
        candidatos = candidatosNuevos;
    }

    public void setVotos(ArrayList<Voto> votosNuevos) {
        votos = votosNuevos;
    }

    // Muestra los datos de la elección
    @Override
    public String toString() {
        return "Elección: " + nombre +
                ", Candidatos: " + candidatos.size() +
                ", Votos: " + votos.size();
    }

    // Compara dos elecciones para ver si son iguales
    public boolean equals(EleccionNacional eleccionComparar) {
        return nombre.equals(eleccionComparar.nombre);
    }
}