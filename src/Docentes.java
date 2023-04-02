public class Docentes extends Persona {
    private String titulacion;
    private double numPuntos;

    public Docentes(String nombre, String primerApellido, String segundoApellido, String titulacion, double numPuntos) {
        super(nombre, primerApellido, segundoApellido);
        this.titulacion = titulacion;
        this.numPuntos = numPuntos;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public double getNumPuntos() {
        return numPuntos;
    }

    public void setNumPuntos(double numPuntos) {
        this.numPuntos = numPuntos;
    }

    @Override
    public String toString() {
        return super.toString() +"\n Titulación: " + titulacion + "\n Puntos: " + numPuntos ; //Se imprime la clase padre (Persona) + la clase hija
    }

    
}
