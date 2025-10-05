// Relación de DEPENDENCIA: el ciudadano necesita una elección para votar,
// pero no pertenece ni se almacena dentro de ella.

class Ciudadano {
    private String nombre;
    private String cedula;
    private boolean yaVoto;

    public Ciudadano(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.yaVoto = false;
    }

    public String getNombre() { return nombre; }

    public void votar(EleccionNacional eleccion, Candidato candidato) {
        if (!yaVoto) {
            eleccion.registrarVoto(new Voto(this, candidato));
            yaVoto = true;
            System.out.println(nombre + " ha votado por " + candidato.getNombre());
        } else {
            System.out.println(nombre + " ya votó previamente.");
        }
    }
}