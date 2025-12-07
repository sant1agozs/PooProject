package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.EleccionBL;
import cr.ac.ucenfotec.dao.*;
import cr.ac.ucenfotec.dl.*;

import java.util.List;

public class EleccionController {

    private EleccionBL eleccionBL = new EleccionBL("Elecciones Nacionales");

    private CandidatoDAO candidatoDAO = new CandidatoDAO();
    private PartidoDAO partidoDAO = new PartidoDAO();
    private CiudadanoDAO ciudadanoDAO = new CiudadanoDAO();
    private VotoDAO votoDAO = new VotoDAO();

    public EleccionController() {
        cargarDatosIniciales();
    }

    // ==========================================================
    //               CARGA INICIAL DE DATOS
    // ==========================================================
    private void cargarDatosIniciales() {
        try {
            // Cargar candidatos desde BD
            List<Candidato> candidatos = candidatoDAO.listar();
            eleccionBL.setCandidatos(candidatos);

            // Cargar votos desde BD
            List<Voto> votos = votoDAO.listar();
            eleccionBL.setVotos(votos);

        } catch (Exception e) {
            System.out.println("Error cargando datos iniciales: " + e.getMessage());
        }
    }

    // ==========================================================
    //                     CANDIDATOS
    // ==========================================================
    public void agregarCandidato(String nombre, String partidoNombre, String siglas) {
        try {
            siglas = siglas.toUpperCase().trim();

            PartidoPolitico p = new PartidoPolitico(partidoNombre, siglas);
            partidoDAO.insertar(p);

            Candidato c = new Candidato(nombre, p, 0);
            candidatoDAO.insertar(c);

            // Actualiza lista interna
            refrescarCandidatos();

            System.out.println("Candidato guardado correctamente.");
        } catch (Exception e) {
            System.out.println("Error guardando candidato: " + e.getMessage());
        }
    }

    // ==========================================================
    //       SIEMPRE LEER CANDIDATOS DESDE LA BD
    // ==========================================================
    public List<Candidato> obtenerCandidatos() {
        try {
            List<Candidato> lista = candidatoDAO.listar();
            eleccionBL.setCandidatos(lista); // actualiza memoria
            return lista;
        } catch (Exception e) {
            System.out.println("Error obteniendo candidatos: " + e.getMessage());
            return null;
        }
    }

    private void refrescarCandidatos() throws Exception {
        List<Candidato> lista = candidatoDAO.listar();
        eleccionBL.setCandidatos(lista);
    }

    // ==========================================================
    //                     CIUDADANOS
    // ==========================================================
    public Ciudadano crearCiudadano(String nombre, String cedula) {
        try {
            Ciudadano c = new Ciudadano(nombre, cedula, false);
            ciudadanoDAO.insertar(c);
            return c;

        } catch (Exception e) {
            System.out.println("Error guardando ciudadano: " + e.getMessage());
            return null;
        }
    }

    // ==========================================================
    //                     REGISTRAR VOTO
    // ==========================================================
    public void registrarVoto(Ciudadano ciudadano, Candidato candidato) {
        try {
            eleccionBL.registrarVoto(ciudadano, candidato);

            Voto v = new Voto(ciudadano, candidato);
            votoDAO.insertar(v);

            ciudadano.setYaVoto(true);
            ciudadanoDAO.actualizar(ciudadano);

            System.out.println("Voto registrado correctamente.");

        } catch (Exception e) {
            System.out.println("Error registrando voto: " + e.getMessage());
        }
    }

    // ==========================================================
    //                      RESULTADOS
    // ==========================================================

    public void contarVotos() {
        try {
            // 1. Recargar candidatos desde BD
            List<Candidato> candidatos = candidatoDAO.listar();
            eleccionBL.setCandidatos(candidatos);

            // 2. Recargar votos desde BD
            List<Voto> votos = votoDAO.listar();
            eleccionBL.setVotos(votos);

            // 3. Contar votos reales
            eleccionBL.contarVotos();

            // 4. Actualizar votos en BD
            for (Candidato c : eleccionBL.obtenerCandidatos()) {
                candidatoDAO.actualizarVotos(c);
            }

        } catch (Exception e) {
            System.out.println("Error contando votos: " + e.getMessage());
        }
    }

    private void actualizarVotosEnBD() {
        try {
            List<Candidato> candidatos = obtenerCandidatos(); // ahora sí con IDs correctos

            for (Candidato c : candidatos) {
                candidatoDAO.actualizarVotos(c);
            }

        } catch (Exception e) {
            System.out.println("Error actualizando votos: " + e.getMessage());
        }
    }

    public boolean hayEmpate() {
        return eleccionBL.hayEmpate();
    }

    public Candidato obtenerGanador() {
        return eleccionBL.obtenerGanador();
    }

    public List<Candidato> obtenerEmpatados() {
        return eleccionBL.obtenerEmpatados();
    }

    public String obtenerNombreEleccion() {
        return eleccionBL.getNombreEleccion();
    }
}