package cr.ac.ucenfotec.dl;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una elección nacional.
 * Gestiona candidatos, votos y determina los resultados.
 */
public class EleccionNacional {

    private String nombre;
    private List<Candidato> candidatos;
    private List<Voto> votos;

    public EleccionNacional(String nombreObjeto) {
        this.nombre = nombreObjeto;
        this.candidatos = new ArrayList<>();
        this.votos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setNombre(String nombreNuevo) {
        this.nombre = nombreNuevo;
    }

    public void setCandidatos(List<Candidato> candidatosNuevos) {
        this.candidatos = candidatosNuevos;
    }

    public void setVotos(List<Voto> votosNuevos) {
        this.votos = votosNuevos;
    }

    // ================= COMPORTAMIENTO DE NEGOCIO =================

    /**
     * Registra un nuevo candidato en la elección si no existe todavía.
     */
    public void registrarCandidato(Candidato candidato) {
        if (candidato != null && !candidatos.contains(candidato)) {
            candidatos.add(candidato);
        }
    }

    /**
     * Registra un voto ya construido.
     */
    public void registrarVoto(Voto voto) {
        if (voto != null) {
            votos.add(voto);
        }
    }

    /**
     * Crea y registra un voto a partir de un ciudadano y un candidato.
     */
    public void registrarVoto(Ciudadano ciudadano, Candidato candidato) {
        if (ciudadano != null && candidato != null) {
            Voto nuevoVoto = new Voto(ciudadano, candidato);
            votos.add(nuevoVoto);
        }
    }

    /**
     * Reinicia los votos de cada candidato y vuelve a contarlos
     * según la lista de Voto almacenada en la elección.
     */
    public void contarVotos() {
        // Reiniciar conteo
        for (Candidato c : candidatos) {
            c.setVotos(0);
        }
        // Volver a sumar según cada voto
        for (Voto voto : votos) {
            Candidato asociado = voto.getCandidato();
            asociado.setVotos(asociado.getVotos() + 1);
        }
    }

    /**
     * Devuelve el máximo número de votos que tiene algún candidato.
     */
    public int obtenerMaximoVotos() {
        int max = 0;
        for (Candidato c : candidatos) {
            if (c.getVotos() > max) {
                max = c.getVotos();
            }
        }
        return max;
    }

    /**
     * Indica si hay más de un candidato con la cantidad máxima de votos.
     */
    public boolean hayEmpate() {
        int max = obtenerMaximoVotos();
        int cantidadConMax = 0;

        for (Candidato c : candidatos) {
            if (c.getVotos() == max) {
                cantidadConMax++;
            }
        }
        return cantidadConMax > 1;
    }

    /**
     * Si hay un único ganador, lo devuelve.
     * Si hay empate, devuelve null.
     */
    public Candidato obtenerGanadorUnico() {
        int max = obtenerMaximoVotos();
        Candidato ganador = null;

        for (Candidato c : candidatos) {
            if (c.getVotos() == max) {
                if (ganador == null) {
                    ganador = c;           // primer candidato con el máximo
                } else {
                    return null;           // hay más de uno → empate
                }
            }
        }
        return ganador;
    }

    /**
     * Devuelve la lista de candidatos empatados con el máximo número de votos.
     * Útil para mostrar quiénes pasan a segunda ronda.
     */
    public List<Candidato> obtenerCandidatosEmpatados() {
        List<Candidato> empatados = new ArrayList<>();
        int max = obtenerMaximoVotos();

        for (Candidato c : candidatos) {
            if (c.getVotos() == max) {
                empatados.add(c);
            }
        }
        return empatados;
    }

    @Override
    public String toString() {
        return "Elección: " + nombre +
                ", Candidatos: " + candidatos.size() +
                ", Votos: " + votos.size();
    }

    public boolean equals(EleccionNacional eleccionComparar) {
        if (eleccionComparar == null) {
            return false;
        }
        return this.nombre.equals(eleccionComparar.nombre);
    }
}