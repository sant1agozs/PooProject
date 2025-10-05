public class Main {
    public static void main(String[] args) {

        // Crear la elección nacional
        EleccionNacional eleccion = new EleccionNacional("Elecciones Nacionales de Costa Rica 2026");

        // Crear los partidos políticos
        PartidoPolitico partido1 = new PartidoPolitico("Avance Nacional", "AN");
        PartidoPolitico partido2 = new PartidoPolitico("Futuro Verde", "FV");
        PartidoPolitico partido3 = new PartidoPolitico("Unidad Ciudadana", "UC");

        // Crear los candidatos con su partido y votos iniciales en 0
        Candidato candidato1 = new Candidato("Laura Castro", partido1, 0);
        Candidato candidato2 = new Candidato("Diego Méndez", partido2, 0);
        Candidato candidato3 = new Candidato("Camila Rojas", partido3, 0);

        // Agregar los candidatos a la elección
        eleccion.getCandidatos().add(candidato1);
        eleccion.getCandidatos().add(candidato2);
        eleccion.getCandidatos().add(candidato3);

        // Crear los ciudadanos (votantes)
        Ciudadano votante1 = new Ciudadano("Andrea López", "1-2345-6789", false);
        Ciudadano votante2 = new Ciudadano("Luis González", "1-5678-1234", false);
        Ciudadano votante3 = new Ciudadano("María Torres", "1-9876-5432", false);
        Ciudadano votante4 = new Ciudadano("Pedro Salas", "1-1111-2222", false);

        // Registrar votos (dependencia entre Ciudadano y EleccionNacional)
        Voto voto1 = new Voto(votante1, candidato2);
        Voto voto2 = new Voto(votante2, candidato3);
        Voto voto3 = new Voto(votante3, candidato3);
        Voto voto4 = new Voto(votante4, candidato2);

        // Agregar los votos a la elección
        eleccion.getVotos().add(voto1);
        eleccion.getVotos().add(voto2);
        eleccion.getVotos().add(voto3);
        eleccion.getVotos().add(voto4);

       // Actualizar automáticamente el conteo de votos en los candidatos
        for (Voto voto : eleccion.getVotos()) {
            Candidato candidatoAsociado = voto.getCandidato();
            candidatoAsociado.setVotos(candidatoAsociado.getVotos() + 1);
        }

        // Mostrar resultados
        System.out.println("\nResultados de la " + eleccion.getNombre() + ":");
        for (Candidato candidato : eleccion.getCandidatos()) {
            System.out.println(candidato.toString());
        }

        // Determinar el máximo de votos
        int maxVotos = 0;
        for (Candidato c : eleccion.getCandidatos()) {
            if (c.getVotos() > maxVotos) {
                maxVotos = c.getVotos();
            }
        }

        // Verificar si hay empate
        boolean hayEmpate = false;
        for (Candidato c : eleccion.getCandidatos()) {
            if (c.getVotos() == maxVotos && hayEmpate) {
                System.out.println("\nEmpate en las " + eleccion.getNombre() + ":");
                for (Candidato empateCandidato : eleccion.getCandidatos()) {
                    if (empateCandidato.getVotos() == maxVotos) {
                        System.out.println("- " + empateCandidato.getNombre() + " (" +
                                empateCandidato.getPartido().getSiglas() + ") con " + empateCandidato.getVotos() + " votos.");
                    }
                }
                System.out.println("\nSe requiere una segunda ronda electoral.");
                return;
            }
            if (c.getVotos() == maxVotos) {
                hayEmpate = true;
            }
        }

        // Mostrar ganador si no hay empate
        for (Candidato c : eleccion.getCandidatos()) {
            if (c.getVotos() == maxVotos) {
                System.out.println("\nGanador de las " + eleccion.getNombre() + ": " +
                        c.getNombre() + " del partido " + c.getPartido().getNombre() +
                        " con " + c.getVotos() + " votos.");
            }
        }
    }
}