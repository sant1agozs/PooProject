import java.util.ArrayList;

class EleccionNacional {
    private String nombre;
    private ArrayList<Candidato> candidatos; // agregación
    private ArrayList<Voto> votos;           // composición

    public EleccionNacional(String nombre) {
        this.nombre = nombre;
        this.candidatos = new ArrayList<>();
        this.votos = new ArrayList<>();
    }

    public void agregarCandidato(Candidato c) {
        candidatos.add(c);
    }

    public void registrarVoto(Voto voto) {
        votos.add(voto);
        voto.getCandidato().agregarVoto();
    }

    public void mostrarResultados() {
        System.out.println("\nResultados de la " + nombre + ":");
        for (Candidato c : candidatos) {
            System.out.println(c);
        }
    }

    public void mostrarGanador() {
        int maxVotos = 0;
        for (Candidato c : candidatos) {
            if (c.getVotos() > maxVotos) {
                maxVotos = c.getVotos();
            }
        }

        // Buscar todos los candidatos que tienen el máximo de votos
        ArrayList<Candidato> ganadores = new ArrayList<>();
        for (Candidato c : candidatos) {
            if (c.getVotos() == maxVotos) {
                ganadores.add(c);
            }
        }

        // Mostrar resultados
        if (ganadores.size() == 1) {
            Candidato g = ganadores.get(0);
            System.out.println("\n Ganador de las " + nombre + ": " +
                    g.getNombre() + " del partido " + g.getPartido().getNombre() +
                    " con " + g.getVotos() + " votos.");
        } else {
            System.out.println("\n️ Empate en las " + nombre + " entre:");
            for (Candidato g : ganadores) {
                System.out.println("- " + g.getNombre() + " (" + g.getPartido().getSiglas() + ") con " + g.getVotos() + " votos.");
            }
            System.out.println("\n Se requiere una segunda ronda electoral.");
        }
    }
}