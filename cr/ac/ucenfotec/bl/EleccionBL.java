package cr.ac.ucenfotec.bl;

import cr.ac.ucenfotec.dl.Candidato;
import cr.ac.ucenfotec.dl.Ciudadano;
import cr.ac.ucenfotec.dl.PartidoPolitico;
import cr.ac.ucenfotec.dl.Voto;

import java.util.ArrayList;
import java.util.List;

public class EleccionBL {

    private String nombreEleccion;
    private List<Candidato> candidatos = new ArrayList<>();
    private List<Voto> votos = new ArrayList<>();

    public EleccionBL(String nombreEleccion) {
        this.nombreEleccion = nombreEleccion;
    }

    public String getNombreEleccion() {
        return nombreEleccion;
    }

    // ================== CANDIDATOS ==================
    public void agregarCandidato(String nombre, PartidoPolitico partido) {
        Candidato c = new Candidato(nombre, partido, 0);
        candidatos.add(c);
    }

    public List<Candidato> obtenerCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> lista) {
        this.candidatos = lista;
    }

    // ================== VOTACIÓN ==================
    public void registrarVoto(Ciudadano ciudadano, Candidato candidato) {
        if (ciudadano.getYaVoto()) return;
        votos.add(new Voto(ciudadano, candidato));
        ciudadano.setYaVoto(true);
    }

    public void setVotos(List<Voto> lista) {
        this.votos = lista;
    }

    public void contarVotos() {

        for (Candidato c : candidatos) {
            c.setVotos(0);
        }

        for (Voto v : votos) {
            Candidato votado = v.getCandidato();

            for (Candidato c : candidatos) {
                if (c.getId() == votado.getId()) {
                    c.setVotos(c.getVotos() + 1);
                }
            }
        }
    }

    // ================== RESULTADOS ==================
    public boolean hayEmpate() {
        int max = obtenerMaxVotos();
        int count = 0;

        for (Candidato c : candidatos)
            if (c.getVotos() == max)
                count++;

        return count > 1;
    }

    public Candidato obtenerGanador() {
        int max = obtenerMaxVotos();
        for (Candidato c : candidatos)
            if (c.getVotos() == max)
                return c;

        return null;
    }

    public List<Candidato> obtenerEmpatados() {
        List<Candidato> empatados = new ArrayList<>();
        int max = obtenerMaxVotos();

        for (Candidato c : candidatos)
            if (c.getVotos() == max)
                empatados.add(c);

        return empatados;
    }

    private int obtenerMaxVotos() {
        int max = 0;
        for (Candidato c : candidatos)
            if (c.getVotos() > max)
                max = c.getVotos();
        return max;
    }
}