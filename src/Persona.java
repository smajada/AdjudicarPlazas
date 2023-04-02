public abstract class Persona {
    private int ID;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private static int contador = 0;


    public Persona(String nombre, String primerApellido, String segundoApellido) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        setID(); //Se utiliza el método setID en el constructor para crear el ID automáticamente
    }
    //Se crea un ID a partir del contador
    public void setID() {
        contador++;
        this.ID = contador;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Persona.contador = contador;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\n Nombre: " + nombre + "\n Apellido1: " + primerApellido + "\n Apellido2: "+ segundoApellido;
    }
}
