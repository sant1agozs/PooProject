package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.tl.EleccionController;
import cr.ac.ucenfotec.dl.Candidato;
import cr.ac.ucenfotec.dl.Ciudadano;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static EleccionController controller = new EleccionController();

    public void iniciar() throws Exception {

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1) Agregar candidato");
            System.out.println("2) Registrar votación");
            System.out.println("3) Mostrar resultados");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(in.readLine());

            switch (opcion) {
                case 1:
                    agregarCandidato();
                    break;

                case 2:
                    registrarVotacion();
                    break;

                case 3:
                    mostrarResultados();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // ===========================================================
    // AGREGAR CANDIDATO
    // ===========================================================
    private static void agregarCandidato() throws Exception {
        System.out.print("Nombre del candidato: ");
        String nombre = in.readLine();

        System.out.print("Nombre del partido: ");
        String partido = in.readLine();

        System.out.print("Siglas: ");
        String siglas = in.readLine();

        controller.agregarCandidato(nombre, partido, siglas);
    }

    // ===========================================================
    // REGISTRAR VOTACIÓN (CORREGIDO)
    // ===========================================================
    private static void registrarVotacion() throws Exception {

        System.out.print("Nombre del ciudadano: ");
        String nombreC = in.readLine();

        System.out.print("Cédula: ");
        String cedula = in.readLine();

        // Crear ciudadano en DB
        Ciudadano ciudadano = controller.crearCiudadano(nombreC, cedula);
        if (ciudadano == null) {
            System.out.println("Error creando ciudadano.");
            return;
        }

        // Obtener candidatos DESDE BD con sus IDs correctos
        List<Candidato> candidatos = controller.obtenerCandidatos();

        if (candidatos.isEmpty()) {
            System.out.println("No hay candidatos registrados.");
            return;
        }

        System.out.println("Seleccione candidato:");
        for (int i = 0; i < candidatos.size(); i++) {
            System.out.println((i + 1) + ") " + candidatos.get(i).getNombre());
        }

        System.out.print("Opción: ");
        int opc = Integer.parseInt(in.readLine());

        if (opc < 1 || opc > candidatos.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        // SELECCIONA EL CANDIDATO CORRECTO (CON ID REAL DE BD)
        Candidato candidatoElegido = candidatos.get(opc - 1);

        // Registrar voto
        controller.registrarVoto(ciudadano, candidatoElegido);
    }

    // ===========================================================
    // MOSTRAR RESULTADOS
    // ===========================================================
    private static void mostrarResultados() {

        controller.contarVotos();

        System.out.println("\n===== RESULTADOS COMPLETOS =====");

        List<Candidato> todos = controller.obtenerCandidatos();

        // 1. Ordenar de mayor a menor por votos
        todos.sort((a, b) -> Integer.compare(b.getVotos(), a.getVotos()));

        // 2. Imprimir todos los candidatos
        for (Candidato c : todos) {
            System.out.println(c.getNombre() + " - Votos: " + c.getVotos());
        }

        // 3. Mostrar ganador o empate
        if (controller.hayEmpate()) {
            System.out.println("\n*** EMPATE ***");
            for (Candidato c : controller.obtenerEmpatados()) {
                System.out.println(c.getNombre() + " - Votos: " + c.getVotos());
            }
        } else {
            Candidato ganador = controller.obtenerGanador();
            System.out.println("\n*** GANADOR ***");
            System.out.println(ganador.getNombre() + " - Votos: " + ganador.getVotos());
        }
    }
}