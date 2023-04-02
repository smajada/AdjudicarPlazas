import java.util.ArrayList;

public class Main {

    public static void adjudicarPlazas(ArrayList<Plazas> listPlazas, ArrayList<Persona> listPersona) {
        //Adjudicar plazas mediante un for. Si el tipo de plaza es D o S y si la plaza no ha sido ya adjudicada
        for (int i = 0; i < listPlazas.size(); i++) {
            if (listPlazas.get(i).getTipoPlaza() == 'D' && !listPlazas.get(i).isAdjudicada()) {
                Docentes docente = getDocenteWithHighPunctuation(listPersona); //Se coge al docente con mayor puntuación
                if (docente != null) { //Si aún quedan docentes en listPersona
                    listPlazas.get(i).setPersona(docente);
                    listPlazas.get(i).setAdjudicada(true);
                    listPersona.remove(docente);
                }

            } else if (listPlazas.get(i).getTipoPlaza() == 'S' && !listPlazas.get(i).isAdjudicada()) {
                Sanitarios sanitario = getSanitarioWithHighPunctuation(listPersona); //Se coge al sanitario con mayor puntuación
                if (sanitario != null) { //Si aún quedan sanitarios en listPersona
                    listPlazas.get(i).setPersona(sanitario);
                    listPlazas.get(i).setAdjudicada(true);
                    listPersona.remove(sanitario);
                }
            }
        }

    }

    //Métodos para alfabetizar a las personas segun puntuacion
    public static Docentes getDocenteWithHighPunctuation(ArrayList<Persona> listDocente) {
        Docentes highPunctDocente = null;
        double punctDocente = 0;

        for (int i = 0; i < listDocente.size(); i++) {
            if (listDocente.get(i) instanceof Docentes) { //Si de la lista de personas el elemento i es un docente
                Docentes docente = (Docentes) listDocente.get(i); //Transforma a la persona en docente (para evitar errores en otros métodos)
                if (docente.getNumPuntos() > punctDocente) { //Si el docente en cuestión tiene más días trabajados que otr
                    punctDocente = docente.getNumPuntos();
                    highPunctDocente = docente; //Ese docente es el de mayor puntuación actual
                }
            }
        }
        //Retornamos el docente con mayor puntuación
        return highPunctDocente;
    }

    public static Sanitarios getSanitarioWithHighPunctuation(ArrayList<Persona> listSanitarios) {
        Sanitarios highPunctSanitarios = null;
        double punctSanitarios = 0;

        for (int i = 0; i < listSanitarios.size(); i++) {
            if (listSanitarios.get(i) instanceof Sanitarios) { //Si de la lista de personas el elemento i es un sanitario
                Sanitarios sanitario = (Sanitarios) listSanitarios.get(i); //Transforma a la persona en sanitario (para evitar errores en otros métodos)
                if (sanitario.getDiasTrabajados() > punctSanitarios) { //Si el sanitario en cuestión tiene más días trabajados que otro
                    punctSanitarios = sanitario.getDiasTrabajados(); 
                    highPunctSanitarios = sanitario; //Ese sanitario es el de mayor puntuación actual
                }
            }
        }
        //Retornamos el sanitario con mayor puntuación
        return highPunctSanitarios;
    }

    // Mostrar las adjudicaciones
    public static void mostrarAdjudicaciones(ArrayList<Plazas> listPlazas) {
        System.out.println("=============================================");
        System.out.println("La última adjudicación de plazas ha producido \n los siguientes resultados para DOCENTES");
        System.out.println("=============================================");
        for (int i = 0; i < listPlazas.size(); i++) {
            if (listPlazas.get(i).getTipoPlaza() == 'D') { //Primero mostramos las plazas de docentes
                System.out.println(listPlazas.get(i).toString()); //Mostramos los datos de la plaza
                System.out.println("______________________________________");
            }
        }
        System.out.println("=============================================");
        System.out
                .println("La última adjudicación de plazas ha producido \n los siguientes resultados para SANITARIOS");
        System.out.println("=============================================");
        for (int i = 0; i < listPlazas.size(); i++) {
            if (listPlazas.get(i).getTipoPlaza() == 'S') {
                System.out.println(listPlazas.get(i).toString()); //Mostramos los datos de la plaza
                System.out.println("______________________________________");
            }
        }
    }

    // Métodos para simular la adjudicación
    public static ArrayList<Plazas> crearPlazas() {
        ArrayList<Plazas> listPlazas = new ArrayList<Plazas>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                Plazas plaza = new Plazas(i, 'D', false, null);
                listPlazas.add(plaza);
            } else {
                Plazas plaza = new Plazas(i, 'S', false, null);
                listPlazas.add(plaza);
            }
        }

        return listPlazas;
    }

    public static ArrayList<Persona> crearPersonas() {
        ArrayList<Persona> listPersona = new ArrayList<Persona>();
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                Docentes docente = new Docentes("nombre" + String.valueOf(i), "apellido" + String.valueOf(i),
                        "apellido" + String.valueOf(i), "titulacion" + String.valueOf(i), i + 3);
                listPersona.add(docente);
            } else {
                Sanitarios sanitario = new Sanitarios("nombre" + String.valueOf(i), "apellido" + String.valueOf(i),
                        "apellido" + String.valueOf(i), "especialidad" + String.valueOf(i), i + 40);
                listPersona.add(sanitario);
            }
        }

        return listPersona;
    }

    public static void main(String[] args) throws Exception {

        ArrayList<Plazas> listPlazas = crearPlazas();
        ArrayList<Persona> listPersona = crearPersonas();

        adjudicarPlazas(listPlazas, listPersona);
        mostrarAdjudicaciones(listPlazas);
    }

}
