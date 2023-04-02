public class Sanitarios extends Persona {
    private String especialidad;
    private int diasTrabajados;

    public Sanitarios(String nombre, String primerApellido, String segundoApellido, String especialidad,
            int diasTrabajados) {
        super(nombre, primerApellido, segundoApellido);
        this.especialidad = especialidad;
        this.diasTrabajados = diasTrabajados;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Especialidad: " + especialidad + "\n Días trabajados: " + diasTrabajados; //Se imprime la clase padre (Persona) + la clase hija
    }

    
    
    
}
