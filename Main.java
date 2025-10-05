public class Main {
    public static void main(String[] args) {
        EleccionNacional eleccion = new EleccionNacional("Elecciones Nacionales de Costa Rica 2026");

        PartidoPolitico pp1 = new PartidoPolitico("Avance Nacional", "AN");
        PartidoPolitico pp2 = new PartidoPolitico("Futuro Verde", "FV");
        PartidoPolitico pp3 = new PartidoPolitico("Unidad Ciudadana", "UC");

        Candidato candidate1 = new Candidato("Laura Castro", pp1);
        Candidato candidate2 = new Candidato("Diego Méndez", pp2);
        Candidato candidate3 = new Candidato("Camila Rojas", pp3);

        eleccion.agregarCandidato(candidate1);
        eleccion.agregarCandidato(candidate2);
        eleccion.agregarCandidato(candidate3);

        Ciudadano v1 = new Ciudadano("Andrea López", "1-2345-6789");
        Ciudadano v2 = new Ciudadano("Luis González", "1-5678-1234");
        Ciudadano v3 = new Ciudadano("María Torres", "1-9876-5432");
        Ciudadano v4 = new Ciudadano("Pedro Salas", "1-1111-2222");

        v1.votar(eleccion, candidate2);
        v2.votar(eleccion, candidate3);
        v3.votar(eleccion, candidate3);
        v4.votar(eleccion, candidate2);

        eleccion.mostrarResultados();
        eleccion.mostrarGanador();
    }
}