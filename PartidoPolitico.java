// Relación de AGREGACIÓN: la clase es usada por Candidato,
// pero ambos pueden existir de forma independiente.

class PartidoPolitico {
    private String nombre;
    private String siglas;

    public PartidoPolitico(String nombre, String siglas) {
        this.nombre = nombre;
        this.siglas = siglas;
    }

    public String getNombre() { return nombre; }
    public String getSiglas() { return siglas; }

    @Override
    public String toString() {
        return nombre + " (" + siglas + ")";
    }
}
